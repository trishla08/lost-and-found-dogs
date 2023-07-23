import React from "react";
import { Link } from "react-router-dom";
import "./css/header.css";

const Header = () => {
  return (
    <header>
      <nav>
        <Link to="/add-lost">Add Lost Dog</Link>
        <Link to="/add-found">Add Found Dog</Link>
        <Link to="/my-posts">My Posts</Link>
        <Link to="/my-profile">My Profile</Link>
      </nav>
    </header>
  );
};

export default Header;
