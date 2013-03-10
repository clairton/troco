package br.eti.clairton.troco;

import java.util.LinkedHashSet;
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
        //como as variaveis de quantidade sao estatica, devem ser zeradas
        for (Moeda moeda : Moeda.values()) {
            moeda.setQuantidade(0);
        }
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
