package my.library.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer pub_Year;
    @OneToOne(/*cascade = CascadeType.ALL,*/ fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;
    @ManyToMany(/*cascade = CascadeType.ALL, */mappedBy = "books")
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

    public Integer getPub_Year() {
        return pub_Year;
    }

    public void setPub_Year(Integer pub_Year) {
        this.pub_Year = pub_Year;
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
        return pub_Year == book.pub_Year &&
                Objects.equals(name, book.name) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pub_Year, genre, authors);
    }
}
