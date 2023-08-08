BEGIN TRANSACTION;

Drop table IF EXISTS users,kids,activity,mascot,items_store,closet CASCADE;
CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
Create table kids (
	kids_id SERIAL NOT NULL,
	user_id SERIAL NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	carrots int,
	CONSTRAINT PK_kids_id PRIMARY KEY (kids_id),
	CONSTRAINT FK_kids_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);
create table activity (
	kids_id int NOT NULL,
	steps int,
	hours int,
	CONSTRAINT FK_kids_id FOREIGN KEY (kids_id) REFERENCES kids (kids_id)
);
Create table items_store (
	item_id SERIAL,
	item_type varchar(50),
	item_name varchar(50),
	CONSTRAINT PK_item_id PRIMARY KEY (item_id),
	CONSTRAINT UQ_item_id UNIQUE (item_id)
);
Create table mascot (
	mascot_id SERIAL,
	kids_id int NOT NULL,
	shirt int,
	shoes int,
	hat int,
	accessory int,
	background int,
	closet_id int,
	CONSTRAINT PK_mascot_id PRIMARY KEY (mascot_id),
	CONSTRAINT FK_mascot_kids FOREIGN KEY (kids_id) REFERENCES kids (kids_id),
	CONSTRAINT FK_mascot_closet_shirt FOREIGN KEY (shirt) REFERENCES items_store (item_id),
	CONSTRAINT FK_mascot_closet_shoes FOREIGN KEY (shoes) REFERENCES items_store (item_id),
	CONSTRAINT FK_mascot_closet_hat FOREIGN KEY (hat) REFERENCES items_store (item_id),
	CONSTRAINT FK_mascot_closet_accessory FOREIGN KEY (accessory) REFERENCES items_store (item_id),
	CONSTRAINT FK_mascot_closet_background FOREIGN KEY (background) REFERENCES items_store (item_id),
	--,shoes,hat,accessory,background
	CONSTRAINT UQ_mascot_id UNIQUE (mascot_id)
);
Create table closet (
	mascot_id int,
	item_id int,
	CONSTRAINT PK_closet_id PRIMARY KEY (item_id, mascot_id),
	CONSTRAINT FK_kids_closet FOREIGN KEY (mascot_id) REFERENCES mascot (mascot_id),
	CONSTRAINT FK_closet_mascot FOREIGN KEY (item_id) REFERENCES items_store (item_id)
);
COMMIT TRANSACTION;
