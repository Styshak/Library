package com.styshak.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "genre")
@Access(AccessType.FIELD)
public class Genre implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        return id == genre.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
