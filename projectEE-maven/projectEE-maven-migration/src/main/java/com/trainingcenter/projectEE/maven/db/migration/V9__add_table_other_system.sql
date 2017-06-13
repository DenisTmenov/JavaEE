CREATE TABLE `other_system` (
  `id_other_system` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` INTEGER NOT NULL,
  `fk_pr_system` INTEGER NOT NULL,
  
  CONSTRAINT `fk_pr_system_in_other_system_to_primary_system` 
  	FOREIGN KEY (`fk_pr_system`) REFERENCES `primary_system` (`id_pr_system`)
    	ON DELETE RESTRICT
    	ON UPDATE RESTRICT 
);