package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import model.Author;
import model.Book;
import model.Rack;
import model.bookComparators.BookPriceComparator;
import model.bookComparators.IsbnComparator;
import model.bookComparators.TitleComparator;

public class LibraryDao {
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
	
	public void addAuthorToBook(Author auth,Book b) {
		b.addAuthor(auth);
	}
	
	public List<Book> getBooksByTitle() {
		List<Book> books = getAllBooks();
		Collections.sort(books,new TitleComparator());
		return books;
	}
	
	public List<Book> getBooksByIsbn() {
		List<Book> books = getAllBooks();
		Collections.sort(books,new IsbnComparator());
		return books;
	}
	
	public List<Rack> getRacks() {
		List<Rack> ret = new ArrayList<>();
		String sql = "select * from racks where visible=1";
		Connection con= null;
		Statement st= null;
		ResultSet res = null;
		
		try {
			con = DBConnector.getConnection();
			st = con.createStatement();
			res = st.executeQuery(sql);
			while (res.next()) {
				Rack r = new Rack();
				r.setDescription(res.getString("description"));
				r.setLocal(res.getString("local"));
				ret.add(r);
			}
			
		} catch (SQLException e) {
			
		} finally {
			DBConnector.closeResources(res, st, con);
		}
		return ret;
	}
	
	public int getAuthorId(Author auth) {
		int ret = 0;
		String sql = "select id from authors where visible = 1 and firstname = ? and lastname = ?";
		Connection con= null;
		PreparedStatement st= null;
		ResultSet res = null;
		
		try {
			con = DBConnector.getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, auth.getFirstname());
			st.setString(2, auth.getLastname());
			res = st.executeQuery(sql);
			if (res.next()) {
				ret = res.getInt("id");
			}
			
			
		} catch (SQLException e) {
			
		} finally {
			DBConnector.closeResources(res, st, con);
		}
		return ret;
	}
	
	public int getBookId(Book b) {
		int ret = 0;
		String sql = "select id from books where visible = 1 and isbn = ?";
		Connection con= null;
		PreparedStatement st= null;
		ResultSet res = null;
		
		try {
			con = DBConnector.getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, b.getIsbn());
			res = st.executeQuery(sql);
			if (res.next()) {
				ret = res.getInt("id");
			}
			
			
		} catch (SQLException e) {
			
		} finally {
			DBConnector.closeResources(res, st, con);
		}
		return ret;
	}
	
	public Book getBookById(int id) {
		Book ret = null;
		String sql = "select * from books where id = ?";
		Connection con= null;
		PreparedStatement st= null;
		ResultSet res = null;
		
		try {
			con = DBConnector.getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			res = st.executeQuery(sql);
			if (res.next()) {
				ret = new Book();
				ret.setIsbn(res.getString("isbn"));
				ret.setPrice(res.getInt("price"));
				ret.setTitle(res.getString("title"));
			}
			
			
		} catch (SQLException e) {
			
		} finally {
			DBConnector.closeResources(res, st, con);
		}
		return ret;
		}

	public Author getAuthorById(int id) {
		Author ret = null;
		String sql = "select * from author where id = ?";
		Connection con= null;
		PreparedStatement st= null;
		ResultSet res = null;
		
		try {
			con = DBConnector.getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			res = st.executeQuery(sql);
			if (res.next()) {
				ret = new Author();
				ret.setFirstname(res.getString("firstname"));
				ret.setLastname(res.getString("lastname"));
				ret.setBirthDate(new Date(res.getDate("birthdate").getTime()));
			}
			
			
		} catch (SQLException e) {
			
		} finally {
			DBConnector.closeResources(res, st, con);
		}
		return ret;
		}








}
	

		



	

