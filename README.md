# Seminario Java - Grupo 3

Projeto didatico para demonstrar como Java organiza e implementa uma solucao
computacional usando Programacao Orientada a Objetos.

## Conceitos demonstrados

- classes e objetos;
- encapsulamento;
- abstracao;
- heranca;
- sobrescrita de metodos;
- polimorfismo;
- separacao de responsabilidades;
- validacao de dados;
- testes automatizados sem dependencias externas.

## Estrutura

```text
src/main/java/br/com/grupo3/seguros/
|-- Veiculo.java
|-- Carro.java
|-- Moto.java
|-- RelatorioSeguro.java
`-- Main.java
```

## Como executar

No terminal aberto na raiz do projeto:

```powershell
javac -d out src/main/java/br/com/grupo3/seguros/*.java
java -cp out br.com.grupo3.seguros.Main
```

## Como executar os testes

No terminal aberto na raiz do projeto:

```powershell
javac -d out src/main/java/br/com/grupo3/seguros/*.java src/test/java/br/com/grupo3/seguros/*.java
java -cp out br.com.grupo3.seguros.TesteVeiculos
```

Os testes verificam as taxas de Carro e Moto, as validacoes dos veiculos, o
calculo do total dos seguros e a rejeicao de uma lista vazia.

O fluxo `Verificacao Java`, localizado em `.github/workflows/java-ci.yml`,
repete automaticamente essa verificacao no GitHub a cada envio para `main` e
a cada pull request direcionado para essa branch.

## Regras da simulacao

- Carro: seguro equivalente a 5% do valor do veiculo.
- Moto: seguro equivalente a 8% do valor do veiculo.
- O relatorio apresenta os valores em reais e calcula o total dos seguros.

Requisito: JDK 21 ou uma versao compativel instalada.

## Como apresentar sem baixar no computador da faculdade

O projeto pode ser executado no navegador com **GitHub Codespaces**. O ambiente
usa Java 21 por meio de `.devcontainer/devcontainer.json`. O GitHub Actions
tambem pode ser iniciado manualmente para mostrar os testes e a saida do
programa nos registros da execucao.

Veja o passo a passo em [Como executar no dia](docs/Como_Executar_No_Dia.md).
