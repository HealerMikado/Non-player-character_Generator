const initialState = {
  races: []
};

export const raceReducer = (state = initialState, action) => {
  switch (action.type) {
    case "SET_RACE": {
      return { ...state, races: action.payload };
    }
    default:
      return state;
  }
};
