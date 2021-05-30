
package br.com.fwtj.smartnfe.util.inter.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class BoletosResponseContent {

    private String nossoNumero;
    private String seuNumero;
    private String cnpjCpfSacado;
    private String nomeSacado;
    private String situacao;
    private String dataVencimento;
    private Float valorNominal;
    private String telefone;
    private String email;
    private String dataEmissao;
    private String dataLimite;
    private String linhaDigitavel;
    private Float valorJuros;
    private Float valorMulta;
    private Desconto1 desconto1;
    private Desconto2 desconto2;
    private Desconto3 desconto3;
    private Multa multa;
    private Mora mora;
    private Float valorAbatimento;

    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public String getSeuNumero() {
        return seuNumero;
    }

    public void setSeuNumero(String seuNumero) {
        this.seuNumero = seuNumero;
    }

    public String getCnpjCpfSacado() {
        return cnpjCpfSacado;
    }

    public void setCnpjCpfSacado(String cnpjCpfSacado) {
        this.cnpjCpfSacado = cnpjCpfSacado;
    }

    public String getNomeSacado() {
        return nomeSacado;
    }

    public void setNomeSacado(String nomeSacado) {
        this.nomeSacado = nomeSacado;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Float getValorNominal() {
        return valorNominal;
    }

    public void setValorNominal(Float valorNominal) {
        this.valorNominal = valorNominal;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getLinhaDigitavel() {
        return linhaDigitavel;
    }

    public void setLinhaDigitavel(String linhaDigitavel) {
        this.linhaDigitavel = linhaDigitavel;
    }

    public Float getValorJuros() {
        return valorJuros;
    }

    public void setValorJuros(Float valorJuros) {
        this.valorJuros = valorJuros;
    }

    public Float getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(Float valorMulta) {
        this.valorMulta = valorMulta;
    }

    public Desconto1 getDesconto1() {
        return desconto1;
    }

    public void setDesconto1(Desconto1 desconto1) {
        this.desconto1 = desconto1;
    }

    public Desconto2 getDesconto2() {
        return desconto2;
    }

    public void setDesconto2(Desconto2 desconto2) {
        this.desconto2 = desconto2;
    }

    public Desconto3 getDesconto3() {
        return desconto3;
    }

    public void setDesconto3(Desconto3 desconto3) {
        this.desconto3 = desconto3;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public Mora getMora() {
        return mora;
    }

    public void setMora(Mora mora) {
        this.mora = mora;
    }

    public Float getValorAbatimento() {
        return valorAbatimento;
    }

    public void setValorAbatimento(Float valorAbatimento) {
        this.valorAbatimento = valorAbatimento;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("nossoNumero", nossoNumero).append("seuNumero", seuNumero).append("cnpjCpfSacado", cnpjCpfSacado).append("nomeSacado", nomeSacado).append("situacao", situacao).append("dataVencimento", dataVencimento).append("valorNominal", valorNominal).append("telefone", telefone).append("email", email).append("dataEmissao", dataEmissao).append("dataLimite", dataLimite).append("linhaDigitavel", linhaDigitavel).append("valorJuros", valorJuros).append("valorMulta", valorMulta).append("desconto1", desconto1).append("desconto2", desconto2).append("desconto3", desconto3).append("multa", multa).append("mora", mora).append("valorAbatimento", valorAbatimento).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(valorNominal).append(situacao).append(telefone).append(mora).append(nomeSacado).append(multa).append(valorAbatimento).append(valorJuros).append(cnpjCpfSacado).append(dataEmissao).append(seuNumero).append(desconto3).append(dataVencimento).append(linhaDigitavel).append(desconto1).append(nossoNumero).append(desconto2).append(dataLimite).append(valorMulta).append(email).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BoletosResponseContent) == false) {
            return false;
        }
        BoletosResponseContent rhs = ((BoletosResponseContent) other);
        return new EqualsBuilder().append(valorNominal, rhs.valorNominal).append(situacao, rhs.situacao).append(telefone, rhs.telefone).append(mora, rhs.mora).append(nomeSacado, rhs.nomeSacado).append(multa, rhs.multa).append(valorAbatimento, rhs.valorAbatimento).append(valorJuros, rhs.valorJuros).append(cnpjCpfSacado, rhs.cnpjCpfSacado).append(dataEmissao, rhs.dataEmissao).append(seuNumero, rhs.seuNumero).append(desconto3, rhs.desconto3).append(dataVencimento, rhs.dataVencimento).append(linhaDigitavel, rhs.linhaDigitavel).append(desconto1, rhs.desconto1).append(nossoNumero, rhs.nossoNumero).append(desconto2, rhs.desconto2).append(dataLimite, rhs.dataLimite).append(valorMulta, rhs.valorMulta).append(email, rhs.email).isEquals();
    }

}
