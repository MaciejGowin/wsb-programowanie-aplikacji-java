package pl.wsb.programowaniejava.maciejgowin.zadanie27;

public class Book {

    private String isbn;
    private String title;

    public Book(final String isbn, final String title) {
        this.isbn = isbn;
        this.title = title;
    }

    @Override
    public String toString() {
        return "{" + isbn + ", " + title + "}";
    }
}
