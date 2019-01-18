package my.library.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String name;
    @Column(name = "pub_year")
    private Integer pubYear;
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "genre_id")
    private Genre genre;
    @ManyToMany(cascade = {CascadeType.PERSIST}, mappedBy = "books")
    private List<Author> authors;

    public void addAuthor(Author author) {
        if (authors == null) {
            authors = new ArrayList<>();
        }
        authors.add(author);
        if (!author.getBooks().contains(this)) {
            author.addBook(this);
        }
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long id) {
        this.bookId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPubYear() {
        return pubYear;
    }

    public void setPubYear(Integer pub_Year) {
        this.pubYear = pub_Year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Author> getAuthors() {
        return authors == null ? new ArrayList<>() : authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pubYear.equals(book.pubYear)&&
                Objects.equals(name, book.name) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pubYear, genre, authors);
    }
}
