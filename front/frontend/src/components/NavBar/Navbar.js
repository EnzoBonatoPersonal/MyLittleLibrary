import React from "react";
import { Link } from "react-router-dom";
import "./Navbar.css"; // Importation du CSS

const Navbar = () => {
    return (
        <nav className="navbar">
            <h1 className="logo">📚 My Little Library</h1>
            <div className="nav-links">
                <Link to="/books" className="nav-button">Livres</Link>
                <Link to="/users" className="nav-button">Mes Livres</Link>
            </div>
        </nav>
    );
};

export default Navbar;
