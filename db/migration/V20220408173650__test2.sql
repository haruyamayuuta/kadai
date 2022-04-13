CREATE TABLE pets (
	id bigint(20) NOT NULL AUTO_INCREMENT,
  user_id bigint(20) NOT NULL,
	name varchar(100) NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4;
insert into pets
VALUES( 1 , 1,"ペットA"),(2,1,"ペットB"),(3,1,"ペットC"),(4,2,"ペットD"),(5,2,"ペットE"),(6,2,"ペットF"),(7,3,"ペットG"),(8,3,"ペットH"),(9,3,"ペットI"),(10,3,"ペットJ");