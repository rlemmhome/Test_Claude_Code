import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookInventoryTest {

    private BookInventory inventory;
    private final Book dune      = Book.of("Dune",        "Herbert", "111", 1965);
    private final Book messiah   = Book.of("Dune Messiah","Herbert", "222", 1969);
    private final Book foundation= Book.of("Foundation",  "Asimov",  "333", 1951);

    @BeforeEach
    void setUp() {
        inventory = new BookInventory();
    }

    // --- add ---

    @Test
    void add_bookAppearsInCsv() {
        inventory.add(dune);
        assertTrue(inventory.toCsv().contains("Dune"));
    }

    @Test
    void add_multipleBooks_allAppearInCsv() {
        inventory.add(dune);
        inventory.add(foundation);
        String csv = inventory.toCsv();
        assertTrue(csv.contains("Dune"));
        assertTrue(csv.contains("Foundation"));
    }

    // --- remove ---

    @Test
    void remove_existingBook_returnsTrue() {
        inventory.add(dune);
        assertTrue(inventory.remove(dune));
    }

    @Test
    void remove_existingBook_noLongerInCsv() {
        inventory.add(dune);
        inventory.add(foundation);
        inventory.remove(dune);
        assertFalse(inventory.toCsv().contains("Dune"));
        assertTrue(inventory.toCsv().contains("Foundation"));
    }

    @Test
    void remove_absentBook_returnsFalse() {
        assertFalse(inventory.remove(dune));
    }

    // --- findByAuthor ---

    @Test
    void findByAuthor_matchingBooks_returnsAll() {
        inventory.add(dune);
        inventory.add(messiah);
        inventory.add(foundation);
        List<Book> results = inventory.findByAuthor("Herbert");
        assertEquals(2, results.size());
        assertTrue(results.contains(dune));
        assertTrue(results.contains(messiah));
    }

    @Test
    void findByAuthor_caseInsensitive() {
        inventory.add(dune);
        assertEquals(1, inventory.findByAuthor("herbert").size());
        assertEquals(1, inventory.findByAuthor("HERBERT").size());
    }

    @Test
    void findByAuthor_noMatch_returnsEmptyList() {
        inventory.add(dune);
        assertTrue(inventory.findByAuthor("Tolkien").isEmpty());
    }

    @Test
    void findByAuthor_emptyInventory_returnsEmptyList() {
        assertTrue(inventory.findByAuthor("Herbert").isEmpty());
    }

    // --- toCsv ---

    @Test
    void toCsv_emptyInventory_returnsHeaderOnly() {
        assertEquals("title,author,isbn,year\n", inventory.toCsv());
    }

    @Test
    void toCsv_singleBook_correctRow() {
        inventory.add(foundation);
        String csv = inventory.toCsv();
        assertEquals("title,author,isbn,year\nFoundation,Asimov,333,1951\n", csv);
    }

    @Test
    void toCsv_fieldWithComma_isQuoted() {
        inventory.add(Book.of("Hello, World", "Author", "999", 2000));
        assertTrue(inventory.toCsv().contains("\"Hello, World\""));
    }

    @Test
    void toCsv_fieldWithQuote_isEscaped() {
        inventory.add(Book.of("Say \"Hi\"", "Author", "998", 2000));
        assertTrue(inventory.toCsv().contains("\"Say \"\"Hi\"\"\""));
    }

    @Test
    void toCsv_fieldWithNewline_isQuoted() {
        inventory.add(Book.of("Line1\nLine2", "Author", "997", 2000));
        assertTrue(inventory.toCsv().contains("\"Line1\nLine2\""));
    }
}
