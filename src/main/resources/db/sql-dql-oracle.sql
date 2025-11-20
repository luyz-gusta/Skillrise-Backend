SELECT u.user_id,
       u.name,
       t.trilha_id,
       t.title AS trilha_title,
       i.enrolled_at,
       i.status
FROM TB_USER u
INNER JOIN TB_INSCRICAO i ON u.user_id = i.user_id
INNER JOIN TB_TRILHA t ON i.trilha_id = t.trilha_id
ORDER BY u.user_id, i.enrolled_at DESC;

SELECT t.trilha_id,
       t.title,
       COUNT(DISTINCT i.user_id) AS num_inscritos,
       ROUND(AVG(p.percentage),2) AS avg_progress_percentage
FROM TB_TRILHA t
LEFT JOIN TB_INSCRICAO i ON t.trilha_id = i.trilha_id
LEFT JOIN TB_PROGRESSO p ON i.inscricao_id = p.inscricao_id
GROUP BY t.trilha_id, t.title
ORDER BY num_inscritos DESC;

SELECT t.trilha_id,
       t.title,
       t.difficulty,
       NVL(COUNT(i.inscricao_id),0) AS inscricoes_count,
       t.duration_hours
FROM TB_TRILHA t
LEFT OUTER JOIN TB_INSCRICAO i ON t.trilha_id = i.trilha_id
WHERE t.difficulty IN ('BEGINNER','INTERMEDIATE')
GROUP BY t.trilha_id, t.title, t.difficulty, t.duration_hours
ORDER BY t.duration_hours DESC;
