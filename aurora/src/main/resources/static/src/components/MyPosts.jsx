import React, { useEffect, useState } from "react";
import axios from "axios";
import { getAuth, onAuthStateChanged } from "firebase/auth";
import {
  Container,
  Typography,
  List,
  ListItem,
  ListItemText,
  Button,
  Grid,
} from "@mui/material";
import { Link } from "react-router-dom";

const MyPosts = () => {
  const [lostDogPosts, setLostDogPosts] = useState([]);
  const [foundDogPosts, setFoundDogPosts] = useState([]);
  const [expandedPosts, setExpandedPosts] = useState({});

  const loadLostDogPosts = async () => {
    try {
      const auth = getAuth();
      const user = auth.currentUser;

      if (!user) {
        // User is not logged in, handle the case accordingly
        console.log("User is not logged in.");
        return;
      }
      const response = await axios.get(
        `http://localhost:8080/v1/user/${user.uid}/posts/lost`
      );
      setLostDogPosts(response.data);
      setFoundDogPosts([]); // Clear the foundDogPosts array to display only Lost Dog Posts
    } catch (error) {
      console.error(error);
    }
  };

  const loadFoundDogPosts = async () => {
    try {
      const auth = getAuth();
      const user = auth.currentUser;

      if (!user) {
        // User is not logged in, handle the case accordingly
        console.log("User is not logged in.");
        return;
      }
      const response = await axios.get(
        "http://localhost:8080/v1/user/${user.uid}/posts/found"
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

  const handleOpenPost = (postId) => {
    // Logic to open the post view page with the given postId
    // You can use React Router's Link component to navigate to the post view page
    // Example: <Link to={`/post/${postId}`}>Link</Link>
  };

  const renderLostDogPosts = () => {
    return lostDogPosts.map((post) => (
      <ListItem key={post.uid}>
        <ListItemText
          primary={post.title}
          secondary={`Name: ${post.lostDog.name} | Breed: ${post.lostDog.breed} | Age: ${post.lostDog.age}`}
        />
        <Button
          variant="outlined"
          component={Link}
          to={`/post-view/lost/${post.uid}`}
        >
          Open
        </Button>
      </ListItem>
    ));
  };

  const renderFoundDogPosts = () => {
    return foundDogPosts.map((post) => (
      <ListItem key={post.uid}>
        <ListItemText
          primary={post.title}
          secondary={`Name: ${post.foundDog.name} | Breed: ${post.foundDog.breed} | Age: ${post.foundDog.age}`}
        />
        <Button
          variant="outlined"
          component={Link}
          to={`/post-view/found/${post.uid}`}
        >
          Open
        </Button>
      </ListItem>
    ));
  };

  return (
    <Container maxWidth="md" className="my-posts-container">
      <Grid
        container
        justifyContent="center"
        spacing={2}
        style={{ marginTop: "16px" }}
      >
        <Grid item>
          <Button variant="contained" onClick={loadLostDogPosts}>
            View Lost Dog Posts
          </Button>
        </Grid>
        <Grid item>
          <Button variant="contained" onClick={loadFoundDogPosts}>
            View Found Dog Posts
          </Button>
        </Grid>
      </Grid>

      <List>
        {lostDogPosts.length > 0 && renderLostDogPosts()}
        {foundDogPosts.length > 0 && renderFoundDogPosts()}
      </List>
    </Container>
  );
};

export default MyPosts;
