import React from "react";
import PropTypes from "prop-types";
import Container from "@material-ui/core/Container";
import Paper from "@material-ui/core/Paper";
import { makeStyles } from "@material-ui/core/styles";
import Fab from "@material-ui/core/Fab";
import Add from "@material-ui/icons/Add";
import Search from "@material-ui/icons/Search";
import InputBase from "@material-ui/core/InputBase";
import Switch from "@material-ui/core/Switch";
import Tooltip from "@material-ui/core/Tooltip";
import PoneyGrid from "./PoneyGrid";
export default function Core() {
  const [state, setState] = React.useState({
    checkedA: false
  });

  const handleChange = name => event => {
    setState({ ...state, [name]: event.target.checked });
  };

  const classes = useStyles();
  return (
    <Container>
      <Tooltip title="Activer la suppression">
        <Switch
          className={classes.Switch}
          checked={state.checkedA}
          onChange={handleChange("checkedA")}
          value="checkedA"
          label="Supprimer"
          inputProps={{ "aria-label": "secondary checkbox" }}
          labelPlacement="bottom"
        />
      </Tooltip>
      <Paper className={classes.paper}>
        <h1 className={classes.h1}>Ecurie</h1>
        <Fab variant="extended" aria-label="Add" className={classes.fab}>
          <Add className={classes.extendedIcon} />
          &nbsp; Ajouter un nouveau poney
        </Fab>
        <Fab variant="extended" className={classes.fab2} disableRipple={true}>
          <Search className={classes.extendedIcon} />
          <InputBase
            placeholder="Recherchez votre poney"
            classes={{
              root: classes.inputRoot,
              input: classes.inputInput
            }}
            inputProps={{ "aria-label": "Search" }}
          />
        </Fab>
        <PoneyGrid checked={true} />
      </Paper>
    </Container>
  );
}

const useStyles = makeStyles(theme => ({
  h1: {
    color: "black",
    fontFamily: "Cormorant Garamond",
    borderBottom: "3px solid #e66c7e",
    fontSize: "48px",
    fontWeight: "400",
    lineHeight: "72px",
    letterSpacing: "35px",
    marginBottom: "57px",
    textAlign: "center",
    textIndent: "24px",
    textTransform: "uppercase"
  },
  fab: {
    marginBottom: "57px",
    background: "linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)",
    border: 0,
    borderRadius: 3,
    boxShadow: "0 3px 5px 2px rgba(255, 105, 135, .3)",
    color: "black",
    height: 48,
    padding: "0 30px"
  },
  fab2: {
    marginBottom: "57px",
    background: "linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)",
    border: 0,
    borderRadius: 3,
    boxShadow: "0 3px 5px 2px rgba(255, 105, 135, .3)",
    color: "black",
    height: 48,
    padding: "0 30px",
    float: "right"
  },
  inputRoot: {
    color: "inherit"
  },
  inputInput: {
    padding: theme.spacing(1, 1, 1, 7),
    transition: theme.transitions.create("width"),
    width: "100%",
    [theme.breakpoints.up("sm")]: {
      width: 120,
      "&:focus": {
        width: 200
      }
    }
  }
}));

Core.propTypes = {
  classes: PropTypes.object.isRequired
};

//https://www.pixelstalk.net/wp-content/uploads/2016/04/MLP-wallpapers-HD-cartoon-fantasy-horses-horse-unicorn.png
