// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { getAuth } from "firebase/auth";

// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyB3e74rZZJqeaTr7eeJNEipUci64zUKvSg",
  authDomain: "aurora-1e95a.firebaseapp.com",
  projectId: "aurora-1e95a",
  storageBucket: "aurora-1e95a.appspot.com",
  messagingSenderId: "319365786374",
  appId: "1:319365786374:web:6f5814761a90384dd5cc87",
  measurementId: "G-2C8LZKZ16Y",
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);

// Initialize Firebase Authentication and get a reference to the service
export const auth = getAuth(app);
export default app;
