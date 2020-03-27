package com.pasha.arena.app.db.repository;

import com.pasha.arena.app.db.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsByUsernameAndPassword(String username, String password);

    User getByUsername(String username);

    User getByUsernameAndPassword(String username, String password);

    @Query("{ $and : [ { $or : [{ 'email' : ?0 }, { 'username' : ?0 } ]}, { 'password' : ?1 } ] }")
    User getUserByLoginStringAndPassword(String loginString, String password);
}
