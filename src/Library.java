

import java.util.Map;
import java.util.Map.Entry;
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
		TreeMap<Integer,Book> books = getBooksPrice();		
		// TreeMap<Integer,Book> list = getBooksPrice();
		if (mode) {
			books = (TreeMap<Integer,Book>) books.descendingMap();
		}
		
		for (Book b : books.values()) {
			System.out.println(b.toString());
		}
	}
	
}
