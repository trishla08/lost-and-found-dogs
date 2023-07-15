import { Fragment, useState } from "react";

function ListGroup() {
  const items = ["Create User", "Add Lost", "Add Post", "Contact Us"];

  const [selectedItem, setSelectedItem] = useState(-1);

  return (
    <>
      <h1>List</h1>
      <ul className="list-group">
        {items.map((item, index) => (
          <li
            key={item}
            className={
              selectedItem === index
                ? "list-group-item active"
                : "list-group-item"
            }
            onClick={() => setSelectedItem(index)}
          >
            {item}
          </li>
        ))}
      </ul>
    </>
  );
}

export default ListGroup;
