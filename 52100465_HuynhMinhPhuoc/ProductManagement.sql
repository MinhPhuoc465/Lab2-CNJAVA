CREATE DATABASE ProductManagement;
USE ProductManagement;
DROP TABLE IF EXISTS Product;
CREATE TABLE `Product` (
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`price` INT UNSIGNED NULL DEFAULT NULL,
	`color` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
AUTO_INCREMENT=5
;
