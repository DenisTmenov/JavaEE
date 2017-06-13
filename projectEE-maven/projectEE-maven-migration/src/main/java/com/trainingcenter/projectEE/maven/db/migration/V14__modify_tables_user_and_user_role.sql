ALTER TABLE `user_role` DROP FOREIGN KEY `fk_id_user_in_user_role_to_user`;
ALTER TABLE `user_role` DROP COLUMN `fk_id_user`;

ALTER TABLE `user` ADD  `fk_role` INTEGER NOT NULL;
ALTER TABLE `user` ADD
	CONSTRAINT `fk_role_in_user_to_user_role` FOREIGN KEY (`fk_role`) REFERENCES `user_role` (`id_role`)
		ON DELETE CASCADE
		ON UPDATE CASCADE;

ALTER TABLE `user_info` DROP FOREIGN KEY `fk_id_role_in_user_info_to_user`;
ALTER TABLE `user_info` DROP COLUMN `fk_id_role`;
