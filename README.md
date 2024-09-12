
# Product and Category Microservices API

This API allows users to manage products, categories, and product reviews.

## Authentication & Authorization

- **USER** and **ADMIN** roles are supported.
- Certain operations (like creating, updating, and deleting products or categories) are restricted to **ADMIN** role only.
- JWT-based authentication is assumed for securing the endpoints.

---

## Product Endpoints

### 1. Create a Product
- **URL**: `/products`
- **Method**: `POST`
- **Roles**: `ADMIN`
- **Description**: Create a new product.
- **Request Body**:
  ```json
  {
    "name": "Product Name",
    "description": "Product Description",
    "price": 100,
    "category": { "id": "category-id", "name": "Category Name" },
    "attributes": ["color", "size"],
    "imageUrls": ["image1.jpg", "image2.jpg"]
  }


---

### 2. Update a Product
- **URL**: `/products/{id}`
- **Method**: `PUT`
- **Roles**: `ADMIN`
- **Description**: Update a product by ID.
- **Request Body**: Same as the create product request.
- **Response**: Returns the updated product.

---

### 3. Delete a Product
- **URL**: `/products/{id}`
- **Method**: `DELETE`
- **Roles**: `ADMIN`
- **Description**: Deletes a product by ID.
- **Response**: No content.

---

### 4. Get All Products
- **URL**: `/products`
- **Method**: `GET`
- **Roles**: `USER`, `ADMIN`
- **Description**: Retrieves all products with optional filters for category or search.
- **Query Parameters**:
  - `category` (optional): Filter by category.
  - `search` (optional): Search by product name.
- **Response**: Returns a list of products.

---

### 5. Get a Product by ID
- **URL**: `/products/{id}`
- **Method**: `GET`
- **Roles**: `USER`, `ADMIN`
- **Description**: Get a product by its ID.
- **Response**: Returns the product details.

---

### 6. Search Products by Name
- **URL**: `/products/search`
- **Method**: `GET`
- **Roles**: `USER`, `ADMIN`
- **Description**: Search for products by name.
- **Query Parameters**:
  - `name`: The product name to search for.
- **Response**: Returns a list of matching products.

---

### 7. Filter Products by Category
- **URL**: `/products/category/{categoryId}`
- **Method**: `GET`
- **Roles**: `USER`, `ADMIN`
- **Description**: Filters products based on a category ID.
- **Response**: Returns a list of products for the specified category.

---

### 8. Get Reviews for a Product
- **URL**: `/products/{productId}/reviews`
- **Method**: `GET`
- **Roles**: `USER`, `ADMIN`
- **Description**: Get all reviews for a specific product.
- **Response**: Returns a list of reviews for the specified product.

---

### 9. Add a Review for a Product
- **URL**: `/products/{productId}/reviews`
- **Method**: `POST`
- **Roles**: `USER`, `ADMIN`
- **Description**: Add a review to a product.
- **Request Body**:
  ```json
  {
    "reviewerName": "John Doe",
    "comment": "Great product!",
    "rating": 5
  }
  ```
- **Response**: Returns the added review.

---

## Category Endpoints

### 1. Create a Category
- **URL**: `/api/categories`
- **Method**: `POST`
- **Roles**: `ADMIN`
- **Description**: Create a new category.
- **Request Body**:
  ```json
  {
    "name": "Category Name"
  }
  ```
- **Response**: Returns the created category.

---

### 2. Update a Category
- **URL**: `/api/categories/{id}`
- **Method**: `PUT`
- **Roles**: `ADMIN`
- **Description**: Update a category by ID.
- **Request Body**: Same as the create category request.
- **Response**: Returns the updated category.

---

### 3. Delete a Category
- **URL**: `/api/categories/{id}`
- **Method**: `DELETE`
- **Roles**: `ADMIN`
- **Description**: Delete a category by ID.
- **Response**: No content.

---

### 4. Get All Categories
- **URL**: `/api/categories`
- **Method**: `GET`
- **Roles**: `USER`, `ADMIN`
- **Description**: Retrieve all categories.
- **Response**: Returns a list of categories.

---

## Notes
- Ensure to pass the `Authorization` header with a valid JWT token for endpoints requiring authentication.
- Role-based access control is applied for secured endpoints. Ensure the appropriate role is assigned to the user before performing the actions.
