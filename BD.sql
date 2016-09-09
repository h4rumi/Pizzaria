DROP TABLE IF EXISTS manterCardapio;
CREATE TABLE manterCardapio(
  id int NOT NULL,
  saborPizza varchar(20) DEFAULT NULL,
  ingredientes varchar(100) DEFAULT NULL,
  PRIMARY KEY (id));
