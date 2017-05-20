DROP SCHEMA IF EXISTS `jdbc_task01_db`;

CREATE SCHEMA IF NOT EXISTS `jdbc_task01_db`
CHARACTER SET `utf8`;

USE `jdbc_task01_db`;

CREATE TABLE `products` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `products` VARCHAR(255) NOT NULL
);

INSERT INTO `jdbc_task01_db`.`products` (`id`, `products`) VALUES (1, 'Apple');
INSERT INTO `jdbc_task01_db`.`products` (`id`, `products`) VALUES (2, 'Bread');
INSERT INTO `jdbc_task01_db`.`products` (`id`, `products`) VALUES (3, 'Milk');
