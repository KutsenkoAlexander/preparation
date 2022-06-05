package my.study.coder.path.fourteen.third;

import java.util.Objects;
import java.util.StringJoiner;

public class Book {
    private String title;
    private String author;
    private int year;
    private int pageCount;

    public Book(String title, String author, int year, int pageCount) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("author='" + author + "'")
                .add("year=" + year)
                .add("pageCount=" + pageCount)
                .toString();
    }

    private boolean isCorrectNumber(int number) {
        return number > 0;
    }

    private boolean isCorrectString(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (year != book.year) return false;
        if (pageCount != book.pageCount) return false;
        if (!Objects.equals(title, book.title)) return false;
        return Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + pageCount;
        return result;
    }
}
