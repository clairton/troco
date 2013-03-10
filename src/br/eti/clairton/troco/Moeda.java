package br.eti.clairton.troco;

import java.math.BigDecimal;


/**
 * Enum da possiveis notas de troco.
 *
 * @author Clairton Rodrigo Heinzen <clairton.rodrigo@gmail.com>
 */
public enum Moeda{
    CEM_REAIS(Double.valueOf(100)),
    CINQUENTA_REAIS(Double.valueOf(50)),
    VINTE_REAIS(Double.valueOf(20)),
    DEZ_REAIS(Double.valueOf(10)),
    CINCO_REAIS(Double.valueOf(5)),
    DOIS_REAIS(Double.valueOf(2)),
    UM_REAL(Double.valueOf(1)),
    CINQUENTA_CENTAVOS(Double.valueOf(0.5)),
    VINTE_E_CINCO_CENTAVOS(Double.valueOf(0.25)),
    DEZ_CENTAVOS(Double.valueOf(0.10)),
    CINCO_CENTAVOS(Double.valueOf(0.05)),
    UM_CENTAVO(Double.valueOf(0.01));
    
    private final Double valor;
    private Integer quantidade = 0;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    private Moeda(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }
    
    public void addMoeda(){
        this.quantidade++;
    }
}
