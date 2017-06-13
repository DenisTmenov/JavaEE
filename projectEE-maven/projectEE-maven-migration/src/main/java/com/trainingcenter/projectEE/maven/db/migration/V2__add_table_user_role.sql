CREATE TABLE `user_role` (
  `id_role` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name_role` VARCHAR(255) NOT NULL,
  `add` BOOLEAN NOT NULL,
  `delete` BOOLEAN NOT NULL,
  `modify` BOOLEAN NOT NULL,
  `read` BOOLEAN NOT NULL,
  `fk_id_user` INTEGER NOT NULL,
  	
  CONSTRAINT `fk_id_user_in_user_role_to_user` FOREIGN KEY (`fk_id_user`) REFERENCES `user` (`id_user`)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);