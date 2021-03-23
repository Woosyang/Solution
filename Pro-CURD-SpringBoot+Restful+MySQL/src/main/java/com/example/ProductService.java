package com.example;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class ProductService {
	@Autowired
	private ProductRepository Repo;
	
	public List<Product> listAll() {
		return Repo.findAll();
	}
	
	public void save(Product Pro) {
		Repo.save(Pro);
	}
	
	public Product get(int ID) {
		return Repo.findById(ID).get();	
	}
	
	public void delete(int ID) {
		Repo.deleteById(ID);
	}
}
