import React, { useEffect, useState } from "react";
import "./BooksList.css";

const BooksList = () => {
    const [books, setBooks] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/books")
            .then((response) => response.json())
            .then((data) => setBooks(data))
            .catch((error) => console.error("Erreur lors du fetch:", error));
    }, []);

    return (
        <div className="books-container">
            <h2 className="section-title">📖 Liste des Livres</h2>
            <ul className="book-list">
                {books.map((book) => (
                    <li key={book.id} className="book-item">
                        <div className="book-info">
                            <h3>{book.title} - {book.author}</h3>
                            <p className="description">{book.description}</p>
                            <p className="pages">{book.pages} pages</p>
                        </div>
                        <button className="louer-button">Louer</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default BooksList;
