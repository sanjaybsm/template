package com.sanjay.template.repository;

import com.sanjay.template.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyApplicationRepository extends MongoRepository<User, String> {
}
