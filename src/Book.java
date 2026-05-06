public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private final int year;

    private Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public static Book of(String title, String author, String isbn, int year) {
        if (isbn == null) throw new NullPointerException("isbn must not be null");
        return new Book(title, author, isbn, year);
    }

    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', isbn='%s', year=%d}", title, author, isbn, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return isbn.equals(book.isbn) && title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return 31 * isbn.hashCode() + title.hashCode();
    }
}