import React from "react";
import Container from "@material-ui/core/Container";
import Paper from "@material-ui/core/Paper";
import { withStyles } from "@material-ui/core/";
import Fab from "@material-ui/core/Fab";
import Add from "@material-ui/icons/Add";
import PoneyGrid from "./PoneyGrid";
import theme from "../../Theme";
import { connect } from "react-redux";
import * as poneyReducer from "../../redux/Poney/index";
import * as raceReducer from "../../redux/Races/index";
import FormDialog from "../Form/FormDialog";
import Recherche from "./Recherche";
class Core extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isToggleOn: false
    };
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    this.setState({ isToggleOn: this.state.isToggleOn === false });
  }
  fixPony() {
    const { pony, setPony } = this.props;
    console.log(pony);
    const pon = {
      ...pony,
      name: undefined,
      race: undefined,
      level: undefined,
      src: undefined
    };
    console.log(pon);
    setPony(pon);
    debugger;
  }

  componentDidMount() {
    const { fetchPonies, fetchRaces } = this.props;
    fetchPonies();
    fetchRaces();
  }
  componentWillUnmount() {
    const { setPonies } = this.props;
    setPonies();
  }

  handleSubmit() {}

  render() {
    const { classes } = this.props;
    const { ToggleOn } = this.state;
    return (
      <Container>
        {/* <Tooltip title="Activer la suppression">
          <Switch
            className={classes.Switch}
            checked={ToggleOn}
            onChange={this.handleClick}
            value="checked"
            inputProps={{ "aria-label": "suppression" }}
          />
        </Tooltip> */}
        <Paper className={classes.paper}>
          <h1 className={classes.h1}>Ecurie</h1>
          <div>
            <FormDialog handleClick={this.handleSubmit()}>
              <Fab variant="extended" aria-label="Add" className={classes.fab}>
                <Add className={classes.extendedIcon} />
                &nbsp; Ajouter un nouveau poney
              </Fab>
            </FormDialog>
            <Recherche className={classes.fab2} />
          </div>
          <PoneyGrid checked={ToggleOn} />
        </Paper>
      </Container>
    );
  }
}

const styles = {
  form: {
    position: "absolute"
  },
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
    position: "relative",
    marginBottom: "57px",
    background: "linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)",
    border: 0,
    borderRadius: 3,
    boxShadow: "0 3px 5px 2px rgba(255, 105, 135, .3)",
    color: "black",
    height: 48,
    float: "right",
    bottom: "100px"
  },
  fab3: {
    marginBottom: "57px",
    marginLeft: 200,
    background: "linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)",
    border: 0,
    borderRadius: 3,
    boxShadow: "0 3px 5px 2px rgba(255, 105, 135, .3)",
    color: "black",
    height: 48,
    padding: "0 30px"
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
};

const mapDispatchToProps = dispatch => {
  return {
    fetchPonies: isChargement => {
      dispatch(poneyReducer.fetchPonies(isChargement));
    },
    setPonies: ponies => {
      dispatch(poneyReducer.setPonies(ponies));
    },
    fetchRaces: () => {
      dispatch(raceReducer.fetchRaces());
    },
    fetchRandomPony: () => {
      dispatch(poneyReducer.fetchRandomPony());
    },
    setPony: pony => {
      dispatch(poneyReducer.setPony(pony));
    }
  };
};

export default withStyles(styles)(
  connect(
    null,
    mapDispatchToProps
  )(Core)
);

//https://www.pixelstalk.net/wp-content/uploads/2016/04/MLP-wallpapers-HD-cartoon-fantasy-horses-horse-unicorn.png
