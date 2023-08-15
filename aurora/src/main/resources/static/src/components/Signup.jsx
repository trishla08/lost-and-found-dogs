import React, { useState } from "react";
import { NavLink, Link, useNavigate } from "react-router-dom";
import { createUserWithEmailAndPassword } from "firebase/auth";
import { auth } from "./firebase/firebase";
import SignupComponent from "./SignupComponent";

const Signup = () => {
  // const navigate = useNavigate();

  // const [email, setEmail] = useState("");
  // const [password, setPassword] = useState("");

  // const handleSubmit = async (e) => {
  //   e.preventDefault();

  //   try {
  //     // Create user in Firebase Authentication
  //     const userCredential = await createUserWithEmailAndPassword(
  //       auth,
  //       email,
  //       password
  //     );
  //     const firebaseUser = userCredential.user;

  //     // Use Firebase UID as the user ID in your backend
  //     const uid = firebaseUser.uid;

  //     // Send the user data to your backend
  //     const userData = {
  //       uid: uid,
  //       emailAddress: email,
  //       // Add other user data fields as needed
  //     };

  //     // Make a POST request to your backend API to store user data
  //     // Example using fetch API:
  //     await fetch("http://localhost:8080/v1/user", {
  //       method: "POST",
  //       headers: {
  //         "Content-Type": "application/json",
  //       },
  //       body: JSON.stringify(userData),
  //     });

  //     console.log("User signed up and data stored:", userData);

  //     // Navigate to the landing page or any other route after successful signup
  //     navigate("/landing");
  //   } catch (error) {
  //     const errorCode = error.code;
  //     const errorMessage = error.message;
  //     console.log("Signup error:", errorCode, errorMessage);
  //     // Handle signup error
  //   }
  // };

  return (
    <SignupComponent></SignupComponent>
    // <main>
    //   <section>
    //     <div>
    //       <div>
    //         <h1>FocusApp</h1>
    //         <form onSubmit={handleSubmit}>
    //           <div>
    //             <label htmlFor="email-address">Email address</label>
    //             <input
    //               type="email"
    //               label="Email address"
    //               value={email}
    //               onChange={(e) => setEmail(e.target.value)}
    //               required
    //               placeholder="Email address"
    //             />
    //           </div>

    //           <div>
    //             <label htmlFor="password">Password</label>
    //             <input
    //               type="password"
    //               label="Create password"
    //               value={password}
    //               onChange={(e) => setPassword(e.target.value)}
    //               required
    //               placeholder="Password"
    //             />
    //           </div>

    //           <button type="submit">Sign up</button>
    //         </form>

    //         <p>
    //           Already have an account? <Link to="/login">Sign in</Link>
    //         </p>
    //       </div>
    //     </div>
    //   </section>
    // </main>
  );
};

export default Signup;
