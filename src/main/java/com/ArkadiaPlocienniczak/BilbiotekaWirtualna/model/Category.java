package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
@Data
    @Table(name = "Category")
    public class Category {

    /*    @param category, wich generates entity into my sql table

     */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "category_id")
        private Long id;
        @Column(length = 30)
        private String name;

        @OneToMany(mappedBy = "category")
        @JsonIgnore
        private List<Book> books;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


