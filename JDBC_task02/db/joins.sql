DROP SCHEMA IF EXISTS `training_db`;

CREATE SCHEMA IF NOT EXISTS `training_db`
CHARACTER SET `utf8`;

USE `training_db`;

CREATE TABLE `categories` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `category_name` VARCHAR(255) NOT NULL
);

CREATE TABLE `courses` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `course_name` VARCHAR(555) NOT NULL,
  `fk_category_id` INTEGER default NULL,

  CONSTRAINT `fk_course_to_category` FOREIGN KEY (`fk_category_id`) REFERENCES `categories` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);

INSERT INTO `categories` (`id`, `category_name`) VALUES (1, 'Программирование');
INSERT INTO `categories` (`id`, `category_name`) VALUES (2, 'Выживание');
INSERT INTO `categories` (`id`, `category_name`) VALUES (3, 'Рукоделие');

INSERT INTO `courses` (`id`, `course_name`, `fk_category_id`, `fk_profile_id`) VALUES (1, 'Java Enterprise Edition', 1, 1);
INSERT INTO `courses` (`id`, `course_name`, `fk_category_id`, `fk_profile_id`) VALUES (2, 'Езда в троллейбусе в час пик', 2, 1);

INSERT INTO `lessons` (`lesson_name`, `lesson_order`, `fk_course_id`) VALUES ('Web Development - HTML, CSS, JS', 1, 1);
INSERT INTO `lessons` (`lesson_name`, `lesson_order`, `fk_course_id`) VALUES ('Web Development on Java Platform', 2, 1);
INSERT INTO `lessons` (`lesson_name`, `lesson_order`, `fk_course_id`) VALUES ('Servlets API', 3, 1);
INSERT INTO `lessons` (`lesson_name`, `lesson_order`, `fk_course_id`) VALUES ('JSP - Java Server Pages', 4, 1);
