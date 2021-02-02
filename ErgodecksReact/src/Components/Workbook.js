import React, {useState, useEffect} from "react";
import { makeStyles } from "@material-ui/core/styles";
import Button from '@material-ui/core/Button';
import ActiveCard from "./ActiveCard";

const useStyles = makeStyles(theme => ({
  background: {
    minHeight: '100vh',
    backgroundColor: '#d3d3d3'
  }
}));

export default function Workbook(props) {
  const classes = useStyles();
  const [activeCardResults, selectCard] = useState([]);

  //For triggering fetchActiveCards from parent and searched cards component
  const {cardDrop: [cardDrop, setCardDrop]} = {
    cardDrop: useState(0),
      ...(props.state || {})
  };

  async function fetchActiveCard() {
    selectCard([]);
    let response = await fetch("/activecard");
    let body = await response.json();
    selectCard([]);
    selectCard(body);
  };

  //Runs after a card from CardSearch is dropped into workbook
  useEffect(() => {
    selectCard([]);
    fetchActiveCard();
    console.log("cardDrop value: " + cardDrop);
    console.log("activeCardResults.length value: " + activeCardResults.length);
  }, [cardDrop]);

  async function clearWorkbook() {
    for (var i = 0; i < activeCardResults.length; i++) {
      await fetch(`/activecard/` + activeCardResults[i].active_id, {
        method: "DELETE",
      });
    }
    fetchActiveCard();
    console.log("Workbook cleared")
  }

 function refreshWorkbook() {
      fetchActiveCard();
      console.log("REFRESH BUTTON CLICKED activeCardResults size: " + activeCardResults.length);
  }

  return (
    <div classname={classes.background} >
      <Button variant="outlined" onClick={clearWorkbook} style={{position:"absolute", marginTop:"10px", marginLeft:"10px", zIndex:99900}}>Clear All</Button>
      <Button variant="outlined" onClick={refreshWorkbook} style={{position:"absolute", marginTop:"10px", marginLeft:"130px", zIndex:99900}}>Refresh</Button>
      {activeCardResults.map((activeCard) => (
              
              <ActiveCard state={{ cardDrop: [cardDrop, setCardDrop] }} {...activeCard} />
              
            ))}
    </div>
  );
}