import React, { useEffect, useState } from "react";

function UsersList() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/users")
      .then((response) => response.json())
      .then((data) => setUsers(data));
  }, []);

  return (
    <div className="p-4">
      <h2 className="text-2xl mb-4">👤 Liste des Utilisateurs</h2>
      <ul>
        {users.map((user) => (
          <li key={user.id} className="border p-2 my-2">
            {user.name} - {user.email}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default UsersList;
