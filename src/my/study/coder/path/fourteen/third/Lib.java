package my.study.coder.path.fourteen.third;

import java.util.Arrays;
import java.util.Objects;

import static java.lang.System.out;

public class Lib {
    private static final int MAX_BOOKS = 5;
    Book[] books = new Book[MAX_BOOKS];

    public void add(Book book) {
        for (int i = 0; i <= books.length - 1; ++i) {
            if (books[i] == null) {
                books[i] = book;
                break;
            }
        }
    }

    public void remove(Book book) {
        for (int i = 0; i <= books.length - 1; ++i) {
            if (books[i] != null && books[i].equals(book)) {
                books[i] = null;
                break;
            }
        }
    }

    public void printBooks() {
        Arrays.stream(books)
                .filter(Objects::nonNull)
                .forEach(out::println);
    }
}
