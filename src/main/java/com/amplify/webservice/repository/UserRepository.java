package com.amplify.webservice.repository;

import com.amplify.webservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findById(String user);
}
