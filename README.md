# Conversor de Moedas - Java

Este é um desafio de programação que consiste em um conversor de moedas que consome a API **ExchangeRate-API** para obter taxas de câmbio em tempo real.

## Funcionalidades

O sistema oferece um menu interativo no console com as seguintes conversões:
- Dólar (USD) para Peso Argentino (ARS)
- Peso Argentino (ARS) para Dólar (USD)
- Dólar (USD) para Real Brasileiro (BRL)
- Real Brasileiro (BRL) para Dólar (USD)
- Dólar (USD) para Peso Colombiano (COP)
- Peso Colombiano (COP) para Dólar (USD)

## Tecnologias Utilizadas

* **Java 17** (ou superior)
* **HttpClient**: Para realizar as requisições HTTP à API.
* **Gson (Google)**: Para converter a resposta JSON da API em objetos Java (Records).
* **ExchangeRate-API**: Fonte de dados para as taxas de câmbio.

## Estrutura do Projeto

O projeto está organizado no pacote `buscarapi`:
- `Main.java`: Ponto de entrada da aplicação.
- `ConversaoMoeda.java`: Contém a lógica do menu, loop principal e tratamento de erros.
- `BuscarDadosApi.java`: Responsável por fazer a conexão HTTP e retornar o objeto mapeado.
- `DadosApi.java`: Um `record` que representa a estrutura de dados recebida da API.

## Como Executar

1.  **Clone o repositório:**
  
2.  **Adicione a biblioteca Gson:**
    Certifique-se de ter o arquivo `.jar` do Gson no seu classpath ou adicione a dependência via Maven/Gradle:
    ```xml
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
    ```
3.  **Obtenha uma chave da API:**
    Cadastre-se em [ExchangeRate-API](https://www.exchangerate-api.com/) e substitua a chave no código na classe `BuscarDadosApi`.

4.  **Execute a classe Main:**
    Basta rodar o arquivo `Main.java` e seguir as instruções no terminal.

## Tratamento de Erros

O projeto conta com proteções para:
* **Entradas Inválidas:** O sistema não trava se o usuário digitar letras no lugar de números (usando `InputMismatchException`).
* **Erros de Conexão:** Mensagens claras caso a API esteja fora do ar ou a sigla da moeda seja inválida.

