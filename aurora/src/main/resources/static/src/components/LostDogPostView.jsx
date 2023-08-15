import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import {
  Container,
  Typography,
  Card,
  CardContent,
  CardHeader,
  CardMedia,
  Divider,
  List,
  ListItem,
  ListItemText,
  Button,
  Dialog,
  DialogActions,
  DialogContent,
  DialogContentText,
  DialogTitle,
} from "@mui/material";
import { useNavigate } from "react-router-dom"; // Import the useNavigate hook

const LostDogPostView = () => {
  const navigate = useNavigate(); // Initialize the useNavigate hook
  var editPostData;
  const { postId } = useParams();
  const [post, setPost] = useState(null);
  const [deleteDialogOpen, setDeleteDialogOpen] = useState(false);

  useEffect(() => {
    const fetchPostDetails = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/v1/dog/lost/${postId}`
        );
        setPost(response.data);
      } catch (error) {
        console.error(error);
      }
    };

    fetchPostDetails();
  }, [postId]);

  const handleEdit = (post) => {
    // Extract the necessary data from the post object
    console.log(post);
    editPostData = post;
    // Navigate to the report lost form route with post data as state
    navigate("/add-lost", { state: { editPostData } });
  };

  const handleDelete = async () => {
    try {
      await axios.delete(`http://localhost:8080/v1/dog/lost/${postId}`);
      setDeleteDialogOpen(false);
      navigate("/my-posts"); // Use navigate to redirect
    } catch (error) {
      console.error(error);
    }
  };

  const openDeleteDialog = () => {
    setDeleteDialogOpen(true);
  };

  const closeDeleteDialog = () => {
    setDeleteDialogOpen(false);
  };
  if (!post) {
    return <Typography>Loading...</Typography>;
  }

  return (
    <Container maxWidth="md">
      <Card sx={{ marginTop: 2 }}>
        <CardHeader title={post.title} subheader={post.lostDog.dateLost} />
        <CardMedia
          component="img"
          height="300"
          image={`data:image/jpeg;base64,${post.lostDog.photo}`}
          alt={post.title}
        />
        <CardContent>
          <Typography variant="h6">Lost Dog Details:</Typography>
          <List>
            <ListItem>
              <ListItemText
                primary={`Name: ${post.lostDog.name}`}
                secondary={`Breed: ${post.lostDog.breed} | Age: ${post.lostDog.age}`}
              />
            </ListItem>
            <Divider />
            <ListItem>
              <ListItemText
                primary={`Gender: ${post.lostDog.gender}`}
                secondary={`Distinctive Features: ${post.lostDog.distinctiveFeatures}`}
              />
            </ListItem>
            <Divider />
            <ListItem>
              <ListItemText
                primary={`Last Known Location: ${post.lostDog.lastKnownLocation}`}
                secondary={`Owner: ${post.lostDog.ownerName} | Email: ${post.lostDog.ownerEmail} | Phone: ${post.lostDog.ownerPhone}`}
              />
            </ListItem>
            {/* Add more fields here */}
          </List>
          <Button
            variant="contained"
            color="primary"
            onClick={() => handleEdit(post)} // Pass a function reference
            sx={{ marginRight: 2 }}
          >
            Edit
          </Button>
          <Button variant="outlined" color="error" onClick={openDeleteDialog}>
            Delete
          </Button>
          {/* Confirmation Dialog */}
          <Dialog
            open={deleteDialogOpen}
            onClose={closeDeleteDialog}
            aria-labelledby="alert-dialog-title"
            aria-describedby="alert-dialog-description"
          >
            <DialogTitle id="alert-dialog-title">Delete Post?</DialogTitle>
            <DialogContent>
              <DialogContentText id="alert-dialog-description">
                Are you sure you want to delete this post?
              </DialogContentText>
            </DialogContent>
            <DialogActions>
              <Button onClick={closeDeleteDialog} color="primary">
                Cancel
              </Button>
              <Button onClick={handleDelete} color="error" autoFocus>
                Delete
              </Button>
            </DialogActions>
          </Dialog>
        </CardContent>
      </Card>
    </Container>
  );
};

export default LostDogPostView;
