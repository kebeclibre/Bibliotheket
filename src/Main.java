
public class Main {
	public static void main(String[] args) {
		Library bnf = new Library();
		Author meurice = new Author();
		meurice.setFirstname("guillaume");
		meurice.setLastname("Meurice");
		
		
		Author lordon = new Author("Lordon","Frederic");

		
		
		for (int i = 0; i <10; i++) {
			Book book = new Book(i+"123","bla"+i,meurice);
			bnf.addBook(book);
			Book b2 = new Book(i+10+"123","bla"+i+10,lordon);
			bnf.addBook(b2);
		}
		
		
		System.out.println(bnf.authorsBooks().toString());
		
	}
}
