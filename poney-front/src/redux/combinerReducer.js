import { combineReducers } from "redux";
import { poneyReducer } from "./Poney/poneyReducer";

const combinedReducer = combineReducers({
  poneyReducer
});

export default combinedReducer;
