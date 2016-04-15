

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;


public class Library {
	private TreeMap<String,Book> shelves=new TreeMap<String,Book>();
	
	public void addBook(Book book) {
		shelves.put(book.getIsbn(), book);
	}
	
	public void rmBook(Book book) {
		shelves.remove(book.getIsbn());
	}
	
	public TreeMap<Integer,Book> getBooksPrice() {
		 
		TreeMap<Integer,Book> priceBooks = new TreeMap<Integer,Book>();
		
		Set<Map.Entry<String,Book>> bookset = shelves.entrySet();
		 
		 for (Entry<String,Book> entry : bookset) {
			 priceBooks.put(entry.getValue().getPrice(),entry.getValue());
			 
		 }
		 
		return priceBooks;
	}

	public void printBooksPrice(boolean mode) {
		NavigableMap<Integer,Book> books = getBooksPrice();		
		// TreeMap<Integer,Book> list = getBooksPrice();
		if (mode) {
			books = books.descendingMap();
		}
		
		for (Book b : books.values()) {
			System.out.println(b.toString());
		}
	}
	
	public TreeMap<Author,Book[]> authorsBooks() {
	
	TreeMap<Author,Book[]> authorBooks = new TreeMap<Author,Book[]>();
	
	Set<Map.Entry<String,Book>> bookset = shelves.entrySet();
	 
	 for (Author auth : registeredAuth()) {
		 
	 }
	
	return authorBooks;
	}
		 
	
	public Set<Map.Entry<String,Book>> getEntrySet() {
		return  shelves.entrySet();
	}
	
	public Set<Author> registeredAuth() {
		Set<Author> result = new HashSet<Author>();
		
		for (Entry<String,Book> entry : getEntrySet()) {
			for (Author auth : entry.getValue().getAuthors()) {
				result.add(auth);
			}
		}
	
		return result;
	}

	// idee: en iterant sur la treemap, bloquer auteur, regarder s'il a pa d'autres bouquin, et le cas échéant lui ajouter à sa liste de boukin

}
