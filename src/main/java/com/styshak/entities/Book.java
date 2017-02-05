package com.styshak.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "book")
@Access(AccessType.FIELD)
public class Book implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JoinColumn(name = "author_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    @JoinColumn(name = "genre_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Genre genre;

    @JoinColumn(name = "publisher_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Publisher publisher;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private byte[] content;

    @Column(name = "page_count")
    private int pageCount;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publish_year")
    private int publishYear;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Long rating;

    @Column(name = "vote_count")
    private Long voteCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
