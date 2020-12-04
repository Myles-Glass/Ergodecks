import React from "react";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles(theme => ({
        background: {
            display: "flex",
            flexDirection: "column",
            minWidth: '50px',
            
            minHeight: '100vh',
            backgroundColor: '#202020'
    }
  }));


export default function WorkBookBar() {
    const classes = useStyles();

    return (
        <div className={classes.background}></div>
    )
}