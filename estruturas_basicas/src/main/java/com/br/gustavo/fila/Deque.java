package com.br.gustavo.fila;

import java.util.NoSuchElementException;

public class Deque<T> extends Fila<T> {

    public Deque(){}

    public Deque(int capacidadeInicial){
        super(capacidadeInicial);
    }

    public void addFirst(T elemento){
        adicionaNaPrimeiraPosicaoSeNecessario(elemento);

        final No<T> p = this.primeiro;
        final No<T> novoNo = new No<>(null, elemento, p);
        this.primeiro = novoNo;
        p.noAnterior = this.primeiro;

        add(0, elemento);
    }

    public void addLast(T elemento){
        if (adicionaNaPrimeiraPosicaoSeNecessario(elemento)) return;
        adicionaNoFim(elemento);
    }

    public T removeFirst(){
        return dequeue();
    }

    public T removeLast(){
        if(this.ultimo == null){
            throw new NoSuchElementException("Não há elementos na lista para remover!");
        }

        this.ultimo = this.ultimo.noAnterior;
        this.ultimo.proximoNo = null;
        return remove(getTamanho() -1);
    }
}
