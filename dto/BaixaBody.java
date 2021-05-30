package br.com.fwtj.smartnfe.util.inter.dto;

public class BaixaBody {

    public BaixaBody() {
        this.codigoBaixa = "DEVOLUCAO";
    }

    public BaixaBody(String codigoBaixa) {
        this.codigoBaixa = codigoBaixa;
    }

    private String codigoBaixa;

    public String getCodigoBaixa() {
        return codigoBaixa;
    }

    public void setCodigoBaixa(String codigoBaixa) {
        this.codigoBaixa = codigoBaixa;
    }

    @Override
    public String toString() {
        return "BaixaBody{" +
                "codigoBaixa='" + codigoBaixa + '\'' +
                '}';
    }
}
