create table articles(
  id integer primary key,
  title varchar(20) not null,
  author varchar(20),
  content text not null
);
