-- 1) Relação de chamados(com descrição e tipo) 
--    do dia corrente, ordenados pela hora de abertura de forma crescente

SELECT
  h.descha AS descricao,
  tc.clatipcha AS tipo
FROM
  chamado c
  INNER JOIN historico_chamado h ON c.codcha = h.codcha
  INNER JOIN tipo_chamado tc ON h.tipcodcha = tc.tipcodcha
WHERE
  DATE_TRUNC('day', c.databecha) = DATE_TRUNC('day', CURRENT_DATE)
ORDER BY
  EXTRACT(HOUR FROM c.databecha) ASC,
  EXTRACT(MINUTE FROM c.databecha) ASC;











