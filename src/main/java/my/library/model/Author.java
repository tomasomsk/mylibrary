package my.library.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    private String name;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "third_name")
    private String thirdName;
    @Column(name = "birth_year")
    private Integer birthYear;
    private String biography;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "author_book",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Book> books;

    public void addBook(Book book) {
        if (books == null) {
            books = new ArrayList<>();
        }
        books.add(book);
        if (!book.getAuthors().contains(this)) {
            book.addAuthor(this);
        }
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long id) {
        this.authorId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String second_Name) {
        this.secondName = second_Name;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String third_Name) {
        this.thirdName = third_Name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birth_Year) {
        this.birthYear = birth_Year;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Book> getBooks() {
        return books == null ? new ArrayList<>() : books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return birthYear.equals(author.birthYear) &&
                Objects.equals(name, author.name) &&
                Objects.equals(secondName, author.secondName) &&
                Objects.equals(thirdName, author.thirdName) &&
                Objects.equals(biography, author.biography) &&
                Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, secondName, thirdName, birthYear, biography, books);
    }
}
