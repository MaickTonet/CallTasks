CREATE TABLE chamado (
  codcha SERIAL NOT NULL,
  cnpemp varchar(14) NOT NULL,
  codusu varchar(11) NOT NULL,
  databecha timestamp,
  stcha char(1),
  PRIMARY KEY (codcha)
);

CREATE TABLE departamento (
  coddep SERIAL NOT NULL,
  cpfusu varchar(11) NOT NULL,
  cardep varchar(30),
  PRIMARY KEY (coddep)
);

CREATE TABLE empresa (
  cnpemp varchar(14) NOT NULL,
  nomemp varchar(40),
  emaemp varchar(40),
  PRIMARY KEY (cnpemp)
);

CREATE TABLE endereco_empresa (
  codendemp SERIAL NOT NULL,
  empresacnpemp varchar(14) NOT NULL,
  cepend varchar(11),
  ruaend varchar(40),
  baiend varchar(20),
  cidend varchar(20),
  PRIMARY KEY (codendemp)
);

CREATE TABLE historico_chamado (
  codhischa SERIAL NOT NULL,
  codcha int4 NOT NULL,
  tipcodcha int4 NOT NULL,
  datrescha date,
  resregcha varchar(30),
  descha text NOT NULL,
  PRIMARY KEY (codhischa)
);

CREATE TABLE telefone_empresa (
  codtelemp SERIAL NOT NULL,
  cnpemp varchar(14) NOT NULL,
  contelemp varchar(20),
  pestelemp varchar(20) NOT NULL,
  PRIMARY KEY (codtelemp)
);

CREATE TABLE telefone_usuario (
  coditelusu SERIAL NOT NULL,
  cpfusu varchar(11) NOT NULL,
  telpesusu varchar(20),
  telresusu varchar(20) NOT NULL,
  PRIMARY KEY (coditelusu)
);

CREATE TABLE tipo_chamado (
  tipcodcha SERIAL NOT NULL,
  codcha int4 NOT NULL,
  gratipcha char(1),
  clatipcha char(1) NOT NULL,
  PRIMARY KEY (tipcodcha)
);

CREATE TABLE usuario (
  cpfusu varchar(11) NOT NULL,
  nomusu varchar(40) NOT NULL,
  emausu varchar(40),
  idausu date NOT NULL,
  PRIMARY KEY (cpfusu)
);

ALTER TABLE endereco_empresa
  ADD CONSTRAINT FKendereco_e979932 FOREIGN KEY (empresacnpemp) REFERENCES empresa (cnpemp);

ALTER TABLE chamado
  ADD CONSTRAINT FKchamado106257 FOREIGN KEY (codusu) REFERENCES usuario (cpfusu);

ALTER TABLE chamado
  ADD CONSTRAINT FKchamado662276 FOREIGN KEY (cnpemp) REFERENCES empresa (cnpemp);

ALTER TABLE tipo_chamado
  ADD CONSTRAINT FKtipo_chama409245 FOREIGN KEY (codcha) REFERENCES chamado (codcha);

ALTER TABLE telefone_empresa
  ADD CONSTRAINT FKtelefone_e351819 FOREIGN KEY (cnpemp) REFERENCES empresa (cnpemp);

ALTER TABLE departamento
  ADD CONSTRAINT FKdepartamen684576 FOREIGN KEY (cpfusu) REFERENCES usuario (cpfusu);

ALTER TABLE telefone_usuario
  ADD CONSTRAINT FKtelefone_u376850 FOREIGN KEY (cpfusu) REFERENCES usuario (cpfusu);

ALTER TABLE historico_chamado
  ADD CONSTRAINT FKhistorico_547505 FOREIGN KEY (codcha) REFERENCES chamado (codcha);

ALTER TABLE historico_chamado
  ADD CONSTRAINT FKhistorico_85058 FOREIGN KEY (tipcodcha) REFERENCES tipo_chamado (tipcodcha);
