CREATE TABLE IF  NOT EXISTS product(
     id SERIAL,
     descripcion VARCHAR(30) NOT NULL,
     brand VARCHAR(30) NOT NULL,
     stock INT NOT NULL,
     PRIMARY KEY (id)
   );