-- Crea la tabla categories
CREATE TABLE categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL
);

-- Crea la tabla products
CREATE TABLE products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL,
    description VARCHAR(200),
    stock DECIMAL(10, 2),
    price DECIMAL(10, 2),
    status VARCHAR(10),
    created_at DATE,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);


-- Inserta datos en la tabla categories (categorías)
INSERT INTO categories (name) VALUES ('shoes'); -- Inserta datos en la categoría "shoes" (zapatos)
INSERT INTO categories (name) VALUES ('books'); -- Inserta datos en la categoría "books" (libros)
INSERT INTO categories (name) VALUES ('electronics'); -- Inserta datos en la categoría "electronics" (electrónicos)

-- Inserta datos en la tabla products (productos)
INSERT INTO products (name, description, stock, price, status, created_at, category_id)
VALUES ('The Beast', 'Descripción de The Beast', 5, 49.99, 'DISPONIBLE', CURDATE(), 2); -- Inserta datos del producto "The Beast"

INSERT INTO products (name, description, stock, price, status, created_at, category_id)
VALUES ('Under Armour Men', 'Descripción de Under Armour Men', 5, 29.99, 'DISPONIBLE', CURRENT_TIMESTAMP, 2); -- Inserta datos del producto "Under Armour Men"

INSERT INTO products (name, description, stock, price, status, created_at, category_id)
VALUES ('Adidas air', 'Descripción de Adidas Air', 5, 329.99, 'DISPONIBLE', CURRENT_TIMESTAMP, 1); -- Inserta datos del producto "Adidas air"
