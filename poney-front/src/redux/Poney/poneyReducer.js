const initialState = {
  ponies: [],
  pony: {}
};

export const poneyReducer = (state = initialState, action) => {
  switch (action.type) {
    case "SET_PONIES": {
      return { ...state, ponies: action.ponies };
    }

    case "SET_PONY":
      return {
        ...state,
        pony: action.pony
      };

    case "ADD_PONY":
      return {
        ...state,
        ponies: [...state.ponies, action.pony]
      };
    default:
      return state;
  }
};