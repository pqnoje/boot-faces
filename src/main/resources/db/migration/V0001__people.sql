create table person (
  id identity not null,
  name varchar (255) not null,
  gender varchar (255),
  email varchar (255),
  naturalness varchar (255),
  nationality varchar (255),
  cpf char (11) not null unique,
  birthdate date not null
);
