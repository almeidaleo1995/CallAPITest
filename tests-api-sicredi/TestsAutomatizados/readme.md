# Teste automatizados

Este é o projeto dos testes automatizados

##  Requisitos
 * Java 8+ JDK deve estar instalado
 * Maven deve estar instalado e configurado no path da aplicação
 * Navegador Google Chrome

 
## Como executar a aplicação 

Na raiz do projeto, através de seu Prompt de Commando/Terminal/Console execute o comando 

```bash
mvn clean spring-boot:run
```

A aplicação estará disponível através da URL [http://localhost:8080](http://localhost:8080)

Você pode trocar a porta da aplicação, caso a _8080_ já estiver em uso, adicionando a propriedade JVM `server.port`.

Exemplo:

```bash
mvn clean spring-boot:run -Dserver.port=8888
```

## Como executar os testes

Na raiz do projeto, através de seu Prompt de Commando/Terminal/Console execute o comando

exemplo:
C:\reposJava\desafiosicredi\tests-api-sicredi\TestsAutomatizados

```bash
mvn clean test -Dtest=RunnerTests
```

Apos executar esse comando, ainda em seu terminal execute o comando para buscar o relatorio de teste

colocar o caminho do absoluto do seu arquivo na sua pasta target, este caminho abaixo é so um exemplo
nessario que o navegador do chrome esteja instalado para melhor visualização do relatorio

```bash
start chrome C:\reposJava\desafiosicredi\tests-api-sicredi\TestsAutomatizados\target\cucumber.html
```
## Vale ressaltar que alguns teste estão falhando por conta de bugs da propria a API
## Em minha opnião vale fomentar que o correto nunca é adaptar os teste para o sucesso
