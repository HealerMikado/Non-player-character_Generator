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

export const updatePony = pony => {
  return {
    type: "UPDATE_PONY",
    pony
  };
};
export const addPony = pony => {
  return {
    type: "ADD_PONY",
    pony
  };
};

export const fetchPonies = (isChargement = false) => (dispatch, getState) => {
  if (isChargement || getState().poneyReducer.ponies.length === 0) {
    return fetch("http://localhost:8080/characters")
      .then(response => response.json())
      .then(result => {
        dispatch(setPonies(result));
      });
  }
};

export const fetchPonyById = name => {
  return dispatch => {
    fetch(`http://localhost:8080/characters/${name}`)
      .then(response => response.json())
      .then(result => {
        dispatch(setPony(result));
      });
  };
};

export const postPony = (pony) => {
  return (dispatch,getState) => {
    fetch(
      "http://localhost:8080/creation",{      
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(pony)
      }).then(
        dispatch(addPony(pony))
      );
  };
};

export const fetchRandomPony = (isChargement = true) => {
  return (dispatch, getState) => {
    if (isChargement || getState().poneyReducer.pony.mindLevel.length === 0) {
      fetch("http://localhost:8080/generate")
        .then(response => response.json())
        .then(result => {
          dispatch(setPony(result));
        });
    }
  };
};
