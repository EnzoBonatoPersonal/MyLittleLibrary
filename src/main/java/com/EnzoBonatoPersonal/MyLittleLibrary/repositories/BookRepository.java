package com.EnzoBonatoPersonal.MyLittleLibrary.repositories;

import com.EnzoBonatoPersonal.MyLittleLibrary.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitleIgnoreCase(@Param("title") String title);
}
