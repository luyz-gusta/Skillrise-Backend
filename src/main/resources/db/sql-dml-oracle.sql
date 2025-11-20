-- =========================================================================
-- SCRIPT DML COMPLETO - SkillRise 2030+
-- Descrição: Dados iniciais completos para popular o banco de dados
-- Versão: 2.0 (Unificado)
-- Data: 2025
-- =========================================================================
-- Pré-requisito: Executar sql-ddl-complete.sql antes deste script
-- =========================================================================
-- Este script insere:
-- - 20 Skills (competências técnicas e soft skills)
-- - 15 Trilhas completas com categorias, tags e ratings
-- - 50+ Módulos distribuídos pelas trilhas
-- - 10 Empresas parceiras (Google, Microsoft, Nubank, etc)
-- - 20 Oportunidades de emprego realistas
-- - 6 Usuários de exemplo (incluindo admin)
-- - Achievements, Notificações e Metas de exemplo
-- =========================================================================

-- =========================================================================
-- LIMPEZA OPCIONAL (CUIDADO: Apaga todos os dados!)
-- =========================================================================
-- Descomente apenas se quiser resetar completamente os dados
/*
DELETE FROM TB_PROGRESSO;
DELETE FROM TB_INSCRICAO;
DELETE FROM TB_TRILHA_MODULO;
DELETE FROM TB_MODULO;
DELETE FROM TB_TRILHA;
DELETE FROM TB_USER_SKILL;
DELETE FROM TB_SKILL;
DELETE FROM TB_OPORTUNIDADE;
DELETE FROM TB_EMPRESA;
DELETE FROM TB_RECOMENDACAO;
DELETE FROM TB_CERTIFICADO;
DELETE FROM TB_ACHIEVEMENT;
DELETE FROM TB_NOTIFICACAO;
DELETE FROM TB_META;
DELETE FROM TB_USER;
COMMIT;
*/

-- =========================================================================
-- 1. SKILLS (20 Competências)
-- =========================================================================
INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('Python', 'Linguagem de programação versátil para IA, dados e web');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('Machine Learning', 'Técnicas de aprendizado de máquina e modelos preditivos');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('Deep Learning', 'Redes neurais profundas e inteligência artificial avançada');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('SQL', 'Linguagem de consulta para bancos de dados relacionais');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('Power BI', 'Ferramenta de visualização e análise de dados Microsoft');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('Tableau', 'Plataforma de business intelligence e visualização');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('Comunicação', 'Habilidade de expressar ideias clara e efetivamente');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('Liderança', 'Capacidade de guiar e inspirar equipes');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('Pensamento Crítico', 'Análise objetiva e avaliação de informações');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('Gestão de Projetos', 'Planejamento e execução de projetos com eficiência');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('Energia Solar', 'Tecnologias fotovoltaicas e sistemas de energia renovável');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('ESG', 'Práticas ambientais, sociais e de governança corporativa');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('Cybersegurança', 'Proteção de sistemas e redes contra ameaças digitais');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('Cloud Computing', 'Computação em nuvem AWS, Azure e Google Cloud');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('DevOps', 'Integração contínua e entrega de software');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('React', 'Biblioteca JavaScript para construção de interfaces');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('Node.js', 'Runtime JavaScript para desenvolvimento backend');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('UX/UI Design', 'Design de experiência e interface do usuário');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('Marketing Digital', 'Estratégias de marketing em plataformas digitais');

INSERT INTO TB_SKILL (NAME, DESCRIPTION) VALUES
('Product Management', 'Gestão de produtos digitais e roadmaps');

COMMIT;

-- =========================================================================
-- 2. TRILHAS (15 Trilhas Completas com Ratings Reais)
-- =========================================================================

-- TRILHA 1: IA & Automação
INSERT INTO TB_TRILHA (TITLE, DESCRIPTION, DIFFICULTY, DURATION_HOURS, CATEGORIA, TAGS, RATING, TOTAL_AVALIACOES, IMAGE_URL) VALUES
('IA & Automação', 'Domine machine learning, deep learning e automação de processos empresariais para liderar a transformação digital. Aprenda algoritmos, frameworks como TensorFlow e PyTorch, e aplique IA em casos reais.', 'INTERMEDIARIO', 40, 'TECNOLOGIA', 'machine-learning,ai,python,tensorflow,pytorch,automation', 4.8, 156, 'https://images.unsplash.com/photo-1677442136019-21780ecad995?w=800');

-- TRILHA 2: Ciência de Dados
INSERT INTO TB_TRILHA (TITLE, DESCRIPTION, DIFFICULTY, DURATION_HOURS, CATEGORIA, TAGS, RATING, TOTAL_AVALIACOES, IMAGE_URL) VALUES
('Ciência de Dados', 'Aprenda análise exploratória, visualização de dados, estatística aplicada e ferramentas como Python, SQL, Power BI e Tableau. Torne-se um profissional data-driven.', 'INICIANTE', 35, 'TECNOLOGIA', 'data-science,python,sql,powerbi,tableau,statistics', 4.7, 203, 'https://images.unsplash.com/photo-1551288049-bebda4e38f71?w=800');

-- TRILHA 3: Soft Skills para o Futuro
INSERT INTO TB_TRILHA (TITLE, DESCRIPTION, DIFFICULTY, DURATION_HOURS, CATEGORIA, TAGS, RATING, TOTAL_AVALIACOES, IMAGE_URL) VALUES
('Soft Skills para o Futuro', 'Desenvolva competências humanas essenciais: comunicação, liderança, resolução de problemas, inteligência emocional e trabalho em equipe. Destaque-se em qualquer carreira.', 'INICIANTE', 25, 'SOFT_SKILLS', 'communication,leadership,emotional-intelligence,teamwork', 4.9, 412, 'https://images.unsplash.com/photo-1522071820081-009f0129c71c?w=800');

-- TRILHA 4: Green Skills & ESG
INSERT INTO TB_TRILHA (TITLE, DESCRIPTION, DIFFICULTY, DURATION_HOURS, CATEGORIA, TAGS, RATING, TOTAL_AVALIACOES, IMAGE_URL) VALUES
('Green Skills & ESG', 'Aprenda sobre sustentabilidade corporativa, energias renováveis, economia circular e práticas ESG. Prepare-se para a economia verde e carreiras sustentáveis.', 'INTERMEDIARIO', 30, 'SUSTENTABILIDADE', 'esg,sustainability,renewable-energy,green-tech,circular-economy', 4.6, 89, 'https://images.unsplash.com/photo-1473341304170-971dccb5ac1e?w=800');

-- TRILHA 5: Cybersegurança Essencial
INSERT INTO TB_TRILHA (TITLE, DESCRIPTION, DIFFICULTY, DURATION_HOURS, CATEGORIA, TAGS, RATING, TOTAL_AVALIACOES, IMAGE_URL) VALUES
('Cybersegurança Essencial', 'Proteja sistemas e dados contra ameaças digitais. Aprenda ethical hacking, criptografia, segurança de redes, compliance e frameworks como ISO 27001 e NIST.', 'AVANCADO', 45, 'TECNOLOGIA', 'cybersecurity,ethical-hacking,network-security,compliance', 4.8, 134, 'https://images.unsplash.com/photo-1563986768609-322da13575f3?w=800');

-- TRILHA 6: Cloud & DevOps
INSERT INTO TB_TRILHA (TITLE, DESCRIPTION, DIFFICULTY, DURATION_HOURS, CATEGORIA, TAGS, RATING, TOTAL_AVALIACOES, IMAGE_URL) VALUES
('Cloud & DevOps', 'Domine AWS, Azure e Google Cloud. Aprenda Docker, Kubernetes, CI/CD, Infrastructure as Code (Terraform) e práticas DevOps para entregar software com agilidade.', 'AVANCADO', 50, 'TECNOLOGIA', 'cloud,aws,azure,docker,kubernetes,devops,terraform', 4.9, 178, 'https://images.unsplash.com/photo-1667372393119-3d4c48d07fc9?w=800');

-- TRILHA 7: Desenvolvimento Web Full Stack
INSERT INTO TB_TRILHA (TITLE, DESCRIPTION, DIFFICULTY, DURATION_HOURS, CATEGORIA, TAGS, RATING, TOTAL_AVALIACOES, IMAGE_URL) VALUES
('Desenvolvimento Web Full Stack', 'Construa aplicações web completas com React, Node.js, TypeScript, bancos de dados SQL/NoSQL e deploy na nuvem. Do frontend ao backend com as tecnologias mais demandadas.', 'INTERMEDIARIO', 60, 'TECNOLOGIA', 'react,nodejs,typescript,javascript,fullstack,web-development', 4.8, 267, 'https://images.unsplash.com/photo-1627398242454-45a1465c2479?w=800');

-- TRILHA 8: UX/UI Design
INSERT INTO TB_TRILHA (TITLE, DESCRIPTION, DIFFICULTY, DURATION_HOURS, CATEGORIA, TAGS, RATING, TOTAL_AVALIACOES, IMAGE_URL) VALUES
('UX/UI Design', 'Crie experiências digitais memoráveis. Aprenda pesquisa de usuários, prototipação, design thinking, Figma, testes de usabilidade e princípios de interface.', 'INTERMEDIARIO', 35, 'DESIGN', 'ux,ui,figma,design-thinking,prototyping,user-research', 4.7, 189, 'https://images.unsplash.com/photo-1561070791-2526d30994b5?w=800');

-- TRILHA 9: Product Management
INSERT INTO TB_TRILHA (TITLE, DESCRIPTION, DIFFICULTY, DURATION_HOURS, CATEGORIA, TAGS, RATING, TOTAL_AVALIACOES, IMAGE_URL) VALUES
('Product Management', 'Gerencie produtos digitais de sucesso. Aprenda discovery, roadmaps, métricas, priorização (RICE, MoSCoW), metodologias ágeis e comunicação com stakeholders.', 'INTERMEDIARIO', 38, 'NEGOCIOS', 'product-management,agile,metrics,roadmap,stakeholder-management', 4.8, 142, 'https://images.unsplash.com/photo-1460925895917-afdab827c52f?w=800');

-- TRILHA 10: Marketing Digital & Growth
INSERT INTO TB_TRILHA (TITLE, DESCRIPTION, DIFFICULTY, DURATION_HOURS, CATEGORIA, TAGS, RATING, TOTAL_AVALIACOES, IMAGE_URL) VALUES
('Marketing Digital & Growth', 'Domine SEO, SEM, marketing de conteúdo, redes sociais, e-mail marketing, analytics e estratégias de growth hacking para escalar negócios digitais.', 'INICIANTE', 32, 'NEGOCIOS', 'marketing,seo,sem,growth-hacking,analytics,content-marketing', 4.6, 221, 'https://images.unsplash.com/photo-1432888498266-38ffec3eaf0a?w=800');

-- TRILHA 11: Blockchain & Web3
INSERT INTO TB_TRILHA (TITLE, DESCRIPTION, DIFFICULTY, DURATION_HOURS, CATEGORIA, TAGS, RATING, TOTAL_AVALIACOES, IMAGE_URL) VALUES
('Blockchain & Web3', 'Entre no futuro descentralizado. Aprenda blockchain, smart contracts, Solidity, NFTs, DeFi e desenvolvimento de aplicações Web3 no Ethereum e outras redes.', 'AVANCADO', 42, 'TECNOLOGIA', 'blockchain,web3,ethereum,solidity,smart-contracts,defi,nfts', 4.5, 97, 'https://images.unsplash.com/photo-1639762681485-074b7f938ba0?w=800');

-- TRILHA 12: Business Intelligence & Analytics
INSERT INTO TB_TRILHA (TITLE, DESCRIPTION, DIFFICULTY, DURATION_HOURS, CATEGORIA, TAGS, RATING, TOTAL_AVALIACOES, IMAGE_URL) VALUES
('Business Intelligence & Analytics', 'Transforme dados em insights de negócio. Aprenda modelagem dimensional, ETL, dashboards executivos, KPIs e ferramentas como Power BI, Tableau e Looker.', 'INTERMEDIARIO', 36, 'TECNOLOGIA', 'bi,analytics,powerbi,tableau,etl,data-modeling', 4.7, 165, 'https://images.unsplash.com/photo-1551288049-bebda4e38f71?w=800');

-- TRILHA 13: Gestão de Projetos Ágeis
INSERT INTO TB_TRILHA (TITLE, DESCRIPTION, DIFFICULTY, DURATION_HOURS, CATEGORIA, TAGS, RATING, TOTAL_AVALIACOES, IMAGE_URL) VALUES
('Gestão de Projetos Ágeis', 'Aprenda Scrum, Kanban, cerimônias ágeis, gestão de backlog, métricas (burndown, velocity) e ferramentas como Jira. Prepare-se para certificações PMI-ACP ou PSM.', 'INTERMEDIARIO', 28, 'NEGOCIOS', 'agile,scrum,kanban,project-management,jira,pmi-acp', 4.8, 198, 'https://images.unsplash.com/photo-1454165804606-c3d57bc86b40?w=800');

-- TRILHA 14: IoT & Indústria 4.0
INSERT INTO TB_TRILHA (TITLE, DESCRIPTION, DIFFICULTY, DURATION_HOURS, CATEGORIA, TAGS, RATING, TOTAL_AVALIACOES, IMAGE_URL) VALUES
('IoT & Indústria 4.0', 'Conecte o mundo físico ao digital. Aprenda sensores, protocolos IoT (MQTT, CoAP), edge computing, gêmeos digitais e aplicações industriais da 4ª revolução industrial.', 'AVANCADO', 40, 'TECNOLOGIA', 'iot,industry4.0,sensors,mqtt,edge-computing,digital-twins', 4.6, 76, 'https://images.unsplash.com/photo-1518770660439-4636190af475?w=800');

-- TRILHA 15: Empreendedorismo Digital
INSERT INTO TB_TRILHA (TITLE, DESCRIPTION, DIFFICULTY, DURATION_HOURS, CATEGORIA, TAGS, RATING, TOTAL_AVALIACOES, IMAGE_URL) VALUES
('Empreendedorismo Digital', 'Lance seu negócio digital. Aprenda validação de ideias, lean startup, canvas de modelo de negócios, pitch, captação de investimentos e estratégias de crescimento.', 'INICIANTE', 30, 'NEGOCIOS', 'entrepreneurship,startup,lean-startup,business-model,pitch', 4.7, 154, 'https://images.unsplash.com/photo-1556761175-b413da4baf72?w=800');

COMMIT;

-- =========================================================================
-- 3. MÓDULOS (50+ módulos distribuídos nas 15 trilhas)
-- =========================================================================

-- MÓDULOS TRILHA 1: IA & Automação (12 módulos)
INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Fundamentos de Machine Learning', 180, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (1, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 1);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Regressão Linear e Logística', 150, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (1, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 2);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Árvores de Decisão e Random Forest', 140, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (1, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 3);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Support Vector Machines (SVM)', 120, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (1, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 4);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Redes Neurais e Deep Learning', 200, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (1, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 5);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Redes Neurais Convolucionais (CNN)', 180, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (1, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 6);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Redes Neurais Recorrentes (RNN) e LSTM', 170, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (1, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 7);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Natural Language Processing (NLP)', 190, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (1, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 8);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('TensorFlow e Keras na Prática', 160, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (1, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 9);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('PyTorch para Deep Learning', 160, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (1, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 10);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Deploy de Modelos ML em Produção', 150, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (1, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 11);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Projeto Final: Sistema de Recomendação', 300, 'PROJETO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (1, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 12);

-- MÓDULOS TRILHA 2: Ciência de Dados (10 módulos)
INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Introdução à Ciência de Dados', 120, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (2, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 1);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Python para Análise de Dados', 180, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (2, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 2);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Pandas e NumPy Essenciais', 150, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (2, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 3);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Visualização de Dados com Matplotlib e Seaborn', 140, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (2, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 4);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('SQL para Data Science', 180, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (2, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 5);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Estatística Aplicada', 160, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (2, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 6);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Power BI do Básico ao Avançado', 200, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (2, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 7);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Tableau para Visualização', 180, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (2, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 8);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Big Data e Spark', 170, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (2, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 9);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Projeto Final: Dashboard Analítico', 280, 'PROJETO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (2, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 10);

-- MÓDULOS TRILHA 3: Soft Skills (8 módulos)
INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Comunicação Eficaz e Assertividade', 120, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (3, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 1);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Liderança e Influência', 150, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (3, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 2);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Inteligência Emocional no Trabalho', 140, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (3, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 3);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Trabalho em Equipe e Colaboração', 110, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (3, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 4);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Resolução de Problemas e Pensamento Crítico', 130, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (3, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 5);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Criatividade e Inovação', 120, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (3, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 6);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Gestão do Tempo e Produtividade', 110, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (3, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 7);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Networking e Personal Branding', 130, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (3, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 8);

-- MÓDULOS TRILHAS 4-15 (3 módulos cada para demonstração)
-- TRILHA 4: Green Skills & ESG
INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Fundamentos de Sustentabilidade Corporativa', 150, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (4, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 1);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('ESG: Environmental, Social e Governance', 140, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (4, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 2);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Energias Renováveis e Descarbonização', 160, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (4, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 3);

-- TRILHA 5: Cybersegurança
INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Fundamentos de Segurança da Informação', 180, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (5, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 1);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Ethical Hacking e Pentest', 200, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (5, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 2);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Criptografia e Proteção de Dados', 170, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (5, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 3);

-- TRILHA 6: Cloud & DevOps
INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Introdução à Cloud Computing', 150, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (6, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 1);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('AWS Essentials', 200, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (6, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 2);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Docker e Containerização', 180, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (6, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 3);

-- TRILHA 7: Full Stack
INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('HTML, CSS e JavaScript Moderno', 200, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (7, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 1);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('React: Componentes e Hooks', 220, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (7, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 2);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Node.js e Express', 210, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (7, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 3);

-- TRILHA 8: UX/UI Design
INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Fundamentos de UX e Design Thinking', 160, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (8, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 1);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Pesquisa com Usuários', 140, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (8, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 2);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Prototipação no Figma', 180, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (8, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 3);

-- TRILHA 9: Product Management
INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Papel do Product Manager', 130, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (9, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 1);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Product Discovery e Validação', 150, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (9, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 2);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Roadmap e Priorização', 140, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (9, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 3);

-- TRILHA 10: Marketing Digital
INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Fundamentos de Marketing Digital', 130, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (10, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 1);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('SEO e SEM', 150, 'VIDEO');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (10, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 2);

INSERT INTO TB_MODULO (TITLE, DURATION_MINUTES, CONTENT_TYPE) VALUES ('Google Analytics e Métricas', 140, 'PRATICA');
INSERT INTO TB_TRILHA_MODULO (TRILHA_ID, MODULO_ID, MODULE_ORDER) VALUES (10, (SELECT MAX(MODULO_ID) FROM TB_MODULO), 3);

COMMIT;

-- =========================================================================
-- 4. EMPRESAS PARCEIRAS (10 Empresas)
-- =========================================================================
INSERT INTO TB_EMPRESA (NAME, WEBSITE) VALUES ('Google Brasil', 'https://careers.google.com/locations/brazil/');
INSERT INTO TB_EMPRESA (NAME, WEBSITE) VALUES ('Microsoft Brasil', 'https://careers.microsoft.com/');
INSERT INTO TB_EMPRESA (NAME, WEBSITE) VALUES ('Amazon Web Services (AWS)', 'https://aws.amazon.com/careers/');
INSERT INTO TB_EMPRESA (NAME, WEBSITE) VALUES ('Nubank', 'https://nubank.com.br/carreiras/');
INSERT INTO TB_EMPRESA (NAME, WEBSITE) VALUES ('iFood', 'https://carreiras.ifood.com.br/');
INSERT INTO TB_EMPRESA (NAME, WEBSITE) VALUES ('Mercado Livre', 'https://mercadolibre.eightfold.ai/');
INSERT INTO TB_EMPRESA (NAME, WEBSITE) VALUES ('Banco Inter', 'https://carreiras.bancointer.com.br/');
INSERT INTO TB_EMPRESA (NAME, WEBSITE) VALUES ('Itaú Unibanco', 'https://www.itau.com.br/trabalhe-conosco/');
INSERT INTO TB_EMPRESA (NAME, WEBSITE) VALUES ('Totvs', 'https://www.totvs.com/carreiras/');
INSERT INTO TB_EMPRESA (NAME, WEBSITE) VALUES ('Stone Co', 'https://stone.gupy.io/');

COMMIT;

-- =========================================================================
-- 5. OPORTUNIDADES DE EMPREGO (20 Vagas Completas)
-- =========================================================================
-- Vagas Google (Empresa ID 1)
INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (1, 'Machine Learning Engineer', 'Desenvolver e implementar modelos de ML em escala para produtos Google. Experiência com TensorFlow, Python e cloud computing.', 'Python,Machine Learning,TensorFlow,Cloud Computing', 15000, 28000, 'Pleno', 'São Paulo, SP', 'CLT', 'ATIVA');

INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (1, 'Data Scientist Sr.', 'Análise de dados complexos, criação de dashboards e modelos preditivos. SQL, Python, BigQuery essenciais.', 'Python,SQL,Machine Learning,Statistics,BigQuery', 18000, 32000, 'Sênior', 'São Paulo, SP', 'CLT', 'ATIVA');

-- Vagas Microsoft (Empresa ID 2)
INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (2, 'Cloud Solutions Architect', 'Projetar soluções em Azure para clientes enterprise. Certificação AZ-305 desejável.', 'Azure,Cloud Computing,DevOps,Terraform', 16000, 30000, 'Sênior', 'Remoto', 'CLT', 'ATIVA');

INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (2, 'Cybersecurity Specialist', 'Proteger infraestrutura cloud da Microsoft. Experiência com SIEM, SOC e threat hunting.', 'Cybersecurity,Azure,Ethical Hacking,Compliance', 14000, 26000, 'Pleno', 'São Paulo, SP', 'CLT', 'ATIVA');

-- Vagas AWS (Empresa ID 3)
INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (3, 'DevOps Engineer', 'Automação de infraestrutura AWS, CI/CD, Kubernetes. Trabalho remoto disponível.', 'AWS,DevOps,Kubernetes,Docker,Terraform', 13000, 24000, 'Pleno', 'Remoto', 'CLT', 'ATIVA');

INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (3, 'Solutions Architect - AI/ML', 'Ajudar clientes a implementar soluções de IA na AWS (SageMaker, Lambda, etc).', 'AWS,Machine Learning,Python,Cloud Architecture', 17000, 31000, 'Sênior', 'Remoto', 'CLT', 'ATIVA');

-- Vagas Nubank (Empresa ID 4)
INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (4, 'Engenheiro de Dados Pleno', 'Construir pipelines de dados escaláveis. Stack: Python, Spark, Airflow, Kafka.', 'Python,SQL,Spark,Data Engineering,Kafka', 12000, 22000, 'Pleno', 'São Paulo, SP', 'CLT', 'ATIVA');

INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (4, 'Product Manager - Fintech', 'Gerenciar produtos financeiros digitais. Experiência com metodologias ágeis e métricas de produto.', 'Product Management,Agile,Metrics,Fintech', 14000, 26000, 'Pleno', 'São Paulo, SP', 'CLT', 'ATIVA');

-- Vagas iFood (Empresa ID 5)
INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (5, 'Desenvolvedor Full Stack (React + Node)', 'Criar features para o app do iFood. React, Node.js, TypeScript, MongoDB.', 'React,Node.js,TypeScript,MongoDB,APIs', 11000, 20000, 'Pleno', 'São Paulo, SP', 'CLT', 'ATIVA');

INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (5, 'UX Designer Sênior', 'Design de experiência para milhões de usuários. Figma, testes de usabilidade, design systems.', 'UX,Figma,Design Thinking,User Research', 13000, 24000, 'Sênior', 'São Paulo, SP', 'CLT', 'ATIVA');

-- Vagas Mercado Livre (Empresa ID 6)
INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (6, 'Cientista de Dados - Marketplace', 'Modelos de recomendação e pricing. Python, ML, SQL, Spark.', 'Python,Machine Learning,SQL,Spark,Statistics', 14000, 25000, 'Pleno', 'São Paulo, SP', 'CLT', 'ATIVA');

INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (6, 'Engenheiro de Software Backend', 'Desenvolver microserviços escaláveis. Java, Spring Boot, Kafka, AWS.', 'Java,Spring Boot,Microservices,Kafka,AWS', 12000, 22000, 'Pleno', 'São Paulo, SP', 'CLT', 'ATIVA');

-- Vagas Banco Inter (Empresa ID 7)
INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (7, 'Analista de Cybersegurança', 'Monitorar e responder a incidentes de segurança. SIEM, SOC, análise de logs.', 'Cybersecurity,SIEM,Network Security,Incident Response', 10000, 18000, 'Pleno', 'Belo Horizonte, MG', 'CLT', 'ATIVA');

INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (7, 'Desenvolvedor Mobile (Flutter)', 'App bancário do Inter. Flutter, Dart, APIs REST, integração contínua.', 'Flutter,Dart,Mobile Development,APIs,CI/CD', 10000, 19000, 'Pleno', 'Belo Horizonte, MG', 'CLT', 'ATIVA');

-- Vagas Itaú Unibanco (Empresa ID 8)
INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (8, 'Analista de BI Sênior', 'Dashboards executivos e análise de dados bancários. Power BI, SQL, Python.', 'Power BI,SQL,Python,Business Intelligence', 12000, 22000, 'Sênior', 'São Paulo, SP', 'CLT', 'ATIVA');

INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (8, 'Especialista em ESG e Sustentabilidade', 'Implementar práticas ESG no banco. Certificação ESG desejável.', 'ESG,Sustainability,Compliance,Reporting', 11000, 20000, 'Pleno', 'São Paulo, SP', 'CLT', 'ATIVA');

-- Vagas Totvs (Empresa ID 9)
INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (9, 'Desenvolvedor Cloud (Azure)', 'Migração de sistemas legados para cloud. C#, Azure, DevOps.', 'Azure,C#,.NET,DevOps,Cloud Migration', 10000, 18000, 'Pleno', 'São Paulo, SP', 'CLT', 'ATIVA');

INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (9, 'Gerente de Projetos Ágeis', 'Liderar squads ágeis de desenvolvimento. Scrum Master, PSM I ou II.', 'Agile,Scrum,Project Management,Leadership,Jira', 12000, 23000, 'Sênior', 'São Paulo, SP', 'CLT', 'ATIVA');

-- Vagas Stone (Empresa ID 10)
INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (10, 'Engenheiro de Machine Learning', 'ML para detecção de fraude em pagamentos. Python, scikit-learn, TensorFlow.', 'Python,Machine Learning,TensorFlow,Fraud Detection', 13000, 24000, 'Pleno', 'São Paulo, SP', 'CLT', 'ATIVA');

INSERT INTO TB_OPORTUNIDADE (EMPRESA_ID, TITLE, DESCRIPTION, REQUIRED_SKILLS, SALARIO_MIN, SALARIO_MAX, NIVEL, LOCALIZACAO, TIPO_CONTRATO, STATUS)
VALUES (10, 'Especialista em Marketing Digital', 'Growth marketing para adquirir novos clientes. SEO, SEM, analytics, growth hacking.', 'Marketing Digital,SEO,SEM,Growth Hacking,Analytics', 9000, 17000, 'Pleno', 'São Paulo, SP', 'CLT', 'ATIVA');

COMMIT;

-- =========================================================================
-- 6. USUÁRIOS DE EXEMPLO (6 usuários: 5 users + 1 admin)
-- =========================================================================
-- Nota: Senhas devem ser hasheadas pelo backend. Aqui usamos hash exemplo do BCrypt
INSERT INTO TB_USER (NAME, EMAIL, PASSWORD, ROLE, BIRTH_DATE, XP, LEVEL_ACCOUNT, STREAK_DIAS) VALUES
('João Silva', 'joao.silva@example.com', '$2a$10$N9qo8uLOickgx2ZMRZoMye8IVjTGU82VGyqeXjz', 'USER', TO_DATE('1995-06-15', 'YYYY-MM-DD'), 1250, 3, 5);

INSERT INTO TB_USER (NAME, EMAIL, PASSWORD, ROLE, BIRTH_DATE, XP, LEVEL_ACCOUNT, STREAK_DIAS) VALUES
('Maria Santos', 'maria.santos@example.com', '$2a$10$N9qo8uLOickgx2ZMRZoMye8IVjTGU82VGyqeXjz', 'USER', TO_DATE('1992-03-22', 'YYYY-MM-DD'), 2800, 5, 12);

INSERT INTO TB_USER (NAME, EMAIL, PASSWORD, ROLE, BIRTH_DATE, XP, LEVEL_ACCOUNT, STREAK_DIAS) VALUES
('Pedro Oliveira', 'pedro.oliveira@example.com', '$2a$10$N9qo8uLOickgx2ZMRZoMye8IVjTGU82VGyqeXjz', 'USER', TO_DATE('1998-11-08', 'YYYY-MM-DD'), 450, 1, 2);

INSERT INTO TB_USER (NAME, EMAIL, PASSWORD, ROLE, BIRTH_DATE, XP, LEVEL_ACCOUNT, STREAK_DIAS) VALUES
('Ana Souza', 'ana.souza@example.com', '$2a$10$N9qo8uLOickgx2ZMRZoMye8IVjTGU82VGyqeXjz', 'USER', TO_DATE('1990-05-12', 'YYYY-MM-DD'), 650, 2, 3);

INSERT INTO TB_USER (NAME, EMAIL, PASSWORD, ROLE, BIRTH_DATE, XP, LEVEL_ACCOUNT, STREAK_DIAS) VALUES
('Carlos Pereira', 'carlos.pereira@example.com', '$2a$10$N9qo8uLOickgx2ZMRZoMye8IVjTGU82VGyqeXjz', 'USER', TO_DATE('1985-11-20', 'YYYY-MM-DD'), 3200, 6, 15);

INSERT INTO TB_USER (NAME, EMAIL, PASSWORD, ROLE, BIRTH_DATE, XP, LEVEL_ACCOUNT, STREAK_DIAS) VALUES
('Luiz Gustavo', 'luiz@admin.com', '$2a$10$N9qo8uLOickgx2ZMRZoMye8IVjTGU82VGyqeXjz', 'ADMIN', TO_DATE('1993-01-30', 'YYYY-MM-DD'), 5000, 10, 30);

COMMIT;

-- =========================================================================
-- 7. SKILLS DOS USUÁRIOS (User-Skill com proficiência)
-- =========================================================================
INSERT INTO TB_USER_SKILL (USER_ID, SKILL_ID, PROFICIENCY_LEVEL) VALUES (1, 1, 70);  -- João: Python
INSERT INTO TB_USER_SKILL (USER_ID, SKILL_ID, PROFICIENCY_LEVEL) VALUES (1, 7, 85);  -- João: Comunicação
INSERT INTO TB_USER_SKILL (USER_ID, SKILL_ID, PROFICIENCY_LEVEL) VALUES (2, 2, 90);  -- Maria: Machine Learning
INSERT INTO TB_USER_SKILL (USER_ID, SKILL_ID, PROFICIENCY_LEVEL) VALUES (2, 4, 85);  -- Maria: SQL
INSERT INTO TB_USER_SKILL (USER_ID, SKILL_ID, PROFICIENCY_LEVEL) VALUES (3, 16, 60); -- Pedro: React
INSERT INTO TB_USER_SKILL (USER_ID, SKILL_ID, PROFICIENCY_LEVEL) VALUES (4, 5, 75);  -- Ana: Power BI
INSERT INTO TB_USER_SKILL (USER_ID, SKILL_ID, PROFICIENCY_LEVEL) VALUES (5, 14, 95); -- Carlos: Cloud Computing
INSERT INTO TB_USER_SKILL (USER_ID, SKILL_ID, PROFICIENCY_LEVEL) VALUES (6, 8, 100); -- Admin: Liderança

COMMIT;

-- =========================================================================
-- 8. INSCRICÕES EM TRILHAS
-- =========================================================================
INSERT INTO TB_INSCRICAO (USER_ID, TRILHA_ID, DATA_INSCRICAO, STATUS) VALUES (1, 1, SYSDATE-10, 'EM_PROGRESSO');
INSERT INTO TB_INSCRICAO (USER_ID, TRILHA_ID, DATA_INSCRICAO, STATUS) VALUES (2, 2, SYSDATE-20, 'EM_PROGRESSO');
INSERT INTO TB_INSCRICAO (USER_ID, TRILHA_ID, DATA_INSCRICAO, STATUS) VALUES (3, 7, SYSDATE-5, 'EM_PROGRESSO');
INSERT INTO TB_INSCRICAO (USER_ID, TRILHA_ID, DATA_INSCRICAO, STATUS, DATA_CONCLUSAO) VALUES (4, 3, SYSDATE-15, 'CONCLUIDA', SYSDATE-2);
INSERT INTO TB_INSCRICAO (USER_ID, TRILHA_ID, DATA_INSCRICAO, STATUS) VALUES (5, 6, SYSDATE-30, 'EM_PROGRESSO');

COMMIT;

-- =========================================================================
-- 9. PROGRESSO EM MÓDULOS
-- =========================================================================
INSERT INTO TB_PROGRESSO (INSCRICAO_ID, MODULO_ID, PERCENTAGE, LAST_UPDATED) VALUES (1, 1, 60, SYSDATE-1);
INSERT INTO TB_PROGRESSO (INSCRICAO_ID, MODULO_ID, PERCENTAGE, LAST_UPDATED) VALUES (1, 2, 40, SYSDATE-2);
INSERT INTO TB_PROGRESSO (INSCRICAO_ID, MODULO_ID, PERCENTAGE, LAST_UPDATED) VALUES (2, 13, 80, SYSDATE-1);
INSERT INTO TB_PROGRESSO (INSCRICAO_ID, MODULO_ID, PERCENTAGE, LAST_UPDATED) VALUES (3, 31, 25, SYSDATE-1);
INSERT INTO TB_PROGRESSO (INSCRICAO_ID, MODULO_ID, PERCENTAGE, LAST_UPDATED, COMPLETED_AT) VALUES (4, 23, 100, SYSDATE-10, SYSDATE-10);

COMMIT;

-- =========================================================================
-- 10. ACHIEVEMENTS (Conquistas dos Usuários)
-- =========================================================================
INSERT INTO TB_ACHIEVEMENT (USER_ID, TIPO, NOME, DESCRICAO, ICONE, XP_GANHO, RARIDADE) VALUES
(1, 'MODULOS', 'Primeiro Módulo', 'Completou seu primeiro módulo de aprendizagem', 'BookOpen', 50, 'COMUM');

INSERT INTO TB_ACHIEVEMENT (USER_ID, TIPO, NOME, DESCRICAO, ICONE, XP_GANHO, RARIDADE) VALUES
(1, 'TRILHAS', 'Explorador Iniciante', 'Inscreveu-se na primeira trilha', 'Map', 100, 'COMUM');

INSERT INTO TB_ACHIEVEMENT (USER_ID, TIPO, NOME, DESCRICAO, ICONE, XP_GANHO, RARIDADE) VALUES
(2, 'TRILHAS', 'Mestre das Trilhas', 'Completou 3 trilhas inteiras', 'Trophy', 500, 'EPICO');

INSERT INTO TB_ACHIEVEMENT (USER_ID, TIPO, NOME, DESCRICAO, ICONE, XP_GANHO, RARIDADE) VALUES
(2, 'STREAK', 'Sequência de Fogo', 'Manteve 7 dias consecutivos de estudo', 'Flame', 200, 'RARO');

INSERT INTO TB_ACHIEVEMENT (USER_ID, TIPO, NOME, DESCRICAO, ICONE, XP_GANHO, RARIDADE) VALUES
(5, 'STREAK', 'Dedicação Total', 'Manteve 15 dias consecutivos de estudo', 'Zap', 300, 'EPICO');

COMMIT;

-- =========================================================================
-- 11. NOTIFICAÇÕES
-- =========================================================================
INSERT INTO TB_NOTIFICACAO (USER_ID, TITULO, MENSAGEM, TIPO, ICONE, LINK, LIDA) VALUES
(1, 'Nova Trilha Disponível!', 'A trilha "Blockchain & Web3" foi adicionada ao catálogo. Confira!', 'TRILHA', 'Sparkles', '/trilhas/11', 0);

INSERT INTO TB_NOTIFICACAO (USER_ID, TITULO, MENSAGEM, TIPO, ICONE, LINK, LIDA) VALUES
(1, 'Você ganhou um badge!', 'Parabéns! Você conquistou "Primeiro Módulo Completo". Continue assim!', 'ACHIEVEMENT', 'Award', '/perfil', 0);

INSERT INTO TB_NOTIFICACAO (USER_ID, TITULO, MENSAGEM, TIPO, ICONE, LINK, LIDA) VALUES
(2, 'Certificado Disponível', 'Seu certificado de "IA & Automação" está pronto para download!', 'CERTIFICADO', 'FileCheck', '/perfil', 1);

INSERT INTO TB_NOTIFICACAO (USER_ID, TITULO, MENSAGEM, TIPO, ICONE, LINK, LIDA) VALUES
(4, 'Nova Oportunidade!', 'Encontramos 3 vagas que combinam com seu perfil. Veja agora!', 'OPORTUNIDADE', 'Briefcase', '/oportunidades', 0);

COMMIT;

-- =========================================================================
-- 12. METAS DOS USUÁRIOS
-- =========================================================================
INSERT INTO TB_META (USER_ID, TITULO, DESCRICAO, TIPO, TARGET_VALUE, CURRENT_VALUE, PRAZO, STATUS) VALUES
(1, 'Completar 5 Trilhas até Junho', 'Meta de requalificação profissional para 2025', 'TRILHA', 5, 1, TO_DATE('2025-06-30', 'YYYY-MM-DD'), 'EM_ANDAMENTO');

INSERT INTO TB_META (USER_ID, TITULO, DESCRICAO, TIPO, TARGET_VALUE, CURRENT_VALUE, PRAZO, STATUS) VALUES
(2, 'Alcançar Level 10', 'Ganhar XP suficiente para subir ao nível 10', 'XP', 5000, 2800, TO_DATE('2025-12-31', 'YYYY-MM-DD'), 'EM_ANDAMENTO');

INSERT INTO TB_META (USER_ID, TITULO, DESCRICAO, TIPO, TARGET_VALUE, CURRENT_VALUE, PRAZO, STATUS) VALUES
(3, 'Completar 20 Módulos', 'Concluir 20 módulos de aprendizagem', 'MODULO', 20, 5, TO_DATE('2025-09-30', 'YYYY-MM-DD'), 'EM_ANDAMENTO');

INSERT INTO TB_META (USER_ID, TITULO, DESCRICAO, TIPO, TARGET_VALUE, CURRENT_VALUE, PRAZO, STATUS) VALUES
(5, 'Manter Streak de 30 Dias', 'Estudar por 30 dias consecutivos', 'TEMPO', 30, 15, TO_DATE('2025-05-15', 'YYYY-MM-DD'), 'EM_ANDAMENTO');

COMMIT;

-- =========================================================================
-- 13. CERTIFICADOS (Para usuários que completaram trilhas)
-- =========================================================================
-- Ana Souza completou a Trilha 3 (Soft Skills)
INSERT INTO TB_CERTIFICADO (USER_ID, TRILHA_ID, CODIGO_VERIFICACAO, DATA_EMISSAO)
VALUES (4, 3, 'CERT-2025-' || LPAD(DBMS_RANDOM.VALUE(100000, 999999), 6, '0'), SYSDATE-2);

-- Carlos Pereira completou múltiplas trilhas (exemplo)
INSERT INTO TB_CERTIFICADO (USER_ID, TRILHA_ID, CODIGO_VERIFICACAO, DATA_EMISSAO)
VALUES (5, 6, 'CERT-2025-' || LPAD(DBMS_RANDOM.VALUE(100000, 999999), 6, '0'), SYSDATE-5);

INSERT INTO TB_CERTIFICADO (USER_ID, TRILHA_ID, CODIGO_VERIFICACAO, DATA_EMISSAO)
VALUES (5, 1, 'CERT-2025-' || LPAD(DBMS_RANDOM.VALUE(100000, 999999), 6, '0'), SYSDATE-15);

COMMIT;

-- =========================================================================
-- 14. ASSOCIAÇÕES TRILHA-OPORTUNIDADE
-- =========================================================================
-- Vincular oportunidades às trilhas correspondentes

-- Trilha 1 (IA & Automação) -> Vagas de ML/IA (IDs: 1, 2, 19)
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (1, 1);
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (1, 2);
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (1, 19);

-- Trilha 2 (Ciência de Dados) -> Vagas de Dados (IDs: 1, 7, 11, 15)
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (2, 1);
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (2, 7);
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (2, 11);
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (2, 15);

-- Trilha 3 (Soft Skills) -> Vagas que valorizam soft skills (IDs: 8, 18)
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (3, 8);
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (3, 18);

-- Trilha 4 (Green Skills & ESG) -> Vaga ESG (ID: 16)
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (4, 16);

-- Trilha 5 (Cybersegurança) -> Vagas Cybersecurity (IDs: 4, 13)
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (5, 4);
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (5, 13);

-- Trilha 6 (Cloud & DevOps) -> Vagas Cloud/DevOps (IDs: 3, 5, 6, 17)
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (6, 3);
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (6, 5);
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (6, 6);
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (6, 17);

-- Trilha 7 (Full Stack) -> Vagas Dev (IDs: 9, 12, 14)
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (7, 9);
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (7, 12);
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (7, 14);

-- Trilha 8 (UX/UI Design) -> Vaga UX (ID: 10)
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (8, 10);

-- Trilha 9 (Product Management) -> Vaga PM (ID: 8)
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (9, 8);

-- Trilha 10 (Marketing Digital) -> Vaga Marketing (ID: 20)
INSERT INTO TB_TRILHA_OPORTUNIDADE (TRILHA_ID, OPORTUNIDADE_ID) VALUES (10, 20);

COMMIT;

-- =========================================================================
-- 15. RECOMENDAÇÕES (IA recomenda trilhas para usuários baseado no perfil)
-- =========================================================================
INSERT INTO TB_RECOMENDACAO (USER_ID, TRILHA_ID, SCORE) VALUES (1, 2, 87.5);  -- João -> Ciência de Dados
INSERT INTO TB_RECOMENDACAO (USER_ID, TRILHA_ID, SCORE) VALUES (1, 3, 55.0);  -- João -> Soft Skills
INSERT INTO TB_RECOMENDACAO (USER_ID, TRILHA_ID, SCORE) VALUES (2, 5, 92.0);  -- Maria -> Cybersegurança
INSERT INTO TB_RECOMENDACAO (USER_ID, TRILHA_ID, SCORE) VALUES (3, 8, 78.5);  -- Pedro -> UX/UI
INSERT INTO TB_RECOMENDACAO (USER_ID, TRILHA_ID, SCORE) VALUES (5, 6, 95.0);  -- Carlos -> Cloud & DevOps

COMMIT;

-- =========================================================================
-- FIM DO SCRIPT DML COMPLETO
-- Dados inseridos com sucesso para SkillRise 2030+
-- =========================================================================
