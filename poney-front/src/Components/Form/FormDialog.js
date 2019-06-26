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
import { addPony } from "../../redux/Poney/poneyAction";
class FormDialog extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      open: false,
      name: "",
      level: "",
      race: "",
      src: ""
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
    this.setState({ [name]: event.target.value });
  };

  handleSubmit = ponies => {
    ponies.push({
      name: this.state.name,
      level: this.state.level,
      race: this.state.race,
      src: this.state.src
    });
    addPony();
  };
  render() {
    const { children, classes, ponies } = this.props;
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
              // C'est clairement dégueulasse, mais pas le time
            }
            <DialogContentText>Ajout de poney</DialogContentText>
            <CssTextField
              className={classes.margin}
              label="Nom"
              variant="outlined"
              onChange={this.handleChange("name")}
              autoFocus
            />
            <CssTextField
              className={classes.margin}
              label="Espèce"
              variant="outlined"
              onChange={this.handleChange("race")}
            />
            <CssTextField
              className={classes.margin}
              label="Niveau"
              variant="outlined"
              onChange={this.handleChange("level")}
            />
            <CssTextField
              className={classes.margin}
              label="Image"
              variant="outlined"
              helperText="src"
              onChange={this.handleChange("src")}
            />
          </DialogContent>
          <DialogActions>
            <Tooltip title="Ajouter un nouveau poney random">
              <Fab
                variant="round"
                aria-label="AddRandom"
                className={classes.fab}
              >
                <FilterVintageRounded className={classes.extendedIcon} />
              </Fab>
            </Tooltip>
            {
              //Pareil
            }
            {this.state.name !== "" &&
            this.state.race !== "" &&
            this.state.level !== "" &&
            this.state.src !== "" ? (
              <Tooltip title="Ajouter un nouveau poney ">
                <Fab
                  onClick={this.handleSubmit(ponies)}
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
    ponies: poneyReducer.ponies
  };
};

const mapDispatchToProps = dispatch =>
  bindActionCreators({ addPony }, dispatch);

export default withStyles(styles)(
  connect(
    mapStateToProps,
    mapDispatchToProps
  )(FormDialog)
);
