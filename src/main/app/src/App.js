import React, { Component } from "react";
import { ListGroup, ListGroupItem } from "reactstrap";
import { CircleFill, PersonFill } from "react-bootstrap-icons";
import "./App.css";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      serverData: [],
      isLoaded: false,
      error: null,
    };
  }

  componentDidMount() {
    this.fetchUserData().then(
      (data) =>
        this.setState({ ...this.state, isLoaded: true, serverData: data }),
      (error) => this.setState({ ...this.state, isLoaded: true, error: error })
    );
  }

  async fetchUserData() {
    return await fetch(
      "/api/servers"
    ).then((response) => response.json());
  }

  render() {
    return (
      <div className="App">
        <header id="terra-header">
          <a href="/" id="title">
            terra
          </a>
          <PersonFill className="person-fill" color="white" size={25} />
        </header>
        <ServerList className="list-group" serverData={this.state.serverData} />
        <footer id="terra-footer">{`v0.0.1`}</footer>
      </div>
    );
  }
}

const ServerList = ({ serverData }) => (
  <ListGroup>
    {serverData.map((server) => (
      <ListGroupItem
        key={server.id}
        tag="a"
        href="#"
        className="justify-content-between"
        action
      >
        <CircleFill
          className="circle-icon "
          color={server.running ? "grey" : "green"}
          size={10}
        />
        {server.name}
      </ListGroupItem>
    ))}
  </ListGroup>
);

export default App;
