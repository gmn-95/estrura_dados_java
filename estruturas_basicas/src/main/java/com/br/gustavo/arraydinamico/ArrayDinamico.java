package com.br.gustavo.arraydinamico;

import java.util.*;

@SuppressWarnings("unchecked")
public class ArrayDinamico<T> {

    private T[] elementos;
    private int tamanho;
    private int capacidadeAtual;

    public ArrayDinamico(){
        inicializarArray(0);
    }

    public ArrayDinamico(int capacidade){
        if(capacidade < 0){
            throw new IllegalArgumentException("A capacidade não pode ser negativa!");
        }

        inicializarArray(capacidade);
    }

    public boolean add(T o){
        if(isArrayCapacidadeZerada()){
            inicializarArray(1);
        } else if (isCapacidadeMaxima()) {
            aumentaCapacidadeAutomaticamente();
        }

        this.elementos[tamanho++] = o;
        return true;
    }

    public void add(int index, T elemento){
        if(index < 0 || index > this.tamanho - 1) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        for (int i = this.tamanho - 1; i >= index; i--){
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[index] = elemento;

        this.tamanho++;
    }

    public T remove(int index){
        if(index < 0 || index > this.tamanho - 1) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        T valorRemovido = this.getElemento(index);

        for (int i = index; i < this.tamanho; i++){
            this.elementos[i] = this.elementos[i + 1];
        }

        this.tamanho--;
        return valorRemovido;
    }

    public boolean remove(T elemento){

        for (int i = 0; i < this.tamanho; i++){
            if(elemento == this.elementos[i]){
                remove(i);
                return true;
            }
        }

        return false;
    }

    public int indexDe(T elemento){
        for (int i = 0; i < this.tamanho; i++){
            if(elemento == this.elementos[i]){
                return i;
            }
        }

        return -1;
    }

    /**
     * retorna a Última ocorrencia do valor
     * */
    public int ultimoIndexDe(T elemento){
        for (int i = this.tamanho - 1; i >= 0; i--){
            if(elemento == this.elementos[i]){
                return i;
            }
        }
        return -1;
    }

    public void limpar(){
//        this.elementos = (T[]) new Object[0];

        for (int i = 0; i < this.tamanho; i++){
            this.elementos[i] = null;
        }

        this.tamanho = 0;
    }

    protected void aumentaCapacidadeAutomaticamente(){
        capacidadeAtual *= 2; //dobrar a capacidade;
        T[] elementosCopia = (T[]) new Object[capacidadeAtual];

        for (int i = 0; i < this.tamanho; i++){
            elementosCopia[i] = this.elementos[i];
        }

        this.elementos = elementosCopia;
    }

    public T getElemento(int index){
        if(index < 0 || index > this.tamanho) throw new ArrayIndexOutOfBoundsException("Posição inválida!");

        return this.elementos[index];
    }

    public boolean contemElemento(Object o){
        if (isArrayCapacidadeZerada()) return false;

        return verificaSeExisteElemento(o);
    }

    private boolean verificaSeExisteElemento(Object objetoVerificador){
        for (int i = 0; i < this.tamanho; i++){
            if (this.elementos[i] == objetoVerificador) return true;
        }

        return false;
    }

    private void inicializarArray(int capacidade) {
        capacidadeAtual = capacidade;
        elementos = (T[]) new Object[capacidadeAtual];
    }

    private boolean isCapacidadeMaxima(){
        return this.tamanho == this.capacidadeAtual;
    }

    private boolean isArrayCapacidadeZerada(){
        return capacidadeAtual == 0;
    }

    public int getCapacidadeAtual(){
        return this.capacidadeAtual;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayDinamico)) return false;
        ArrayDinamico<?> that = (ArrayDinamico<?>) o;
        return getTamanho() == that.getTamanho() && getCapacidadeAtual() == that.getCapacidadeAtual() && Objects.deepEquals(elementos, that.elementos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(elementos), getTamanho(), getCapacidadeAtual());
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ArrayDinamico{elementos=[");

        for (int i = 0; i < this.tamanho - 1; i++){
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if(this.tamanho > 0){
            s.append(this.elementos[this.tamanho - 1]);
        }

        s.append("]");

        return s.toString();
    }
}