CREATE TABLE `Car`
(
 `id`       int NOT NULL AUTO_INCREMENT ,
 `model`    nvarchar(50) NOT NULL UNIQUE ,
 `type` nvarchar(100) NOT NULL ,
 `price` double NOT NULL ,
 `user_id` int NOT NULL ,
 `description` nvarchar(1000) NOT NULL ,

PRIMARY KEY auto_increment(`id`),
CONSTRAINT verify_type CHECK ( type IN ('Cargo', 'Light', 'Moto', 'Bus'))
);

