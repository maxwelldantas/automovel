# Automóvel - API

Projeto desenvolvido com Spring Web, Spring Data JPA e banco de dados H2 Database.

Verificar se no sistema operacional encontra-se instalado o Java na versão 11 com as variáveis de ambiente devidamente definidas.

Para executar o projeto, é necessário entrar na raiz do projeto e rodar o seguinte comando:

Para sistema operacional Windows executar pelo CMD:
```
mvnw.cmd spring-boot:run
```
Para sistema operacional Linux executar no Terminal:
```
mvnw spring-boot:run
```


Após o projeto subir com sucesso o mesmo estará executando na URL: http://localhost:8080

## Endpoints
### Cadastro de automóvel disponível para compra
#### POST /cadastroAutomoveis

Cadastra o automóvel disponível para compra.

Dados enviados no corpo da requisição em JSON.

Não é necessário passar o campo id pois é gerado automaticamente.

Não é necessário passar o campo dataCadastro pois é gerada automaticamente conforme a data que está sendo realizado o cadastro.

Retorna 201 se criação for ok.

Exemplo de corpo de requisição:

```
{
    "marca": "Toyota",
    "modelo": "Corolla",
    "valor": 60000.24
}
```


### Retorna todos os automóveis cadastrados em JSON
#### GET /automóveis

Retorna uma lista em JSON com os automóveis cadastrados para compra.
E retorna 200 se a consulta for ok.

Exemplo do retorno:

```
[
    {
        "id": 1,
        "marca": "Toyota",
        "modelo": "Corolla",
        "valor": 60000.24,
        "dataCadastro": "27/06/2022"
    },
    {
        "id": 2,
        "marca": "Honda",
        "modelo": "Civic",
        "valor": 80000.24,
        "dataCadastro": "27/06/2022"
    }
]
```