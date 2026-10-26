# MARCHA API

A **MARCHA** é a primeira API desenvolvida por mim, com foco em operações CRUD de produtos usando Java e Spring Boot.

## Visão geral

A aplicação expõe endpoints REST para criar, buscar, atualizar e remover produtos.
Os dados são persistidos em banco **H2 em memória**, com schema inicial definido em `src/main/resources/data.sql`.

## Tecnologias

- Java 21
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- Banco H2 (em memória)
- Maven (via Maven Wrapper `./mvnw`)

## Pré-requisitos

- JDK 21 instalado
- Permissão para executar o Maven Wrapper (`mvnw`)

## Instalação

```bash
git clone https://github.com/Pgualberto-dev/My-first-API.git
cd My-first-API
```

## Configuração

Configurações atuais em `src/main/resources/application.yml`:

- `spring.datasource.url=jdbc:h2:mem:produtos`
- `spring.datasource.username=sa`
- `spring.datasource.password` (definida no `application.yml`)
- Console H2 habilitado em: `/h2-console`

## Execução

```bash
./mvnw spring-boot:run
```

A aplicação sobe com o nome `produtosapi` e disponibiliza os endpoints sob o caminho base `/produtos`.

## Endpoints / uso

Base path: `/produtos`

### Criar produto

**POST** `/produtos`

Exemplo de requisição:

```bash
curl -X POST http://localhost:8080/produtos \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Notebook",
    "description": "Notebook 16GB RAM",
    "price": 4500.00
  }'
```

### Buscar produto por ID

**GET** `/produtos/{id}`

```bash
curl http://localhost:8080/produtos/{id}
```

### Atualizar produto

**PUT** `/produtos/{id}`

```bash
curl -X PUT http://localhost:8080/produtos/{id} \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Notebook Pro",
    "description": "Modelo atualizado",
    "price": 5200.00
  }'
```

### Remover produto

**DELETE** `/produtos/{id}`

```bash
curl -X DELETE http://localhost:8080/produtos/{id}
```

### Listar produtos por nome

**GET** `/produtos?nome={nome}`

```bash
curl "http://localhost:8080/produtos?nome=Notebook"
```

> Observação: o endpoint de listagem atual usa o parâmetro de query `nome` como filtro.

## Testes

Para executar os testes existentes no projeto:

```bash
./mvnw test
```

## Contribuição

Contribuições são bem-vindas.

Fluxo sugerido:

1. Faça um fork do repositório
2. Crie uma branch para sua melhoria (`git checkout -b minha-melhoria`)
3. Commit suas alterações
4. Abra um Pull Request
