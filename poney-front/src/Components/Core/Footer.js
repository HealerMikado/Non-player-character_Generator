import React from "react";
import Button from "@material-ui/core/Button";
import { Tooltip } from "@material-ui/core";
export default class Footer extends React.Component {
  render() {
    return (
      <Tooltip title="↑↑↓↓←→←→ba">
        <a href="https://en.wikipedia.org/wiki/Konami_Code">
          <Button color="secondary" />{" "}
        </a>
      </Tooltip>
    );
  }
}
