import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Draggable from 'react-draggable';
import Moveable from "react-moveable";


const useStyles = makeStyles(theme => ({
    cardstyle: {
        padding : '5px',

    }
  }));



  //onSTOP get location, if its in workbook then send props to workbook class and do 
  //another GET API for the uuid of card to permanatly place in workbook when its dropped

  //onDragStop = {sendToWorkbook} this function will determine whether or not it is in workbook area, if it is, then i think i can add the card to a workbook component
const Card = (props) => {
  const classes = useStyles();

  const [target, setTarget] = React.useState();

  React.useEffect(() => {
      setTarget(document.querySelector(".target"));
    }, []);


    //const [card,selectCard] = React.useState(props)
    //console.log(cards, props);

const mouseHandle = () => {
console.log("mouse up");
  return Draggable.disabled(true)
}
    

    return (

        <Draggable
        handle=".target"
        onMouseUp={mouseHandle}
        onStart={Draggable.handleStart}
        onDrag={Draggable.handleDrag}
        onStop={Draggable.handleStop}
        >

        <div className={classes.cardstyle}>
        <img className="target" src={props.image_urissmall}  width="146" height="204" alt="Card Result"></img>
        </div>

        </Draggable>
);
}

export default Card;