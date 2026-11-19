package com.example.Wishlist.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import java.util.List;

// Repository interface for ItemDB entity - provides database operations for wishlist items
// Extends JpaRepository to get built-in CRUD methods (save, findAll, delete, etc.)
public interface ItemDAO extends JpaRepository<ItemDB, Long> {

    // Find all items belonging to a specific user
    @Query("SELECT i FROM ItemDB i WHERE i.userId = ?1")
    List<ItemDB> findItemByUser(int userId);

    // Find items by their unique ID
    @Query("SELECT i FROM ItemDB i WHERE i.id = ?1")
    List<ItemDB> findByItemId(int id);

    // Find items in a specific list for a specific user
    @Query("SELECT i FROM ItemDB i WHERE i.listName = ?1 AND i.userId = ?2")
    List<ItemDB> findItemByList(String listName, int userId);

    // Find items by name (search functionality)
    @Query("SELECT i FROM ItemDB i WHERE i.name = ?1")
    List<ItemDB> findItemByName(String name);

    // Delete all items associated with userId, this is to prevent orphanded items during User Delete
    // Use JPA's built-in delete by specification
    @Transactional
    void deleteByUserId(int userId);
}
