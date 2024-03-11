package is.hi.hbv202g.assignment8;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

    private List<Book> books;
    private List<User> users;
    private List<Lending> lendings;

    //+LibrarySystem(): ctor
    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.lendings = new ArrayList<>();
    }

    //+addBookWithTitleAndNameOfSingleAuthor(String title, String authorName): void
    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName) {
        Author author = new Author(authorName);
        Book book = new Book();
        books.add(book);
    }

    //+addBookWithTitleAndAuthorList(String title, List<Author> authors): void
    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) {
        Book book = new Book(title, authors);
        books.add(book);
    }

    //+addStudentUser(String name, boolean feePaid): void
    public void addStudentUser(String name, boolean feePaid) {
        Student student = new Student(name, feePaid);
        users.add(student);
    }

    //+addFacultyMemberUser(String name, String department): void
    public void addFacultyMemberUser(String name, String department) {
        FacultyMember facultyMember = new FacultyMember(name, department);
        users.add(facultyMember);
    }

    //+findBookByTitle(String title): Book
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    //+findUserByName(String name): User
    public User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }


    //+borrowBook(User user, Book book): void
    public void borrowBook(User user, Book book) {
        // Implementation to borrow a book by a user
        Lending lending = new Lending(book, user);


    }


    //+extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate): void
    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) {
        // Implementation to extend lending of a book
        Lending lending = new Lending(book, facultyMember);
        newDueDate = LocalDate.now().plusDays(30);
        Lending newLending = new Lending(book, facultyMember, newDueDate);

    }

    //+returnBook(User user, Book book): void
    public void returnBook(User user, Book book) {
        // Implementation to return a book
        if (user instanceof Student) {
            Student student = (Student) user;
            student.setFeePaid(true);
        }
    }

}
