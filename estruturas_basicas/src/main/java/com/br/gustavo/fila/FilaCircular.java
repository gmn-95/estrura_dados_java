package com.br.gustavo.fila;

public class FilaCircular<T> extends Fila<T>{

    public FilaCircular(){
        super();
    }

    public FilaCircular(int capacidadeInicial){
        super(capacidadeInicial);
    }

    @Override
    protected boolean adicionaNoInicio(T elemento) {
        final No<T> p = this.primeiro;
        final No<T> novoNo = new No<>(this.ultimo, elemento, p); //o primeiro novo nó vai apontar para o último nó
        this.primeiro = novoNo;
        this.ultimo = novoNo;

        return add(elemento);
    }

    @Override
    protected boolean adicionaNoFim(T elemento) {
        final No<T> referenciaDoUltimoNo = this.ultimo;
        final No<T> novoNo = new No<>(referenciaDoUltimoNo, elemento, this.primeiro); //O último nó criado também aponta para o primeiro
        this.ultimo = novoNo;

        //atualiza por referência quem é o próximo nó, para o novo nó que foi criado na linha anterior
        if(referenciaDoUltimoNo != null) {
            referenciaDoUltimoNo.proximoNo = novoNo;
        }

        this.primeiro.noAnterior = this.ultimo; //o primeiro nó vai apontar para o último nó
        return add(elemento);
    }
}
