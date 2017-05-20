DROP SCHEMA IF EXISTS `jdbc_task02_db`;

CREATE SCHEMA IF NOT EXISTS `jdbc_task02_db`
CHARACTER SET `utf8`;

USE `jdbc_task02_db`;

CREATE TABLE `questions` (
  `id_q` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `question` VARCHAR(255) NOT NULL
);

CREATE TABLE `answers` (
  `id_a` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `answer` VARCHAR(255) NOT NULL,
  `trueOrFalse` VARCHAR(255) NOT NULL DEFAULT 'falce',
  `fk_question_id` INTEGER default NULL,

  CONSTRAINT `fk_answer_to_quwstion` FOREIGN KEY (`fk_question_id`) REFERENCES `questions` (`id_q`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);

INSERT INTO `jdbc_task02_db`.`questions` (`id_q`, `question`) VALUES (1, 'Выберите, пожалуйста, название животного.');
INSERT INTO `jdbc_task02_db`.`questions` (`id_q`, `question`) VALUES (2, 'Выберите, пожалуйста, на чем можно летать.');
INSERT INTO `jdbc_task02_db`.`questions` (`id_q`, `question`) VALUES (3, 'Как пишется ДОМ по английски.');

INSERT INTO `jdbc_task02_db`.`answers` (`id_a`, `answer`, `trueOrFalse`, `fk_question_id`) VALUES (1, 'Ягуар', 'true', 1 );
INSERT INTO `jdbc_task02_db`.`answers` (`id_a`, `answer`, `trueOrFalse`, `fk_question_id`) VALUES (2, 'Груша', 'falce', 1 );
INSERT INTO `jdbc_task02_db`.`answers` (`id_a`, `answer`, `trueOrFalse`, `fk_question_id`)  VALUES (3, 'Динамит', 'falce', 1 );
INSERT INTO `jdbc_task02_db`.`answers` (`id_a`, `answer`, `trueOrFalse`, `fk_question_id`)  VALUES (4, 'Ратуша', 'falce', 1 );

INSERT INTO `jdbc_task02_db`.`answers` (`id_a`, `answer`,  `fk_question_id`)  VALUES (5, 'Кенгуру', 2 );
INSERT INTO `jdbc_task02_db`.`answers` (`id_a`, `answer`,  `fk_question_id`)  VALUES (6, 'Шапка',  2 );
INSERT INTO `jdbc_task02_db`.`answers` (`id_a`, `answer`, `trueOrFalse`, `fk_question_id`)  VALUES (7, 'Планер', 'true', 2 );
INSERT INTO `jdbc_task02_db`.`answers` (`id_a`, `answer`,  `fk_question_id`)  VALUES (8, 'Какарда',  2 );

INSERT INTO `jdbc_task02_db`.`answers` (`answer`, `fk_question_id`) VALUES ('ДЪЁМ',  3 );
INSERT INTO `jdbc_task02_db`.`answers` (`answer`, `fk_question_id`) VALUES ('Кватэра', 3 );
INSERT INTO `jdbc_task02_db`.`answers` (`answer`, `fk_question_id`) VALUES ('Тюльпан', 3 );
INSERT INTO `jdbc_task02_db`.`answers` (`answer`, `trueOrFalse`, `fk_question_id`) VALUES ('HOUSE', 'true', 3 );
