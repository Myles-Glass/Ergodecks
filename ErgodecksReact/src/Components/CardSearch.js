import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import Card from "./Card";
import TextField from "@material-ui/core/TextField";

const useStyles = makeStyles(theme => ({
  searcharea: {
    flexGrow: '1',
    flexDirection: "row",
    backgroundColor: "#686256",
    height: '244px',
  },
  cardstyle: {
    display: 'flex',
    flexDirection: "row",
    draggable: true
  }
}));

export default function CardSearch(props) {
    const classes = useStyles();
    const [cardResults, selectCard] = useState([]);

    const {cardDrop: [cardDrop, setCardDrop]} = {
      cardDrop: useState(0),
      ...(props.state || {})
    };

    async function fetchCard() {
      var cardInput = document.getElementById("searchInput").value;

      if (cardInput.length > 2) {
        let response = await fetch("/card/search/" + cardInput);
        let body = await response.json();
        selectCard(body);
      }
      //Empties the result list when blank
      if (cardInput.length === 0) {
        selectCard([]);
      }
    }

    return (
      <div className={classes.searcharea} >
          <TextField 
            id="searchInput" 
            onChange = {fetchCard}
            style={{width: 438}}
            ></TextField>

            <div className={classes.cardstyle}>
              {cardResults.slice(0, 8).map((card) => ( 
                  <Card state={{ cardDrop: [cardDrop, setCardDrop] }} {...card} />        
              ))}
            </div>
        </div>
    );
}