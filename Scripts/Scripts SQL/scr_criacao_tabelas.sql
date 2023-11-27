-- Table: chamado
CREATE TABLE chamado (
    codigo_chamado SERIAL NOT NULL,
    cnpj_empresa varchar(14) NOT NULL,
    cpf_usuario varchar(11) NOT NULL,
    dataAbertura_chamado timestamp,
    status_chamado char(1),
    usuariocodigo_usuario int4,
    PRIMARY KEY (codigo_chamado)
);

COMMENT ON TABLE chamado IS 'Cadastro do chamado';
COMMENT ON COLUMN chamado.codigo_chamado IS 'Codigo do chamado';
COMMENT ON COLUMN chamado.cnpj_empresa IS 'CNPJ da empresa';
COMMENT ON COLUMN chamado.cpf_usuario IS 'Código do usuário';
COMMENT ON COLUMN chamado.dataAbertura_chamado IS 'Data de abertura do chamado';
COMMENT ON COLUMN chamado.status_chamado IS 'Status do chamado';

-- Table: departamento
CREATE TABLE departamento (
    codigo_departamento SERIAL NOT NULL,
    cpf_usuario varchar(11) NOT NULL,
    cargo_departamento varchar(30),
    usuariocodigo_usuario int4 NOT NULL,
    PRIMARY KEY (codigo_departamento)
);

COMMENT ON TABLE departamento IS 'Departamento do usuário ou técnico';
COMMENT ON COLUMN departamento.codigo_departamento IS 'Código do departamento';
COMMENT ON COLUMN departamento.cpf_usuario IS 'CPF do usuário';
COMMENT ON COLUMN departamento.cargo_departamento IS 'Cargo do usuário dentro do departamento';

-- Table: empresa
CREATE TABLE empresa (
    cnpj_empresa varchar(14) NOT NULL,
    nome_empresa varchar(40),
    email_empresa varchar(40),
    PRIMARY KEY (cnpj_empresa)
);

COMMENT ON TABLE empresa IS 'Catálogo da empresa';
COMMENT ON COLUMN empresa.cnpj_empresa IS 'CNPJ da empresa';
COMMENT ON COLUMN empresa.nome_empresa IS 'Nome da empresa';
COMMENT ON COLUMN empresa.email_empresa IS 'E-mail da empresa';

-- Table: endereço_empresa
CREATE TABLE endereço_empresa (
    cod_endereco_empresa SERIAL NOT NULL,
    cpnj_empresa varchar(14) NOT NULL,
    cep_endereco varchar(11),
    rua_endereco varchar(40),
    bairro_endereco varchar(20),
    cidade_endereco varchar(20),
    PRIMARY KEY (cod_endereco_empresa)
);

COMMENT ON TABLE endereço_empresa IS 'Endereço da empresa';
COMMENT ON COLUMN endereço_empresa.cod_endereco_empresa IS 'Código do endereço da empresa';
COMMENT ON COLUMN endereço_empresa.cpnj_empresa IS 'Chave estrangeira da empresa';
COMMENT ON COLUMN endereço_empresa.cep_endereco IS 'CEP da empresa';
COMMENT ON COLUMN endereço_empresa.rua_endereco IS 'Rua da empresa';
COMMENT ON COLUMN endereço_empresa.bairro_endereco IS 'Bairro da empresa';
COMMENT ON COLUMN endereço_empresa.cidade_endereco IS 'Cidade da empresa';

-- Table: historico_chamado
CREATE TABLE historico_chamado (
    cod_historico_chamado SERIAL NOT NULL,
    codigo_chamado int4 NOT NULL,
    cod_tipo_chamado int4 NOT NULL,
    data_reg_chamado date,
    responsavel_reg_chamado varchar(30),
    descricao_chamado text NOT NULL,
    PRIMARY KEY (cod_historico_chamado)
);

COMMENT ON TABLE historico_chamado IS 'Histórico dos chamados';
COMMENT ON COLUMN historico_chamado.cod_historico_chamado IS 'Código do histórico de chamados';
COMMENT ON COLUMN historico_chamado.codigo_chamado IS 'Código do chamado';
COMMENT ON COLUMN historico_chamado.cod_tipo_chamado IS 'Código do tipo do chamado';
COMMENT ON COLUMN historico_chamado.data_reg_chamado IS 'Data de registro do chamado';
COMMENT ON COLUMN historico_chamado.responsavel_reg_chamado IS 'Responsável pelo registro do chamado';
COMMENT ON COLUMN historico_chamado.descricao_chamado IS 'Descrição do chamado';

-- Table: telefone_empresa
CREATE TABLE telefone_empresa (
    codigo_tel_empresa SERIAL NOT NULL,
    cnpj_empresa varchar(14) NOT NULL,
    tel_residencial_empresa varchar(20),
    tel_pessoal_empresa varchar(20) NOT NULL,
    PRIMARY KEY (codigo_tel_empresa)
);

COMMENT ON TABLE telefone_empresa IS 'Telefones de contato da empresa';
COMMENT ON COLUMN telefone_empresa.codigo_tel_empresa IS 'Código dos telefones da empresa';
COMMENT ON COLUMN telefone_empresa.cnpj_empresa IS 'CNPJ da empresa';
COMMENT ON COLUMN telefone_empresa.tel_residencial_empresa IS 'Telefone de contato da empresa';
COMMENT ON COLUMN telefone_empresa.tel_pessoal_empresa IS 'Telefone pessoal da empresa';

-- Table: telefone_usuario
CREATE TABLE telefone_usuario (
    codigo_tel_usuario SERIAL NOT NULL,
    cpf_usuario varchar(11) NOT NULL,
    tel_pessoal_usuario varchar(20),
    tel_residencial_usuario varchar(20) NOT NULL,
    usuariocodigo_usuario int4 NOT NULL,
    PRIMARY KEY (codigo_tel_usuario)
);

COMMENT ON TABLE telefone_usuario IS 'Catálogo dos telefones dos usuários';
COMMENT ON COLUMN telefone_usuario.codigo_tel_usuario IS 'Código dos telefones do usuário';
COMMENT ON COLUMN telefone_usuario.cpf_usuario IS 'CPF do usuário';
COMMENT ON COLUMN telefone_usuario.tel_pessoal_usuario IS 'Telefone pessoal';
COMMENT ON COLUMN telefone_usuario.tel_residencial_usuario IS 'Telefone residencial do usuário';

-- Table: tipo_chamado
CREATE TABLE tipo_chamado (
    cod_tipo_chamado SERIAL NOT NULL,
    codigo_chamado int4 NOT NULL,
    grau_chamado char(1),
    classe_chamado char(1) NOT NULL,
    PRIMARY KEY (cod_tipo_chamado)
);

COMMENT ON TABLE tipo_chamado IS 'Tipo do chamado';
COMMENT ON COLUMN tipo_chamado.cod_tipo_chamado IS 'Código do chamado';
COMMENT ON COLUMN tipo_chamado.codigo_chamado IS 'Código do chamado';
COMMENT ON COLUMN tipo_chamado.grau_chamado IS 'Grau do chamado ( ''U'' = urgente / ''M'' = moderado / ''P'' = pouco urgente )';
COMMENT ON COLUMN tipo_chamado.classe_chamado IS 'Classe do chamado ( ''H'' = hardware / ''S'' = software )';

-- Table: usuario
CREATE TABLE usuario (
    codigo_usuario SERIAL NOT NULL,
    cpf_usuario varchar(11) NOT NULL,
    nome_usuario varchar(40) NOT NULL,
    email_usuario varchar(40),
    dataNascimento_usuario date NOT NULL,
    PRIMARY KEY (codigo_usuario)
);

COMMENT ON TABLE usuario IS 'Cadastro de usuário';
COMMENT ON COLUMN usuario.codigo_usuario IS 'Código do usuário';
COMMENT ON COLUMN usuario.cpf_usuario IS 'CPF do usuário';
COMMENT ON COLUMN usuario.nome_usuario IS 'Nome do usuário';
COMMENT ON COLUMN usuario.email_usuario IS 'E-mail do usuário';

-- Foreign Key Constraints
ALTER TABLE endereço_empresa ADD CONSTRAINT FKendereço_e597786 FOREIGN KEY (cpnj_empresa) REFERENCES empresa (cnpj_empresa);
ALTER TABLE chamado ADD CONSTRAINT FKchamado524409 FOREIGN KEY (usuariocodigo_usuario) REFERENCES usuario (codigo_usuario);
ALTER TABLE chamado ADD CONSTRAINT FKchamado686775 FOREIGN KEY (cnpj_empresa) REFERENCES empresa (cnpj_empresa);
ALTER TABLE tipo_chamado ADD CONSTRAINT FKtipo_chama175715 FOREIGN KEY (codigo_chamado) REFERENCES chamado (codigo_chamado);
ALTER TABLE telefone_empresa ADD CONSTRAINT FKtelefone_e997232 FOREIGN KEY (cnpj_empresa) REFERENCES empresa (cnpj_empresa);
ALTER TABLE departamento ADD CONSTRAINT FKdepartamen283320 FOREIGN KEY (usuariocodigo_usuario) REFERENCES usuario (codigo_usuario);
ALTER TABLE telefone_usuario ADD CONSTRAINT FKtelefone_u221893 FOREIGN KEY (usuariocodigo_usuario) REFERENCES usuario (codigo_usuario);
ALTER TABLE historico_chamado ADD CONSTRAINT FKhistorico_313975 FOREIGN KEY (codigo_chamado) REFERENCES chamado (codigo_chamado);
ALTER TABLE historico_chamado ADD CONSTRAINT FKhistorico_572937 FOREIGN KEY (cod_tipo_chamado) REFERENCES tipo_chamado (cod_tipo_chamado);
