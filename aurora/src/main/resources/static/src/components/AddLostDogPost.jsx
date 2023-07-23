import React, { useReducer, useState } from "react";
import axios from "axios";

const AddLostDogPostForm = () => {
  const [title, setTitle] = useState("");
  const [name, setName] = useState("");
  const [age, setAge] = useState(0);
  const [sex, setSex] = useState("");
  const [breed, setBreed] = useState("");
  const [ownerName, setOwnerName] = useState("");
  const [ownerEmail, setOwnerEmail] = useState("");
  const [ownerPhone, setOwnerPhone] = useState("");
  const [message, setMessage] = useState("");
  const [showMoreDetails, setShowMoreDetails] = useState(false); // State to toggle extra fields
  const [colours, setSelectedColors] = useState([]); // State to store selected colors
  const [size, setSelectedSize] = useState("UNSPECIFIED");
  const [collar, setCollar] = useState("UNSPECIFIED"); // Default value is "UNSPECIFIED"
  const [coat, setCoat] = useState("UNSPECIFIED");
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

    const newLostDogPost = {
      title,
      lostDog: {
        name,
        age,
        sex,
        breed,
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
        uid,
      },
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
      <h2 className="headerStyle">🐶 Add Lost Dog Post 🐾</h2>
      <form onSubmit={handleSubmit} className="formStyle">
        <div className="inputContainerStyle">
          <label htmlFor="title" className="labelStyle">
            What should be the title of your post?
          </label>
          <input
            type="text"
            id="title"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
            className="inputStyle"
            style={{ width: "100%", marginBottom: "15px" }}
          />
        </div>
        <div className="inputContainerStyle">
          <label htmlFor="name" className="labelStyle">
            Name:
          </label>
          <input
            type="text"
            id="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
            className="inputStyle"
          />
        </div>
        <div className="inputContainerStyle">
          <label htmlFor="age" className="labelStyle">
            Age:
          </label>
          <input
            type="number"
            id="age"
            value={age}
            onChange={(e) => setAge(e.target.value)}
            required
            className="inputStyle"
          />
        </div>
        <div className="inputContainerStyle">
          <label htmlFor="sex" className="labelStyle">
            Sex:
          </label>
          <select
            id="sex"
            value={sex}
            onChange={(e) => setSex(e.target.value)}
            required
            className="inputStyle"
          >
            <option value="">Select a sex</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
          </select>
        </div>
        <div className="inputContainerStyle">
          <label htmlFor="breed" className="labelStyle">
            Breed:
          </label>
          <input
            type="text"
            id="breed"
            value={breed}
            onChange={(e) => setBreed(e.target.value)}
            required
            className="inputStyle"
          />
        </div>
        <div className="inputContainerStyle">
          <label htmlFor="ownerName" className="labelStyle">
            Owner Name:
          </label>
          <input
            type="text"
            id="ownerName"
            value={ownerName}
            onChange={(e) => setOwnerName(e.target.value)}
            required
            className="inputStyle"
          />
        </div>
        <div className="inputContainerStyle">
          <label htmlFor="ownerEmail" className="labelStyle">
            Owner Email:
          </label>
          <input
            type="text"
            id="ownerEmail"
            value={ownerEmail}
            onChange={(e) => setOwnerEmail(e.target.value)}
            required
            className="inputStyle"
          />
        </div>
        <div className="inputContainerStyle">
          <label htmlFor="ownerPhone" className="labelStyle">
            Owner Phone:
          </label>
          <input
            type="text"
            id="ownerPhone"
            value={ownerPhone}
            onChange={(e) => setOwnerPhone(e.target.value)}
            required
            className="inputStyle"
          />
        </div>
        <div className="inputContainerStyle">
          <label htmlFor="message" className="labelStyle">
            Message you'd like to add:
          </label>
          <input
            type="text"
            id="message"
            value={message}
            onChange={(e) => setMessage(e.target.value)}
            required
            className="inputStyle"
          />
        </div>
        {!showMoreDetails && (
          <button
            type="button"
            className="addDetailsButton"
            onClick={() => setShowMoreDetails(true)}
          >
            Add more details
          </button>
        )}
        {/* Extra fields for DogPhysicalAttributes */}
        {showMoreDetails && (
          <>
            <div className="inputContainerStyle">
              <label className="labelStyle">Colours:</label>
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
            </div>
            <div className="inputContainerStyle">
              <label className="labelStyle">Size:</label>
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
            </div>
            <div className="inputContainerStyle">
              <label className="labelStyle">Collar:</label>
              <select value={collar} onChange={handleCollarChange}>
                <option value="UNSPECIFIED">UNSPECIFIED</option>
                <option value="COLLAR">COLLAR</option>
                <option value="NO_COLLAR">NO_COLLAR</option>
              </select>
            </div>
            <div className="inputContainerStyle">
              <label className="labelStyle">Coat:</label>
              <select value={coat} onChange={handleCoatChange}>
                <option value="UNSPECIFIED">UNSPECIFIED</option>
                <option value="COAT">COAT</option>
                <option value="NO_COAT">NO_COAT</option>
              </select>
            </div>
            {/* Add other input fields for DogPhysicalAttributes as needed */}
          </>
        )}

        {/* Add other fields of LostDog as needed */}
        <button type="submit" className="submitButtonStyle">
          Submit
        </button>
      </form>
    </div>
  );
};

export default AddLostDogPostForm;
