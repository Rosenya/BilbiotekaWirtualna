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
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(length = 30)
    private String firstname;
    @Column(length = 20)
    private String email;

    @OneToMany(cascade = CascadeType.REFRESH,mappedBy = "user")
    private Set<Book> books = new HashSet<>();
}
