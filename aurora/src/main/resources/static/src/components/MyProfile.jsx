import React, { useEffect, useState } from "react";
import axios from "axios";
import UpdateProfileForm from "./UpdateProfileForm";
import "./css/myProfile.css";

const MyProfile = () => {
  const [user, setUser] = useState(null);
  const [isUpdateFormOpen, setIsUpdateFormOpen] = useState(false);

  useEffect(() => {
    // Fetch user data from the API when the component mounts
    fetchUserData();
  }, []);

  const fetchUserData = async () => {
    try {
      // Assuming the API endpoint is /v1/user/1 for user with id 1
      const response = await axios.get("http://localhost:8080/v1/user/1");
      setUser(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const handleUpdateButtonClick = () => {
    setIsUpdateFormOpen(true);
  };

  const handleUpdateFormSuccess = () => {
    setIsUpdateFormOpen(false);
    // You can optionally fetch updated user data after successful update
    // to reflect the changes immediately without a page refresh.
    fetchUserData();
  };

  const handleUpdateFormCancel = () => {
    setIsUpdateFormOpen(false);
  };

  return (
    <div className="profile-container">
      <div className="profile-header">
        <h2>My Profile</h2>
        {!isUpdateFormOpen && (
          <button onClick={handleUpdateButtonClick}>Update</button>
        )}
      </div>
      {!isUpdateFormOpen ? (
        <>
          {user ? (
            <div className="profile-details">
              <p>
                <strong>Name:</strong> {user.name}
              </p>
              <p>
                <strong>Email:</strong> {user.emailAddress}
              </p>
              <p>
                <strong>Contact Number:</strong> {user.contactNumber}
              </p>
            </div>
          ) : (
            <p>Loading user data...</p>
          )}
        </>
      ) : (
        <UpdateProfileForm
          user={user}
          onUpdateSuccess={handleUpdateFormSuccess}
          onCancel={handleUpdateFormCancel}
        />
      )}
    </div>
  );
};

export default MyProfile;
