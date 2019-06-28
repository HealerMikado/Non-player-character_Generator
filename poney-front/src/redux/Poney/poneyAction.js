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
    fetch(`{http://localhost:8080/characters/${name}}`)
      .then(response => response.json())
      .then(result => {
        dispatch(setPony(result));
      });
  };
};

export const postPony = pony => {
  return (dispatch, getState) => {
    fetch(
      "http://localhost:8080/creation",
      this.state.pony,
      {
        method: "POST", // *GET, POST, PUT, DELETE, etc.
        mode: "cors", // no-cors, cors, *same-origin
        cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
        credentials: "same-origin", // include, *same-origin, omit
        headers: {
          "Content-Type": "application/json"
          // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: "follow", // manual, *follow, error
        referrer: "no-referrer", // no-referrer, *client
        body: JSON.stringify(setPony)
      }.then(response => response.json())
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
