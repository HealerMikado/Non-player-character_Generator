const initialState = {
  ponies: []
};

export const poneyReducer = (state = initialState, action) => {
  switch (action.type) {
    case "SET_PONIES": {
      return { ...state, ponies: action.ponies };
    }
    case "ADD_PONY":
      return {
        ...state,
        ponies: [...state.arr, action.addPony]
      };
    default:
      return state;
  }
};
