-- 1) Relação de chamados(com descrição e tipo) 
--    do dia corrente, ordenados pela hora de abertura de forma crescente

SELECT
  h.descha AS descricao, -- Seleciona a descrição do histórico do chamado
  tc.clatipcha AS tipo -- Seleciona o tipo do chamado
FROM
  chamado c -- Tabela chamado
  INNER JOIN historico_chamado h ON c.codcha = h.codcha -- Combinação com a tabela historico_chamado
  INNER JOIN tipo_chamado tc ON h.tipcodcha = tc.tipcodcha -- Combinação com a tabela tipo_chamado
WHERE
  DATE_TRUNC('day', c.databecha) = DATE_TRUNC('day', CURRENT_DATE) -- Filtra os registros do dia atual
ORDER BY
  EXTRACT(HOUR FROM c.databecha) ASC, -- Ordena por hora de registro em ordem crescente
  EXTRACT(MINUTE FROM c.databecha) ASC; -- Ordena por minuto de registro em ordem crescente

  
-- 2) Relação de atendentes(com nome e idade) 
--	  que atenderam chamados relacionados a hardware no mês de
--	  março de 2023. Apresentar a relação ordenada pelo nome 
--	  do atendente de forma descendente

SELECT u.nomusu, EXTRACT(YEAR FROM AGE(current_date, u.idausu)) AS idade -- Seleciona o nome do usuário e calcula a idade em anos
FROM usuario u -- Tabela usuário
JOIN chamado ch ON u.cpfusu = ch.codusu -- Combinação com a tabela chamado baseada no CPF do usuário
JOIN tipo_chamado tc ON ch.codcha = tc.codcha -- Combinação com a tabela tipo_chamado baseada no código do chamado
WHERE tc.clatipcha = 'H' -- Filtra os registros do tipo 'H'
  AND EXTRACT(MONTH FROM ch.databecha) = 3 -- Filtra os registros com mês igual a 3 (março)
  AND EXTRACT(YEAR FROM ch.databecha) = 2023 -- Filtra os registros com ano igual a 2023
ORDER BY u.nomusu DESC; -- Ordena por nome de usuário em ordem decrescente


-- 3) Relação dos top 10 usuários com mais chamados abertos em 2023;

SELECT u.nomusu, COUNT(ch.codcha) AS total_chamados -- Seleciona o nome do usuário e conta o número total de chamados
FROM usuario u -- Tabela usuário
LEFT JOIN chamado ch ON u.cpfusu = ch.codusu -- Combinação com a tabela chamado baseada no CPF do usuário (incluindo usuários sem chamados)
WHERE EXTRACT(YEAR FROM ch.databecha) = 2023 -- Filtra os registros com ano igual a 2023
GROUP BY u.nomusu -- Agrupa os registros pelo nome do usuário
ORDER BY total_chamados DESC -- Ordena pelo número total de chamados em ordem decrescente
LIMIT 10; -- Limita o resultado a 10 registros


-- 4) Relação de meses e o total de chamados, por mês, 
--	  a partir de 2022. Relacionar somente meses com mais
--	  de 15 chamados. Ordene o relatório do mês com mais chamados 
--	  para o mês com menos chamados.

SELECT EXTRACT(MONTH FROM ch.databecha) AS mes, COUNT(ch.codcha) AS total_chamados -- Seleciona o mês extraído da coluna databecha e conta o número total de chamados
FROM chamado ch -- Tabela chamado
WHERE EXTRACT(YEAR FROM ch.databecha) >= 2022 -- Filtra os registros com ano igual ou superior a 2022
GROUP BY mes -- Agrupa os registros pelo mês
HAVING COUNT(ch.codcha) > 15 -- Filtra os grupos com mais de 15 chamados
ORDER BY total_chamados DESC, mes ASC; -- Ordena pelo número total de chamados em ordem decrescente e, em caso de empate, ordena pelos meses em ordem crescente