import { combineReducers } from "redux";

// Import reducers
import poneyReducer from "./Poney/index";
import raceReducer from "./Races/index";
//import { reducer as formReducer } from "redux-form";

// Combinage
const reducers = combineReducers({
  ...{ poneyReducer },
  ...{ raceReducer }
  //  ...{ formReducer }
});

export default reducers;
