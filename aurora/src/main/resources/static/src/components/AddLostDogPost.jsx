import React, { useReducer, useState } from "react";
import axios from "axios";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import InputLabel from "@mui/material/InputLabel";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import MenuItem from "@mui/material/MenuItem";
import Grid from "@mui/material/Grid";
import { getAuth, onAuthStateChanged } from "firebase/auth";
import "./css/addLost.css";
import { useLocation } from "react-router-dom";
import { useEffect } from "react";

const AddLostDogPostForm = () => {
  const location = useLocation(); // Import useLocation hook from react-router-dom
  const { editPostData } = location.state || {}; // Access the post data from location state
  const { post } = location.state || {}; // Access the post data from location state
  const [title, setTitle] = useState(editPostData ? editPostData.title : "");
  const [name, setName] = useState(
    editPostData ? editPostData.lostDog.name : ""
  );
  const [age, setAge] = useState(editPostData ? editPostData.lostDog.age : 0);
  const [gender, setGender] = useState(
    editPostData && editPostData.lostDog.gender
      ? editPostData.lostDog.gender
      : ""
  );
  const [breed, setBreed] = useState(
    editPostData ? editPostData.lostDog.breed : ""
  );
  const [ownerName, setOwnerName] = useState(
    editPostData ? editPostData.lostDog.ownerName : ""
  );
  const [ownerEmail, setOwnerEmail] = useState(
    editPostData ? editPostData.lostDog.ownerEmail : ""
  );
  // const [ownerInfo, setOwnerInfo] = useState({ownerEmail:'',ownerName:});
  const [ownerPhone, setOwnerPhone] = useState(
    editPostData ? editPostData.lostDog.ownerPhone : ""
  );
  const [message, setMessage] = useState(
    editPostData ? editPostData.lostDog.message : ""
  );
  const [showMoreDetails, setShowMoreDetails] = useState(false); // State to toggle extra fields
  const [colours, setSelectedColors] = useState([]); // State to store selected colors
  const [size, setSelectedSize] = useState(
    editPostData ? editPostData.lostDog.distinctiveFeatures.size : "UNSPECIFIED"
  );
  const [collar, setCollar] = useState(
    editPostData
      ? editPostData.lostDog.distinctiveFeatures.collar
      : "UNSPECIFIED"
  );
  const [coat, setCoat] = useState(
    editPostData ? editPostData.lostDog.distinctiveFeatures.coat : "UNSPECIFIED"
  );
  const [uid, setUser] = useState(1);

  // List of color options
  const colorOptions = ["WHITE", "BROWN", "BLACK", "GOLDEN", "GREY"];
  const sizeOptions = ["SMALL", "MEDIUM", "LARGE"];
  const collarOptions = ["UNSPECIFIED", "COLLAR", "NO_COLLAR"];
  const handleColorChange = (color) => {
    if (colours.includes(color)) {
      setSelectedColors(
        colours.filter((selectedColor) => selectedColor !== color)
      );
    } else {
      setSelectedColors([...colours, color]);
    }
  };

  const handleCollarChange = (event) => {
    setCollar(event.target.value);
  };

  const handleCoatChange = (event) => {
    setCoat(event.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const auth = getAuth();
    const user = auth.currentUser;

    console.log(user);
    if (!user) {
      // User is not logged in, handle the case accordingly
      console.log("User is not logged in.");
      return;
    }

    const newLostDogPost = {
      title,
      lostDog: {
        name,
        breed,
        age,
        gender,
        ownerName,
        ownerEmail,
        ownerPhone,
        message,
        distinctiveFeatures: {
          colours,
          size,
          collar,
          coat,
          // wounded,
          // furry,
          // limping,
          // sterilised,
        },
      },
      user: {
        uid: user.uid,
      },
    };
    console.log(user.uid);

    try {
      if (editPostData) {
        newLostDogPost.uid = editPostData.uid;
        console.log(newLostDogPost);
        // If there's editPostData, perform a PUT request to update the post
        const response = await axios.put(
          `http://localhost:8080/v1/dog/lost/${editPostData.uid}`,
          newLostDogPost
        );
        console.log(response.data);
      } else {
        // Otherwise, perform a POST request to create a new post
        const response = await axios.post(
          "http://localhost:8080/v1/dog/lost",
          newLostDogPost
        );
        console.log(response.data);
      }
      // Reset form fields
      setTitle("");
      setName("");
      setAge(0);
      setGender("");
      setBreed("");
      setOwnerName("");
      setOwnerEmail("");
      setOwnerPhone("");
      setMessage("");
      setShowMoreDetails(false); // Reset the state for showing extra fields
    } catch (error) {
      console.error(error);
      // Handle error as needed
    }
  };

  return (
    <div className="container">
      <div className="banner">
        <h1>
          <center>{editPostData ? "Edit Your Post" : "Add a lost dog"}</center>
        </h1>
      </div>

      <form onSubmit={handleSubmit} className="formStyle">
        <Box marginBottom={2}>
          <InputLabel htmlFor="title" className="labelStyle">
            What should be the title of your post?
          </InputLabel>
          <TextField
            id="title"
            label="Title"
            variant="standard"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
            fullWidth
          />
        </Box>
        <Grid container spacing={2}>
          <Grid item xs={6}>
            <InputLabel htmlFor="name" className="labelStyle">
              Name of the dog
            </InputLabel>
            <TextField
              id="name"
              variant="standard"
              value={name}
              onChange={(e) => setName(e.target.value)}
              required
              fullWidth
            />
          </Grid>
        </Grid>

        <Grid container spacing={2}>
          <Grid item xs={4}>
            <InputLabel htmlFor="age" className="labelStyle">
              Age
            </InputLabel>
            <TextField
              type="number"
              id="age"
              value={age}
              onChange={(e) => setAge(e.target.value)}
              variant="standard"
              fullWidth
            />
          </Grid>
          <Grid item xs={4}>
            <InputLabel htmlFor="gender" className="labelStyle">
              Gender
            </InputLabel>
            <Select
              id="gender"
              value={gender}
              onChange={(e) => setGender(e.target.value)}
              variant="standard"
              fullWidth
            >
              <MenuItem value="MALE">Male</MenuItem>
              <MenuItem value="FEMALE">Female</MenuItem>
            </Select>
          </Grid>
          <Grid item xs={4}>
            <InputLabel htmlFor="breed" className="labelStyle">
              Breed
            </InputLabel>
            <TextField
              id="breed"
              variant="standard"
              value={breed}
              onChange={(e) => setBreed(e.target.value)}
              fullWidth
            />
          </Grid>
        </Grid>
        <hr></hr>
        <Grid container spacing={2}>
          <Grid item xs={4}>
            <Box marginBottom={2}>
              <InputLabel htmlFor="ownerName" className="labelStyle">
                Owner Name
              </InputLabel>
              <TextField
                id="ownerName"
                variant="standard"
                value={ownerName}
                onChange={(e) => setOwnerName(e.target.value)}
                required
                fullWidth
              />
            </Box>
          </Grid>
          <Grid item xs={4}>
            <Box marginBottom={2}>
              <InputLabel htmlFor="ownerEmail" className="labelStyle">
                Owner Email
              </InputLabel>
              <TextField
                id="ownerEmail"
                variant="standard"
                value={ownerEmail}
                onChange={(e) => setOwnerEmail(e.target.value)}
                required
                fullWidth
              />
            </Box>
          </Grid>
          <Grid item xs={4}>
            <Box marginBottom={2}>
              <InputLabel htmlFor="ownerPhone" className="labelStyle">
                Owner Phone
              </InputLabel>
              <TextField
                id="ownerPhone"
                variant="standard"
                value={ownerPhone}
                onChange={(e) => setOwnerPhone(e.target.value)}
                required
                fullWidth
              />
            </Box>
          </Grid>
        </Grid>
        <Box marginBottom={2}>
          <InputLabel htmlFor="message" className="labelStyle">
            Add a message to your post (anything additional you'd like to call
            out!)
          </InputLabel>
          <TextField
            id="message"
            label="Message"
            variant="standard"
            value={message}
            onChange={(e) => setMessage(e.target.value)}
            fullWidth
          />
        </Box>
        {!showMoreDetails && (
          <Button
            type="button"
            variant="contained"
            color="primary"
            onClick={() => setShowMoreDetails(true)}
          >
            Add more details
          </Button>
        )}
        {showMoreDetails && (
          <div>
            <Grid container spacing={2}>
              <Box marginBottom={2}>
                <Grid item xs={6}>
                  <InputLabel className="labelStyle">Colours</InputLabel>
                  <div className="colorOptionsContainer">
                    {colorOptions.map((color) => (
                      <div key={color} className="colorOption">
                        <label>
                          <input
                            type="checkbox"
                            checked={colours.includes(color)}
                            onChange={() => handleColorChange(color)}
                          />
                          {color}
                        </label>
                      </div>
                    ))}
                  </div>
                </Grid>
              </Box>
              <Box marginBottom={2}>
                <Grid item xs={6}>
                  <InputLabel className="labelStyle">Size:</InputLabel>
                  <div className="radioGroup">
                    {sizeOptions.map((sizeOption) => (
                      <div key={sizeOption} className="radioOption">
                        <label>
                          <input
                            type="radio"
                            value={sizeOption}
                            checked={size === sizeOption}
                            onChange={(e) => setSelectedSize(e.target.value)}
                          />
                          {sizeOption}
                        </label>
                      </div>
                    ))}
                  </div>
                </Grid>
              </Box>
            </Grid>
            <Grid container spacing={2}>
              <Box marginBottom={2}>
                <Grid item xs={6}>
                  <FormControl variant="standard">
                    <InputLabel className="labelStyle">Collar:</InputLabel>
                    <Select value={collar} onChange={handleCollarChange}>
                      <MenuItem value="UNSPECIFIED">UNSPECIFIED</MenuItem>
                      <MenuItem value="COLLAR">COLLAR</MenuItem>
                      <MenuItem value="NO_COLLAR">NO_COLLAR</MenuItem>
                    </Select>
                  </FormControl>
                </Grid>
              </Box>
              <Box marginBottom={6}>
                <Grid item xs={4}>
                  <FormControl variant="standard">
                    <InputLabel className="labelStyle">Coat:</InputLabel>
                    <Select value={coat} onChange={handleCoatChange}>
                      <MenuItem value="UNSPECIFIED">UNSPECIFIED</MenuItem>
                      <MenuItem value="COAT">COAT</MenuItem>
                      <MenuItem value="NO_COAT">NO_COAT</MenuItem>
                    </Select>
                  </FormControl>
                </Grid>
              </Box>
            </Grid>
            {/* Add other input fields for DogPhysicalAttributes as needed */}
          </div>
        )}

        <Box marginBottom={2}>
          <Button type="submit" variant="contained" color="primary">
            Submit
          </Button>
        </Box>
      </form>
    </div>
  );
};

export default AddLostDogPostForm;
