
![Events2](https://github.com/user-attachments/assets/be5f52d3-da7f-45b9-9868-9b3c76dbb4eb)

# 📌 API de Inscrições em Eventos  

Esse projeto foi desenvolvido para facilitar o processo de inscrições e indicações em eventos. Com ele, os participantes podem se cadastrar, indicar amigos e acompanhar um ranking de indicações.  

## 🚀 Sobre o Projeto  

O Sistema de Inscrições em Eventos permite que organizadores criem eventos e que os usuários façam inscrições de forma simples. Além disso, cada inscrito recebe um link único para indicar outras pessoas, e quem mais indicar aparece no ranking de destaques!  

🔎 Quer saber mais sobre os **requisitos funcionais, user stories e detalhes do projeto**?  
Acesse o documento completo aqui: [Mais informações sobre o projeto](https://economic-jaborosa-ec9.notion.site/Sistema-de-inscri-es-em-Eventos-1a1268a7953a80b488c0c6e80434cfa9)  

### 🔹 Funcionalidades  

✅ Inscrição de participantes com nome e e-mail  
✅ Geração de link único para indicar amigos  
✅ Ranking de indicações atualizado em tempo real  
✅ Interface simples para gerenciamento dos eventos  

## 🛠 Tecnologias Utilizadas  

O projeto foi desenvolvido com as seguintes tecnologias:  

- **Java com Spring Boot** (para a API REST)  
- **Spring JPA** (para manipulação do banco de dados)  
- **MySQL** (para armazenar as informações)  
- **Maven** (para gerenciamento de dependências)  
- **Postman** (para testar os endpoints da API)  

## 🎯 Como Rodar o Projeto  

### 🔹 Pré-requisitos  
Antes de começar, você precisa ter instalado:  
- **Java 23**  
- **Maven**  
- **MySQL**  
- **Postman (opcional, mas recomendado para testes)**  

### 🔹 Passo a Passo  

1️⃣ **Clone o repositório:**  
```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
```  

2️⃣ **Entre na pasta do projeto:**  
```bash
cd nome-do-repositorio
```  

3️⃣ **Configure o banco de dados**  
- Crie um banco de dados no MySQL com o nome `eventos_db`  
- No arquivo `application.properties`, configure as credenciais do MySQL:  
  ```
  spring.datasource.url=jdbc:mysql://localhost:3306/eventos_db
  spring.datasource.username=seu_usuario
  spring.datasource.password=sua_senha
  ```  

4️⃣ **Crie as tabelas no banco de dados**  
- Para criar as tabelas necessárias, execute o SQL disponível neste link:  
  👉 [Query SQL para criação das tabelas](https://economic-jaborosa-ec9.notion.site/Query-SQL-API-Events-1a1268a7953a80488c22f2f2f1fca64f)  

5️⃣ **Instale as dependências e rode o projeto:**  
```bash
mvn clean install
mvn spring-boot:run
```  

6️⃣ **Testando a API**  
- Para testar os endpoints, você pode usar o **Postman** ou qualquer ferramenta similar.  

## 💡 Contribuição  

Se quiser melhorar algo ou adicionar mais funcionalidades, fique à vontade para abrir um pull request ou sugerir mudanças! 😊  
