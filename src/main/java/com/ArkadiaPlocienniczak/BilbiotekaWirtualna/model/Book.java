package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
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
        private String status;
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

    public Book(Long id, String name, String author, Long tome, String type, String ean, String status, String availibility, Category category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.tome = tome;
        this.type = type;
        this.ean = ean;
        this.status = status;
        this.availibility = availibility;
        this.category = category;
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
                ", status='" + status + '\'' +
                ", availibility='" + availibility + '\'' +
                ", category_id=" + category.getId() +
                ", user=" + user +
                ", rents=" + rents +
                '}';
    }
}


