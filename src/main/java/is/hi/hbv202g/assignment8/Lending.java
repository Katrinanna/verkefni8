package is.hi.hbv202g.assignment8;

import java.time.LocalDate;

public class Lending {

    private LocalDate duDate;
    private Book book;
    private User user;

    public Lending(Book book, User user) {
        this.duDate = LocalDate.now().plusDays(30);
        this.book = book;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDueDate() {
        return duDate;
    }

    public void setDueDate(LocalDate duDate) {
        this.duDate = duDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
