import React from "react";
import { Route, Routes, useNavigate } from "react-router-dom";
import HomePage from "./components/homepage";
import LoginForm from "./components/Login";
import RegisterPage from "./components/Register";
import LandingPage from "./components/LandingPage";
import AddUserForm from "./components/AddUser";
import AddLostDogPostForm from "./components/AddLostDogPost";

const App = () => {
  const navigate = useNavigate();

  const handleSubmit = () => {
    // Perform login logic here
    // Assuming login is successful, navigate to the landing page
    navigate("/landing");
  };

  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route
        path="/login"
        element={<LoginForm handleSubmit={handleSubmit} />}
      />
      <Route
        path="/register"
        element={<RegisterPage handleSubmit={handleSubmit} />}
      />
      <Route path="/landing" element={<LandingPage />} />
      <Route path="/add-user" element={<AddUserForm />} />
      <Route path="/add-lost-dog-post" element={<AddLostDogPostForm />} />
    </Routes>
  );
};

export default App;
