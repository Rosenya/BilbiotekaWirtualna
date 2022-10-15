package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.repository;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
