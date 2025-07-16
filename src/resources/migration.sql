CREATE TABLE products (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          account_number VARCHAR(255) NOT NULL,
                          balance DECIMAL(19, 2) NOT NULL,
                          type VARCHAR(255) NOT NULL,
                          user_id BIGINT,
                          FOREIGN KEY (user_id) REFERENCES users(id)
);