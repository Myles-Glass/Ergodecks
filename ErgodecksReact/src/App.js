import React, { Component } from "react";
import Home from "./Components/Home";
//import SearchCard from "./Components/SearchCard";
import { Route, BrowserRouter as Router } from "react-router-dom";


class App extends Component {
  render() {
    //<Route exact path="/" component={Home} />

    return (
      <Router>     
        
        <Route exact path="/" component={Home} />
      </Router>
    );
  }
}

export default App;
