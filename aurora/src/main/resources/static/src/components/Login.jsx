import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

const LoginForm = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  const [loggedInUser, setLoggedInUser] = useState(null);

  useEffect(() => {
    const storedUsername = localStorage.getItem("username");
    const storedPassword = localStorage.getItem("password");
    console.log("Stored username:", storedUsername);
    console.log("Stored password:", storedPassword);
  
    if (storedUsername && storedPassword) {
      setLoggedInUser({
        username: storedUsername,
        password: storedPassword,
      });
      console.log("User is logged in");
    } else {
      console.log("User is not logged in");
    }
  }, []); // Empty dependency array
    

  const handleSubmit = (event) => {
    event.preventDefault();

    console.log("Submitted username:", username);
    console.log("Submitted password:", password);

    // Check if the user entered a username and password
    if (username && password) {
      // Persist the user's account information in localStorage
      localStorage.setItem("username", username);
      localStorage.setItem("password", password);

      // Set the logged-in user
      setLoggedInUser({
        username: username,
        password: password,
      });
      console.log("User is logged in");
      navigate("/landing");
    } else {
      console.log("User is not logged in");
    }
  };

  return (
    <div>
      <h1>Login</h1>
      <input
        type="text"
        placeholder="Username"
        value={username}
        onChange={(event) => setUsername(event.target.value)}
      />
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(event) => setPassword(event.target.value)}
      />
      <button onClick={handleSubmit}>Login</button>
    </div>
  );
};

export default LoginForm;
