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

class PoneyCard extends React.Component {
  render() {
    const { checked, name, description, src, classes } = this.props;
    return (
      <Card className={classes.card}>
        <CardActionArea>
          <CardMedia className={classes.media} image={src} title={name} />
          <CardContent>
            <Typography gutterBottom variant="h5" component="h2">
              {name}
            </Typography>
            <Typography variant="body2" color="textSecondary" component="p">
              {description}
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
    height: 140
  },
  fab: {
    float: "right"
  }
};

export default withStyles(styles)(PoneyCard);
