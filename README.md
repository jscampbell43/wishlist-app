# Wishlist Application

A modern full-stack web application for managing personal wishlists with items containing names, descriptions, links, and images.

## Project Overview

Wishlist is a full-stack web application that allows users to:
- Create personal accounts with secure password authentication
- Add items to their wishlist with customizable details
- Organize items into lists
- Update and delete items
- Manage their account settings

The application features a modern React SPA frontend and a Spring Boot REST API backend with SQLite database persistence.

## Technology Stack

### Backend
- **Language:** Java 21
- **Framework:** Spring Boot 3.2.0
- **ORM:** JPA/Hibernate 6.3.1
- **Database:** SQLite (WishlistDatabase.db)
- **Security:** BCrypt password hashing
- **API Documentation:** SpringDoc OpenAPI (Swagger UI)
- **Build Tool:** Maven with Maven Wrapper
- **Server:** Embedded Tomcat 10.1.16
- **Connection Pool:** HikariCP

### Frontend
- **Language:** JavaScript (ES6+)
- **Framework:** React 19.3.1
- **Build Tool:** Vite 8.3.5
- **Routing:** React Router 7.18.4
- **HTTP Client:** Axios
- **Styling:** Tailwind CSS 3.4.19
- **State Management:** React Context API (AuthContext)

## Features

### User Management
- ✅ User signup with BCrypt password hashing
- ✅ User login with password verification
- ✅ User logout with session clearing
- ✅ Update username and password
- ✅ Delete account with all associated items
- ✅ Session persistence across page refreshes

### Item Management
- ✅ Add items to wishlist (name, description, link, image, list)
- ✅ View all items for logged-in user
- ✅ View items filtered by list name
- ✅ Update existing items
- ✅ Delete items
- ✅ Search items by list name
- ✅ Responsive card layout with scrollable long descriptions

### Security Features
- ✅ BCrypt password hashing (never stores plain text passwords)
- ✅ Ownership-based access control (users can only modify their own data)
- ✅ Protected routes (React Router guards)
- ✅ CSRF partial protection via SameSite cookie attribute (lax)
- ✅ Input validation on all API endpoints
- ✅ Cross-user access prevention (403 Forbidden)

### API Documentation
- ✅ Swagger UI available at `/swagger-ui.html`
- ✅ OpenAPI documentation at `/api-docs`
- ✅ Interactive API testing
- ✅ Request/response examples

## Setup Instructions

### Prerequisites
- Java 21 or higher
- Node.js 18 or higher
- npm or yarn

### Backend Setup

1. **Navigate to the project directory:**
   ```bash
   cd C:\Users\jscam\OneDrive\Desktop\fa21_groupA_project2\fa21_groupA_project2
   ```

2. **Run the Spring Boot application:**
   ```bash
   .\mvnw.cmd spring-boot:run
   ```

3. **Verify the backend is running:**
   - Open http://localhost:8080 in your browser
   - You should see the welcome page or a 404 (normal - frontend is separate)
   - Swagger UI available at http://localhost:8080/swagger-ui.html

### Frontend Setup

1. **Navigate to the frontend directory:**
   ```bash
   cd C:\Users\jscam\OneDrive\Desktop\fa21_groupA_project2\fa21_groupA_project2\frontend
   ```

2. **Install dependencies (first time only):**
   ```bash
   npm install
   ```

3. **Run the Vite development server:**
   ```bash
   npm run dev
   ```

4. **Access the application:**
   - Open http://localhost:5173 in your browser
   - The Vite proxy will forward API requests to the backend

### Accessing the Application

- **Frontend:** http://localhost:5173
- **Backend API:** http://localhost:8080
- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **API Docs:** http://localhost:8080/api-docs

## API Endpoints

### Users
- `POST /users/signup` - Register a new user
- `POST /users/login` - Authenticate a user
- `GET /users/logout` - Logout a user
- `GET /users/{username}` - Find user by username
- `GET /users/allUsers` - Get all users
- `PUT /users/update` - Update user account
- `DELETE /users/delete` - Delete user account

### Items
- `GET /items/allItems` - Get all items
- `GET /items/user/{user_id}` - Get items for a specific user
- `GET /items/list/{list_name}/user/{user_id}` - Get items from a specific list
- `POST /items/additem` - Add a new item
- `PUT /items/updateItem` - Update an existing item
- `DELETE /items/deleteItem` - Delete an item

For detailed API documentation with request/response examples, visit the Swagger UI at http://localhost:8080/swagger-ui.html

## Known Limitations

### Security
- **CSRF Protection:** Partial implementation via SameSite cookie attribute (lax)
  - Full CSRF protection requires Spring Security web security enabled or JWT authentication
  - Current implementation provides meaningful defense for development
  - Production deployment should implement JWT or proper Spring Security with CSRF tokens

### Database
- **SQLite in Production:** Not recommended for production use
  - Suitable for development and small-scale applications
  - Production should use PostgreSQL or MySQL
  - No concurrent write limitations in current usage

### Technical Debt
- **ItemDAO.addItem() ID Return:** Returns ID=0 placeholder in response
  - Uses native SQL INSERT that doesn't return auto-generated ID
  - Affects API response quality but not functionality
  - Solutions: Use JPA save() method or add separate query to fetch last inserted ID

### Future Enhancements
- Admin functionality (role-based access control, admin dashboard)
- List management (create/delete/rename lists)
- Unit and integration tests
- Docker containerization
- Production database (PostgreSQL/MySQL)
- JWT authentication for stateless sessions

## Architecture

### Application Type
- **Full-stack Web Application**
- **Architecture:** Client-Server (Monolithic Backend + SPA Frontend)
- **Paradigm:** REST API with Single Page Application
- **Authentication:** Manual session-based with BCrypt password hashing
- **Authorization:** Ownership-based access control

### Modern Practices Implemented
- RESTful API design with proper HTTP methods and status codes
- JSON request/response bodies with DTOs (Data Transfer Objects)
- Bean Validation (Jakarta Validation)
- Global exception handling with custom exceptions
- SPA architecture with client-side routing
- Functional React components with hooks
- Context API for global state management
- Responsive design with Tailwind CSS

## Development

### Running Both Servers

**Terminal 1 (Backend):**
```bash
cd C:\Users\jscam\OneDrive\Desktop\fa21_groupA_project2\fa21_groupA_project2
.\mvnw.cmd spring-boot:run
```

**Terminal 2 (Frontend):**
```bash
cd C:\Users\jscam\OneDrive\Desktop\fa21_groupA_project2\fa21_groupA_project2\frontend
npm run dev
```

### Database Queries

To query the SQLite database directly:
```bash
cd C:\Users\jscam\OneDrive\Desktop\fa21_groupA_project2\fa21_groupA_project2
sqlite3 WishlistDatabase.db
```

Example queries:
```sql
.tables                          -- View all tables
SELECT * FROM users;             -- View all users
SELECT * FROM items;             -- View all items
SELECT COUNT(*) FROM items;      -- Count total items
.quit                            -- Exit SQLite shell
```

## Testing

The application has been tested for:
- ✅ User lifecycle (signup, login, logout, account management)
- ✅ Item CRUD operations (add, view, update, delete)
- ✅ Security (ownership checks, unauthorized access)
- ✅ Error handling (validation, API errors, network errors)
- ✅ Cross-browser compatibility (Chrome, Firefox, Edge)
- ✅ Responsive design (desktop, tablet, mobile)
- ✅ Edge cases (special characters, large data, concurrent operations)

## License

This project is for educational purposes.

## Support

For issues or questions, please refer to the project documentation in AGENTS.md.
