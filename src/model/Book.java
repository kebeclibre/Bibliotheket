package model;
import java.util.TreeSet;

public class Book implements Comparable<Book>{
	private String title;
	private TreeSet<Author> authors=new TreeSet<Author>();
	private String isbn;
	private TreeSet<String> category=new TreeSet<String>();
	private int price; 

	public Book(String isbn, String title){
		this.isbn = isbn;
		this.title = title;
	}
	
	public Book(String isbn, String title, Author... authors) {
		this(isbn,title);
		setAuthors(authors);
	}
	
	public Book(String isbn, String title, String...authors) {
		this(isbn,title);
		stringToAuthor(authors);
		
	}
	
	
	public TreeSet<Author> stringToAuthor(String... authors) {
		TreeSet<Author> finalResult = new TreeSet<Author>();
		for (String auth : authors) {
			Author result = new Author(); 
			String[] sep;
			sep = auth.split(",");
			result.setLastname(sep[0]);
			String firstname="";
			for (int i=1 ; i < sep.length; i++) {
				firstname += sep[i];
			}
			result.setFirstname(firstname);
			finalResult.add(result);
		}
		return finalResult;
	}
		
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthorsString() {
		StringBuilder sb = new StringBuilder(); 
		for (Author author : authors) {
			if (!authors.iterator().hasNext()) {
				sb.append(author.toString());
			} else {
				sb.append(author.toString());
				sb.append(", ");
			}
		}	
		return sb.toString();
	}
	
	public TreeSet<Author> getAuthors() {
		return authors;
	}
		
		
	public String getIsbn() {
		return isbn;
	}
	
	public String getCategory() {
		StringBuilder categories = new StringBuilder();
		for (String cat : this.category) {
			categories.append(cat);
		}
		return categories.toString();
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthors(Author... author) {
		for (Author auth : author) {
			this.authors.add(auth);
		}
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setCategory(String... category) {
		for (String cat : category) {
			this.category.add(cat);
		}
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}


	
	public int getPrice() {
		return price;
	}


	
	public void setPrice(int price) {
		this.price = price;
	}

	
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", isbn=" + isbn + ", price=" + price + ", Authors=" + getAuthorsString() + "]";
	}

	@Override
	public int compareTo(Book o) {
		return this.hashCode()-o.hashCode();	
	}

	
	
}
