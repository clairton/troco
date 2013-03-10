package br.eti.clairton.troco;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Clairton Rodrigo Heinzen <clairton.rodrigo@gmail.com>
 */
public class Troco {

    /**
     * Construtor escondio para classe utilitaria.
     */
    private Troco() {
    }

    public static Set<Moeda> calcular(Double valorEntrada) {
        Set<Moeda> retorno = new LinkedHashSet<>();
        Double valorRestante = valorEntrada;
        for (Moeda moeda : Moeda.values()) {
            System.out.println("Valor Restante: "+(valorRestante - moeda.getValor()));
            while ((valorRestante - moeda.getValor()) >= 0) {
                moeda.addMoeda();
                retorno.add(moeda);
                valorRestante -= moeda.getValor();
                System.out.println("Valor Restante: "+(valorRestante - moeda.getValor()));
            }
            if(valorRestante == 0){
                break;
            }
        }
        return retorno;
    }
}
