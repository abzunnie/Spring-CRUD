package com.example.demo;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Model.Author;
import com.example.demo.Model.Books;
import com.example.demo.Repository.AuthorRepository;
import com.example.demo.Repository.BookRepository;

@SpringBootApplication
public class SpringCrudApplication {

	@Autowired
	AuthorRepository authorRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
		System.out.println("Server started");
	}
	
	@PostConstruct
	public void createAuthors(){
		Author author1 = new Author("Chetan","Bhagat");
		Books book1 = new Books("Five Point Someone",author1,256);
		book1.setTags(Arrays.asList("Fiction","Comedy"));
		Author author2 = new Author("Dan","Brown");
		Books book2 = new Books("Da Vinci Code",author2,1156);
		book2.setTags(Arrays.asList("Fiction","Comedy"));
		authorRepo.save(author1);
		authorRepo.save(author2);
		bookRepo.save(book1);
		bookRepo.save(book2);
		
		
	}
	
	
}
