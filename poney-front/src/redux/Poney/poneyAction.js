export const setPonies = ponies => {
  return {
    type: "SET_PONIES",
    ponies
  };
};
export const setPony = pony => {
  return {
    type: "SET_PONY",
    pony
  };
};

export const addPony = pony => {
  return {
    type: "ADD_PONY",
    pony
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

export const fetchRandomPony = () => {
  return (dispatch, getState) => {
    fetch("http://localhost:8080/generate")
      .then(response => response.json())
      .then(result => {
        dispatch(setPony(result));
      });
  };
};
