import { combineReducers } from "redux";

// Import reducers
import poneyReducer from "./Poney/index";
import raceReducer from "./Races/index";

// Combinage
const reducers = combineReducers({
  ...{ poneyReducer },
  ...{ raceReducer }
});

export default reducers;
