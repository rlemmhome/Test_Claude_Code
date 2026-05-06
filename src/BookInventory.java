import java.util.ArrayList;
import java.util.List;

public class BookInventory {
    private final List<Book> books = new ArrayList<>();

    public void add(Book book) {
        books.add(book);
    }

    public boolean remove(Book book) {
        return books.remove(book);
    }

    public List<Book> findByAuthor(String author) {
        return books.stream()
                .filter(b -> b.author().equalsIgnoreCase(author))
                .toList();
    }

    public String toCsv() {
        var sb = new StringBuilder("title,author,isbn,year\n");
        for (Book b : books) {
            sb.append(csvField(b.title())).append(',')
              .append(csvField(b.author())).append(',')
              .append(csvField(b.isbn())).append(',')
              .append(b.year()).append('\n');
        }
        return sb.toString();
    }

    private static String csvField(String value) {
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    }
}
