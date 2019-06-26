const initialState = {
  ponies: []
};

export const poneyReducer = (state = initialState, action) => {
  switch (action.type) {
    case "SET_PONIES": {
      return { ...state, ponies: action.ponies };
    }
    default:
      return state;
  }
};
