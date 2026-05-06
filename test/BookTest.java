import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private static final Book A = Book.of("Dune", "Herbert", "111", 1965);
    private static final Book B = Book.of("Dune", "Herbert", "111", 1965);
    private static final Book DIFF_TITLE = Book.of("Dune Messiah", "Herbert", "111", 1969);
    private static final Book DIFF_ISBN  = Book.of("Dune", "Herbert", "222", 1965);

    // --- factory ---

    @Test
    void of_returnsBookWithCorrectFields() {
        String s = A.toString();
        assertTrue(s.contains("Dune"));
        assertTrue(s.contains("Herbert"));
        assertTrue(s.contains("111"));
        assertTrue(s.contains("1965"));
    }

    @Test
    void of_nullIsbn_throwsNullPointerException() {
        assertThrows(NullPointerException.class,
                () -> Book.of("Title", "Author", null, 2000));
    }

    // --- equals ---

    @Test
    void equals_sameInstance_isTrue() {
        assertEquals(A, A);
    }

    @Test
    void equals_identicalFields_isTrue() {
        assertEquals(A, B);
    }

    @Test
    void equals_differentTitle_samIsbn_isFalse() {
        assertNotEquals(A, DIFF_TITLE);
    }

    @Test
    void equals_differentIsbn_sameTitle_isFalse() {
        assertNotEquals(A, DIFF_ISBN);
    }

    @Test
    void equals_null_isFalse() {
        assertNotEquals(A, null);
    }

    @Test
    void equals_differentType_isFalse() {
        assertNotEquals(A, "Dune");
    }

    // --- hashCode contract ---

    @Test
    void hashCode_equalBooks_haveSameHashCode() {
        assertEquals(A.hashCode(), B.hashCode());
    }

    @Test
    void hashCode_differentTitle_likelyDifferent() {
        assertNotEquals(A.hashCode(), DIFF_TITLE.hashCode());
    }
}
