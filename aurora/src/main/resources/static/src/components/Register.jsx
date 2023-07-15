import React, { useState } from "react";
import axios from "axios";

const RegisterPage = () => {
  const [emailAddress, setEmailAddress] = useState("");
  const [name, setName] = useState("");
  const [contactNumber, setContactNumber] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (event) => {
    event.preventDefault();

    const userData = {
      emailAddress: emailAddress,
      name: name,
      contactNumber: contactNumber,
      password: password,
    };

    try {
      const response = await axios.post(
        "http://localhost:8080/v1/user",
        userData
      );

      console.log("User registration successful");
      console.log(response.data); // Optional: Log the response data received from the server

      // Redirect to a success page or perform any other desired actions
    } catch (error) {
      console.log("Error occurred during user registration", error);
      // Handle the error, show an error message, etc.
    }
  };

  return (
    <div>
      <h1>Register</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="emailAddress"
          placeholder="emailAddress ID"
          value={emailAddress}
          onChange={(event) => setEmailAddress(event.target.value)}
        />
        <input
          type="text"
          placeholder="Full Name"
          value={name}
          onChange={(event) => setName(event.target.value)}
        />
        <input
          type="text"
          placeholder="Contact Number"
          value={contactNumber}
          onChange={(event) => setContactNumber(event.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(event) => setPassword(event.target.value)}
        />
        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default RegisterPage;
