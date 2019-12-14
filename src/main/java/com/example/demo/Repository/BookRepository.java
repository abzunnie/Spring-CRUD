package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Long>{

}
