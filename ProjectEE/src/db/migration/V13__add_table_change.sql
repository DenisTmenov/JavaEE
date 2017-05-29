CREATE TABLE `change` (
  `id_change` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `data` DATETIME  NOT NULL,
  `fk_user` INTEGER NOT NULL,
  `fk_pr_system` INTEGER NOT NULL,
  `fk_other_system` INTEGER NOT NULL,
  `fk_equipment` INTEGER NOT NULL,
  
  CONSTRAINT `fk_user_in_change_to_user` FOREIGN KEY (`fk_user`) REFERENCES `user` (`id_user`)
    	ON DELETE RESTRICT
    	ON UPDATE RESTRICT 
);

ALTER TABLE `change` ADD
	CONSTRAINT `fk_pr_system_in_change_to_primary_system` FOREIGN KEY (`fk_pr_system`) REFERENCES `primary_system` (`id_pr_system`)
		ON DELETE CASCADE
		ON UPDATE CASCADE;

ALTER TABLE `change` ADD
	CONSTRAINT `fk_other_system_in_change_to_other_system` FOREIGN KEY (`fk_other_system`) REFERENCES `other_system` (`id_other_system`)
		ON DELETE CASCADE
		ON UPDATE CASCADE;
		
ALTER TABLE `change` ADD
	CONSTRAINT `fk_equipment_in_change_to_equipment` FOREIGN KEY (`fk_equipment`) REFERENCES `equipment` (`id_equipment`)
		ON DELETE CASCADE
		ON UPDATE CASCADE;