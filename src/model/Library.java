package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Library {
	private List<Rack> racks = new ArrayList<Rack>();
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void addBook(Book b,Rack r) {
		if (racks.contains(r)) {
			r.addBook(b);
		} else {
			r.addBook(b);
			racks.add(r);
		}
		
	}
	
	public void rmBook(Book b) {
		for (Rack r : racks) {
			if (r.getAllBooks().contains(b)) {
				r.rmBook(b);
			}
		}
	}
	
	public void rmBook(Book b,Rack r) {
		if (racks.contains(r)) {
			r.rmBook(b);
		}
	}
	
	public List<Book> getAllBooks() {
		List<Book> res = new ArrayList<Book>();
		for (Rack r : racks) {
			res.addAll(r.getAllBooks());
		}
		return res;
	}
	
	public List<Book> getAllBooksByPrice() {
		List<Book> byprice = getAllBooks();
		Collections.sort(byprice, new BookPriceComparator());
		return byprice;
		
	}
	
}
		



	

