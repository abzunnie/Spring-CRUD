package com.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Books;
import com.example.demo.Repository.BookRepository;


@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookRepository bookRepo;
	
	//Display all books
	@GetMapping("/")
	public List<Books> getBookList(){
		return bookRepo.findAll();
		}

	//Add book details
		@RequestMapping(value= "/", method=RequestMethod.POST,consumes={"application/json"})
		public Books addBook(@RequestBody Books newbook)
		{
			return bookRepo.save(newbook);
			
		}
		}	
	
