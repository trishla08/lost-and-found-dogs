import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

const FoundDogPostView = () => {
  const { postId } = useParams();
  const [post, setPost] = useState(null);

  useEffect(() => {
    const fetchPostDetails = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/v1/post/found/${postId}`
        );
        setPost(response.data);
      } catch (error) {
        console.error(error);
      }
    };

    fetchPostDetails();
  }, [postId]);

  if (!post) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h1>{post.title}</h1>
      {/* Display other Found Dog post details */}
    </div>
  );
};

export default FoundDogPostView;
