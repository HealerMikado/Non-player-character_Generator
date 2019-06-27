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

export const handleEqualChange = event => {
  this.setState({
    equal: event.target.value
  });
};

export const fetchPonies = (x = false) => {
  return (dispatch, getState) => {
    if (x || getState().poneyReducer.ponies.length === 0) {
      fetch("http://localhost:8080/characters")
        .then(response => response.json())
        .then(result => {
          dispatch(setPonies(result));
        });
    }
  };
};

export const fetchRandomPony = (x = true) => {
  return (dispatch, getState) => {
    if (x || getState().poneyReducer.pony.mindLevel.length === 0) {
      fetch("http://localhost:8080/generate")
        .then(response => response.json())
        .then(result => {
          dispatch(setPony(result));
        });
    }
  };
};
