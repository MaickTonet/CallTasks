-- privilegios

-- Create a user
CREATE USER Funcionario WITH PASSWORD '123mudar';

-- Grant privileges on tables
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE chamado TO Funcionario;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE departamento TO Funcionario;
-- Repeat for other tables as needed

-- Grant privileges on sequences (assuming SERIAL is backed by a sequence)
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO Funcionario;

-- Create a group
CREATE GROUP Funcionarios;

-- Add users to the group
GRANT Funcionarios TO Funcionario;
