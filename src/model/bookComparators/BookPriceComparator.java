package model.bookComparators;

import java.util.Comparator;

import model.Book;

public class BookPriceComparator implements Comparator<Book>{

	@Override
	public int compare(Book arg0, Book arg1) {
		return arg0.getPrice() - arg1.getPrice();
	}
	
}
