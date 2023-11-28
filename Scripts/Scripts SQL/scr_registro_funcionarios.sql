-- privilegios

CREATE USER Funcionario WITH PASSWORD '123mudar';

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE chamado TO Funcionario;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE departamento TO Funcionario;

GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO Funcionario;

CREATE GROUP Funcionarios;

GRANT Funcionarios TO Funcionario;
