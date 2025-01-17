package com.gustavo.fila;

import com.br.gustavo.fila.Deque;
import com.br.gustavo.fila.Fila;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TesteDeque {

    @Test
    public void testaAddFirst(){
        Deque<Integer> fila = new Deque<>();
        fila.addFirst(5);
        fila.addFirst(2);
        fila.addFirst(3);
        fila.addFirst(4);

        System.out.println(fila);

        assertEquals(4, fila.getTamanho());
        assertEquals(4, fila.getPrimeiroElemento());
        assertEquals(5, fila.getUltimoElemento());
    }

    @Test
    public void testeAddLast(){
        Deque<Integer> fila = new Deque<>();
        fila.addLast(8);
        fila.addLast(1);
        fila.addLast(2);
        fila.addLast(3);
        fila.addLast(4);
        fila.addLast(5);
        fila.addLast(6);
        fila.addLast(7);

        assertEquals(8, fila.getTamanho());
        assertEquals(8, fila.getPrimeiroElemento());
        assertEquals(7, fila.getUltimoElemento());
    }

    @Test
    public void testeRemoveLast(){
        Deque<Integer> fila = new Deque<>();
        fila.addLast(8);
        fila.addLast(1);
        fila.addLast(2);
        fila.addLast(3);
        fila.addLast(4);
        fila.addLast(5);

        Integer r1 = fila.removeLast();
        Integer r2 = fila.removeLast();

        assertEquals(4, fila.getTamanho());
        assertEquals(8, fila.getPrimeiroElemento());
        assertEquals(3, fila.getUltimoElemento());
        assertEquals(r1, 5);
        assertEquals(r2, 4);
    }



    @Test
    public void testeDequeueLancaErroCasoListaVazia(){
        Fila<Integer> fila = new Fila<>();
        assertThrows(NoSuchElementException.class, fila::dequeue, "Não há elementos na lista para remover!");
    }
}
