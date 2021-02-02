import React from "react";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles(theme => ({
        background: {
            display: "flex",
            flexDirection: "column",
            minWidth: '50px',
            
            minHeight: '100vh',
            backgroundColor: '#587e76'
    }
  }));
//TODO: generate buttons from array and api request, if button is active, display workbook
export default function WorkbookBar() {
    const classes = useStyles();
    return (
        <div className={classes.background}>
        </div>
    )
}