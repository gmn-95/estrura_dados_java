package com.gustavo.pilha;

import com.br.gustavo.pilha.Pilha;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class TestePilha {

    @Test
    public void testePush(){
        Pilha<Integer> pilha = new Pilha<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30); //deve ser adicionado no topo

        assertEquals(30, pilha.getElemento(0));
        assertEquals(30, pilha.peek());
    }

    @Test
    public void testePeek(){
        Pilha<Integer> pilha = new Pilha<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.peek());
    }

    @Test
    public void testePop(){
        Pilha<Integer> pilha = new Pilha<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        Integer elementoRemovido = pilha.pop();
        Integer novoTopo = 20;

        assertEquals(30, elementoRemovido);
        assertEquals(novoTopo, pilha.peek());
        assertEquals(2, pilha.getTamanho());
    }

    @Test
    public void testeLancaExceptionSeTentarRemoverEmPilhaVazia(){
        Pilha<Integer> pilha = new Pilha<>();
        assertThrows(EmptyStackException.class, pilha::pop);
    }

    @Test
    public void testeLancaExceptionSeTentarConsultarPilhaVazia(){
        Pilha<Integer> pilha = new Pilha<>();
        assertThrows(EmptyStackException.class, pilha::peek);
    }


}
