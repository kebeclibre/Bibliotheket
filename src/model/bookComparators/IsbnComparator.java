package model.bookComparators;

import java.util.Comparator;

import model.Book;

public class IsbnComparator implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		return o1.compareTo(o2);
	}

}
