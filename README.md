# 📝 Sobre

Este é um projeto de geração de Certificados utilizando a biblioteca JasperReports e JasperSoft Studio. O objetivo deste projeto é demonstrar a geração de relatórios _.jasper_ com integração ao framework [Spring Boot](https://spring.io/projects/spring-boot).

O contexto do projeto é uma API de certificados, onde temos os alunos cadastrados e ao concluir seus respectivos cursos, será gerada uma URL para poder acessar seu certificado e também um QR Code + um link para validar o certificado.

<br/>

# 🎥 Vídeos

<div align="center">
    <div>
        <p style="font-size: 15px;">Esse vídeo demonstra o fluxo básico do sistema, vai do cadastro do aluno até a geração de seu certificado</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/api-certificados/api-certificados-fluxo.gif?raw=true" alt="Certificado-4">
    </div>
    <br/>
    <div>
        <p style="font-size: 15px;">Validando o certificado através do QR Code</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/api-certificados/api-certificados-qrcode.gif?raw=true" alt="Certificado-4">
    </div>
</div>

<br/>

# 🎨 Imagens

<div align="center">
    <div>
        <p style="font-size: 15px;">Certificado do aluno de código 4</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/api-certificados/certificado-4.png?raw=true" alt="Certificado-4">
    </div>
    <div>
        <p style="font-size: 15px;">Certificado Detalhes</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/api-certificados/certificado-amplo.png?raw=true" alt="Certificado Detalhes">
    </div>
    <div>
        <p style="font-size: 15px;">Certificado Inexistente</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/api-certificados/certificado-inexistente.png?raw=true" alt="Certificado Inexistente">
    </div>
    <div>
        <p style="font-size: 15px;">Lista Alunos</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/api-certificados/lista-alunos.png?raw=true" alt="Lista Alunos">
    </div>
    <div>
        <p style="font-size: 15px;">Cadastro Aluno</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/api-certificados/cadastro-aluno.png?raw=true" alt="Cadastro Aluno">
    </div>
    <div>
        <p style="font-size: 15px;">Concluir Curso</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/api-certificados/concluir-curso.png?raw=true" alt="Concluir Curso">
    </div>
</div>


# 🚀 Tecnologias utilizadas

## Para o desenvolvimento da aplicação

- Java 17
- Spring Boot
- PostgreSQL
- Spring Data JPA
- Lombok
- Maven
- JasperSoft Studio
- JasperReports

<br/>

# 🔗 Link para acessar a API remotamente

Para acessar a API que está hospedada na plataforma [Heroku](https://id.heroku.com/login) e poder testar as rotas, basta clicar aqui: https://edvan-api-certificados.herokuapp.com/alunos

Para a URL de alunos, estão disponíveis as operações básicas de um CRUD de acordo com o padrão REST:

- /alunos (POST) → Cadastrar um novo aluno
- /alunos (GET) → Lista todos os alunos
- /alunos/{id} (PUT) → Atualiza o aluno informado
- /alunos/{id} (GET) → Busca o aluno pelo ID
- /alunos/{id} (DELETE) → Deleta o aluno
- /alunos/{id} (PATCH) → Definir data da conclusão do curso

Para a URL de certificados, está disponível a busca do certificado do aluno:

- /certificados/{id} (GET) → Busca o certificado do aluno informado

<br/>

# 👓 Instruções de como rodar o projeto localmente em sua máquina

Para executar localmente, apenas será necessário ter instalados em sua máquina os seguintes programas: [Java](https://www.java.com/pt-BR/), [Git](https://git-scm.com/), [Maven](https://maven.apache.org/) e [PostgreSQL](https://www.postgrescompare.com/).

Com todos os programas devidamente instalados, segue as instruções:

1 - Primeiro é preciso criar um banco de dados chamado _certificados_ no [PostgreSQL](https://www.postgrescompare.com/).

```sql
    CREATE DATABASE certificados ENCODING 'UTF-8';
```

2- Em seguida é necessário criar o usuário com permissão de login, o nome será _adm_ e a senha _123456_.

```sql
    CREATE ROLE adm WITH LOGIN SUPERUSER PASSWORD '123456';
```
3- Por fim, agora é só executar em um terminal os comandos abaixo.

```bash
$ git clone https://github.com/Edvan-Oliveira/api-certificados.git

$ cd api-certificados

$ mvn clean install

$ cd target

$ java -jar certificados-jasperreports-0.0.1-SNAPSHOT.jar

```

#

## Contatos

<div>
    <a href="https://www.linkedin.com/in/edvan-oliveira-0822b2227/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
  <a href = "mailto:edvan.oliveiract@gmail.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
  <a href = "https://t.me/Edvan_Oliveira"><img src="https://img.shields.io/badge/Telegram-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white" target="_blank"></a>

</div>

#
