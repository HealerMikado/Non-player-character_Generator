import React from "React";
import { Tooltip, Fab } from "@material-ui/core";
import { FilterVintageRounded } from "@material-ui/icons";
import { makeStyles } from "@material-ui/core/styles";
import FormDialog from "./FormDialog";

export default function DialogForm() {
  const classes = useStyles();
  return (
    <FormDialog>
      <Tooltip title="Ajouter un nouveau poney random">
        <Fab variant="round" aria-label="AddRandom" className={classes.fab}>
          <FilterVintageRounded className={classes.extendedIcon} />
        </Fab>
      </Tooltip>
    </FormDialog>
  );
}

const useStyles = makeStyles(theme => ({
  fab: {
    background: "linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)",
    border: 0,
    borderRadius: 3,
    boxShadow: "0 3px 5px 2px rgba(255, 105, 135, .3)",
    color: "black",
    height: 48,
    padding: "0 30px",
    float: "left"
  }
}));
