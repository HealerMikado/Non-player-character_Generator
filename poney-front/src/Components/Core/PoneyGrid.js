import React, { Component } from "react";
import Grid from "@material-ui/core/Grid";
import PoneyCard from "../PoneyCard";
import { withStyles } from "@material-ui/core/styles";

class PoneyGrid extends Component {

  constructor(){
    super();
    this.state = {ponies : []};
  }


  /**
   * Quand on va créer le composant on va chercher tous les poney
   */
  componentWillMount() {
    this.getAllPonies();
  }

  /**
   * Get all the ponies !
   */
  getAllPonies = () => {
    console.log("getAllPonies")
    let thisG = this;

        fetch('http://localhost:8080/characters')
            .then(response => response.json())
            .then(function (result) {
                console.log(result);
                thisG.setState({ ponies: result });
                console.log(thisG.state.pony);
            });

  }

  render() {
    const { classes } = this.props;
    return (
      <React.Fragment>
        <Grid Container spacing={6}>
          <Grid item xs={12} className={classes.gridItem}>

          {this.state.ponies.map((pony, i) =>  <PoneyCard
              className={classes.PoneyCard}
              pony = {pony}
            />)}

           
          </Grid>
        </Grid>
      </React.Fragment>
    );
  }
}

const styles = {
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
};

export default withStyles(styles)(PoneyGrid);
