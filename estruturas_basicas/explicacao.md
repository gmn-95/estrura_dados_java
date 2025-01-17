# Estruturas Básicas

## 1 - Array Dinâmico
Um array dinâmico (ou um vetor dinâmico) é uma estrutura de dados que permite a manipulação de arrays de forma dinâmica, 
ou seja, de forma mais livre e fácil. Por exemplo, é possível adicionar ou remover valores com facilidade e em qualquer posição, 
sem a necessidade de gerenciar manualmente o tamanho do array. Ele automaticamente ajusta seu tamanho conforme necessário, 
aumentando ou diminuindo conforme os elementos são adicionados ou removidos.

Além disso, os arrays dinâmicos oferecem algumas vantagens adicionais:

- Crescimento Amortizado: Embora a inserção de um novo elemento possa, ocasionalmente, requerer a cópia de todos os elementos
para um novo array maior, a média de tempo por operação de inserção é constante.

- Memória Contínua: Como os arrays dinâmicos armazenam dados em blocos contínuos de memória, o acesso aos elementos é muito 
rápido (tempo constante).

- Flexibilidade: É possível redimensionar o array conforme necessário, permitindo a alocação de memória eficiente e a capacidade 
de lidar com conjuntos de dados de tamanhos variados.

## 2 - Pilha
Pilha é uma estrutura básica baseada no princípio LIFO (Last in, First Out (Último a entrar, primeiro a sair)). Ou seja, 
o último elemento inserido, é o primeiro a sair. Um exemplo do seu uso é na chamada de funções/métodos que diversas linguagens
e aplicações fazem. Essas pilhas podem ter tamanhos fixos ou dinâmicos. 

Pode ser utilizada quando queremos: Armazenar dados de forma temporária e acessá-los em ordem reversa, como funções recursivas,
verificações de expressões, dentre outras.

Um exemplo mais abstrato e bem comum quando falamos de pilhas, é a pilha de pratos quando vamos lavar louça. O último prato
inserido na pilha, é sempre o primeiro a sair. 

## 3 - Fila
Fila é uma estrutura básica baseada no princípio FIFO (First in, First Out (Primeiro a entrar, primeiro a sair)). Ou seja,
diferente da pilha, o primeiro elemento inserido, é o primeiro a sair. 

Um exemplo mais abstrato e bem comum que podemos usar de fila são filas de supermercado, onde a primeira pessoa que chega 
na fila, é a primeira a ser atendida. O conceito, se aplica aqui também.

O uso mais comum de filas é onde necessário processar elementos em uma ordem que se baseia em seu princípio FIFO. É uma 
estrutura ideal para sistemas que dependem de uma ordem cronológica.

Exemplos de usos:
- Sistemas de Gerenciamento de tarefas
- Filas de requisições
- Sistemas de atendimentos
- Processamentos de dados em lotes

## 4 - Fila circular
A Fila circular é uma variação da fila comum, onde os elementos são armazenados em forma de circulo, onde o último elemento
está diretamente conectado ao primeiro. Isso permite um uso mais eficiente de memória, pois elimina espaços não utilizados
quando elementos são removidos da fila.

Benefícios:
- Evita desperdício de espaço em aplicações onde o tamanho máximo da fila é conhecido.
- Fácil de implementar e eficiente para uso de memória.

Desvantagens:
- Limitação de capacidade (não cresce automaticamente).
- Pode ser menos eficiente do que filas baseadas em listas encadeadas para tamanhos dinâmicos.

## 5 - Deque
Deque (Double-Ended Queue) é uma estrutura de dados que permite inserções e remoções de elementos em ambas extremidades:
início e fim. Pode ser visto como uma generalização de uma fila ou pilha, mas a flexibilidade de operar em ambas as 
extremidades.

Vantagens:
- Flexibilidade: Combina as propriedades de pilhas e filas.
- Desempenho eficiente: Inserções e remoções nas extremidades são geralmente 𝑂(1).
- Problemas que requerem acesso a ambas as extremidades de forma eficiente.

Desvantagens:
- Uso de memória
- Não permite acesso direto a elementos intermediários (não é como um array).