<h1 align="center">Microserviço de usuários</h1>
<h3 align="center">Arquitetura hexagonal</h3>
<br />

<h3 align="left">Vamos conectar?</h3>
<p align="left">
  <a href="https://linkedin.com/in/leonardo-almeida-391579161" target="_blank">
    <img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="leonardo-almeida-391579161" height="30" width="40" />
  </a>
</p>

### Tecnologias usadas:

<p align="left">
  <a href="https://openjdk.org/projects/jdk/17/" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40" />
  </a>
  <a href="https://spring.io/projects/spring-boot" target="_blank">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" alt="typescript" width="40" height="40" />
  </a>
    <a href="https://www.postgresql.org" target="_blank">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postgresql/postgresql-plain.svg" alt="postgresql" width="40" height="40" />
  </a>
 <a href="https://www.rabbitmq.com/" target="_blank">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/rabbitmq/rabbitmq-original.svg" alt="rabbitMq" width="40" height="40" />
  </a>
</p>

### TODO
- [ ] Configuração detalhada do ambiente de desenvolvimento.
- [ ] Guia de instalação e execução do projeto.
- [ ] Documentação da API com exemplos de requisições e respostas.
- [ ] Descrição detalhada da arquitetura e design do sistema.
- [ ] Estratégias de teste e qualidade de código.
- [ ] Estratégias de segurança e autenticação.


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
