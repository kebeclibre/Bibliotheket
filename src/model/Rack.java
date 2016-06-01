package model;

import java.util.ArrayList;
import java.util.List;

public class Rack {
	private String local;
	private String description;
	private List<Book> books = new ArrayList<Book>();
	
	public String getLocal() {
		return local;
	}
	public String getDescription() {
		return description;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void rmBook(Book book) {
		books.remove(book);
	}
	
	public List<Book> getAllBooks() {
		return this.books;
	}
	
	
	
	
}
