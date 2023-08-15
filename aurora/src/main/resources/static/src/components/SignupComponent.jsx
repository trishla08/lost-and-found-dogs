import React, { useState } from "react";
import {
  MDBContainer,
  MDBCol,
  MDBRow,
  MDBBtn,
  MDBIcon,
  MDBInput,
  MDBCheckbox,
} from "mdb-react-ui-kit";
import { signInWithEmailAndPassword } from "firebase/auth";
import { auth } from "./firebase/firebase";
import { NavLink, useNavigate } from "react-router-dom";
import { createUserWithEmailAndPassword } from "firebase/auth";

function SignupComponent() {
  const navigate = useNavigate();

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const onSubmit = async (e) => {
    e.preventDefault();

    try {
      // Create user in Firebase Authentication
      console.log(email);
      const userCredential = await createUserWithEmailAndPassword(
        auth,
        email,
        password
      );
      console.log(email);
      const firebaseUser = userCredential.user;

      // Use Firebase UID as the user ID in your backend
      const uid = firebaseUser.uid;

      // Send the user data to your backend
      const userData = {
        uid: uid,
        name: name,
        emailAddress: email,
        // Add other user data fields as needed
      };

      // Make a POST request to your backend API to store user data
      // Example using fetch API:
      await fetch("http://localhost:8080/v1/user", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(userData),
      });

      console.log("User signed up and data stored:", userData);

      // Navigate to the landing page or any other route after successful signup
      navigate("/landing");
    } catch (error) {
      const errorCode = error.code;
      const errorMessage = error.message;
      console.log("Signup error:", errorCode, errorMessage);
      // Handle signup error
    }
  };
  return (
    <MDBContainer fluid className="p-3 my-5 h-custom">
      <MDBRow>
        <MDBCol col="10" md="6">
          <center>
            <img
              src="https://imgtr.ee/images/2023/07/28/c9fe5ac6cadc9a075facd21b55ed5344.png"
              className="img-fluid"
              alt="Sample image"
            />
          </center>
        </MDBCol>

        <MDBCol col="4" md="6">
          <div className="d-flex flex-row align-items-center justify-content-center">
            <p className="lead fw-normal mb-0 me-3">Sign up with</p>

            <MDBBtn floating size="md" tag="a" className="me-2">
              <MDBIcon fab icon="facebook-f" />
            </MDBBtn>

            <MDBBtn floating size="md" tag="a" className="me-2">
              <MDBIcon fab icon="twitter" />
            </MDBBtn>

            <MDBBtn floating size="md" tag="a" className="me-2">
              <MDBIcon fab icon="linkedin-in" />
            </MDBBtn>
          </div>

          <div className="divider d-flex align-items-center my-4">
            <p className="text-center fw-bold mx-3 mb-0">Or </p>
          </div>

          <MDBInput
            wrapperClass="mb-4"
            label="Name"
            id="name"
            name="name"
            type="string"
            required
            placeholder="Name"
            onChange={(e) => setName(e.target.value)}
            size="lg"
          />
          <MDBInput
            wrapperClass="mb-4"
            label="Email address"
            id="email"
            name="email"
            type="email"
            required
            placeholder="Email address"
            onChange={(e) => setEmail(e.target.value)}
            size="lg"
          />
          <MDBInput
            wrapperClass="mb-4"
            label="Password"
            id="formControlLg"
            name="password"
            type="password"
            required
            placeholder="Password"
            onChange={(e) => setPassword(e.target.value)}
            size="lg"
          />

          <div className="text-center text-md-start mt-4 pt-2">
            <MDBBtn className="mb-0 px-5" size="lg" onClick={onSubmit}>
              Sign Up
            </MDBBtn>
            <p className="small fw-bold mt-2 pt-1 mb-2">
              Already have an account?{" "}
              <a href="/login" className="link-danger">
                Login
              </a>
            </p>
          </div>
        </MDBCol>
      </MDBRow>
    </MDBContainer>
  );
}

export default SignupComponent;
