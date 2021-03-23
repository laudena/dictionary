

--  While using hibernate, there is no need to create any table manually.
CREATE TABLE entry (
                       id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(60) NOT NULL,
                       file_name VARCHAR(512) NOT NULL,
                       translation VARCHAR(60),
                       reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)

