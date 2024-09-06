

# Product Microservice

## Overview

The Product Microservice provides RESTful APIs for managing products in an e-commerce platform. It supports basic CRUD operations and allows access control based on user roles. This service is secured using Spring Security, and different endpoints have specific access permissions.

## Endpoints

### 1. Create Product

**Endpoint:** `POST /products`

**Description:** Creates a new product.

**Request Body:**

```json
{
  "id": "string",
  "name": "string",
  "category": "string",
  "price": "number",
  "description": "string"
}
```

**Permissions:** Requires `ADMIN` role.

**Responses:**

- `200 OK` - Returns the created product.

### 2. Update Product

**Endpoint:** `PUT /products/{id}`

**Description:** Updates an existing product by its ID.

**Path Variable:**

- `id` (string) - The ID of the product to be updated.

**Request Body:**

```json
{
  "name": "string",
  "category": "string",
  "price": "number",
  "description": "string"
}
```

**Permissions:** Requires `ADMIN` role.

**Responses:**

- `200 OK` - Returns the updated product.

### 3. Delete Product

**Endpoint:** `DELETE /products/{id}`

**Description:** Deletes a product by its ID.

**Path Variable:**

- `id` (string) - The ID of the product to be deleted.

**Permissions:** Requires `ADMIN` role.

**Responses:**

- `204 No Content` - Successfully deleted the product.

### 4. Get Products

**Endpoint:** `GET /products`

**Description:** Retrieves a list of products with optional filtering by category and search term.

**Query Parameters:**

- `category` (optional) - The category to filter products by.
- `search` (optional) - A search term to filter products by name or description.

**Permissions:** Requires `USER` or `ADMIN` role.

**Responses:**

- `200 OK` - Returns a list of products matching the criteria.

## Security

All endpoints are secured with Spring Security:

- **Create, Update, Delete**: Accessible only to users with the `ADMIN` role.
- **Get Products**: Accessible to users with `USER` or `ADMIN` roles.

## Configuration

Ensure that your security configuration is set up to allow access to the relevant endpoints based on user roles. Example configuration might look like:

```java
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**").permitAll()
        .requestMatchers("/products/**").hasRole("USER")
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
}
```

