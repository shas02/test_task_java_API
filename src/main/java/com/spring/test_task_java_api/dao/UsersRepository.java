package com.spring.test_task_java_api.dao;

import com.spring.test_task_java_api.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UsersRepository extends MongoRepository <User, String>{

}
