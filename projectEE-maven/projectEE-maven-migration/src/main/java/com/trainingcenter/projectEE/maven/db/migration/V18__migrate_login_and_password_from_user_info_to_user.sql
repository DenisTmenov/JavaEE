UPDATE `user`, `user_info` 
	SET `user`.`login`=`user_info`.`login`, `user`.`password`=`user_info`.`password` 
		WHERE `user_info`.`fk_id_user` = `user`.`id_user`; 