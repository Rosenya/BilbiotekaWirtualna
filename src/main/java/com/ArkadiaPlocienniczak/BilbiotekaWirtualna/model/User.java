package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Table(name = "User")
public class User {

/*    @param user, wich generates entity into my sql table

 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(length = 30)
    private String name;
    @Column(length = 20)
    private String email;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Book> books;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
