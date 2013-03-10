package br.eti.clairton.troco;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testa a classe de troco.
 *
 * @author Clairton Rodrigo Heinzen <clairton.rodrigo@gmail.com>
 */
public class TrocoTest {

    @Test
    public void test100Reais() {
        Set<Moeda> resultado = Troco.calcular(Double.valueOf(100.00));
        Iterator<Moeda> iterator = resultado.iterator();
        Moeda e = iterator.next();
        assertEquals(Moeda.CEM_REAIS, e);
        assertEquals(Integer.valueOf(1), e.getQuantidade());
        assertEquals(1, resultado.size());
    }
    
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
    
    @Test
    public void test25ReaisE12Centavo() {
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
     * A ordenação do valores do enum é de vital importancia para o funcionamento.
     * Esse metodo testa a troca acidental da ordem da Moedas disponiveis
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