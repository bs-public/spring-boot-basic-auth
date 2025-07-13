-- V<Version>__<Description>.sql
CREATE TABLE role (
  id int(11) AUTO_INCREMENT,
  rolename varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE user (
  id int(11) AUTO_INCREMENT,
  email varchar(255) NOT NULL,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  role_id int(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (role_id) REFERENCES role (id)
);
