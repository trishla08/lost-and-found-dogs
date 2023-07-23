import React from "react";
import Header from "./Header";

const Layout = ({ children }) => {
  return (
    <div>
      <Header />
      {children} {/* This will render the content of the pages */}
    </div>
  );
};

export default Layout;
