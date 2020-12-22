DROP TABLE IF EXISTS user_features;

CREATE TABLE email_user(
   email_id int AUTO_INCREMENT primary key ,
   email varchar (100) not null
);

CREATE TABLE feature(
   feature_id int AUTO_INCREMENT primary key ,
   feature_name varchar (100) not null
);

CREATE TABLE email_features (
  id int AUTO_INCREMENT primary key,
  email_id int  NOT NULL,
  feature_id int  NOT NULL,
  enabled BOOLEAN 
);


INSERT INTO feature(feature_name) VALUES
('Movies'),
('Sports'),
('Music'),
('Science'),
('History'),
('WebSeries1'),
('News');


INSERT INTO email_user(email) VALUES
('husmukh@gmail.com'),
('imtiaz@gmail.com'),
('deepak@gmail.com'),
('naresh@gmail.com'),
('dileep@gmail.com'),
('zheming@gmail.com'),
('yup@gmail.com'),
('ana@gmail.com');


INSERT INTO email_feature (email_id, feature_id, enabled) VALUES
  (1, 1, true),
  (1, 2, false),
  (1, 3, true),
  (1, 4, false),
  (1, 5, false),
  (1, 6, true),
  
  
  (2, 1, false),
  (2, 2, true),
  (2, 3, true),
  (2, 4, true),
  (2, 5, true),
  (2, 6, false),
  
  
  (3, 1, false),
  (3, 2, true),
  (3, 3, true),
  (3, 4, false),
  (3, 5, true),
  (3, 6, true),
  
  
  (4, 1, true),
  (4, 2, false),
  (4, 3, true),
  (4, 4, false),
  (4, 5, true),
  (4, 6, false),
  
  (5, 1, false),
  (5, 2, false),
  (5, 3, false),
  (5, 4, false),
  (5, 5, false),
  (5, 6, true);  
  
  
  