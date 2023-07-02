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
 
 
-- 2) Relação de atendentes(com nome e idade) 
--	  que atenderam chamados relacionados a hardware no mês de
--	  março de 2023. Apresentar a relação ordenada pelo nome 
--	  do atendente de forma descendente

SELECT u.nomusu, EXTRACT(YEAR FROM AGE(current_date, u.idausu)) AS idade
FROM usuario u
JOIN chamado ch ON u.cpfusu = ch.codusu
JOIN tipo_chamado tc ON ch.codcha = tc.codcha
WHERE tc.clatipcha = 'H' AND EXTRACT(MONTH FROM ch.databecha) = 3 AND EXTRACT(YEAR FROM ch.databecha) = 2023
ORDER BY u.nomusu DESC;


-- 3) Relação dos top 10 usuários com mais chamados abertos em 2023;

SELECT u.nomusu, COUNT(ch.codcha) AS total_chamados
FROM usuario u
LEFT JOIN chamado ch ON u.cpfusu = ch.codusu
WHERE EXTRACT(YEAR FROM ch.databecha) = 2023
GROUP BY u.nomusu
ORDER BY total_chamados DESC
LIMIT 10;


-- 4) Relação de meses e o total de chamados, por mês, 
--	  a partir de 2022. Relacionar somente meses com mais
--	  de 15 chamados. Ordene o relatório do mês com mais chamados 
--	  para o mês com menos chamados.

SELECT EXTRACT(MONTH FROM ch.databecha) AS mes, COUNT(ch.codcha) AS total_chamados
FROM chamado ch
WHERE EXTRACT(YEAR FROM ch.databecha) >= 2022
GROUP BY mes
HAVING COUNT(ch.codcha) > 15
ORDER BY total_chamados DESC, mes ASC;