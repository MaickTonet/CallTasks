CREATE TABLE chamados (
  id INT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(255) NOT NULL,
  descricao TEXT NOT NULL,
  status VARCHAR(255) NOT NULL,
  data_abertura DATETIME NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO chamados (titulo, descricao, status, data_abertura)
VALUES (
  ?,
  ?,
  ?,
  CURRENT_TIMESTAMP
);
