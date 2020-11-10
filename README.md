# Desafio Framework

### Para o projeto rodar, adicionar os seguintes valores como variaveis de ambiente

-Dspring.datasource.name=desafio-framework
-Dspring.datasource.driverClassName=org.postgresql.Driver
-Dspring.datasource.url=jdbc:postgresql://127.0.0.1:5432/desafio-framework
-DUSERNAME_DB=postgres
-DPASSWORD_DB=1234

### A idéia seria fazer um Filtro ( JWTFilter) para que todas as requisições tenham que ter no cabeçalho o jwt gerado, em exceção todas que
### batam no /usuarios/* , onde seria a parte não logada
### 
## Com o token JWT, passaria no header, bateria nas API's e conseguiria autenticar a requisição para o recurso cabível.
###
