-- Views

-- Lista detalhadamente todos os chamados contendo informção do usuario, da empresa, horario em que foi aberto 
-- e se foi solucionado ordena eles do chamado mais recente para os mais antigos.
	CREATE VIEW vw_DetalheChamado AS
SELECT
    c.codigo_chamado,
    c.cnpj_empresa,
    e.nome_empresa,
    e.email_empresa,
    c.cpf_usuario, 
    u.nome_usuario,
    u.email_usuario,
    c.dataAbertura_chamado,
    c.status_chamado
FROM 
	chamado c
JOIN usuario u ON 
	c.cpf_usuario = u.cpf_usuario
JOIN empresa e ON 
	c.cnpj_empresa = e.cnpj_empresa
order by 
	c.codigo_chamado desc;

SELECT * FROM vw_DetalheChamado;

--Reune as informações do usuario.
CREATE VIEW vw_InfoUser AS
SELECT
    u.cpf_usuario,
    u.nome_usuario,
    u.email_usuario,
    d.codigo_departamento,
    d.cargo_departamento
FROM usuario u
LEFT JOIN departamento d ON u.cpf_usuario = d.cpf_usuario;

SELECT * FROM vw_InfoUser;

--Reune as informações da empresa.
CREATE VIEW vw_InfoEmpresa AS
SELECT
    e.cnpj_empresa,
    e.nome_empresa,
    e.email_empresa,
    te.tel_residencial_empresa,
    te.tel_pessoal_empresa,
    ee.cep_endereco,
    ee.rua_endereco,
    ee.bairro_endereco,
    ee.cidade_endereco
FROM empresa e
LEFT JOIN telefone_empresa te ON e.cnpj_empresa = te.cnpj_empresa
LEFT JOIN endereco_empresa ee ON e.cnpj_empresa = ee.cnpj_empresa;

SELECT * FROM vw_InfoEmpresa;

--Faz um resumo de todos os chamados, util para saber em que o pessoal tem mais dúvida.
CREATE VIEW vw_ResumoChamados AS
SELECT
    t.cod_tipo_chamado,
    t.codigo_chamado,
    t.grau_chamado,
    t.classe_chamado,
    COUNT(*) AS call_count
FROM tipo_chamado t
GROUP BY t.cod_tipo_chamado, t.codigo_chamado, 
t.grau_chamado, t.classe_chamado;

SELECT * FROM vw_ResumoChamados;

-- Index
	CREATE unique INDEX idx_cnpj_empresa ON empresa(cnpj_empresa);
	CREATE unique INDEX idx_cpf_usuario ON usuario(cpf_usuario);
	CREATE UNIQUE INDEX idx_codigo_chamado ON chamado(codigo_chamado);
	CREATE UNIQUE INDEX idx_codigo_usuario ON usuario(codigo_usuario);

	