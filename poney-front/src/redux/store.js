import thunk from "redux-thunk";
import { compose } from "redux";
import { applyMiddleware, createStore } from "redux";
import reducers from "./reducers";

const storeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const store = createStore(reducers, storeEnhancers(applyMiddleware(thunk)));

export default store;
