package com.sri.movie_app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sri.movie_app.model.User;

@Repository
// public interface UserRepository extends JpaRepository<User, Integer> {
//     // finds the user by email
//     Optional<User> findByEmail(String email);
//     // search for user by email containing a query string
//     List<User> findByEmailContaining(String query);
//     // search for user by email starting with query string
//     List<User> findByEmailStartingWith(String query);
//     // search for user by email ending with query string
//     List<User> findByEmailEndingWith(String query);
    
//     List<User> findByNameContainingIgnoreCase(String query);
// }

public interface UserRepository extends JpaRepository<User, Integer> {
    // finds the user by email
    Optional<User> findByEmail(String email);
    // search for user by email containing a query string
    List<User> findByNameContaining(String query);
    // search for user by email starting with query string
    List<User> findByNameStartingWith(String query);
    // search for user by email ending with query string
    List<User> findByNameEndingWith(String query);
    
    List<User> findByNameContainingIgnoreCase(String query);

    boolean existsByEmail(String email);
}