import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Card from "./Card";
import TextField from "@material-ui/core/TextField";
import {Draggable} from 'react-draggable';

const useStyles = makeStyles(theme => ({
  searcharea: {
    
    flexGrow: '1',
    flexDirection: "row",
    backgroundColor: "#252525",
    //border : 'solid 1px blue',
    height: 'fit-content',
    padding : '10px'

  },
  cardstyle: {
    display: 'flex',
    flexDirection: "row",
    draggable: true
  }
}));






export default function CardSearch() {
    const classes = useStyles();
    const [cardResults, selectCard] = React.useState([]);

    async function fetchCard() {
      var cardInput = document.getElementById("searchInput").value;

      if (cardInput.length > 1) {
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
      <div className={classes.searcharea}>
          <TextField 
            id="searchInput" 
            onChange = {fetchCard}
            style={{width: 438}}
            ></TextField>

            <div className={classes.cardstyle}>

            {cardResults.map((card) => (
              
                <Card {...card} />
                
            ))}

            </div>

        </div>
    );
}