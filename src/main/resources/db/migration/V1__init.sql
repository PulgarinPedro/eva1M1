CREATE TABLE IF  NOT EXISTS Asistente(
     id SERIAL,
     nombres VARCHAR(100) NOT NULL,
     email VARCHAR(30) NOT NULL,
     institucion VARCHAR(100) NOT NULL,
     cargo VARCHAR(100) NOT NULL,
     PRIMARY KEY (id),
     UNIQUE(email)
);