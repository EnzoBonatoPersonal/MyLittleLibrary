import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Navbar from "./components/NavBar/Navbar";
import BooksList from "./components/BooksList/BooksList";
import UsersList from "./components/UsersList";

const App = () => {
    return (
        <Router>
            <Navbar />
            <div className="container">
                <Routes>
                    <Route path="/books" element={<BooksList />} />
                    <Route path="/users" element={<UsersList />} />
                </Routes>
            </div>
        </Router>
    );
};

export default App;
