CREATE TABLE `answers` (
  `id_a` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `answer` VARCHAR(255) NOT NULL,
  `trueOrFalse` VARCHAR(255) NOT NULL DEFAULT 'false',
  `fk_question_id` INTEGER default NULL,

  CONSTRAINT `fk_answer_to_quwstion` FOREIGN KEY (`fk_question_id`) REFERENCES `questions` (`id_q`)
    
);