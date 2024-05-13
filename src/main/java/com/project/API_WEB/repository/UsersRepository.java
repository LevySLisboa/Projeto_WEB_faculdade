package com.project.API_WEB.repository;

import com.project.API_WEB.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsersRepository extends MongoRepository<User,String> {
    User findByEmail(String email);
}
