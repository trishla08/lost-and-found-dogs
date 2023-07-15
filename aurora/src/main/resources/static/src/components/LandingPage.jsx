import React from 'react';
import { Link } from 'react-router-dom';

const LandingPage = () => {
  return (
    <div>
      <h2>Welcome to the Landing Page</h2>
      <p>Please select an option:</p>
      <ul>
        <li>
          <Link to="/add-user">Update User Details</Link>
        </li>
        <li>
          <Link to="/add-lost-dog-post">Add Lost Dog Post</Link>
        </li>
        <li>
          <Link to="/add-found-dog-post">Add Found Dog Post</Link>
        </li>
      </ul>
    </div>
  );
};

export default LandingPage;
