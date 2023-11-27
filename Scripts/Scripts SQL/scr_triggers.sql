-- Triggers

-- Trigger 1: Check se codigo_chamado existe no chamado table antes de inserir no historico_chamado
CREATE OR REPLACE FUNCTION check_chamado_existencia()
RETURNS TRIGGER AS $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM chamado WHERE codigo_chamado = NEW.codigo_chamado) THEN
        RAISE EXCEPTION 'ReferencedReferenciar codigo_chamado não exise no chamado table';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_check_chamado_existence
BEFORE INSERT ON historico_chamado
FOR EACH ROW
EXECUTE FUNCTION check_chamado_existence();

-- Trigger 2: Update status_chamado no chamado table baseado no valor classe_chamado
CREATE OR REPLACE FUNCTION update_status_chamado()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE chamado
    SET status_chamado = CASE NEW.classe_chamado
                            WHEN 'H' THEN 'H' -- Hardware
                            WHEN 'S' THEN 'S' -- Software
                            ELSE 'U' -- Padrão para Urgente para classe_chamado desconhecidas
                         END
    WHERE codigo_chamado = NEW.codigo_chamado;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_update_status_chamado
AFTER INSERT ON tipo_chamado
FOR EACH ROW
EXECUTE FUNCTION update_status_chamado();
