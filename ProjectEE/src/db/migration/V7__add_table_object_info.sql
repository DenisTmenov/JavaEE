CREATE TABLE `object_info` (
  `id_object_info` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `fk_object` INTEGER NOT NULL,
  `fk_country` INTEGER NOT NULL,
  `fk_city` INTEGER NOT NULL,
  `del_status` INTEGER NOT NULL,
  
  CONSTRAINT `fk_object_in_object_info_to_object` FOREIGN KEY (`fk_object`) REFERENCES `object` (`id_object`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT 
);

ALTER TABLE `object_info` ADD
	CONSTRAINT `fk_country_in_object_info_to_country` FOREIGN KEY (`fk_country`) REFERENCES `country` (`id_country`)
		ON DELETE CASCADE
		ON UPDATE CASCADE;
  
ALTER TABLE `object_info` ADD
	CONSTRAINT `fk_city_in_object_info_to_city` FOREIGN KEY (`fk_city`) REFERENCES `city` (`id_city`)
		ON DELETE CASCADE
		ON UPDATE CASCADE;