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
      return { ...state, pony: action.pony };

    case "UPDATE_PONY":
      return { ...state, ...action.pony };

    case "ADD_PONY":
      return {
        ...state,
        ponies: [...state.ponies, state.pony]
      };
    case "POST_PONIES":
      return {
        ...state
      };
    default:
      return state;
  }
};
