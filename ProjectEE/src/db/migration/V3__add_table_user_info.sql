CREATE TABLE `user_info` (
  `id_info` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `first_name` VARCHAR(255),
  `last_name` VARCHAR(255),
  `email` VARCHAR(255),
  `fk_id_user` INTEGER,
  `fk_id_role` INTEGER,
	CONSTRAINT `fk_id_user_in_user_info_to_user` FOREIGN KEY (`fk_id_user`) REFERENCES `user` (`id_user`)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

ALTER TABLE `user_info` ADD
	CONSTRAINT `fk_id_role_in_user_info_to_user` FOREIGN KEY (`fk_id_role`) REFERENCES `user_role` (`id_role`)
		ON DELETE CASCADE
		ON UPDATE CASCADE;