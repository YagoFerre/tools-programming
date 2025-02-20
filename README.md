# Tools Programming

**Tools Programming** é uma API desenvolvida em Java com o objetivo de aprendizado. Este projeto implementa um sistema CRUD para gerenciar uma entidade de linguagens de programação. 

## Sumário

- [Arquitetura do Projeto](#arquitetura-do-projeto)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Executando o Projeto](#executando-o-projeto)
- [Endpoints da API](#endpoints-da-api)
- [Contribuindo](#contribuindo)
- [Licença](#licença)

## Arquitetura do Projeto

O projeto segue a arquitetura de Camadas e Clean Architecture, com uma separação clara entre as responsabilidades:

- **Domain Layer**: Contém as entidades e interfaces de casos de uso.
  - `Tool.java`: Entidade que representa a ferramenta de programação.
  
- **Application Layer**: Contém os casos de uso (use cases) que implementam a lógica de negócios.
  - `CreateToolsUseCase`, `UpdateToolsUseCase`, `ReadToolsUseCase`, `DeleteToolsUseCase`: Interfaces para os casos de uso.
  - Implementações: `CreateToolsUseCaseImpl`, `UpdateToolsUseCaseImpl`, `ReadToolsUseCaseImpl`, `DeleteToolsUseCaseImpl`.
  
- **Infrastructure Layer**: Contém a implementação dos gateways (repositórios), mapeamentos, e a comunicação com a base de dados.
  - `ToolsRepository.java`: Interface do repositório usando Spring Data JPA.
  - `ToolsGatewayImpl.java`: Implementação do gateway que interage com o repositório.
  - `ToolsMapper.java`: Mapeador entre `Tool` e `ToolEntity`.
  - `ToolEntity.java`: Entidade JPA que representa a tabela no banco de dados.

- **Interface Adapters Layer**: Contém os controladores REST para a interação com o cliente.
  - `ToolsController.java`: Controlador REST para a entidade `Tool`.

## Configuração do Ambiente

### Requisitos

- Java 17
- Maven 3.8+
- Docker

### Configurando o Banco de Dados

O projeto utiliza PostgreSQL como banco de dados, gerenciado com Docker Compose.

1. Certifique-se de que o Docker está instalado e em execução.
2. Na raiz do projeto, execute:

   ```bash
   docker-compose up -d
   ```

   Isso iniciará um container PostgreSQL com as credenciais e configurações definidas em `docker-compose.yml`:

   - Banco de dados: `tools`
   - Usuário: `postgres`
   - Senha: `postgres`

## Executando o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/tools-programming.git
   cd tools-programming
   ```

2. Compile e execute a aplicação utilizando Maven:
   ```bash
   mvn spring-boot:run
   ```

3. A aplicação estará disponível em `http://localhost:8080`.

## Endpoints da API

### Base URL

```
http://localhost:8080/api/v1/tools
```

### Endpoints Disponíveis

- `GET /tools`: Retorna todas as ferramentas cadastradas. Pode ser filtrado por tag com o parâmetro `tag`.
- `POST /tools`: Cria uma nova ferramenta.
- `PUT /tools/{id}`: Atualiza uma ferramenta existente pelo ID.
- `DELETE /tools/{id}`: Remove uma ferramenta pelo ID.

## Contribuindo

Contribuições são bem-vindas! Se você encontrou um bug ou tem uma ideia para uma melhoria, abra uma issue ou envie um pull request.

## Licença

Este projeto é distribuído sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.