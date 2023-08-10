BEGIN TRANSACTION;

Drop table IF EXISTS users,kids,activity,mascot,items_store,closet CASCADE;
Drop sequence IF EXISTS seq_shirt_id,seq_shoes_id,seq_hat_id,seq_accessory_id,seq_background_id;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

Create table kids (
	kids_id SERIAL NOT NULL,
	user_id int NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	carrots int,
	play_time_seconds int,
	CONSTRAINT PK_kids_id PRIMARY KEY (kids_id),
	CONSTRAINT FK_kids_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);

create table activity (
	kids_id int NOT NULL,
	steps int,
	minutes int,
	CONSTRAINT FK_kids_id FOREIGN KEY (kids_id) REFERENCES kids (kids_id)
);

CREATE SEQUENCE seq_shirt_id
  INCREMENT BY 1
  START WITH 200
  MAXVALUE 250;

CREATE SEQUENCE seq_shoes_id
  INCREMENT BY 1
  START WITH 251
  MAXVALUE 300;

CREATE SEQUENCE seq_hat_id
  INCREMENT BY 1
  START WITH 301
  MAXVALUE 350;

CREATE SEQUENCE seq_accessory_id
  INCREMENT BY 1
  START WITH 351
  MAXVALUE 400;

CREATE SEQUENCE seq_background_id
  INCREMENT BY 1
  START WITH 401
  MAXVALUE 450;

Create table items_store (
	shirt int DEFAULT nextval ('seq_shirt_id'),
	shoes int DEFAULT nextval ('seq_shoes_id'),
	hat int DEFAULT nextval ('seq_hat_id'),
	accessory int DEFAULT nextval ('seq_accessory_id'),
	background int DEFAULT nextval ('seq_accessory_id'),
	item_type varchar(50),
	item_name varchar(50),
	CONSTRAINT FK_item_store_mascot_shirt FOREIGN KEY (shirt) REFERENCES items_store (shirt),
	CONSTRAINT FK_item_store_mascot_shoes FOREIGN KEY (shoes) REFERENCES items_store (shoes),
	CONSTRAINT FK_item_store_mascot_hat FOREIGN KEY (hat) REFERENCES items_store (hat),
	CONSTRAINT FK_item_store_mascot_accessory FOREIGN KEY (accessory) REFERENCES items_store (accessory),
	CONSTRAINT FK_item_store_mascot_background FOREIGN KEY (background) REFERENCES items_store (background),
	CONSTRAINT UQ_shirt_id UNIQUE (shirt),
	CONSTRAINT UQ_shoes_id UNIQUE (shoes),
	CONSTRAINT UQ_hat_id UNIQUE (hat),
	CONSTRAINT UQ_accessory_id UNIQUE (accessory),
	CONSTRAINT UQ_background_id UNIQUE (background)
);

Create table mascot (
	mascot_id SERIAL,
	kids_id int NOT NULL,
	shirt int DEFAULT nextval ('seq_shirt_id'),
	shoes int DEFAULT nextval ('seq_shoes_id'),
	hat int DEFAULT nextval ('seq_hat_id'),
	accessory int DEFAULT nextval ('seq_accessory_id'),
	background int DEFAULT nextval ('seq_accessory_id'),
	closet_id SERIAL,
	CONSTRAINT PK_mascot_id PRIMARY KEY (mascot_id),
	CONSTRAINT FK_mascot_kids FOREIGN KEY (kids_id) REFERENCES kids (kids_id),
	CONSTRAINT FK_mascot_closet_shirt FOREIGN KEY (shirt) REFERENCES items_store (shirt),
	CONSTRAINT FK_mascot_closet_shoes FOREIGN KEY (shoes) REFERENCES items_store (shoes),
	CONSTRAINT FK_mascot_closet_hat FOREIGN KEY (hat) REFERENCES items_store (hat),
	CONSTRAINT FK_mascot_closet_accessory FOREIGN KEY (accessory) REFERENCES items_store (accessory),
	CONSTRAINT FK_mascot_closet_background FOREIGN KEY (background) REFERENCES items_store (background),
	--,shoes,hat,accessory,background
	CONSTRAINT UQ_mascot_id UNIQUE (mascot_id)
);

Create table closet (
	closet_id int,
	mascot_id int,
	shirt int DEFAULT nextval ('seq_shirt_id'),
	shoes int DEFAULT nextval ('seq_shoes_id'),
	hat int DEFAULT nextval ('seq_hat_id'),
	accessory int DEFAULT nextval ('seq_accessory_id'),
	background int DEFAULT nextval ('seq_accessory_id'),
	CONSTRAINT PK_closet_id PRIMARY KEY (closet_id),
	CONSTRAINT FK_kids_closet FOREIGN KEY (mascot_id) REFERENCES mascot (mascot_id),
	CONSTRAINT FK_mascot_closet_shirt FOREIGN KEY (shirt) REFERENCES items_store (shirt),
	CONSTRAINT FK_mascot_closet_shoes FOREIGN KEY (shoes) REFERENCES items_store (shoes),
	CONSTRAINT FK_mascot_closet_hat FOREIGN KEY (hat) REFERENCES items_store (hat),
	CONSTRAINT FK_mascot_closet_accessory FOREIGN KEY (accessory) REFERENCES items_store (accessory),
	CONSTRAINT FK_mascot_closet_background FOREIGN KEY (background) REFERENCES items_store (background)
	);

COMMIT TRANSACTION;

