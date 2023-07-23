import React, { useState } from "react";
import axios from "axios";

const MyPosts = () => {
  const [lostDogPosts, setLostDogPosts] = useState([]);
  const [foundDogPosts, setFoundDogPosts] = useState([]);
  const [expandedPosts, setExpandedPosts] = useState({});

  const loadLostDogPosts = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/v1/user/1/posts/lost"
      ); // Assuming user ID is 1 for testing
      setLostDogPosts(response.data);
      setFoundDogPosts([]); // Clear the foundDogPosts array to display only Lost Dog Posts
    } catch (error) {
      console.error(error);
    }
  };

  const loadFoundDogPosts = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/v1/user/1/posts/found"
      ); // Assuming user ID is 1 for testing
      setFoundDogPosts(response.data);
      setLostDogPosts([]); // Clear the lostDogPosts array to display only Found Dog Posts
    } catch (error) {
      console.error(error);
    }
  };

  const toggleExpand = (postId) => {
    setExpandedPosts((prevState) => ({
      ...prevState,
      [postId]: !prevState[postId],
    }));
  };

  const renderLostDogPosts = () => {
    return lostDogPosts.map((post) => (
      <div key={post.uid} className="post-card">
        <h3>{post.title}</h3>
        <p>Name: {post.lostDog.name}</p>
        <p>Breed: {post.lostDog.breed}</p>
        <p>Age: {post.lostDog.age}</p>
        {/* Display other relevant post details */}
        <button onClick={() => toggleExpand(post.uid)}>Expand</button>
        {expandedPosts[post.uid] && (
          <div>
            <p>Gender: {post.lostDog.gender}</p>
            {/* Add more details here */}
          </div>
        )}
      </div>
    ));
  };

  const renderFoundDogPosts = () => {
    return foundDogPosts.map((post) => (
      <div key={post.uid} className="post-card">
        <h3>{post.title}</h3>
        <p>Name: {post.foundDog.name}</p>
        <p>Breed: {post.foundDog.breed}</p>
        <p>Age: {post.foundDog.age}</p>
        {/* Display other relevant post details */}
        <button onClick={() => toggleExpand(post.uid)}>Expand</button>
        {expandedPosts[post.uid] && (
          <div>
            <p>Gender: {post.foundDog.gender}</p>
            {/* Add more details here */}
          </div>
        )}
      </div>
    ));
  };

  return (
    <div className="my-posts-container">
      <div className="post-buttons">
        {/* Button to view Lost Dog Posts */}
        <button onClick={loadLostDogPosts}>View Lost Dog Posts</button>
        {/* Button to view Found Dog Posts */}
        <button onClick={loadFoundDogPosts}>View Found Dog Posts</button>
      </div>

      {/* Render the Lost Dog Posts */}
      {lostDogPosts.length > 0 && renderLostDogPosts()}

      {/* Render the Found Dog Posts */}
      {foundDogPosts.length > 0 && renderFoundDogPosts()}
    </div>
  );
};

export default MyPosts;
