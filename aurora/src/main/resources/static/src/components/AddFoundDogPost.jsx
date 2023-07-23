import React, { useReducer, useState } from "react";
import axios from "axios";

const AddFoundDogPostForm = () => {
  const [title, setTitle] = useState("");
  const [sex, setSex] = useState("");
  const [breed, setBreed] = useState("");
  const [finderName, setFinderName] = useState("");
  const [finderEmail, setFinderEmail] = useState("");
  const [finderPhone, setFinderPhone] = useState("");
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

    const newFoundDogPost = {
      title,
      foundDog: {
        sex,
        breed,
        finderName,
        finderEmail,
        finderPhone,
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
        "http://localhost:8080/v1/dog/found",
        newFoundDogPost
      );
      console.log(response.data); // Handle the response as needed
      // Reset form fields
      setTitle("");
      setSex("");
      setBreed("");
      setFinderName("");
      setFinderEmail("");
      setFinderPhone("");
      setMessage("");
      setShowMoreDetails(false); // Reset the state for showing extra fields
    } catch (error) {
      console.error(error);
      // Handle error as needed
    }
  };

  return (
    <div className="container">
      <h2 className="headerStyle">🐶 Add Found Dog Post 🐾</h2>
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
          <label htmlFor="finderName" className="labelStyle">
            finder Name:
          </label>
          <input
            type="text"
            id="finderName"
            value={finderName}
            onChange={(e) => setFinderName(e.target.value)}
            required
            className="inputStyle"
          />
        </div>
        <div className="inputContainerStyle">
          <label htmlFor="finderEmail" className="labelStyle">
            finder Email:
          </label>
          <input
            type="text"
            id="finderEmail"
            value={finderEmail}
            onChange={(e) => setFinderEmail(e.target.value)}
            required
            className="inputStyle"
          />
        </div>
        <div className="inputContainerStyle">
          <label htmlFor="finderPhone" className="labelStyle">
            finder Phone:
          </label>
          <input
            type="text"
            id="finderPhone"
            value={finderPhone}
            onChange={(e) => setFinderPhone(e.target.value)}
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

export default AddFoundDogPostForm;
