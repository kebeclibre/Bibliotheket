package launcher;
import dao.LibraryDao;

public class Main {
	public static void main(String[] args) {
		LibraryDao libDao = new LibraryDao();
		System.out.println(libDao.getRacks());
	}
}
