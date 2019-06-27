import React, { Component } from "react";
import Grid from "@material-ui/core/Grid";
import PoneyCard from "../PoneyCard";
import { withStyles } from "@material-ui/core/styles";
import { connect } from "react-redux";

class PoneyGrid extends Component {
  render() {
    const { classes, ponies } = this.props;
    return (
      <React.Fragment>
        <Grid Container spacing={6}>
          <Grid item xs={12} className={classes.gridItem}>
            {ponies.map((pony, i) => (
              <PoneyCard className={classes.PoneyCard} pony={pony} />
            ))}
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
const mapStateToProps = ({ poneyReducer }) => {
  return {
    /**
     * Get all the ponies !
     */
    ponies: poneyReducer.ponies
  };
};

export default withStyles(styles)(
  connect(
    mapStateToProps,
    null
  )(PoneyGrid)
);
