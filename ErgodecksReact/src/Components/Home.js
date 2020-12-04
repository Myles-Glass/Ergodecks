import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import CardSearch from "./CardSearch";
import WorkBookBar from "./WorkBookBar";


const useStyles = makeStyles(theme => ({
  background: {
    display: "flex",
    flexDirection: "row",
    minHeight: '100vh',
    maxHeight: '100vh',

    backgroundColor: '#151515'
  }
}));

export default function Home() {
  const classes = useStyles();


  return (
    <div className={classes.background} >
      <WorkBookBar />
      <CardSearch />
    </div>
  );
}