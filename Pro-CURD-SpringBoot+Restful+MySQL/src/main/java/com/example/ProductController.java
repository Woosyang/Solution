package com.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController // by using that, there is no need to use @Responsebody
public class ProductController {
	@Autowired
	private ProductService Service;
	
	@GetMapping("/Products")
	public List<Product> List() {
		return Service.listAll();
	}
	
	@GetMapping("/Products/{ID}") // the ID of the URL matches the parameter int ID below
	/* it will still throws the exception if there is value offered
	eg: ID = 1 -> yes, ID = 2 -> yes, ID = 3 -> no
	ID = 3 is not assigned by any value in the database  
	public Product get(@PathVariable int ID) { // @PathVariable take the ID as the part of the URL
		return Service.get(ID);
	}
	*/
	// ResponseEntity extends HttpEntity
	// HttpEntity represents a Http request or a response entity
	public ResponseEntity<Product> get(@PathVariable int ID) {
		try {
			Product Pro = Service.get(ID); // for the catch if the ID does not exist
			return new ResponseEntity<Product>(Pro, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND); // 404
		}
	}
	
	@PostMapping("/Products")
	// @ResponseBody -> tells a controller that the object returned is 
	// automatically serialized into JSON and passed back into the 
	// HttpResponse object.
	
	// RequestBody -> it is used to convert the body of the HTTP request 
	//                to the java class object with the aid of selected 
	//                HTTP message converter. (JSON -> Object) 
	public void add(@RequestBody Product Pro) {
		String s = Pro.getName();
		String res = LongestPalindrome.findLongestPalindrome(s);
		Pro.setName(res);
		Service.save(Pro);
	}
	
	@PutMapping("/Products/{ID}")
	/* if the ID does not exist, it will not catch the exception
	public void update(@RequestBody Product Pro, @PathVariable int ID) {
		// Product existPro = Service.get(ID);
		Service.save(Pro);
	}
	*/
	public ResponseEntity<?> update(@RequestBody Product Pro, @PathVariable int ID) {
		try {
			Product existProduct = Service.get(ID); // to catch the exception
			Service.save(Pro);
			// return new ResponseEntity<>(Pro, HttpStatus.OK);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/Products/{ID}")
	public ResponseEntity<Product> delete(@PathVariable int ID) {
		try {
			Product existProduct = Service.get(ID);
			Service.delete(ID);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
}
