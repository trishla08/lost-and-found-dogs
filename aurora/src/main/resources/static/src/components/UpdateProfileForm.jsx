import React, { useState } from "react";
import axios from "axios";
import "./css/updateProfileForm.css";

const UpdateProfileForm = ({ user, onUpdateSuccess, onCancel }) => {
  const [name, setName] = useState(user.name || "");
  const [emailAddress, setEmailAddress] = useState(user.emailAddress || "");
  const [contactNumber, setContactNumber] = useState(user.contactNumber || "");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const updatedUser = {
      ...user,
      name,
      emailAddress,
      contactNumber,
    };

    try {
      // Assuming the API endpoint is /v1/user/{id} for updating user by id
      await axios.put(`http://localhost:8080/v1/user/${user.id}`, updatedUser);
      onUpdateSuccess();
    } catch (error) {
      console.error(error);
      // Handle error as needed
    }
  };

  return (
    <div className="update-profile-container">
      <h2>Update Profile</h2>
      <form onSubmit={handleSubmit} className="update-profile-form">
        <div className="form-group">
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="emailAddress">Email:</label>
          <input
            type="email"
            id="emailAddress"
            value={emailAddress}
            onChange={(e) => setEmailAddress(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="contactNumber">Contact Number:</label>
          <input
            type="tel"
            id="contactNumber"
            value={contactNumber}
            onChange={(e) => setContactNumber(e.target.value)}
            required
          />
        </div>
        <div className="form-buttons">
          <button type="submit">Update</button>
          <button type="button" onClick={onCancel}>
            Cancel
          </button>
        </div>
      </form>
    </div>
  );
};

export default UpdateProfileForm;
