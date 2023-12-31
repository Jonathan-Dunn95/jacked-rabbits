BEGIN TRANSACTION;
-- Users Table
INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('jason','$2a$10$tZSngHOSzO6CxBhz4O1Vue7HidItv2eCz902cYoKYfbzfxa2p3oGm','ROLE_PARENT'); -- password is password
INSERT INTO users (username,password_hash,role) VALUES ('timmy','$2a$10$tZSngHOSzO6CxBhz4O1Vue7HidItv2eCz902cYoKYfbzfxa2p3oGm','ROLE_KID'); -- password is password
INSERT INTO users (username,password_hash,role) VALUES ('jimmy','$2a$10$tZSngHOSzO6CxBhz4O1Vue7HidItv2eCz902cYoKYfbzfxa2p3oGm','ROLE_KID'); -- password is password
INSERT INTO users (username,password_hash,role) VALUES ('tommy','$2a$10$tZSngHOSzO6CxBhz4O1Vue7HidItv2eCz902cYoKYfbzfxa2p3oGm','ROLE_KID'); -- password is password
INSERT INTO users (username,password_hash,role) VALUES ('bob','$2a$10$tZSngHOSzO6CxBhz4O1Vue7HidItv2eCz902cYoKYfbzfxa2p3oGm','ROLE_PARENT'); -- password is password

-- Kids Table
INSERT INTO kids (kids_id, user_id,username,password_hash,carrots,play_time_seconds) VALUES (4,3,'timmy','$2a$10$tZSngHOSzO6CxBhz4O1Vue7HidItv2eCz902cYoKYfbzfxa2p3oGm',4,60);
INSERT INTO kids (kids_id, user_id,username,password_hash,carrots,play_time_seconds) VALUES (5,3,'jimmy','$2a$10$tZSngHOSzO6CxBhz4O1Vue7HidItv2eCz902cYoKYfbzfxa2p3oGm',23,120);
INSERT INTO kids (kids_id, user_id,username,password_hash,carrots,play_time_seconds) VALUES (6,3,'tommy','$2a$10$tZSngHOSzO6CxBhz4O1Vue7HidItv2eCz902cYoKYfbzfxa2p3oGm',135,600);

-- Activity Table
INSERT INTO activity (kids_id,steps,minutes) VALUES (4,'40',5);
INSERT INTO activity (kids_id,steps,minutes) VALUES (5,'100',20);
INSERT INTO activity (kids_id,steps,minutes) VALUES (6,'230',60);

-- Items Store Table
-- Shirts
INSERT INTO items_store (item_id,img_url) VALUES (1,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt1.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (2,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt2.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (3,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt3.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (4,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt4.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (5,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt5.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (6,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt6.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (7,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt7.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (8,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt8.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (9,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt9.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (10,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt10.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (11,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt11.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (12,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt12.jpg');

-- Shoes
INSERT INTO items_store (item_id,img_url) VALUES (13,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes1.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (14,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes2.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (15,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes3.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (16,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes4.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (17,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes5.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (18,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes6.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (19,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes7.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (20,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes8.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (21,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes9.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (22,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes10.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (23,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes11.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (24,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes12.jpg');

-- Hats
INSERT INTO items_store (item_id,img_url) VALUES (25,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat1.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (26,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat2.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (27,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat3.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (28,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat4.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (29,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat5.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (30,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat6.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (31,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat7.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (32,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat8.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (33,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat9.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (34,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat10.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (35,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat11.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (36,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat12.jpg');

--Accessories
INSERT INTO items_store (item_id,img_url) VALUES (37,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc1.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (38,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc2.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (39,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc3.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (40,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc4.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (41,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc5.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (42,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc6.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (43,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc7.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (44,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc8.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (45,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc9.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (46,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc10.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (47,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc11.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (48,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc12.jpg');

-- Backgrounds
INSERT INTO items_store (item_id,img_url) VALUES (49,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back1.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (50,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back2.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (51,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back3.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (52,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back4.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (53,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back5.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (54,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back6.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (55,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back7.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (56,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back8.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (57,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back9.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (58,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back10.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (59,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back11.jpg');
INSERT INTO items_store (item_id,img_url) VALUES (60,'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back12.jpg');

-- Mascot Selector Table
INSERT INTO mascot_selection (mascot_selection_id,mascot_img_url) VALUES (1,'https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot1.jpg');
INSERT INTO mascot_selection (mascot_selection_id,mascot_img_url) VALUES (2,'https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot2.jpg');
INSERT INTO mascot_selection (mascot_selection_id,mascot_img_url) VALUES (3,'https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot3.jpg');
INSERT INTO mascot_selection (mascot_selection_id,mascot_img_url) VALUES (4,'https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot4.jpg');
INSERT INTO mascot_selection (mascot_selection_id,mascot_img_url) VALUES (5,'https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot5.jpg');
INSERT INTO mascot_selection (mascot_selection_id,mascot_img_url) VALUES (6,'https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot6.jpg');
INSERT INTO mascot_selection (mascot_selection_id,mascot_img_url) VALUES (7,'https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot7.jpg');
INSERT INTO mascot_selection (mascot_selection_id,mascot_img_url) VALUES (8,'https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot8.jpg');
INSERT INTO mascot_selection (mascot_selection_id,mascot_img_url) VALUES (9,'https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot9.jpg');
INSERT INTO mascot_selection (mascot_selection_id,mascot_img_url) VALUES (10,'https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot10.jpg');
INSERT INTO mascot_selection (mascot_selection_id,mascot_img_url) VALUES (11,'https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot11.jpg');
INSERT INTO mascot_selection (mascot_selection_id,mascot_img_url) VALUES (12,'https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot12.jpg');

-- Mascot Table
INSERT INTO mascot (kids_id, shirt, shoes, hat, accessory, background, mascot_selection_id) VALUES(4,1,13,25,37,49,1);
INSERT INTO mascot (kids_id, shirt, shoes, hat, accessory, background, mascot_selection_id) VALUES(5,2,14,26,38,50,2);
INSERT INTO mascot (kids_id, shirt, shoes, hat, accessory, background, mascot_selection_id) VALUES(6,3,15,27,39,51,3);

-- Closet Table
INSERT INTO closet (mascot_id, item_id) VALUES (1,1);
INSERT INTO closet (mascot_id, item_id) VALUES (1,13);
INSERT INTO closet (mascot_id, item_id) VALUES (1,25);
INSERT INTO closet (mascot_id, item_id) VALUES (1,37);
INSERT INTO closet (mascot_id, item_id) VALUES (1,49);
INSERT INTO closet (mascot_id, item_id) VALUES (2,1);
INSERT INTO closet (mascot_id, item_id) VALUES (2,13);
INSERT INTO closet (mascot_id, item_id) VALUES (2,25);
INSERT INTO closet (mascot_id, item_id) VALUES (2,37);
INSERT INTO closet (mascot_id, item_id) VALUES (2,49);
INSERT INTO closet (mascot_id, item_id) VALUES (2,2);
INSERT INTO closet (mascot_id, item_id) VALUES (2,14);
INSERT INTO closet (mascot_id, item_id) VALUES (2,26);
INSERT INTO closet (mascot_id, item_id) VALUES (2,38);
INSERT INTO closet (mascot_id, item_id) VALUES (2,50);
INSERT INTO closet (mascot_id, item_id) VALUES (3,1);
INSERT INTO closet (mascot_id, item_id) VALUES (3,13);
INSERT INTO closet (mascot_id, item_id) VALUES (3,25);
INSERT INTO closet (mascot_id, item_id) VALUES (3,37);
INSERT INTO closet (mascot_id, item_id) VALUES (3,49);
INSERT INTO closet (mascot_id, item_id) VALUES (3,3);
INSERT INTO closet (mascot_id, item_id) VALUES (3,15);
INSERT INTO closet (mascot_id, item_id) VALUES (3,27);
INSERT INTO closet (mascot_id, item_id) VALUES (3,39);
INSERT INTO closet (mascot_id, item_id) VALUES (3,51);

COMMIT TRANSACTION;
