import React from "react";
import { Link } from "react-router-dom";
import Login from "./Login";

const HomePage = () => {
  return (
    <div>
      <h1>Welcome to the Lost and Found for Dogs Website</h1>
      <Login />
    </div>
  );
};

export default HomePage;
