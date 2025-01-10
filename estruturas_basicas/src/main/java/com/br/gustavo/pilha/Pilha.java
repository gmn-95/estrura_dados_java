package com.br.gustavo.pilha;

import com.br.gustavo.arraydinamico.ArrayDinamico;

import java.util.EmptyStackException;

public class Pilha<T> extends ArrayDinamico<T>{

    public Pilha(){
        super();
    }

    /**
     * Sempre insere no topo (primeira posição)
     * */
    public T push(T elemento){
        add(0, elemento);
        return elemento;
    }

    /**
     * Remove o elemento do topo da pilha
     * */
    public T pop(){
        lancaErroSePilhaVazia();
        return remove(0);
    }

    /**
     * Retorna o elemento do topo da pilha sem removê-lo
     * */
    public T peek(){
        lancaErroSePilhaVazia();
        return getElemento(0);
    }

    protected void lancaErroSePilhaVazia(){
        if(super.tamanho == 0) throw new EmptyStackException();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Pilha{elementos=[");

        for (int i = 0; i < super.tamanho - 1; i++){
            s.append(super.elementos[i]);
            s.append(", ");
        }

        if(super.tamanho > 0){
            s.append(super.elementos[super.tamanho - 1]);
        }

        s.append("]");

        return s.toString();
    }
}
