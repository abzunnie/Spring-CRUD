package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>
{

}
