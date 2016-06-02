package model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

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
	
	public TreeMap<Author,List<Book>> booksByAuthor() {
		TreeMap<Author,List<Book>> authorBooks = new TreeMap<>();
		for (Book book : books) {
			for (Author auth : book.getAuthors()) {
				if (!authorBooks.containsKey(auth)) {
					authorBooks.put(auth, new ArrayList<Book>());
				}
				authorBooks.get(auth).add(book);
			}
			
		}
		return authorBooks;
	}
	
	public TreeMap<String,List<Book>> getBooksByCategories() {
		TreeMap<String,List<Book>> catBooks = new TreeMap<>();
		for (Book book : books) {
			for (String cat : book.getCategories()) {
				if (!catBooks.containsKey(cat)) {
					catBooks.put(cat, new ArrayList<Book>());
				}
				catBooks.get(cat).add(book);
			}
			
		}
		return catBooks;
	}
	
	
	
}
