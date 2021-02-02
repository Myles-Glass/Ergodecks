import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import CardSearch from "./CardSearch";
import WorkbookBar from "./WorkbookBar";
import Workbook from "./Workbook";



const useStyles = makeStyles(theme => ({
  background: {
    display: "flex",
    flexDirection: "row",
    minHeight: '100vh',
    maxHeight: '100vh',
    backgroundColor: '#c4b7a6'
  },
  contents: {
    flexGrow: '1',
    flexDirection: "row",
  }
}));

export default function Home() {
  const classes = useStyles();
  const [cardDrop, setCardDrop] = useState(0);

  return (
    <div className={classes.background} >
      <WorkbookBar/>
      <div className={classes.contents}>
        <CardSearch state={{ cardDrop: [cardDrop, setCardDrop] }} />
        <Workbook state={{ cardDrop: [cardDrop, setCardDrop] }} />
      </div>
    </div>
  );
}