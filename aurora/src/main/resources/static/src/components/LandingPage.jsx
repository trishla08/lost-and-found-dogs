import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { MDBContainer, MDBRow, MDBCol, MDBBtn } from "mdb-react-ui-kit";
import "./css/LandingPage.css";

const TypingText = ({ text, typingSpeed }) => {
  const [displayText, setDisplayText] = useState("");

  useEffect(() => {
    let currentCharIndex = 0;

    const typingInterval = setInterval(() => {
      setDisplayText((prevText) => prevText + text[currentCharIndex]);
      currentCharIndex++;

      if (currentCharIndex === text.length) {
        clearInterval(typingInterval);
      }
    }, typingSpeed);

    return () => clearInterval(typingInterval);
  }, [text, typingSpeed]);

  return <>{displayText}</>;
};

const LandingPage = () => {
  return (
    <div className="landing-page">
      {/* Background Image for the top half */}
      <div className="background-image" />

      <MDBContainer fluid className="p-3 my-5 h-custom">
        {/* Rest of the Landing Page content */}
        <MDBRow>
          <MDBCol col="12" md="6">
            <h1 className="mb-4">
              <TypingText
                text="Helping your lost pets get home"
                typingSpeed={100}
              />
            </h1>
            <br />
            {/* Add some margin below the text */}
            <div className="button-container mb-4">
              {" "}
              {/* Add this class */}
              <div className="d-flex flex-row">
                {" "}
                {/* Add this class */}
                <Link to="/add-lost">
                  <MDBBtn className="mb-3 mx-2 btn-lg">Add Lost Dog</MDBBtn>
                </Link>
                <Link to="/add-found">
                  <MDBBtn className="mb-3 mx-2 btn-lg">Add Found Dog</MDBBtn>
                </Link>
                <Link to="/add-user">
                  <MDBBtn className="mb-3 mx-2 btn-lg">Add User</MDBBtn>
                </Link>
              </div>
            </div>
          </MDBCol>
          <MDBCol col="12" md="6">
            {/* Optional content for the right half of the landing page */}
            {/* Add your content here */}
          </MDBCol>
        </MDBRow>
      </MDBContainer>
    </div>
  );
};

export default LandingPage;
