import React from "react";
import { BrowserRouter as Router } from "react-router-dom";
import Header from "./Components/Header";
import Menu from "./Components/Menu";
import Core from "./Components/Core/Core";
import Theme from "./Theme";
import { ThemeProvider } from "@material-ui/styles";
import Footer from "./Components/Core/Footer";

export default function App() {
  return (
    <ThemeProvider theme={Theme}>
      <Router>
        <div>
          <Header />
          <Menu />
          <Core />
          <Footer />
        </div>
      </Router>
    </ThemeProvider>
  );
}
