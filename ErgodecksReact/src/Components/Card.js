import React, { useState } from "react";
import Draggable from 'react-draggable';
import { v4 as uuidv4 } from 'uuid';

const Card = (props) => {

  const [visible, setVisible] = useState(true); //Deletes the card after dropped into workbook

  const [isHovered, setIsHovered] = useState(false);
  const handleMouseEnter = () => setIsHovered(false); //set this to true to turn hover on
  const handleMouseLeave = () => setIsHovered(false);

  //For lifting state up and triggering fetchActiveCards
  const {cardDrop: [cardDrop, setCardDrop]} = {
    cardDrop: useState(0),
    ...(props.state || {})
  };

  const mouseUpHandle = (...args) => {
    const {x, y, offsetX, offsetY} = args[0];

    //Gets position of top left of card with offset subtraction. 
    //x and y are mouse position on component.
    const trueX = x - offsetX;
    const trueY = y - offsetY;
    
    //For lifting state up and triggering fetchActiveCards
    setCardDrop(cardDrop + 1);

    //Determines if searched card is dropped in workbook area, if so, it adds to workbook database.
    if (trueX > 50 && trueY > 244) {
      const active_id = uuidv4();
      //console.log("Dropped inside Workbook area: trueX = " + trueX);
      async function updatePost() {
        const requestOptions = {
          method: 'PUT',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({ 
            active_id: active_id,
            id:props.id,
            name:props.name,
            released_at:props.released_at,
            image_urissmall:props.image_urissmall,
            image_urisnormal:props.image_urisnormal,
            mana_cost:props.mana_cost,
            type_line:props.type_line,
            color_identity0:props.color_identity0,
            set_name:props.set_name,
            pricesusd:props.pricesusd,
            rarity:props.rarity,
            pos_x:trueX,
            pos_y:trueY
          })
        };
        await fetch('/activecard/' + active_id, requestOptions);
      }
      updatePost();
      setVisible(false); //Hides the searched card after its dropped into workbook
    }
  }

  if(!visible) return null;

  return (  
      <div>
        <Draggable
          handle=".target"
          onStop = {mouseUpHandle}
          >
          <img style={{zIndex: '999995', padding : '5px', position: 'relative'}} onMouseEnter={handleMouseEnter} onMouseLeave={handleMouseLeave} className="target" draggable="false" src={props.image_urissmall}  width="146" height="204" alt="Card Result"></img>
        </Draggable>
        <img  style={isHovered ? {display: "block", zIndex: "3"} : {display: "none"}} draggable="false" src={props.image_urisnormal}  width="292" height="408" alt="Card Result"></img>
      </div>
      );
}
export default Card;