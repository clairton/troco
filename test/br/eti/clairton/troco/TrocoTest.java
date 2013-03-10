package br.eti.clairton.troco;

import java.util.Iterator;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testa a classe de troco.
 *
 * @author Clairton Rodrigo Heinzen <clairton.rodrigo@gmail.com>
 */
public class TrocoTest {

    /**
     * Testa o troco de 100 R$.
     */
    @Test
    public void test100Reais() {
        Set<Moeda> resultado = Troco.calcular(Double.valueOf(100.00));
        Iterator<Moeda> iterator = resultado.iterator();
        Moeda e = iterator.next();
        assertEquals(Moeda.CEM_REAIS, e);
        assertEquals(Integer.valueOf(1), e.getQuantidade());
        assertEquals(1, resultado.size());
    }

    /**
     * Testa o troco para 100.01.
     */
    @Test
    public void test100ReaisE1Centavo() {
        Set<Moeda> resultado = Troco.calcular(Double.valueOf(100.01));
        Iterator<Moeda> iterator = resultado.iterator();
        Moeda e = iterator.next();
        assertEquals(Moeda.CEM_REAIS, e);
        assertEquals(Integer.valueOf(1), e.getQuantidade());
        e = iterator.next();
        assertEquals(Moeda.UM_CENTAVO, e);
        assertEquals(Integer.valueOf(1), e.getQuantidade());
        assertEquals(2, resultado.size());
    }

    /**
     * Testa o valor de troco para 25.12R$.
     */
    @Test
    public void test25ReaisE12Centavos() {
        Set<Moeda> resultado = Troco.calcular(Double.valueOf(25.12));
        Iterator<Moeda> iterator = resultado.iterator();
        Moeda e = iterator.next();
        assertEquals(Moeda.VINTE_REAIS, e);
        assertEquals(Integer.valueOf(1), e.getQuantidade());
        e = iterator.next();
        assertEquals(Moeda.CINCO_REAIS, e);
        assertEquals(Integer.valueOf(1), e.getQuantidade());
        e = iterator.next();
        assertEquals(Moeda.DEZ_CENTAVOS, e);
        assertEquals(Integer.valueOf(1), e.getQuantidade());
        e = iterator.next();
        assertEquals(Moeda.UM_CENTAVO, e);
        assertEquals(Integer.valueOf(2), e.getQuantidade());
        assertEquals(4, resultado.size());
    }

    /**
     * Testa o troco para 49.75R$.
     */
    @Test
    public void test49ReaisE75Centavos() {
        Set<Moeda> resultado = Troco.calcular(Double.valueOf(49.75));
        Iterator<Moeda> iterator = resultado.iterator();
        Moeda e = iterator.next();
        assertEquals("Duas notas de vinte", Moeda.VINTE_REAIS, e);
        assertEquals("Duas notas de vinte", Integer.valueOf(2), e.getQuantidade());
        e = iterator.next();
        assertEquals("Uma notas de 5", Moeda.CINCO_REAIS, e);
        assertEquals("Uma notas de 5", Integer.valueOf(1), e.getQuantidade());
        e = iterator.next();
        assertEquals("Duas notas de 2", Moeda.DOIS_REAIS, e);
        assertEquals("Duas notas de 2", Integer.valueOf(2), e.getQuantidade());
        e = iterator.next();
        assertEquals("Uma moeda de 50", Moeda.CINQUENTA_CENTAVOS, e);
        assertEquals("Uma moeda de 50", Integer.valueOf(1), e.getQuantidade());
        e = iterator.next();
        assertEquals("Uma moeda de 25", Moeda.VINTE_E_CINCO_CENTAVOS, e);
        assertEquals("Uma moeda de 25", Integer.valueOf(1), e.getQuantidade());
        assertEquals(5, resultado.size());
    }

    /**
     * A ordenação do valores do enum é de vital importancia para o
     * funcionamento. Esse metodo testa a troca acidental da ordem da Moedas
     * disponiveis
     */
    @Test
    public void testValoresPosicoes() {
        assertEquals(Moeda.CEM_REAIS, Moeda.values()[0]);
        assertEquals(Moeda.CINQUENTA_REAIS, Moeda.values()[1]);
        assertEquals(Moeda.VINTE_REAIS, Moeda.values()[2]);
        assertEquals(Moeda.DEZ_REAIS, Moeda.values()[3]);
        assertEquals(Moeda.CINCO_REAIS, Moeda.values()[4]);
        assertEquals(Moeda.DOIS_REAIS, Moeda.values()[5]);
        assertEquals(Moeda.UM_REAL, Moeda.values()[6]);
        assertEquals(Moeda.CINQUENTA_CENTAVOS, Moeda.values()[7]);
        assertEquals(Moeda.VINTE_E_CINCO_CENTAVOS, Moeda.values()[8]);
        assertEquals(Moeda.DEZ_CENTAVOS, Moeda.values()[9]);
        assertEquals(Moeda.CINCO_CENTAVOS, Moeda.values()[10]);
        assertEquals(Moeda.UM_CENTAVO, Moeda.values()[11]);
    }
}