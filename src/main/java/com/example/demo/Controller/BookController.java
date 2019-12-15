package com.example.demo.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//Display only one books by id
		@GetMapping("/{id}")
		public Optional<Books> getBook(@PathVariable("id") Long id)
		{
			return bookRepo.findById(id);
			}

	//Add book details
		@RequestMapping(value= "/", method=RequestMethod.POST,consumes={"application/json"})
		public Books addBook(@RequestBody Books newbook)
		{
			return bookRepo.save(newbook);
			
		}
		
		//Edit book details
				@RequestMapping(value= "/{id}", method=RequestMethod.PATCH,consumes={"application/json"})
				public Books editBook(@RequestBody Books newbook)
				{
					return bookRepo.save(newbook);
				}
		
				//Delete book details
				@RequestMapping(value= "/{id}", method=RequestMethod.DELETE)
				public String deleteBook(@RequestBody Books newbook)
				{
					 bookRepo.delete(newbook);
					 return "Delete Successful";
				}
}	
	
