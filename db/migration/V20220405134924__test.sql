CREATE TABLE users (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4;
insert into users
VALUES( 1 , 'テスト1さん'),
( 2 , 'テスト2さん'),
( 3 , 'テスト３さん');


