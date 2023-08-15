import React, { useState } from "react";
import { signInWithEmailAndPassword } from "firebase/auth";
import { auth } from "./firebase/firebase";
import { NavLink, useNavigate } from "react-router-dom";
import LoginComponent from "./LoginComponent";

const Login = () => {
  return (
    <>
      <LoginComponent />;
    </>
  );
};

export default Login;
