import React from "react";
import { Route, Routes, useNavigate } from "react-router-dom";
import HomePage from "./components/homepage";
import LoginForm from "./components/Login";
import RegisterPage from "./components/Register";
import Layout from "./components/Layout";
import Header from "./components/Header";
import MyProfile from "./components/MyProfile";
import MyPosts from "./components/MyPosts";

import LandingPage from "./components/LandingPage";
import AddUserForm from "./components/AddUser";
import AddLostDogPostForm from "./components/AddLostDogPost";
import AddFoundDogPostForm from "./components/AddFoundDogPost";

const App = () => {
  const navigate = useNavigate();

  const handleSubmit = () => {
    // Perform login logic here
    // Assuming login is successful, navigate to the landing page
    navigate("/landing");
  };

  return (
    <>
      <Header />
      <Routes>
        <Route element={<Layout />} />
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
        <Route path="/add-lost" element={<AddLostDogPostForm />} />
        <Route path="/add-found" element={<AddFoundDogPostForm />} />
        <Route path="/my-profile" element={<MyProfile />} />
        <Route path="/my-posts" element={<MyPosts />} />
      </Routes>
    </>
  );
};

export default App;