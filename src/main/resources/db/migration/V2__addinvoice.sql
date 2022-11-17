CREATE TABLE IF  NOT EXISTS invoice(
     id SERIAL,
     code VARCHAR(30) NOT NULL,
     create_at DATE NOT NULL,
     total DECIMAL (8,2),
     asistente_id  INT NOT NULL,
     PRIMARY KEY (id),
     UNIQUE (code),
     FOREIGN KEY (asistente_id) REFERENCES asistente (id)
   );