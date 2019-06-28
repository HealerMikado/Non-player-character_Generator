import React from "react";
import Tooltip from "@material-ui/core/Tooltip";
import Fab from "@material-ui/core/Fab";
import { FilterVintageRounded, PersonAdd } from "@material-ui/icons/";
import {
  Dialog,
  DialogActions,
  DialogContent,
  DialogContentText,
  TextField
} from "@material-ui/core/";
import DialogTitle from "@material-ui/core/DialogTitle";
import withStyles from "@material-ui/styles/withStyles";
import theme from "../../Theme";
import { connect } from "react-redux";
import { bindActionCreators } from "redux";
import {
  addPony,
  setPony,
  fetchRandomPony,
  updatePony
} from "../../redux/Poney/poneyAction";

class FormDialog extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      open: false,
      poney: { name: "", race: "", level: "", src: "" }
    };
    this.handleClickOpen = this.handleClickOpen.bind(this);
    this.handleClose = this.handleClose.bind(this);
  }

  handleClickOpen() {
    this.setState({ open: true });
  }

  handleClose() {
    this.setState({ open: false });
  }

  handleChange = name => event => {
    const { setPony, pony } = this.props;
    pony[name] = event.target.value;
    setPony(pony);
    this.setState({ poney: pony });
  };
  // Recupère un poney random depuis l'api et affecte les valeurs a l'ihm
  handleRandomClick = () => {
    const { fetchRandomPony, pony } = this.props;
    fetchRandomPony();
    this.setState({ poney: pony });
  };

  handleSubmit = pony => {
    const { fetchRandomPony, addPony } = this.props;
    fetchRandomPony(false);
    pony = {
      ...pony,
      name: this.state.name,
      race: this.state.race,
      level: this.state.level,
      src: this.state.src
    };
    addPony(pony);
    this.setState({ open: false });
  };
  render() {
    const { children, classes, pony } = this.props;
    return (
      <React.Fragment>
        {React.cloneElement(children, { onClick: this.handleClickOpen })}
        <Dialog
          open={this.state.open}
          onClose={this.handleClose}
          aria-labelledby="form-dialog-title"
        >
          <DialogTitle id="form-dialog-title" className={classes.h1}>
            Ajouter un poney
          </DialogTitle>
          <DialogContent>
            {
              // Léa passion copié-collé
            }
            <DialogContentText>Ajout de poney</DialogContentText>
            <CssTextField
              className={classes.margin}
              label="Nom"
              variant="outlined"
              onChange={this.handleChange("name")}
              value={pony.name}
              autoFocus
            />
            <CssTextField
              className={classes.margin}
              label="Espèce"
              variant="outlined"
              onChange={this.handleChange("race")}
              value={pony.race}
            />
            <CssTextField
              className={classes.margin}
              label="Niveau"
              variant="outlined"
              onChange={this.handleChange("level")}
              value={pony.level}
            />
            <CssTextField
              className={classes.margin}
              label="Image"
              variant="outlined"
              helperText="src"
              onChange={this.handleChange("src")}
              value={pony.src}
            />
          </DialogContent>
          <DialogActions>
            <Tooltip title="Génerer un nouveau poney random">
              <Fab
                variant="round"
                aria-label="AddRandom"
                className={classes.fab}
                onClick={this.handleRandomClick}
              >
                <FilterVintageRounded className={classes.extendedIcon} />
              </Fab>
            </Tooltip>
            {
              //Pareil
            }
            {pony.src !== undefined &&
            pony.race !== undefined &&
            pony.name !== undefined &&
            pony.level !== undefined ? (
              <Tooltip title="Ajouter un nouveau poney ">
                <Fab
                  onClick={this.handleSubmit}
                  color="primary"
                  className={classes.fab}
                  type="submit"
                >
                  <PersonAdd />
                </Fab>
              </Tooltip>
            ) : (
              <React.Fragment />
            )}
          </DialogActions>
        </Dialog>
      </React.Fragment>
    );
  }
}

const styles = {
  h1: {
    color: "black",
    fontFamily: "Cormorant Garamond",
    borderBottom: "3px solid #e66c7e",
    fontSize: "48px",
    fontWeight: "400",
    lineHeight: "72px",
    letterSpacing: "35px",
    textAlign: "center",
    textIndent: "24px",
    textTransform: "uppercase"
  },
  fab: {
    marginLeft: 470,
    background: "linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)",
    boxShadow: "0 3px 5px 2px rgba(255, 105, 135, .3)",
    color: "black",
    padding: "0 30px",
    float: "right"
  },
  margin: {
    margin: theme.spacing(1)
  }
};

const CssTextField = withStyles({
  root: {
    "& label.Mui-focused": {
      color: "green"
    },
    "& .MuiInput-underline:after": {
      borderBottomColor: "green"
    },
    "& .MuiOutlinedInput-root": {
      "& fieldset": {
        borderColor: "red"
      },
      "&:hover fieldset": {
        borderColor: "yellow"
      },
      "&.Mui-focused fieldset": {
        borderColor: "green"
      }
    }
  }
})(TextField);

const mapStateToProps = ({ poneyReducer }) => {
  return {
    ponies: poneyReducer.ponies,
    pony: poneyReducer.pony
  };
};

const mapDispatchToProps = dispatch =>
  bindActionCreators(
    { addPony, setPony, fetchRandomPony, updatePony },
    dispatch
  );

export default withStyles(styles)(
  connect(
    mapStateToProps,
    mapDispatchToProps
  )(FormDialog)
);
