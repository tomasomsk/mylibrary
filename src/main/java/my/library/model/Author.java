package my.library.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "AUTHORS")
public class Author {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String second_Name;
    private String third_Name;
    private Integer birth_Year;
    private String biography;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "AUTHORS_BOOKS",
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecond_Name() {
        return second_Name;
    }

    public void setSecond_Name(String second_Name) {
        this.second_Name = second_Name;
    }

    public String getThird_Name() {
        return third_Name;
    }

    public void setThird_Name(String third_Name) {
        this.third_Name = third_Name;
    }

    public Integer getBirth_Year() {
        return birth_Year;
    }

    public void setBirth_Year(Integer birth_Year) {
        this.birth_Year = birth_Year;
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
        return birth_Year.equals(author.birth_Year) &&
                Objects.equals(name, author.name) &&
                Objects.equals(second_Name, author.second_Name) &&
                Objects.equals(third_Name, author.third_Name) &&
                Objects.equals(biography, author.biography) &&
                Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, second_Name, third_Name, birth_Year, biography, books);
    }
}
