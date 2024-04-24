package com.project.API_WEB.repository;

import com.project.API_WEB.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User,String> {}
