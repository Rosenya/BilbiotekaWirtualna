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
    @Table(name = "Category")
    public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "category_id")
        private Long id;
        @Column(length = 30)
        private String name;

        @OneToMany(cascade = CascadeType.REFRESH,mappedBy = "category")
        private Set<Book> products = new HashSet<>();

    }

}
