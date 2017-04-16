package com.kt.examples.rs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kt.examples.rs.api.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {}