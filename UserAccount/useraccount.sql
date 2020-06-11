use useraccount;

drop table if exists user;

CREATE TABLE if not exists user(
  id int(5) NOT NULL AUTO_INCREMENT,
  firstname varchar(20) NOT NULL,
  lastname varchar(20) NOT NULL,
  username varchar(25) UNIQUE NOT NULL,
  password varchar(25) NOT NULL,
  email varchar(45) UNIQUE NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO user (firstname, lastname, username, password, email)
	VALUES ('Testfirst', 'Testlast', 'testuser', 'Testpw123', 'test@email.com');
