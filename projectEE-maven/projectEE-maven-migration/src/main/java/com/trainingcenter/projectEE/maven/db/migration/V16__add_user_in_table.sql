INSERT INTO `user` (`id_user`, `del_status`, `fk_role`) VALUES (1, 0, 1);
INSERT INTO `user_info` 
(`id_info`, `login`, `password`, `first_name`, `last_name`, `email`, `fk_id_user`) VALUE 
(1, 'admin', 'admin', 'Семен', 'Байт', 'bite.semen@gmail.com', 1);