package com.amplify.webservice.repository;

import com.amplify.webservice.model.AmplifyUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AmplifyUser, Long> {
    AmplifyUser findById(String user);
}
