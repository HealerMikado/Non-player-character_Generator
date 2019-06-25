import React from "react";
import Grid from "@material-ui/core/Grid";
import PoneyCard from "../PoneyCard";
import { makeStyles } from "@material-ui/core/styles";
export default function PoneyGrid() {
  const classes = useStyles();
  return (
    <React.Fragment>
      <Grid Container spacing={6}>
        <Grid item xs={12} className={classes.gridItem}>
          <PoneyCard
            className={classes.PoneyCard}
            description="I am from toulon"
            name="Poney"
            src="https://www.pixelstalk.net/wp-content/uploads/2016/04/MLP-wallpapers-HD-cartoon-fantasy-horses-horse-unicorn.png"
          />
        </Grid>
      </Grid>
    </React.Fragment>
  );
}

const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1
  },
  PoneyCard: {
    float: "left",
    display: "inline",
    width: "100%",
    marginBottom: "10px"
  },
  gridItem: {
    display: "inline-block",
    padding: 20
  }
}));
