import getApiUrl from "../../utils/webServiceUtils";

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

export  const fetchPonies =  (isChargement = false) =>  (dispatch, getState) => {
  if (isChargement || getState().poneyReducer.ponies.length === 0) {
    fetch(`${ getApiUrl()}/characters`)
      .then(response => response.json())
      .then(result => {
        dispatch(setPonies(result))
      })
  }
};

export const fetchPonyById = name => {
  return   dispatch =>  {
    fetch(`${ getApiUrl()}/characters/${name}`)
      .then(response => response.json())
      .then(result => {
        dispatch(setPony(result));
      });
  };
};

export const postPony = (pony) => {
  console.log(pony);
  return  (dispatch) =>  {
    fetch(
      `${ getApiUrl()}/creation`, {
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
  return  (dispatch, getState) => {
    if (isChargement || getState().poneyReducer.pony.mindLevel.length === 0) {
      fetch(`${ getApiUrl()}/generate`)
        .then(response => response.json())
        .then(result => {
          dispatch(setPony(result));
        });
    }
  };
};
