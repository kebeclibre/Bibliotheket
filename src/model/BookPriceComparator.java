package model;

import java.util.Comparator;

public class BookPriceComparator implements Comparator<Book>{

	@Override
	public int compare(Book arg0, Book arg1) {
		return arg0.getPrice() - arg1.getPrice();
	}
	
}
