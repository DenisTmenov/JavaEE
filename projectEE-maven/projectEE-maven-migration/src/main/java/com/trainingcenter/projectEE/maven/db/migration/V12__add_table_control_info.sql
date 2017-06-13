CREATE TABLE `control_info` (
  `id_control_info` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `periodicity` INTEGER NOT NULL,
  `fk_control` INTEGER NOT NULL,
  
  CONSTRAINT `fk_control_in_control_info_to_control` 
  	FOREIGN KEY (`fk_control`) REFERENCES `control` (`id_control`)
    	ON DELETE RESTRICT
    	ON UPDATE RESTRICT 
);