
CREATE SCHEMA IF NOT EXISTS  Skyscanner ;

USE  Skyscanner  ;

DROP TABLE IF EXISTS  user_profile ;
DROP TABLE IF EXISTS  buying_history ;
DROP TABLE IF EXISTS  baggage ;
DROP TABLE IF EXISTS  airline ;
DROP TABLE IF EXISTS  airport ;
DROP TABLE IF EXISTS  flight_info ;
DROP TABLE IF EXISTS  destination ;
DROP TABLE IF EXISTS  flight_ticket ;
DROP TABLE IF EXISTS  connected_flight ;

CREATE TABLE IF NOT EXISTS  user_profile  (
   id  INT UNSIGNED NOT NULL AUTO_INCREMENT,
   name  VARCHAR(45) NULL,
   surname  VARCHAR(45) NULL,
   age  INT NULL,
   email  VARCHAR(319) NULL,
  PRIMARY KEY ( id ))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS  buying_history  (
   id  INT UNSIGNED NOT NULL AUTO_INCREMENT,
   date  DATETIME NOT NULL,
   user_profile_id  INT UNSIGNED NOT NULL,
  PRIMARY KEY ( id ),
  INDEX  fk_buying_history_user_profile1_idx  ( user_profile_id  ASC) VISIBLE,
  CONSTRAINT  fk_buying_history_user_profile1 
    FOREIGN KEY ( user_profile_id )
    REFERENCES user_profile (id))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS  baggage  (
   id  INT NOT NULL AUTO_INCREMENT,
   type  VARCHAR(45) NULL,
   height  FLOAT NULL,
   width  FLOAT NULL,
   weight  FLOAT NULL,
  PRIMARY KEY ( id ))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS  airline  (
   id  INT NOT NULL AUTO_INCREMENT,
   name  VARCHAR(45) NULL,
  PRIMARY KEY ( id ))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS  airport  (
   id  INT NOT NULL AUTO_INCREMENT,
   name  VARCHAR(45) NULL,
   country  VARCHAR(45) NULL,
   city  VARCHAR(45) NULL,
   address  VARCHAR(90) NULL,
  PRIMARY KEY ( id ))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS  flight_info  (
   id  INT NOT NULL AUTO_INCREMENT,
   airline_id  INT NOT NULL,
   airport_id  INT NOT NULL,
   baggage_id  INT NOT NULL,
   date  DATE NOT NULL,
   time  TIME NOT NULL,
  PRIMARY KEY ( id ),
  CONSTRAINT  fk_flight_info_airline1 
    FOREIGN KEY ( airline_id )
    REFERENCES  airline  ( id ),
  CONSTRAINT  fk_flight_info_airport1 
    FOREIGN KEY ( airport_id )
    REFERENCES  airport  ( id ),
  CONSTRAINT  fk_flight_info_baggage1 
    FOREIGN KEY ( baggage_id )
    REFERENCES  baggage  ( id ))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS  connected_flight  (
   id  INT NOT NULL AUTO_INCREMENT,
   contry  VARCHAR(45) NOT NULL,
   city  VARCHAR(45) NOT NULL,
  PRIMARY KEY ( id ))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS  flight_ticket  (
   id  INT NOT NULL AUTO_INCREMENT,
   type  VARCHAR(45) NOT NULL,
   price  DECIMAL(18,2) NOT NULL,
   avaiability  TINYINT NULL,
   buying_history_id  INT UNSIGNED NOT NULL,
   flight_info_id  INT NOT NULL,
   connected_flight_id  INT NOT NULL,
  PRIMARY KEY ( id ,  connected_flight_id ),
  CONSTRAINT  fk_flight_ticket_buying_history1 
    FOREIGN KEY ( buying_history_id )
    REFERENCES  buying_history  ( id ),
  CONSTRAINT  fk_flight_ticket_flight_info1 
    FOREIGN KEY ( flight_info_id )
    REFERENCES  flight_info  ( id ))
ENGINE = InnoDB;


INSERT INTO  user_profile  VALUES
(1, 'Vlad', 'GO', 18, 'asyuhsd@gmail.com'),
(2, 'Oleg', 'Zaya', 21, 'asyuhsd@gmail.com'),
(3, 'Ivan', 'Gira', 65, 'asyuhsd@gmail.com'),
(4, 'Dima', 'Goroh', 43, 'asyuhsd@gmail.com'),
(5, 'Sviat', 'Sliva', 15, 'asyuhsd@gmail.com'),
(6, 'Sasha', 'Grey', 13, 'asyuhsd@gmail.com'),
(7, 'Ira', 'Rome', 18, 'asyuhsd@gmail.com'),
(8, 'Olga', 'Glim', 14, 'asyuhsd@gmail.com'),
(9, 'Nasta', 'Gymi', 13, 'asyuhsd@gmail.com'),
(10, 'Vasa', 'Rogo', 12, 'asyuhsd@gmail.com');



INSERT INTO  buying_history  VALUES
(1, '1000-01-01 00:00:00', 3),
(2, '2020-01-01 00:00:00', 4),
(3, '2021-02-01 00:00:00', 2),
(4, '2021-05-01 00:00:00', 1),
(5, '2021-04-01 00:00:00', 5),
(6, '2021-01-21 00:00:00', 6),
(7, '2021-08-11 00:00:00', 10),
(8, '2021-09-21 00:00:00', 8),
(9, '2021-07-12 00:00:00', 7),
(10,'2021-06-11 00:00:00', 9);


INSERT INTO  baggage  VALUES
(1, 'bag', 1.72, 1.2, 3),
(2, 'hand bag', 3.3, 1.5, 10),
(3, 'backpack', 2.3, 2.1, 12),
(4, 'bag', 2.1, 1.7, 2),
(5, 'sholder bag', 2.1, 1.7, 4),
(6, 'small bag', 22.1, 1.7, 5),
(7, 'sholder bag', 3.1, 1.7, 6),
(8, 'arm bag', 6.1, 1.7, 7),
(9, 'head bag', 4.1, 1.7, 8),
(10, 'foot bag', 3.1, 1.7, 9);

INSERT INTO  airline  VALUES
(1, 'Turkish Airline'),
(2, 'Wizz Air'),
(3, 'Rayn Air'),
(4, 'Dubai Airline'),
(5, 'USA Airline'),
(6, 'Kiwi Airline'),
(7, 'Jap'),
(8, 'Ukrline'),
(9, 'Mocco'),
(10, 'DXY');


INSERT INTO  airport  VALUES
(1, 'Cool', 'Ukraine', 'Lviv', 'Instrumentalna, 45'),
(2, 'Amazing', 'Spain', 'Barcelona', 'Zimov, 45'),
(3, 'Barc', 'Poland', 'Rzezow', 'Sikorskiego, 15'),
(4, 'Near', 'USA', 'New York', 'Briton, 34'),
(5, 'XRP', 'Mexico', 'New York', 'Briton, 34'),
(6, 'Bitoc', 'Port', 'New York', 'Briton, 34'),
(7, 'Assma', 'Rome', 'New York', 'Briton, 34'),
(8, 'Mirro', 'Monacco', 'New York', 'Briton, 34'),
(9, 'Erko', 'France', 'New York', 'Briton, 34'),
(10, 'lobra', 'Grecce', 'Venice', 'Briton, 34');

INSERT INTO  flight_info  VALUES
(1, 2, 3, 1, '2022-09-01', '16:10:00'),
(2, 1, 2, 3, '2022-01-10', '10:10:00'),
(3, 4, 1, 4, '2022-03-23', '12:10:00'),
(4, 3, 4, 2, '2022-05-04', '20:10:00'),
(5, 6, 5, 6, '2022-05-04', '20:10:00'),
(6, 8, 8, 7, '2022-05-04', '20:10:00'),
(7, 7, 10, 10, '2022-05-04', '20:10:00'),
(8, 9, 7, 5, '2022-05-04', '20:10:00'),
(9, 10, 9, 8, '2022-05-04', '20:10:00'),
(10, 5, 6, 9, '2022-05-04', '20:10:00');


INSERT INTO  flight_ticket  VALUES
(1, 'Gold', 1000.00, 12, 1, 2, 3),
(2, 'Silver', 700.00, 5, 3, 1, 4),
(3, 'Bronze', 500.00, 1, 4, 3, 2),
(4, 'Silver', 100.00, 10, 2, 4, 1),
(5, 'Silver', 300.00, 10, 5, 6, 8),
(6, 'Bronze', 400.00, 10, 7, 5, 10),
(7, 'Premium', 2200.00, 10, 8, 7, 5),
(8, 'Premium', 7700.00, 10, 10, 10, 7),
(9, 'Premium', 5600.00, 10, 9, 9, 9),
(10, 'Gold', 200.00, 10, 6, 8, 6);


INSERT INTO  connected_flight  VALUES
(1,  'USA', 'Boston'),
(2,  'Canada', 'Toronto'),
(3,  'Austria', 'Viena'),
(4,  'Poland', 'Warsawa'),
(5,  'Ukraine', 'Lviv'),
(6,  'Turky', 'Stambul'),
(7,  'ALbania', 'Warsawa'),
(8,  'Chehe', 'Warsawa'),
(9,  'France', 'Paris'),
(10,  'GB', 'LOndon');

CREATE INDEX airline_index ON airline(name);
CREATE INDEX flight_ticket_index ON flight_ticket(type, price);
CREATE INDEX user_profile_index ON user_profile (name, surname, age);

