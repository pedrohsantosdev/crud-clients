# CRUD de Clientes — Desafio DevSuperior

API REST desenvolvida como solução do desafio **CRUD de Clientes**, do curso do professor **Nélio Alves**, da **DevSuperior**.

O projeto faz parte do meu aprendizado contínuo em **Java e Spring Boot**, aplicando arquitetura em camadas, persistência de dados e validação de requisições.

## 🚀 Tecnologias

- Java 25
- Spring Boot 4.1.2
- Spring Data JPA / Hibernate
- Jakarta Bean Validation
- Banco de dados H2
- Maven

## ⚙️ Funcionalidades

- Cadastro de clientes.
- Consulta por ID.
- Listagem paginada e ordenada.
- Atualização e exclusão de clientes.
- Validação dos dados de entrada.
- Tratamento de exceções com respostas padronizadas.

## 🏗️ Arquitetura

O projeto está organizado nas camadas **Controller**, **Service** e **Repository**, com **DTOs** para transferência de dados e **entidades** para persistência.

## 🌐 Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/clients` | Listar clientes |
| GET | `/clients/{id}` | Buscar cliente por ID |
| POST | `/clients` | Cadastrar cliente |
| PUT | `/clients/{id}` | Atualizar cliente |
| DELETE | `/clients/{id}` | Excluir cliente |

Exemplo de consulta paginada:

```http
GET /clients?page=0&size=5&sort=name,asc
```

## 📋 Exemplo de requisição

Corpo JSON para cadastro e atualização:

```json
{
  "name": "Maria Silva",
  "cpf": "12345678900",
  "income": 3500.0,
  "birthDate": "1995-08-20",
  "children": 2
}
```

> Dados fictícios para demonstração.

## ✅ Validações e erros

- Nome e CPF não podem estar em branco.
- Renda e quantidade de filhos, quando informadas, não podem ser negativas.
- Data de nascimento, quando informada, não pode estar no futuro.
- **404:** cliente não encontrado.
- **422:** falha na validação dos dados.

## ▶️ Como executar

**Pré-requisito:** JDK 25 instalado.

```bash
git clone https://github.com/pedrohsantosdev/crud-clients.git
cd crud-clients
```

**Linux/macOS/WSL:**

```bash
chmod +x mvnw
./mvnw spring-boot:run
```

**Windows — PowerShell:**

```powershell
.\mvnw.cmd spring-boot:run
```

API disponível em: `http://localhost:8080/clients`

## 🗄️ Banco de dados

O perfil `test` utiliza H2 em memória, com carga inicial de 10 clientes fictícios.

- **Console:** `http://localhost:8080/h2-console`
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Usuário:** `sa`
- **Senha:** deixar em branco

## 👨‍💻 Autor

**[Pedro Henrique dos Santos](https://github.com/pedrohsantosdev)**

Desafio proposto por **Nélio Alves — [DevSuperior](https://devsuperior.com.br/)**.
