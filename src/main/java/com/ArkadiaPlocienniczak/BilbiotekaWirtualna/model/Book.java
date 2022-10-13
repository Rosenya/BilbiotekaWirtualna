package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Book")
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "book_id")
        private Long id;
        @Column(length = 30)
        private String name;
        @Column(length = 30)
        private String author;
        @Column(length = 30)
        private Long tome;
        @Column(length = 30)
        private String type;
        @Column(length = 13)
        private String ean;
        @Column(length = 30)
        private String availibility;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "rent_id")
    private Rents rents;

    public Book(Long id, String name, String author, Long tome, String type, String ean, Category category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.tome = tome;
        this.type = type;
        this.ean = ean;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Long getTome() {
        return tome;
    }

    public String getType() {
        return type;
    }

    public String getEan() {
        return ean;
    }

    public String getAvailibility() {
        return availibility;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", tome=" + tome +
                ", type='" + type + '\'' +
                ", ean='" + ean + '\'' +
                ", availibility='" + availibility + '\'' +
                ", category=" + category +
                '}';
    }
}


