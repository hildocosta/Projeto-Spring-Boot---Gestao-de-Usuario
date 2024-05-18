<p align="center">
  <img src="https://github.com/hildocosta/hildocosta-Curso-Java--Nelio-Alves/blob/main/logo.png" width="300">
</p>

<h1 align="center">💡 Projeto de Gestão de Usuários</h1>

<p>🚀 Este projeto tem como objetivo fornecer uma API REST para a gestão de usuários, permitindo operações de criação, leitura, atualização e exclusão (CRUD) de usuários. Este projeto é desenvolvido utilizando Spring Boot e JPA.</p>

<h2 align="center">📝 Sobre o Projeto</h2>

<p>🌟 O sistema permite a gestão de usuários com operações completas de CRUD, sem diferenciação de tipos de usuários ou permissões específicas.</p>

<h2 align="center">🚀 Vamos Começar</h2>

<h3>Pré-requisitos</h3>

<p>🔧 Antes de iniciar, certifique-se de ter o <a href="https://www.oracle.com/java/technologies/javase-downloads.html">JDK (Java Development Kit)</a> instalado em sua máquina, além de uma IDE Java (Eclipse, IntelliJ IDEA, NetBeans, etc.).</p>

<h3>Clonando o Repositório</h3>

<p>📥 Para começar, clone este repositório em sua máquina local usando o seguinte comando no terminal:</p>

<pre><code>git clone https://github.com/...</code></pre>

<h3>Configuração do Git</h3>

<p>🔑 Se você ainda não tem o Git instalado, baixe e instale-o rapidamente a partir do <a href="https://git-scm.com/downloads">site oficial do Git</a>. Depois de instalado, configure seu nome de usuário e endereço de e-mail com os seguintes comandos:</p>

<pre><code>git config --global user.name "Seu Nome"
git config --global user.email "seu-email@example.com"</code></pre>

<h2 align="center">📋 Estrutura do Projeto</h2>

```
br.com.historico.historico
├── Application.java
├── model
│   ├── request
│   │   └── UserRequest.java
│   └── response
│       └── UserResponse.java
├── persistence
│   ├── entity
│   │   └── User.java
│   └── repository
│       └── UserRepository.java
├── service
│   ├── Mapper.java
│   └── UserRequestMapper.java
│   └── UserResponseMapper.java
│  └── UserServiceImpl.java
│   └── UserService.java
└── ws.historico
    └── UserController.java
└── HistoricoApplication.java

```

<h3>Principais Classes</h3>

- `Application.java`: Classe principal que inicializa a aplicação Spring Boot.
- `UserRequest.java`: Modelo de dados para a criação e atualização de usuários.
- `UserResponse.java`: Modelo de dados para a resposta da API sobre as operações de usuário.
- `User.java`: Entidade JPA que representa a tabela de usuários no banco de dados.
- `UserRepository.java`: Interface JPA Repository para operações de banco de dados.
- `Mapper.java`: Interface genérica para mapeamento entre objetos de diferentes tipos.
- `UserRequestMapper.java`: Implementação de mapeamento de UserRequest para User.
- `UserResponseMapper.java`: Implementação de mapeamento de User para UserResponse.
- `UserService.java`: Interface para os serviços relacionados a usuários.
- `UserServiceImpl.java`: Implementação da interface UserService.
- `UserController.java`: Controlador REST que gerencia as requisições HTTP para operações de usuário.
- `HistoricoApplication.java`: Classe principal de execução da aplicação.

<h2 align="center">📋 Detalhamento das Classes</h2>

### 📋 Detalhamento das Classes

#### br.com.historico.historico.Application
- **Descrição:** Classe principal que inicializa a aplicação Spring Boot.
- **Função:** Contém o método `main`, que inicia a aplicação e configura o contexto do Spring.

#### br.com.historico.historico.model.request.UserRequest
- **Descrição:** Modelo de dados para a criação e atualização de usuários.
- **Função:** Define os campos necessários para criar ou atualizar um usuário, validando-os conforme necessário.

#### br.com.historico.historico.model.response.UserResponse
- **Descrição:** Modelo de dados para a resposta da API sobre as operações de usuário.
- **Função:** Define os campos que serão retornados como resposta para as operações relacionadas ao usuário.

#### br.com.historico.historico.persistence.entity.User
- **Descrição:** Entidade JPA que representa a tabela de usuários no banco de dados.
- **Função:** Define a estrutura da tabela de usuários e suas colunas, incluindo validações e mapeamento de colunas.

#### br.com.historico.historico.persistence.repository.UserRepository
- **Descrição:** Interface JPA Repository para operações de banco de dados.
- **Função:** Define métodos de CRUD e consultas específicas para a entidade `User`.

#### br.com.historico.historico.service.Mapper
- **Descrição:** Interface genérica para mapeamento entre objetos de diferentes tipos.
- **Função:** Define um método genérico para converter objetos de um tipo em outro.

#### br.com.historico.historico.service.UserService
- **Descrição:** Interface para os serviços relacionados a usuários.
- **Função:** Define métodos para as operações de negócio relacionadas a usuários, como criar, atualizar, obter e deletar usuários.

#### br.com.historico.historico.service.UserServiceImpl
- **Descrição:** Implementação da interface UserService.
- **Função:** Implementa a lógica de negócio para as operações de usuário, interagindo com o repositório e mapeando entre entidades e modelos de request/response.

#### br.com.historico.historico.service.mapper.UserRequestMapper
- **Descrição:** Implementação de mapeamento de `UserRequest` para `User`.
- **Função:** Converte objetos do tipo `UserRequest` para `User`.

#### br.com.historico.historico.service.mapper.UserResponseMapper
- **Descrição:** Implementação de mapeamento de `User` para `UserResponse`.
- **Função:** Converte objetos do tipo `User` para `UserResponse`.

#### br.com.historico.historico.web.UserController
- **Descrição:** Controlador REST que gerencia as requisições HTTP para operações de usuário.
- **Função:** Define os endpoints da API e delega as operações de negócio ao serviço `UserService`.

#### br.com.historico.historico.HistoricoApplication
- **Descrição:** Classe principal de execução da aplicação.
- **Função:** Contém a anotação `@SpringBootApplication` e o método `main` para iniciar a aplicação.

### Conceitos Chave

- **Pacotes (Packages):** Os pacotes ajudam a organizar o código de maneira modular e segmentada, facilitando a manutenção e a navegação pelo projeto.
- **Modelos (Models):** Representam os dados que a aplicação manipula. Divididos em `request` e `response` para diferenciar entre dados de entrada e saída.
- **Entidades (Entities):** Classes que mapeiam tabelas do banco de dados, utilizando anotações JPA para definir as colunas e as restrições.
- **Repositórios (Repositories):** Interfaces que extendem `JpaRepository` para realizar operações CRUD e consultas ao banco de dados.
- **Serviços (Services):** Contêm a lógica de negócio da aplicação. Os serviços interagem com os repositórios e mapeiam os dados entre entidades e modelos.
- **Controladores (Controllers):** Definem os endpoints da API REST e gerenciam as requisições HTTP, delegando a lógica de negócio aos serviços.
- **Mapeadores (Mappers):** Implementam a interface `Mapper` para converter objetos de um tipo para outro, facilitando a separação entre camadas de dados e de lógica.


<h3>📋 Anotações JPA</h3>

### Anotações JPA 

As anotações JPA (Java Persistence API) são utilizadas para mapear objetos Java para entidades de banco de dados relacional. Aqui está uma explicação rápida das principais anotações utilizadas:

- `@Entity`: Indica que a classe é uma entidade JPA, ou seja, representa uma tabela no banco de dados.
- `@Table`: Especifica o nome da tabela no banco de dados.
- `@Id`: Indica que o campo é a chave primária da entidade.
- `@GeneratedValue`: Define como o valor da chave primária é gerado, neste caso, automaticamente pelo banco de dados.
- `@Column`: Permite especificar as propriedades de uma coluna do banco de dados, como nome, nullable, etc.
- `@NotBlank`: Uma validação do Bean Validation que garante que o campo não seja nulo e nem uma string vazia.
- `@Email`: Uma validação do Bean Validation que garante que o campo seja um endereço de e-mail válido.
- `@Pattern`: Uma validação do Bean Validation que permite definir um padrão regex para o campo.

### Método `map` na classe `User`

O método `map` na classe `User` é uma abordagem conhecida como padrão de mapeamento. Ele é usado para converter uma instância da entidade `User` em qualquer tipo desejado, utilizando uma função de mapeamento (`Function<User, R>`). Este método é útil para realizar mapeamentos personalizados entre a entidade `User` e outros tipos de dados. Aqui está uma explicação simples do método:

- `public <R> R map(Function<User, R> func)`: Este método é genérico, o que significa que pode retornar qualquer tipo `R`. Ele recebe uma função de mapeamento como argumento, que mapeia uma instância de `User` para o tipo `R`.
- `func.apply(this)`: Aqui, a função de mapeamento é aplicada à instância atual de `User`, convertendo-a para o tipo `R`.

### Método `password` na classe `User`

O método `password` na classe `User` é simplesmente um getter para o campo `password`. Ele permite acessar o valor do campo `password` da entidade `User`. Este campo geralmente armazena a senha do usuário de forma criptografada ou protegida, dependendo das políticas de segurança da aplicação. Aqui está uma descrição básica do método:

- `public String getPassword()`: Este método retorna a senha do usuário como uma string. É comum que este método seja utilizado para autenticar usuários durante o processo de login, por exemplo.



<h2 align="center">🛠️ Testes com Postman</h2>

<p>🔍 Para testar a API, utilizei o <a href="https://www.postman.com/">Postman</a>, uma ferramenta popular para testes de APIs. Abaixo estão os passos para testar cada operação:</p>

<h3>📋 Endpoints e Métodos</h3>

- **Criar Usuário**
  - **URL:** `POST /users`
  - **Body:**
  ```json
  {
    "name": "John Doe",
    "document": "123456789",
    "login": "johndoe",
    "email": "johndoe@example.com",
    "password": "Password123"
  }
  ```

- **Listar Todos os Usuários**
  - **URL:** `GET /users`

- **Obter Detalhes de um Usuário**
  - **URL:** `GET /users/{id}`

- **Atualizar Usuário**
  - **URL:** `PUT /users/{id}`
  - **Body:**
  ```json
  {
    "name": "John Doe Updated",
    "document": "987654321",
    "login": "johndoeupdated",
    "email": "john.doe.updated@example.com",
    "password": "NewPassword123"
  }
  ```

- **Deletar Usuário**
  - **URL:** `DELETE /users/{id}`

<h2 align="center">🔒 Licença</h2>

<p>⚖️ Este projeto está licenciado sob a <a href="LICENSE">Licença MIT</a>.</p>

<h2 align="center">📧 Contato</h2>

<h3>🔗 Redes Sociais e Contato</h3>

<ul>
  <li>📌 GitHub: <a href="https://github.com/hildocosta">hildocosta</a></li>
  <li>💼 LinkedIn: <a href="https://www.linkedin.com/in/hildo-costa-b83812231/">Hildo Costa</a></li>
  <li>✉️ Email: hildo.costa@pm.pr.gov.br</li>
</ul>

<p>Agora que você está preparado e animado, vamos começar!</p>

