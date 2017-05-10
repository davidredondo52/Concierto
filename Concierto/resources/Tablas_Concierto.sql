select * from artista;CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sso_id` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sso_id` (`sso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `app_user_user_profile` (
  `user_id` bigint(20) NOT NULL,
  `user_profile_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`user_profile_id`),
  KEY `FK8w1hjq4mgw8b6xx41bb3q9yqk` (`user_profile_id`),
  CONSTRAINT `FK8w1hjq4mgw8b6xx41bb3q9yqk` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`),
  CONSTRAINT `FK_APP_USER` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `FK_USER_PROFILE` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`),
  CONSTRAINT `FKt3cvepgn2tno4f85jvkauv71o` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `artista` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

CREATE TABLE `concierto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `id_promotor` int(11) DEFAULT NULL,
  `id_sala` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `CONTRATO` longblob,
  `file_name` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2nupp8f71dtav4roxtvj7l5y` (`id_promotor`),
  KEY `FKc84157qbpeinc46669hgetmw5` (`id_sala`),
  CONSTRAINT `FK2nupp8f71dtav4roxtvj7l5y` FOREIGN KEY (`id_promotor`) REFERENCES `promotor` (`id`),
  CONSTRAINT `FKc84157qbpeinc46669hgetmw5` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

CREATE TABLE `concierto_artista` (
  `id_concierto` int(11) NOT NULL,
  `id_artista` int(11) NOT NULL,
  PRIMARY KEY (`id_concierto`,`id_artista`),
  KEY `FKmvv00lfamv8almuoxb1493dro` (`id_artista`),
  CONSTRAINT `FKmvv00lfamv8almuoxb1493dro` FOREIGN KEY (`id_artista`) REFERENCES `artista` (`id`),
  CONSTRAINT `FKwtnqa4yxuja023jq3qk0ifrn` FOREIGN KEY (`id_concierto`) REFERENCES `concierto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `contacto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido1` varchar(50) DEFAULT NULL,
  `apellido2` varchar(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `telefono` varchar(12) DEFAULT NULL,
  `tipo` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `entrada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_concierto` int(11) DEFAULT NULL,
  `precio_neto` double DEFAULT NULL,
  `iva` double DEFAULT NULL,
  `sgae` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK89xyssv1fiha9fkwgwjquymov` (`id_concierto`),
  CONSTRAINT `FK89xyssv1fiha9fkwgwjquymov` FOREIGN KEY (`id_concierto`) REFERENCES `concierto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `promotor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) DEFAULT NULL,
  `id_contacto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `sala` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `aforo` int(11) DEFAULT NULL,
  `id_contacto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnapkw1rvnoalc1iwqhf28xmse` (`id_contacto`),
  CONSTRAINT `FKnapkw1rvnoalc1iwqhf28xmse` FOREIGN KEY (`id_contacto`) REFERENCES `contacto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `tipocontacto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_userid_role` (`role`,`userid`),
  KEY `fk_user_idx` (`userid`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
