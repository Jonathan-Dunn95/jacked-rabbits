BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('jason','$2a$10$tZSngHOSzO6CxBhz4O1Vue7HidItv2eCz902cYoKYfbzfxa2p3oGm','ROLE_PARENT'); -- password is password

INSERT INTO kids (user_id,username,password_hash,carrots) VALUES (3,'timmy','$2a$10$tZSngHOSzO6CxBhz4O1Vue7HidItv2eCz902cYoKYfbzfxa2p3oGm',4);
INSERT INTO kids (user_id,username,password_hash,carrots) VALUES (3,'jimmy','$2a$10$tZSngHOSzO6CxBhz4O1Vue7HidItv2eCz902cYoKYfbzfxa2p3oGm',23);
INSERT INTO kids (user_id,username,password_hash,carrots) VALUES (3,'tommy','$2a$10$tZSngHOSzO6CxBhz4O1Vue7HidItv2eCz902cYoKYfbzfxa2p3oGm',135);

INSERT INTO activity (kids_id,steps,minutes) VALUES (1,'40',5);
INSERT INTO activity (kids_id,steps,minutes) VALUES (2,'100',20);
INSERT INTO activity (kids_id,steps,minutes) VALUES (3,'230',60);

COMMIT TRANSACTION;
