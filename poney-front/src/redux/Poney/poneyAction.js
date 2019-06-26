export const setPonies = ponies => {
  return {
    type: "SET_PONIES",
    ponies
  };
};

export const fetchPonies = () => {
  return (dispatch, getState) => {
    if (getState().poneyReducer.ponies.length === 0) {
      fetch("http://localhost:8080/characters")
        .then(response => response.json())
        .then(result => {
          dispatch(setPonies(result));
        });
    }
  };
};
