package com.br.gustavo.fila;

import com.br.gustavo.arraydinamico.ArrayDinamico;

import java.util.NoSuchElementException;

public class Fila<T> extends ArrayDinamico<T> {

    private No<T> primeiro;
    private No<T> ultimo;

    public Fila(){
        super();
    }

    public Fila(int capacidadeInicial){
        super(capacidadeInicial);
    }

    public boolean enqueue(T elemento){
        if(this.primeiro == null && this.ultimo == null){
            return adicionaNoInicio(elemento);
        } else {
            return adicionaNoFim(elemento);
        }
    }

    public T dequeue(){
        if(primeiro == null){
            throw new NoSuchElementException("Não há elementos na lista para remover!");
        }

        primeiro = primeiro.proximoNo;
        primeiro.noAnterior = null;

        return remove(0);
    }

    protected boolean adicionaNoInicio(T elemento){
        // cria um novo nó: informando o nó anterior, o valor, e qual o próximo nó
        // como nesse caso é o primeiro nó de todos, não tem anterior, nem próximo nó, ambos são os mesmos
        final No<T> p = primeiro;
        final No<T> novoNo = new No<>(null, elemento, p);
        this.primeiro = novoNo;
        this.ultimo = novoNo;

        return add(elemento);
    }

    protected boolean adicionaNoFim(T elemento){
        // caso já existe ao menos um nó, vamos criar um novo nó, onde o atual ultimo nó se tornará o nó anterior, e o
        // novo nó criado passa a apontar para o nó anterior. Esse nó crido, será sempre o último
        final No<T> referenciaDoUltimoNo = ultimo;
        final No<T> novoNo = new No<>(referenciaDoUltimoNo, elemento, null);
        this.ultimo = novoNo;

        //atualiza por referência quem é o próximo nó, para o novo nó que foi criado na linha anterior
        if(referenciaDoUltimoNo != null)
            referenciaDoUltimoNo.proximoNo = novoNo;

        return add(elemento);
    }

    public T getPrimeiroElemento(){
        return this.primeiro.elemento;
    }

    public T getUltimoElemento(){
        return this.ultimo.elemento;
    }

    private static class No<T>{
        T elemento;
        No<T> noAnterior;
        No<T> proximoNo;

        public No(No<T> noAnterior, T elemento, No<T> proximoNo) {
            this.elemento = elemento;
            this.noAnterior = noAnterior;
            this.proximoNo = proximoNo;
        }
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Fila{elementos=[");

        for (int i = 0; i < super.tamanho - 1; i++){
            s.append(super.elementos[i]);
            s.append(", ");
        }

        if(super.tamanho > 0){
            s.append(super.elementos[super.tamanho - 1]);
        }

        s.append("]}");

        return s.toString();
    }


}
