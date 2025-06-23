# Planner

O **Planner** é uma aplicação backend desenvolvida em **Java** utilizando o framework **Spring Boot**. O objetivo do projeto é gerenciar viagens, permitindo o cadastro de participantes, atividades e links relacionados a cada viagem. A aplicação utiliza o banco de dados **H2** para persistência e o **Flyway** para controle de migrações.

## Funcionalidades

- **Gerenciamento de Viagens**:
    - Criar, atualizar e consultar viagens.
    - Confirmar viagens e notificar participantes.

- **Gerenciamento de Participantes**:
    - Convidar participantes para uma viagem.
    - Listar todos os participantes de uma viagem.
    - Enviar e-mails de confirmação para os participantes.

- **Gerenciamento de Atividades**:
    - Registrar atividades relacionadas a uma viagem.
    - Listar todas as atividades de uma viagem.

- **Gerenciamento de Links**:
    - Adicionar links úteis relacionados a uma viagem.
    - Listar todos os links de uma viagem.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal.
- **Spring Boot**: Framework para desenvolvimento do backend.
- **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
- **Flyway**: Controle de versões e migrações do banco de dados.
- **Maven**: Gerenciador de dependências e build.
- **Insomnia**: Ferramenta utilizada para testar as APIs.

## Estrutura do Projeto

O projeto segue uma arquitetura organizada em camadas:

- **Controller**: Responsável por expor as APIs REST.
- **Service**: Contém a lógica de negócios.
- **Repository**: Interface para acesso ao banco de dados.
- **Model**: Representa as entidades do sistema.

## Endpoints

### Viagens (`/trips`)
- **POST** `/trips`: Cria uma nova viagem.
- **GET** `/trips/{id}`: Retorna os detalhes de uma viagem.
- **PUT** `/trips/{id}`: Atualiza os dados de uma viagem.
- **GET** `/trips/{id}/confirm`: Confirma uma viagem e notifica os participantes.

### Participantes (`/trips/{id}/participants`)
- **POST** `/trips/{id}/invite`: Convida um participante para a viagem.
- **GET** `/trips/{id}/participants`: Lista todos os participantes de uma viagem.

### Atividades (`/trips/{id}/activities`)
- **POST** `/trips/{id}/activities`: Registra uma nova atividade para a viagem.
- **GET** `/trips/{id}/activities`: Lista todas as atividades de uma viagem.

### Links (`/trips/{id}/links`)
- **POST** `/trips/{id}/links`: Adiciona um link relacionado à viagem.
- **GET** `/trips/{id}/links`: Lista todos os links de uma viagem.

## Testes da API

Os testes das APIs foram realizados utilizando o **Insomnia**. Todas as rotas foram verificadas para garantir que os dados estão sendo retornados corretamente.

### Exemplos de Testes

1. **Criar uma Viagem**:
    - Método: `POST`
    - URL: `/trips`
    - Payload:
      ```json
      {
        "destination": "Paris",
        "starts_at": "2023-12-01T10:00:00",
        "ends_at": "2023-12-10T18:00:00",
        "emails_to_invite": ["email1@example.com", "email2@example.com"]
      }
      ```

2. **Convidar Participante**:
    - Método: `POST`
    - URL: `/trips/{id}/invite`
    - Payload:
      ```json
      {
        "email": "email3@example.com"
      }
      ```

3. **Registrar Atividade**:
    - Método: `POST`
    - URL: `/trips/{id}/activities`
    - Payload:
      ```json
      {
        "name": "Tour pela Torre Eiffel",
        "description": "Visita guiada pela Torre Eiffel",
        "starts_at": "2023-12-02T14:00:00",
        "ends_at": "2023-12-02T16:00:00"
      }
      ```

## Configuração e Execução

### Pré-requisitos

- **Java 17** ou superior.
- **Maven** instalado.

### Passos para Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/LuisFelipeTS17/planner.git
   cd planner
   ```

2. Execute as migrações do banco de dados:
   ```bash
   mvn flyway:migrate
   ```

3. Inicie a aplicação:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse a aplicação:
    - A API estará disponível em: `http://localhost:8080`.

### Banco de Dados H2

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Usuário: `sa`
- Senha: (vazia)

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.