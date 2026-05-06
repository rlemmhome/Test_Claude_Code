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
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}