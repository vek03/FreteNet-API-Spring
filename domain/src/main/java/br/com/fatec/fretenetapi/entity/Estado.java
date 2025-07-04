package br.com.fatec.fretenetapi.entity;

import br.com.fatec.fretenetapi.exception.NotFoundException;

import java.math.BigDecimal;

public enum Estado {
    AC(12, "AC", "Acre", BigDecimal.ZERO, false),
    AL(27, "AL", "Alagoas", BigDecimal.ZERO, false),
    AP(16, "AP", "Amapá", BigDecimal.ZERO, false),
    AM(13, "AM", "Amazonas", BigDecimal.ZERO, false),
    BA(29, "BA", "Bahia", BigDecimal.ZERO, false),
    CE(23, "CE", "Ceará", BigDecimal.ZERO, false),
    DF(53, "DF", "Distrito Federal", BigDecimal.ZERO, false),
    ES(32, "ES", "Espírito Santo", new BigDecimal("50.00"), true),
    GO(52, "GO", "Goiás", BigDecimal.ZERO, false),
    MA(21, "MA", "Maranhão", BigDecimal.ZERO, false),
    MT(51, "MT", "Mato Grosso", new BigDecimal("50.00"), true),
    MS(50, "MS", "Mato Grosso do Sul", new BigDecimal("50.00"), true),
    MG(31, "MG", "Minas Gerais", new BigDecimal("50.00"), true),
    PA(15, "PA", "Pará", BigDecimal.ZERO, false),
    PB(25, "PB", "Paraíba", BigDecimal.ZERO, false),
    PR(41, "PR", "Paraná", BigDecimal.ZERO, true),
    PE(26, "PE", "Pernambuco", BigDecimal.ZERO, false),
    PI(22, "PI", "Piauí", BigDecimal.ZERO, false),
    RJ(33, "RJ", "Rio de Janeiro", new BigDecimal("20.00"), true),
    RN(24, "RN", "Rio Grande do Norte", BigDecimal.ZERO, false),
    RS(43, "RS", "Rio Grande do Sul", new BigDecimal("20.00"), true),
    RO(11, "RO", "Rondônia", BigDecimal.ZERO, false),
    RR(14, "RR", "Roraima", BigDecimal.ZERO, false),
    SC(42, "SC", "Santa Catarina", new BigDecimal("20.00"), true),
    SP(35, "SP", "São Paulo", BigDecimal.ZERO, true),
    SE(28, "SE", "Sergipe", BigDecimal.ZERO, false),
    TO(17, "TO", "Tocantins", BigDecimal.ZERO, false);

    private final int codigo;
    private final String uf;
    private final String nome;
    private final BigDecimal valorFrete;
    private final Boolean temFrete;

    Estado(int codigo, String uf, String nome, BigDecimal valorFrete, Boolean temFrete) {
        this.codigo = codigo;
        this.uf = uf;
        this.nome = nome;
        this.valorFrete = valorFrete;
        this.temFrete = temFrete;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getUf() {
        return uf;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public Boolean getTemFrete(){
        return temFrete;
    }

    public static Estado porUf(String uf) {
        for (Estado estado : values()) {
            if (estado.uf.equalsIgnoreCase(uf)) {
                return estado;
            }
        }
        throw new NotFoundException("Estado não existe");
    }
}
