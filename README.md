# Relatório Exercício de Programação 1 - Introdução à Programação - 26 de Abril de 2016
Repositório para guardar meu primeiro programa em java. A ideia é nunca esquecer que um dia já fui iniciante.

## Introdução
O programa, sobre o qual, o presente relatório irá tratar, foi escrito para calcular o resultado do Impeachment. O programa pega os dados de cada um dos deputados federais e mostra: 
- O resultado final da apuração: número de votos a favor, contrários e nulos/abstenções. 
- A conclusão da votação: aprovado ou reprovado o pedido. 
- Quantos deputados votaram a favor, contra ou se abstiveram por partido. 
- Quantos deputados votaram a favor, contra ou se abstiveram por unidade da federação que representa (Estado). 

## Metodologia
### Criação de uma Matriz de Dados
Para armazenar os dados de cada deputado foi criada uma matriz contendo NOME, PARTIDO, ESTADO e VOTO (favor, nulo ou contra).

### Uso da Interface Set para criação de um Array de Estados e outra de Partidos sem duplicidade 
Esse recurso foi utilizado na apuração dos votos por Estado e por Partido.

### Apuração final dos votos
Para apuração final dos votos foi utilizada uma comparação de Strings usando `“.equalsIgnoreCase”`
```
int favor;
int contra;
int nulo;
String resultado = "";
```

### Apuração dos votos por Partidos e por Estados
O `Set` foi convertido em um `Array` para ser utilizado como parâmetro dentro de um laço duplo for que percorre as colunas (1 - Partido ou 2 - Estado e 3 - voto) da matriz tabela.

## Resultado
Para testar o EP foi utilizado um arquivo “.txt” com as seguintes entradas:
NÚMERO DE VOTOS (int votos); NOME, PARTIDO, ESTADO e VOTO de cada um dos deputados, no total de 513.

## Compilando
javac Impeachment.java

## Executando
java Impeachment < votos.txt


