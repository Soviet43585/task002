CREATE TABLE `User`
(
 `id`       int NOT NULL AUTO_INCREMENT ,
 `login`    nvarchar(50) NOT NULL UNIQUE ,
 `password` nvarchar(100) NOT NULL ,
 `role`     nvarchar(50) NOT NULL DEFAULT 'ROLE_USER',

PRIMARY KEY auto_increment(`id`),
CONSTRAINT verify_role CHECK ( role IN ('ROLE_ADMIN', 'ROLE_USER'))
);


insert into user (login, password, role) values ('admin', '$2a$04$8xj.qANehHMRLjmy8bDdHuuBDB0feXqzmGCIT/Y4m6QhUTqRyDmVu', 'ROLE_ADMIN');
insert into user (login, password, role) values ('user', '$2a$04$iblQuCwYbIi14fnIh/HAk.mX3WiKvHOS/87ihVUAcFptCDy2358ti', 'ROLE_USER');
insert into user (login, password, role) values ('user1', '$2a$04$iblQuCwYbIi14fnIh/HAk.mX3WiKvHOS/87ihVUAcFptCDy2358ti', 'ROLE_USER');