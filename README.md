# 🚀 SkillRise 2030+ Backend

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0-green.svg)](https://spring.io/projects/spring-boot)
[![Oracle](https://img.shields.io/badge/Oracle-23c-red.svg)](https://www.oracle.com/database/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

> REST API completa para plataforma de upskilling/reskilling gamificada com trilhas personalizadas, sistema de conquistas, certificações digitais e matching com oportunidades de trabalho.

---

## 🎯 Problema e Solução

### O Problema
O mercado de trabalho está em transformação acelerada com:
- **85 milhões de empregos** serão substituídos por automação até 2030 (WEF)
- **97 milhões de novas vagas** exigirão habilidades diferentes
- **50% dos trabalhadores** precisarão de reskilling/upskilling
- Falta de plataformas integradas que conectem aprendizado → certificação → emprego

### Nossa Solução
**SkillRise 2030+** oferece uma jornada completa:
1. **Diagnóstico** - Identifica lacunas de habilidades do profissional
2. **Trilhas Personalizadas** - 15 trilhas estruturadas em IA, Cloud, Cybersecurity, ESG, Soft Skills
3. **Gamificação** - Sistema de XP, níveis, conquistas e streaks para manter engajamento
4. **Certificação Digital** - Certificados verificáveis ao concluir trilhas
5. **Matching com Vagas** - 20 oportunidades reais vinculadas às competências desenvolvidas

---

## 📋 Sobre

Backend da plataforma **SkillRise 2030+** - solução educacional para preparar profissionais para o futuro do trabalho através de:

- 🎓 **15 trilhas de aprendizado** estruturadas (50+ módulos)
- 🎮 **Sistema de gamificação completo** (XP, níveis, achievements, streaks)
- 📜 **Certificados digitais verificáveis** com códigos únicos
- 🔔 **Sistema de notificações** em tempo real
- 🎯 **Metas personalizadas** de aprendizado
- 💼 **20 oportunidades de trabalho** vinculadas às trilhas
- 🤖 **Recomendações inteligentes** baseadas em perfil

---

## 🛠️ Stack Tecnológico

### Core
- **Java 17+** - Linguagem base
- **Spring Boot 4.0.0-SNAPSHOT** - Framework principal
- **Maven** - Gerenciamento de dependências

### Frameworks & Libraries
- **Spring Data JPA** - Persistência de dados
- **Hibernate 7.1.8** - ORM
- **Spring Security** - Autenticação e autorização
- **JWT (jjwt 0.12.6)** - Tokens de autenticação
- **Lombok** - Redução de boilerplate
- **Oracle JDBC Driver** - Conexão com banco

### Database
- **Oracle Database 23c** (compatível com 19c+)
- **17 entidades JPA** 100% sincronizadas com DDL
- **Schema validation** habilitado

### Segurança
- **BCrypt** para hash de senhas
- **JWT temporariamente desabilitado** para facilitar testes
- **CORS** configurado para frontend
- **Autenticação simplificada** para desenvolvimento

---

## 📦 Estrutura do Projeto

```
apirest/
├── src/main/java/com/fiap/skillriseapi/
│   ├── domain/
│   │   ├── entities/          # 17 Entidades JPA
│   │   │   ├── User.java
│   │   │   ├── Trilha.java
│   │   │   ├── Progresso.java
│   │   │   ├── Achievement.java
│   │   │   ├── Certificado.java
│   │   │   └── ...
│   │   └── dto/               # Request/Response DTOs
│   │       ├── auth/
│   │       ├── user/
│   │       ├── trilha/
│   │       └── ...
│   ├── repositories/          # 11 JPA Repositories
│   ├── service/               # 11 Services
│   ├── controllers/           # 10 REST Controllers
│   ├── infra/
│   │   ├── config/           # Configurações
│   │   ├── security/         # JWT, Security Config
│   │   └── errors/           # Exception handlers
│   └── SkillRiseApiApplication.java
├── src/main/resources/
│   ├── application.properties
│   └── application-dev.properties
└── pom.xml
```

---

## 🚀 Como Executar

### Pré-requisitos

- **Java 17+** ([Download](https://adoptium.net/temurin/releases/?version=17))
- **Maven 3.8+** (ou use `./mvnw`)
- **Oracle Database 23c** ou 19c ([Download Oracle XE](https://www.oracle.com/database/technologies/xe-downloads.html))

### 1️⃣ Configurar Banco de Dados

```bash
# Conectar ao Oracle (SQL*Plus ou SQL Developer)
sqlplus system/sua_senha@localhost:1521/XE

# Executar scripts DDL e DML (NA ORDEM!)
@Database/scripts/sql-ddl-oracle.sql
@Database/scripts/sql-dml-oracle.sql

COMMIT;
EXIT;
```

### 2️⃣ Configurar application.properties

Edite `src/main/resources/application.properties`:

```properties
# Database
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.username=system
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Server
server.port=8080
```

### 3️⃣ Executar Aplicação

```bash
# Opção 1: Maven Wrapper (recomendado)
./mvnw clean install
./mvnw spring-boot:run

# Opção 2: Maven instalado
mvn clean install
mvn spring-boot:run

# Opção 3: IntelliJ IDEA
# File → Open → Selecione pasta apirest
# Run → Run 'SkillRiseApiApplication'
```

### 4️⃣ Verificar Funcionamento

```bash
# Health check
curl http://localhost:8080/actuator/health

# Testar listagem de trilhas (sem autenticação)
curl http://localhost:8080/trilhas
```

✅ **API rodando em:** `http://localhost:8080`

---

## 📊 Dados de Teste

### Usuários Pré-cadastrados
```
maria.silva@email.com / senha123 (Level 5, 2000 XP, 8 achievements)
joao.santos@email.com / senha123 (Level 2, 800 XP, 3 achievements)
ana.costa@email.com / senha123 (Level 1, 100 XP, 1 achievement)
```

### Conteúdo Disponível
- **20 Skills** (Java, Python, React, Machine Learning, etc)
- **15 Trilhas** (IA, Cloud, Cybersecurity, Soft Skills, ESG)
- **50+ Módulos** organizados nas trilhas
- **10 Empresas** parceiras
- **20 Vagas** reais vinculadas às trilhas

---

## 🧪 Como Testar

### Opção 1: Swagger UI (Recomendado)

Acesse a interface interativa: **http://localhost:8080/swagger-ui.html**

⚠️ **Nota**: Autenticação JWT está temporariamente desabilitada para facilitar testes.

1. **Acesse a interface** do Swagger
2. **Teste endpoints** diretamente sem necessidade de token
3. **Todos os endpoints** estão acessíveis publicamente

### Opção 2: Postman

#### 1️⃣ Importar Collection

Crie uma nova Collection e adicione:

**POST** `/auth/login` - Autenticação
```json
{
  "email": "maria.silva@email.com",
  "password": "senha123"
}
```

**GET** `/trilhas` - Listar todas as trilhas
```
Sem headers necessários
```

**POST** `/inscricoes` - Inscrever em trilha
```json
{
  "trilhaId": 1
}
```
```
Sem headers necessários
```

**PUT** `/progresso?inscricaoId=1&moduloId=1` - Atualizar progresso
```json
{
  "percentage": 100.0
}
```
```
Sem headers necessários
```

**GET** `/user/stats` - Estatísticas do usuário
```
Sem headers necessários
```

#### 2️⃣ Configurar Ambiente

Crie variável `baseUrl` = `http://localhost:8080`
Crie variável `token` e atualize após login

### Opção 3: Insomnia

Importe o seguinte JSON:

```json
{
  "name": "SkillRise API",
  "requests": [
    {
      "name": "Listar Trilhas",
      "method": "GET",
      "url": "{{ baseUrl }}/trilhas"
    },
    {
      "name": "Inscrever em Trilha",
      "method": "POST",
      "url": "{{ baseUrl }}/inscricoes",
      "body": {
        "trilhaId": 1
      }
    }
  ]
}
```

### Exemplos de Requisições

#### 📝 Registro de Novo Usuário
```bash
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "name": "João Silva",
    "email": "joao@email.com",
    "password": "senha123"
  }'
```

**Resposta:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "userId": 4,
  "name": "João Silva",
  "email": "joao@email.com"
}
```

#### 🔐 Login
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "maria.silva@email.com",
    "password": "senha123"
  }'
```

**Resposta:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "userId": 1,
  "name": "Maria Silva",
  "email": "maria.silva@email.com"
}
```

#### 📚 Listar Trilhas
```bash
curl -X GET http://localhost:8080/trilhas
```

**Resposta:**
```json
{
  "data": [
    {
      "trilhaId": 1,
      "title": "Inteligência Artificial e Machine Learning",
      "description": "Domine IA desde fundamentos até aplicações avançadas",
      "category": "TECHNOLOGY",
      "level": "INTERMEDIARIO",
      "durationHours": 120.00,
      "rating": 4.80,
      "totalAvaliacoes": 234,
      "imageUrl": "https://images.unsplash.com/photo-...",
      "totalModulos": 8
    }
  ],
  "count": 15
}
```

#### ✅ Inscrever em Trilha
```bash
curl -X POST http://localhost:8080/inscricoes \
  -H "Content-Type: application/json" \
  -d '{"trilhaId": 1}'
```

**Resposta:**
```json
{
  "data": {
    "inscricaoId": 5,
    "trilhaId": 1,
    "trilhaTitle": "Inteligência Artificial e Machine Learning",
    "dataInscricao": "2025-11-20",
    "dataConclusao": null,
    "concluida": false,
    "progressoGeral": 0.0
  }
}
```

#### 📈 Atualizar Progresso de Módulo
```bash
curl -X PUT 'http://localhost:8080/progresso?inscricaoId=1&moduloId=1' \
  -H "Content-Type: application/json" \
  -d '{"percentage": 100.0}'
```

**Resposta:**
```json
{
  "data": {
    "progressoId": 10,
    "inscricaoId": 1,
    "moduloId": 1,
    "moduloTitle": "Introdução à IA",
    "percentage": 100.0,
    "lastUpdated": "2025-11-20",
    "completedAt": "2025-11-20"
  }
}
```

#### 🏆 Obter Estatísticas do Usuário
```bash
curl -X GET http://localhost:8080/user/stats
```

**Resposta:**
```json
{
  "data": {
    "userId": 1,
    "name": "Maria Silva",
    "email": "maria.silva@email.com",
    "xp": 2000,
    "level": 5,
    "xpProximoLevel": 500,
    "streakDias": 7,
    "ultimoAcesso": "2025-11-20",
    "totalInscricoes": 5,
    "trilhasCompletas": 2,
    "modulosCompletos": 15,
    "totalCertificados": 2,
    "totalAchievements": 8,
    "taxaConclusao": 40.0
  }
}
```

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
