import React from "react";

export default function Topic({ match }) {
  return <h3>Requested Param: {match.params.id}</h3>;
}
