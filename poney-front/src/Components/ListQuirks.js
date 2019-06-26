import React from 'react';
import { withStyles } from "@material-ui/core/styles";
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import ListItemAvatar from '@material-ui/core/ListItemAvatar';
import Avatar from '@material-ui/core/Avatar';
import ImageIcon from '@material-ui/icons/Image';
import WorkIcon from '@material-ui/icons/Work';
import BeachAccessIcon from '@material-ui/icons/BeachAccess';


class ListQuirks extends React.Component {

  render() {

    const {quirks,classes} = this.props;
    console.log(classes.root);
    return (
        
      <List className={classes.root}>

        {quirks.map((quirk,i ) =>
         <React.Fragment key={i}>
          <ListItem >
            <ListItemAvatar>
              <Avatar>
              <img src="https://img.icons8.com/color/40/000000/drama.png"/>
              </Avatar>
            </ListItemAvatar>
            <ListItemText primary={quirk  }/>
          </ListItem>

         </React.Fragment>
        )}


      </List>

    );
  }

}

const styles = {
  root: {
    width: '100%',
    maxWidth: 360,
    //backgroundColor: theme.palette.background.paper,
  },
};


export default withStyles(styles)(ListQuirks);