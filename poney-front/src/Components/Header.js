import React from "react";
import CssBaseline from "@material-ui/core/CssBaseline";
import { makeStyles } from "@material-ui/core/styles";

export const imgurl =
  "https://vignette.wikia.nocookie.net/mlpfimroleplay/images/0/0e/Community-header-background/revision/latest?cb=20170613202503}";
const useStyles = makeStyles(theme => ({
  img: {
    display: "block",
    minWidth: "1%",
    minHeight: "1%",
    position: "relative"
  },
  div: {
    backgroundImage: `url(${imgurl})`,
    backgroundRepeat: "repeat-x",
    animation: "slide 60s linear infinite"
  }
}));
export default function Header() {
  const classes = useStyles();
  return (
    <React.Fragment>
      <CssBaseline />
      <div className={classes.div}>
        <img
          src="https://vignette.wikia.nocookie.net/mlpfimroleplay/images/0/0e/Community-header-background/revision/latest?cb=20170613202503"
          alt=":)"
          className={classes.img}
        />
      </div>
    </React.Fragment>
  );
}
