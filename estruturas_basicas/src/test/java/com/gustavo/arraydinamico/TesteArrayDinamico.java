package com.gustavo.arraydinamico;

import com.br.gustavo.arraydinamico.ArrayDinamico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TesteArrayDinamico {

    @Test
    public void testeIniciaArrayVazio(){
        ArrayDinamico<Integer> arrayDinamico = new ArrayDinamico<>();
        assertEquals(0, arrayDinamico.getCapacidadeAtual());
    }

    @Test
    public void testeIniciaArrayComCapacidadeInformada(){
        ArrayDinamico<Integer> arrayDinamico = new ArrayDinamico<>(10);
        assertEquals(10, arrayDinamico.getCapacidadeAtual());
    }

    @Test
    public void testeLancaErroCasoCapacidadeSejaNegatica(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new ArrayDinamico<>(-10);
        });

        assertEquals("A capacidade não pode ser negativa!", exception.getMessage());
    }

    @Test
    public void testeAddElementoQuandoTemCapacidade(){
        ArrayDinamico<Integer> arrayDinamico = new ArrayDinamico<>(2);
        assertTrue(arrayDinamico.add(10));

        assertEquals(1, arrayDinamico.getTamanho());

        //neste caso a capacidade deve se manter a inicial
        assertEquals(2, arrayDinamico.getCapacidadeAtual());
    }

    @Test
    public void testeAddElementoQuandoTemCapacidadeZerada(){
        ArrayDinamico<Integer> arrayDinamico = new ArrayDinamico<>();
        assertTrue(arrayDinamico.add(10));

        assertEquals(1, arrayDinamico.getTamanho());

        //neste caso, aumenta a capacidade
        assertEquals(1, arrayDinamico.getCapacidadeAtual());
    }

    @Test
    public void testeAddMaisDeUmElemmentoEComCapacidadeSuficiente(){
        ArrayDinamico<Integer> arrayDinamico = new ArrayDinamico<>(3);
        assertTrue(arrayDinamico.add(10));
        assertTrue(arrayDinamico.add(11));

        assertEquals(2, arrayDinamico.getTamanho());

        //neste caso, mantem a capacidade
        assertEquals(3, arrayDinamico.getCapacidadeAtual());
    }

    @Test
    public void testeAddMaisDeUmElemmentoEComCapacidadeNoMaximo(){
        ArrayDinamico<Integer> arrayDinamico = new ArrayDinamico<>(3);
        assertTrue(arrayDinamico.add(10));
        assertTrue(arrayDinamico.add(11));
        assertTrue(arrayDinamico.add(12));
        assertTrue(arrayDinamico.add(13));

        assertEquals(4, arrayDinamico.getTamanho());

        //neste caso, dobra a capacidade
        assertEquals(4, arrayDinamico.getCapacidadeAtual());
    }

    @Test
    public void testeGetElemento(){
        ArrayDinamico<Integer> arrayDinamico = new ArrayDinamico<>(3);
        assertTrue(arrayDinamico.add(10));
        assertTrue(arrayDinamico.add(11));
        assertTrue(arrayDinamico.add(12));

        assertEquals(10, arrayDinamico.getElemento(0));
        assertEquals(11, arrayDinamico.getElemento(1));
        assertEquals(12, arrayDinamico.getElemento(2));
    }

    @Test
    public void testeGetElementoLancaExceptionPosicaoInvalida(){
        ArrayDinamico<Integer> arrayDinamico = new ArrayDinamico<>(2);
        assertTrue(arrayDinamico.add(10));
        assertTrue(arrayDinamico.add(11));

        ArrayIndexOutOfBoundsException exception1 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            arrayDinamico.getElemento(-1);
        });

        ArrayIndexOutOfBoundsException exception2 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            arrayDinamico.getElemento(10);
        });

        assertEquals("Posição inválida!", exception1.getMessage());
        assertEquals("Posição inválida!", exception2.getMessage());
    }

    @Test
    public void testeVerificaSeExisteElemento(){
        ArrayDinamico<Integer> arrayDinamico = new ArrayDinamico<>(3);
        assertTrue(arrayDinamico.add(10));
        assertTrue(arrayDinamico.add(11));
        assertTrue(arrayDinamico.add(12));
        assertTrue(arrayDinamico.add(null));

        assertTrue(arrayDinamico.contemElemento(10));
        assertTrue(arrayDinamico.contemElemento(11));
        assertTrue(arrayDinamico.contemElemento(12));
        assertTrue(arrayDinamico.contemElemento(null));

        assertFalse(arrayDinamico.contemElemento(10000));
        assertFalse(arrayDinamico.contemElemento(-1));

        ArrayDinamico<Integer> arrayDinamicoZerado = new ArrayDinamico<>();
        assertFalse(arrayDinamicoZerado.contemElemento(10));
    }

    @Test
    public void testeAddEmQualquerPosicao(){
        ArrayDinamico<Integer> arrayDinamico = new ArrayDinamico<>();
        arrayDinamico.add(10);
        arrayDinamico.add(11);
        arrayDinamico.add(12);
        arrayDinamico.add(13);
        arrayDinamico.add(14);

        arrayDinamico.add(4, 100);

        assertEquals(6, arrayDinamico.getTamanho());
        assertEquals(100, arrayDinamico.getElemento(4));

        arrayDinamico.add(0, 200); //adiciona na segunda posição

        assertEquals(7, arrayDinamico.getTamanho());
        assertEquals(200, arrayDinamico.getElemento(0));
    }

    @Test
    public void testeAddEmQualquerPosicaoLancaExceptionQuandoPosicaoInvalida(){
        ArrayDinamico<Integer> arrayDinamico = new ArrayDinamico<>();
        arrayDinamico.add(10);
        arrayDinamico.add(11);
        arrayDinamico.add(12);
        arrayDinamico.add(13);
        arrayDinamico.add(14);

        IndexOutOfBoundsException exception1 = assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayDinamico.add(-1, 100);
        });

        IndexOutOfBoundsException exception2 = assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayDinamico.add(1000, 100);
        });

        assertEquals("Posição inválida", exception1.getMessage());
        assertEquals("Posição inválida", exception2.getMessage());
    }

    @Test
    public void testeRemoveElementoPorIndex(){
        ArrayDinamico<Integer> arrayDinamico = new ArrayDinamico<>();
        arrayDinamico.add(10);
        arrayDinamico.add(11);
        arrayDinamico.add(12);
        arrayDinamico.add(13);
        arrayDinamico.add(14);

        assertEquals(11, arrayDinamico.remove(1));
        assertEquals(4, arrayDinamico.getTamanho());
        System.out.println(arrayDinamico);
    }

    @Test
    public void testeRemoveElementoPorIndexLancaExceptionQuandoPosicaoInvalida(){
        ArrayDinamico<Integer> arrayDinamico = new ArrayDinamico<>();
        arrayDinamico.add(10);
        arrayDinamico.add(11);
        arrayDinamico.add(12);
        arrayDinamico.add(13);
        arrayDinamico.add(14);

        IndexOutOfBoundsException exception1 = assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayDinamico.remove(-1);
        });

        IndexOutOfBoundsException exception2 = assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayDinamico.remove(1000);
        });

        assertEquals("Posição inválida", exception1.getMessage());
        assertEquals("Posição inválida", exception2.getMessage());
    }

    @Test
    public void testeRemoveElementoPorObjeto(){
        ArrayDinamico<String> arrayDinamico = new ArrayDinamico<>();
        arrayDinamico.add("A");
        arrayDinamico.add("B");
        arrayDinamico.add("C");
        arrayDinamico.add("D");
        arrayDinamico.add("E");

        assertTrue(arrayDinamico.remove("B"));
        assertEquals(4, arrayDinamico.getTamanho());

        assertFalse(arrayDinamico.remove("ASD"));
        assertEquals(4, arrayDinamico.getTamanho());
    }

    @Test
    public void testaLimpar(){
        ArrayDinamico<String> arrayDinamico = new ArrayDinamico<>();
        arrayDinamico.add("A");
        arrayDinamico.add("B");
        arrayDinamico.add("C");
        arrayDinamico.add("D");
        arrayDinamico.add("E");

        arrayDinamico.limpar();
        assertEquals(0, arrayDinamico.getTamanho());
        System.out.println(arrayDinamico);
    }

    @Test
    public void testeIndexDe(){
        ArrayDinamico<String> arrayDinamico = new ArrayDinamico<>();
        arrayDinamico.add("A");
        arrayDinamico.add("B");
        arrayDinamico.add("C");
        arrayDinamico.add("D");
        arrayDinamico.add("E");

        assertEquals(2, arrayDinamico.indexDe("C"));
        assertEquals(-1, arrayDinamico.indexDe("GG"));
    }

    @Test
    public void testeUltimoIndexDe(){
        ArrayDinamico<String> arrayDinamico = new ArrayDinamico<>();
        arrayDinamico.add("A");
        arrayDinamico.add("B");
        arrayDinamico.add("C");
        arrayDinamico.add("D");
        arrayDinamico.add("B");
        arrayDinamico.add("E");


        assertEquals(4, arrayDinamico.ultimoIndexDe("B"));
        assertEquals(-1, arrayDinamico.indexDe("GG"));
    }



}
