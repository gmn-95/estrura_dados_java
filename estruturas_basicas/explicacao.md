# Estruturas Básicas

## 1 - Array Dinâmico
Um array dinâmico (ou um vetor dinâmico) é uma estrutura de dados que permite a manipulação de arrays de forma dinâmica, 
ou seja, de forma mais livre e fácil. Por exemplo, é possível adicionar ou remover valores com facilidade e em qualquer posição, 
sem a necessidade de gerenciar manualmente o tamanho do array. Ele automaticamente ajusta seu tamanho conforme necessário, 
aumentando ou diminuindo conforme os elementos são adicionados ou removidos.

Além disso, os arrays dinâmicos oferecem algumas vantagens adicionais:

Crescimento Amortizado: Embora a inserção de um novo elemento possa, ocasionalmente, requerer a cópia de todos os elementos
para um novo array maior, a média de tempo por operação de inserção é constante.

Memória Contígua: Como os arrays dinâmicos armazenam dados em blocos contíguos de memória, o acesso aos elementos é muito 
rápido (tempo constante).

Flexibilidade: É possível redimensionar o array conforme necessário, permitindo a alocação de memória eficiente e a capacidade 
de lidar com conjuntos de dados de tamanhos variados.

## 2 - Pilha
Pilha é uma estrutura básica baseada no princípio LIFO (Last in, First Out (Último a entrar, primeiro a sair)). Ou seja, 
o último elemento inserido, é o primeiro a sair. Um exemplo do seu uso é na chamada de funções/métodos que diversas linguagens
e aplicações fazem. Essas pilhas podem ter tamanhos fixos ou dinâmicos. 

Pode ser utilizada quando queremos: Armazenar dados de forma temporária e acessá-los em ordem reversa, como funções recursivas,
verificações de expressões, dentre outra.

Um exemplo mais abstrato e bem comum quando falamos de pilhas, é a pilha de pratos quando vamos lavar louça. O último prato
inserido na pilha, é sempre o primeiro a sair. 