package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Rents")
public class Rents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_id")
    private Long id;
    @Column(name = "rent_date")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @CreationTimestamp
    private Date rentDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
