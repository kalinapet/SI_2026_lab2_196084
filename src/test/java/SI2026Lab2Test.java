import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class SI2026Lab2Test {

    @Test
    void searchBookEveryStatementTest() {
        Library lib = new Library();
        lib.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        assertNotNull(lib.searchBookByTitle("Clean Code"));
        assertNull(lib.searchBookByTitle("Unknown"));
        assertThrows(IllegalArgumentException.class, () -> lib.searchBookByTitle(""));
    }

    @Test
    void borrowBookEveryBranchTest() {
        Library lib = new Library();
        lib.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy"));
        assertThrows(IllegalArgumentException.class, () -> lib.borrowBook("", "Author"));
        assertThrows(RuntimeException.class, () -> lib.borrowBook("Unknown", "Author"));
        assertDoesNotThrow(() -> lib.borrowBook("The Hobbit", "J.R.R. Tolkien"));
        assertThrows(RuntimeException.class, () -> lib.borrowBook("The Hobbit", "J.R.R. Tolkien"));
    }

    @Test
    void searchBookMultipleConditionTest() {
        Library lib = new Library();
        lib.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        assertNotNull(lib.searchBookByTitle("Clean Code"));
        lib.borrowBook("Clean Code", "Robert C. Martin");
        assertNull(lib.searchBookByTitle("Clean Code"));
        assertNull(lib.searchBookByTitle("Unknown"));
    }

    @Test
    void borrowBookMultipleConditionTest() {
        Library lib = new Library();
        lib.addBook(new Book("Effective Java", "Joshua Bloch", "Programming"));
        assertThrows(IllegalArgumentException.class, () -> lib.borrowBook("", ""));
        assertThrows(IllegalArgumentException.class, () -> lib.borrowBook("Effective Java", ""));
        assertDoesNotThrow(() -> lib.borrowBook("Effective Java", "Joshua Bloch"));
    }
}
