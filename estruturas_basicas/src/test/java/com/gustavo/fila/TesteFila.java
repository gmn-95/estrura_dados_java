package com.gustavo.fila;

import com.br.gustavo.fila.Fila;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TesteFila {

    @Test
    public void testaEnqueue(){
        Fila<Integer> fila = new Fila<>();
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);

        assertEquals(3, fila.getTamanho());
        assertEquals(3, fila.getUltimoElemento());
        assertEquals(1, fila.getPrimeiroElemento());
    }

    @Test
    public void testeDequeue(){
        Fila<Integer> fila = new Fila<>();
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(5);
        fila.enqueue(6);
        fila.enqueue(7);
        fila.enqueue(8);

        Integer valorRemovido1 = fila.dequeue();
        Integer valorRemovido2 = fila.dequeue();
        Integer valorRemovido3 = fila.dequeue();
        Integer valorRemovido4 = fila.dequeue();

        Fila<Integer> filaFinalEsperada = new Fila<>();
        filaFinalEsperada.enqueue(5);
        filaFinalEsperada.enqueue(6);
        filaFinalEsperada.enqueue(7);
        filaFinalEsperada.enqueue(8);

        assertEquals(4, fila.getTamanho());
        assertEquals(5, fila.getPrimeiroElemento());
        assertEquals(8, fila.getUltimoElemento());
        assertEquals(1, valorRemovido1);
        assertEquals(2, valorRemovido2);
        assertEquals(3, valorRemovido3);
        assertEquals(4, valorRemovido4);
        assertEquals(filaFinalEsperada, fila);
    }

    @Test
    public void testeDequeueLancaErroCasoListaVazia(){
        Fila<Integer> fila = new Fila<>();
        assertThrows(NoSuchElementException.class, fila::dequeue, "Não há elementos na lista para remover!");
    }
}
