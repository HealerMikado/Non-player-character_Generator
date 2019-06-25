import React from "react";
import { withStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import Fab from "@material-ui/core/Fab";
import DeleteIcon from "@material-ui/icons/Delete";
import Typography from "@material-ui/core/Typography";
import ListTalents from "../ListQuirks";

class PoneyCard extends React.Component {
  render() {
    const { checked, pony, classes } = this.props;
    return (
      <Card className={classes.card}>
        <CardActionArea>
          <CardMedia className={classes.media} image={pony.src} title={pony.name} />
          <CardContent>
            <Typography gutterBottom variant="h5" component="h2">
              {pony.name}
            </Typography>
            <Typography variant="body2" color="textSecondary" component="p">
              {pony.race}
            </Typography>
            <Typography >
              <img src="https://img.icons8.com/dusk/30/000000/flex-biceps.png" /> : {pony.bodyLevel.diceValue} <br />
              <img src="https://img.icons8.com/bubbles/30/000000/brain.png" />  : {pony.mindLevel.diceValue} <br />
              <img src="https://img.icons8.com/cotton/30/000000/glossy-lips.png" />  :  {pony.charmLevel.diceValue} <br />
              <img src="https://img.icons8.com/cotton/64/000000/star-of-bethlehem--v1.png" />
            </Typography>
            <Typography>

              <ListTalents className={classes.ListTalents} quirks={pony.quirks} />
            </Typography>
          </CardContent>
        </CardActionArea>
        <CardActions>{deleteButton(checked, classes)}</CardActions>
      </Card>
    );
  }
}

const deleteButton = (checked, classes) => {
  if (checked) {
    return (
      <Fab variant="contained" color="primary" className={classes.fab}>
        <DeleteIcon className={classes.rightIcon} />
      </Fab>
    );
  }
};

const styles = {
  card: {
    width: 380,
    marginBottom: 10,
    marginLeft: 10,
    display: "inline-block"
  },
  media: {
    height: 300
  },
  fab: {
    float: "right"
  }
};

export default withStyles(styles)(PoneyCard);
