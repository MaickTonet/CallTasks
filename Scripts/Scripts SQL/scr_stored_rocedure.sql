--Stored Procedure

--
CREATE OR REPLACE PROCEDURE atualizar_grau_chamado(
    IN p_cod_tipo_chamado INT,
    IN p_grau_chamado CHAR(1)
)
AS
$$
BEGIN
    IF p_grau_chamado IN ('U', 'M', 'P') THEN
        UPDATE tipo_chamado
        SET grau_chamado = p_grau_chamado
        WHERE cod_tipo_chamado = p_cod_tipo_chamado;
    ELSE
        RAISE EXCEPTION 'Valor inválido para grau_chamado. Use "U", "M" ou "P".';
    END IF;
END;
$$
LANGUAGE plpgsql;

--
CREATE OR REPLACE PROCEDURE atualizar_classe_chamado(
    IN p_cod_tipo_chamado INT,
    IN p_classe_chamado CHAR(1)
)
AS
$$
BEGIN
    IF p_classe_chamado IN ('H', 'S') THEN
        UPDATE tipo_chamado
        SET classe_chamado = p_classe_chamado
        WHERE cod_tipo_chamado = p_cod_tipo_chamado;
    ELSE
        RAISE EXCEPTION 'Valor inválido para classe_chamado. Use "H" ou "S".';
    END IF;
END;
$$
LANGUAGE plpgsql;
