<h1 align="center">Microserviço de usuários</h1>
<h3 align="center">Arquitetura de Ports e Adapters</h3>
<br />

<h3 align="center">Tecnologias usadas</h3>
<p align="center">
  <a href="https://spring.io/projects/spring-boot" target="_blank">
    <img src="https://upload.wikimedia.org/wikipedia/commons/4/44/Spring_Framework_Logo_2018.svg" alt="Spring" width="100" height="100"/>
  </a>
  <a href="https://www.rabbitmq.com" target="_blank">
    <img src="https://upload.wikimedia.org/wikipedia/commons/7/71/RabbitMQ_logo.svg" alt="RabbitMQ" width="100" height="100"/>
  </a>
  <a href="https://www.postgresql.org" target="_blank">
    <img src="https://upload.wikimedia.org/wikipedia/commons/2/29/Postgresql_elephant.svg" alt="PostgreSQL" width="100" height="100"/>
  </a>
</p>
<br />

### Rotas

#### Criar Usuário
- **POST /**: Cria um novo usuário.
  - Payload: `CreateUserRecordDto` com campos `email` (Email do usuário, obrigatório e deve ser válido) e `name` (Nome do usuário, obrigatório).

#### Listar Todos os Usuários
- **GET /**: Retorna todos os usuários cadastrados.

#### Buscar Usuário por ID
- **GET /{id}**: Busca um usuário pelo seu UUID.
  - Parâmetro de URL: `id` (UUID do usuário).

#### Atualizar Usuário por ID
- **PATCH /{id}**: Atualiza dados de um usuário pelo seu UUID.
  - Parâmetro de URL: `id` (UUID do usuário).
  - Payload: `UpdateUserRecordDto` com campos `email` (novo email do usuário, opcional) e `name` (novo nome do usuário, opcional).

#### Deletar Usuário por ID
- **DELETE /{id}**: Deleta um usuário pelo seu UUID.
  - Parâmetro de URL: `id` (UUID do usuário).

### TODO
- [ ] Configuração detalhada do ambiente de desenvolvimento.
- [ ] Guia de instalação e execução do projeto.
- [ ] Documentação da API com exemplos de requisições e respostas.
- [ ] Descrição detalhada da arquitetura e design do sistema.
- [ ] Estratégias de teste e qualidade de código.
- [ ] Estratégias de segurança e autenticação.
- [ ] Como contribuir para o projeto.
