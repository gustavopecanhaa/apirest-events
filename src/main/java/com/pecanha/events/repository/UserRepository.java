package com.pecanha.events.repository;

import com.pecanha.events.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByUserEmail(String userEmail);
}
