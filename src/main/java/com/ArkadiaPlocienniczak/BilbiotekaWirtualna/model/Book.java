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
        @Column(length = 13)
        private String ean;
        @Column(length = 30)
        private String availibility;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    }

}
