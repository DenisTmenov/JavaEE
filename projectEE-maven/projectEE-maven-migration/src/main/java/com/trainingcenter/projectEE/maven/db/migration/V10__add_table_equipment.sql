CREATE TABLE `equipment` (
  `id_equipment` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` INTEGER NOT NULL,
  `fk_system` INTEGER NOT NULL,
  
  CONSTRAINT `fk_system_in_equipment_to_other_system` 
  	FOREIGN KEY (`fk_system`) REFERENCES `other_system` (`id_other_system`)
    	ON DELETE RESTRICT
    	ON UPDATE RESTRICT 
);