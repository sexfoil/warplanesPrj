CREATE DATABASE warplanes;

USE warplanes;

INSERT INTO `planes`(`name`, `mark`, `model`, `role`, `country`, `description`, 
`crew`, `max_speed`, `service_ceiling`, `picture`, `price`) 
VALUES ("Typhoon","Eurofighter","","interceptor","UK","The Eurofighter Typhoon is a 
twin-engine, canard-delta wing, multirole fighter. 
The Typhoon was designed and is manufactured by a consortium of Alenia Aermacchi 
(Leonardo since 2017), Airbus, and BAE Systems that conducts the majority 
of the project through a joint holding company, 
Eurofighter Jagdflugzeug GmbH formed in 1986.",
1, 2495, 19812,"ef.jpg",162000000)







CREATE TABLE planes (
	plane_id SMALLINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(32) NOT NULL,
	mark VARCHAR(16) NOT NULL,
	model VARCHAR(16) NOT NULL,
	role VARCHAR(16) NOT NULL,
	country VARCHAR(16) NOT NULL,
	description MEDIUMTEXT NOT NULL,
	crew TINYINT NOT NULL, 
	max_speed SMALLINT NOT NULL, 
	service_ceiling SMALLINT NOT NULL,
	picture VARCHAR(32) NOT NULL,
	price INT NOT NULL,
	PRIMARY KEY (plane_id)
);

CREATE TABLE users (
	id  SMALLINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(32) NOT NULL,
	password VARCHAR(16) NOT NULL,
	sex VARCHAR(8) NOT NULL,
	email VARCHAR(64) NOT NULL,
	age SMALLINT NOT NULL,
	money BIGINT NOT NULL,
	cart MEDIUMTEXT NOT NULL,
	PRIMARY KEY (id)
	
);

