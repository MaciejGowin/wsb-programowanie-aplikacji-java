package pl.wsb.programowaniejava.maciejgowin;

public class Application {

    public static void main(String[] args) {
        BookService bookService = new BookService(new BookRepository());

        System.out.println("Add: " + bookService.addTitle("Mockbird"));
        System.out.println("Get: " + bookService.getTitle(0));
    }
}
