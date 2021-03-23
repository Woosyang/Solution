package com.example;
import javax.persistence.*;

@Entity
public class Product {
	private int id;
	private String name;
	private float price;
	
	public Product() {}
	
	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	@Id // declare the field of the Model as the primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // support the MysQL -> Auto_Increment
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
