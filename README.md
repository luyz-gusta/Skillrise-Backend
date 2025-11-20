# 🚀 SkillRise 2030+ Backend

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0-green.svg)](https://spring.io/projects/spring-boot)
[![Oracle](https://img.shields.io/badge/Oracle-23c-red.svg)](https://www.oracle.com/database/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

> REST API completa para plataforma de upskilling/reskilling gamificada com trilhas personalizadas, sistema de conquistas, certificações digitais e matching com oportunidades de trabalho.

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
- **JWT** para autenticação stateless
- **CORS** configurado para frontend
- **Role-based access control** (USER, ADMIN)

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

# JWT
jwt.secret=seu-secret-super-seguro-com-256-bits-no-minimo
jwt.expiration=86400000

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

# Testar login
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"maria.silva@email.com","password":"senha123"}'
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

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
