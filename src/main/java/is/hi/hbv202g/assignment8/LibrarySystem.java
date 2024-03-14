package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Book> books;
    private List<User> users;
    private List<Lending> lendings;

    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.lendings = new ArrayList<>();
    }

    // Method to add a book with a single author
    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName) {
        Author author = new Author(authorName);
        Book book = new Book(title, author);
        books.add(book);
    }

    // Method to add a book with a list of authors
    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) {
        Book book = new Book(title, authors);
        books.add(book);
    }

    // Method to add a student user
    public void addStudentUser(String name, boolean feePaid) {
        Student student = new Student(name, feePaid);
        users.add(student);
    }

    // Method to add a faculty member user
    public void addFacultyMemberUser(String name, String department) {
        FacultyMember facultyMember = new FacultyMember(name, department);
        users.add(facultyMember);
    }

    // Method to find a book by title
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    // Method to find a user by name
    public User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    // Method to borrow a book
    public void borrowBook(User user, Book book) {
        Lending lending = new Lending(book, user);
        lendings.add(lending);
    }

    // Method to extend a lending
    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) {
        for (Lending lending : lendings) {
            if (lending.getBook().equals(book) && lending.getUser().equals(facultyMember)) {
                lending.setDueDate(newDueDate);
                break;
            }
        }
    }

    // Method to return a book
    public void returnBook(User user, Book book) {
        for (Lending lending : lendings) {
            if (lending.getBook().equals(book) && lending.getUser().equals(user)) {
                lendings.remove(lending);
                break;
            }
        }
    }
}
