import React from "react";
import { withStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import ListItemAvatar from '@material-ui/core/ListItemAvatar';
import Avatar from '@material-ui/core/Avatar';
import Fab from "@material-ui/core/Fab";
import DeleteIcon from "@material-ui/icons/Delete";
import Typography from "@material-ui/core/Typography";
import Divider from '@material-ui/core/Divider';
import ListTalents from "./ListQuirks";

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

              <List >
                <ListItem >
                  <ListItemAvatar>
                    <Avatar>
                      <img src="https://img.icons8.com/dusk/40/000000/flex-biceps.png" alt = "body value" />
                    </Avatar>
                  </ListItemAvatar>
                  <ListItemText primary={pony.bodyLevel.diceValue} />
                </ListItem>
                <ListItem >
                  <ListItemAvatar>
                    <Avatar>
                      <img src="https://img.icons8.com/dusk/40/000000/brain.png" alt="brain value"/>
                    </Avatar>
                  </ListItemAvatar>
                  <ListItemText primary={pony.mindLevel.diceValue} />
                </ListItem>
                <ListItem >
                  <ListItemAvatar>
                    <Avatar>
                      <img src="https://img.icons8.com/cotton/40/000000/lips.png" alt="Charm value"/>
                    </Avatar>
                  </ListItemAvatar>
                  <ListItemText primary={pony.charmLevel.diceValue} />
                </ListItem>
              </List>
            </Typography>
            <Divider />
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
  dividerFullWidth: {
    margin: `5px 0 0 2px`,
  },
  media: {
    height: 300
  },
  fab: {
    float: "right"
  }
};

export default withStyles(styles)(PoneyCard);
