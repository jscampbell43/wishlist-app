package com.example.Wishlist.Database;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;


// Repository interface for UserDB entity - provides database operations for user accounts
// Extends JpaRepository to get built-in CRUD methods (save, findAll, delete, etc.)
public interface UserDAO extends JpaRepository<UserDB, Long> {

    // Find a user by their unique user ID
    @Query("SELECT u FROM UserDB u WHERE u.userId = ?1")
    UserDB findUserByUserId(int userId);

    // Find a user by their username (used for login validation)
    @Query("SELECT u FROM UserDB u WHERE u.username = ?1")
    UserDB findUserByName(String username);

    // Find a password by their username (used for login validation)
    @Query("SELECT u FROM UserDB u WHERE u.username = ?1")
    UserDB findPasswordByUser(String username);

}
