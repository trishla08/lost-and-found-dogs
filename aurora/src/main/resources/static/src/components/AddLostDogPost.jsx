import React, { useState } from "react";
import axios from "axios";

const AddLostDogPostForm = () => {
  const [title, setTitle] = useState("");
  const [name, setName] = useState("");
  const [age, setAge] = useState(0);
  const [sex, setSex] = useState("");
  const [breed, setBreed] = useState("");
  // Add other fields of LostDog as needed

  const handleSubmit = async (e) => {
    e.preventDefault();

    const newLostDogPost = {
      title,
      lostDog: {
        name,
        age,
        sex,
        breed,
        // Add other fields of LostDog as needed
      },
      // Add other fields of LostDogPost as needed
    };

    try {
      const response = await axios.post(
        "http://localhost:8080/v1/dog/lost",
        newLostDogPost
      );
      console.log(response.data); // Handle the response as needed
      // Reset form fields
      setTitle("");
      setName("");
      setAge(0);
      setSex("");
      setBreed("");
      // Reset other fields of LostDog and LostDogPost as needed
    } catch (error) {
      console.error(error);
      // Handle error as needed
    }
  };

  return (
    <div>
      <h2>Add Lost Dog Post</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="title">Title:</label>
          <input
            type="text"
            id="title"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="age">Age:</label>
          <input
            type="number"
            id="age"
            value={age}
            onChange={(e) => setAge(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="sex">Sex:</label>
          <input
            type="text"
            id="sex"
            value={sex}
            onChange={(e) => setSex(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="breed">Breed:</label>
          <input
            type="text"
            id="breed"
            value={breed}
            onChange={(e) => setBreed(e.target.value)}
            required
          />
        </div>
        {/* Add other fields of LostDog as needed */}
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default AddLostDogPostForm;
