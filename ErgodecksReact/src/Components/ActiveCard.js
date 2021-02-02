import React from "react";
import Draggable from 'react-draggable';

const ActiveCard = (props) => {
  let highestZ = 0;
  const mouseDownHandle = () => {
  let cardImages = document.getElementsByClassName('target');

  for (let i = 0; i < cardImages.length; i++) {
    let zindex = document.defaultView.getComputedStyle(cardImages[i],null).getPropertyValue("z-index");
        
    if (zindex >= highestZ) {
      highestZ = zindex;
      highestZ++;
    }
    console.log("z-index: " + zindex + " highest: " + highestZ);
  }

  function updateZIndex () {
    document.getElementById(props.active_id).style.zIndex = highestZ;
  }
  updateZIndex();
  }

  const mouseUpHandle = (...args) => {
    const {x, y, offsetX, offsetY} = args[0];
    
    //Gets position of top left of card with offset subtraction. x and y are mouse position on component.
    const trueX = x - offsetX;
    const trueY = y - offsetY;

    async function updatePost() {
      const requestOptions = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ 
          active_id: props.active_id,
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
          pos_y:trueY,
          z_index: highestZ
        })
      };
      await fetch('/activecard/' + props.active_id, requestOptions);

    }
    updatePost();   
    console.log(props.active_id + " props POSX: " + props.pos_x + " truex POSX: " + trueX);
    console.log(props.active_id + " props POSX: " + props.pos_y + " truex POSX: " + trueY);
  }

  return(
    <Draggable
    handle=".target"
    defaultPosition={{x: props.pos_x - 50, y: props.pos_y - 244}}
    onStart = {mouseDownHandle}
    onStop = {mouseUpHandle}
    >
      <img style={{position:"absolute", zIndex:props.z_index}} id={props.active_id} className="target" draggable="false" src={props.image_urissmall}  width="146" height="204" alt="Card Result"></img>
    </Draggable>
  );
}

export default ActiveCard;