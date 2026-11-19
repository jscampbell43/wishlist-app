package com.example.Wishlist.Database;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

// JPA Entity representing a wishlist item in the ITEMS table
@Table(name="ITEMS")
@Entity
public class ItemDB {

    // Primary key - auto-generated unique identifier for the item
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // Foreign key referencing the user who owns this item
    @Column(name = "userId")
    private int userId;

    // Name/title of the wishlist item
    @NotBlank(message = "Item name must not be empty")
    @Column(name = "name")
    private String name;

    // Detailed description of the item
    @Column(name = "description")
    private String description;

    // URL link to the item (e.g., product page)
    @Column(name = "itemLink")
    private String itemLink;

    // URL to an image of the item
    @Column(name = "imgUrl")
    private String imgUrl;

    // Name of the wishlist list this item belongs to (for organization)
    @NotBlank(message = "List name must not be empty")
    @Column(name = "listName")
    private String listName;


    // Constructor to create a new item with all fields populated
    public ItemDB(int userId, String name, String description, String itemLink, String itemUrl, String listName) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.itemLink = itemLink;
        this.imgUrl = itemUrl;
        this.listName = listName;
    }

    // Default constructor required by JPA/Hibernate
    public ItemDB() {

    }

    // Getter for item ID
    public int getId() {
        return id;
    }

    // Setter for item ID (needed for update operations)
    public void setId(int id) {
        this.id = id;
    }

    // Getter for user ID (owner of the item)
    public int getUserId() {
        return userId;
    }

    // Setter for user ID
    public void setUserId(int user_id) {
        this.userId = userId;
    }

    // Getter for item name
    public String getName() {
        return name;
    }

    // Setter for item name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for item description
    public String getDescription() {
        return description;
    }

    // Setter for item description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for item link URL
    public String getItemLink() {
        return itemLink;
    }

    // Setter for item link URL
    public void setItemLink(String item_link) {
        this.itemLink = itemLink;
    }

    // Getter for image URL
    public String getImgUrl() {
        return imgUrl;
    }

    // Setter for image URL
    public void setImgUrl(String img_url) {
        this.imgUrl = imgUrl;
    }

    // Getter for list name
    public String getListName() {
        return listName;
    }

    // Setter for list name
    public void setListName(String list_name) {
        this.listName = listName;
    }
}
