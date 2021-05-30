
package br.com.fwtj.smartnfe.util.inter.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BoletoResponse {

    private String nomeBeneficiario;
    private String cnpjCpfBeneficiario;
    private String tipoPessoaBeneficiario;
    private LocalDateTime dataHoraSituacao;
    private String codigoBarras;
    private String linhaDigitavel;
    private LocalDate dataVencimento;
    private LocalDate dataEmissao;
    private String seuNumero;
    private BigDecimal valorNominal;
    private String nomePagador;
    private String emailPagador;
    private String dddPagador;
    private String telefonePagador;
    private String tipoPessoaPagador;
    private String cnpjCpfPagador;
    private String codigoEspecie;
    private LocalDate dataLimitePagamento;
    private BigDecimal valorAbatimento;
    private String situacao;
    private Mensagem mensagem;
    private Desconto1 desconto1;
    private Desconto2 desconto2;
    private Desconto3 desconto3;
    private Multa multa;
    private Mora mora;
    private String nossoNumero;

    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public String getNomeBeneficiario() {
        return nomeBeneficiario;
    }

    public void setNomeBeneficiario(String nomeBeneficiario) {
        this.nomeBeneficiario = nomeBeneficiario;
    }

    public String getCnpjCpfBeneficiario() {
        return cnpjCpfBeneficiario;
    }

    public void setCnpjCpfBeneficiario(String cnpjCpfBeneficiario) {
        this.cnpjCpfBeneficiario = cnpjCpfBeneficiario;
    }

    public String getTipoPessoaBeneficiario() {
        return tipoPessoaBeneficiario;
    }

    public void setTipoPessoaBeneficiario(String tipoPessoaBeneficiario) {
        this.tipoPessoaBeneficiario = tipoPessoaBeneficiario;
    }

    public LocalDateTime getDataHoraSituacao() {
        return dataHoraSituacao;
    }

    public void setDataHoraSituacao(LocalDateTime dataHoraSituacao) {
        this.dataHoraSituacao = dataHoraSituacao;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getLinhaDigitavel() {
        return linhaDigitavel;
    }

    public void setLinhaDigitavel(String linhaDigitavel) {
        this.linhaDigitavel = linhaDigitavel;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getSeuNumero() {
        return seuNumero;
    }

    public void setSeuNumero(String seuNumero) {
        this.seuNumero = seuNumero;
    }

    public BigDecimal getValorNominal() {
        return valorNominal;
    }

    public void setValorNominal(BigDecimal valorNominal) {
        this.valorNominal = valorNominal;
    }

    public String getNomePagador() {
        return nomePagador;
    }

    public void setNomePagador(String nomePagador) {
        this.nomePagador = nomePagador;
    }

    public String getEmailPagador() {
        return emailPagador;
    }

    public void setEmailPagador(String emailPagador) {
        this.emailPagador = emailPagador;
    }

    public String getDddPagador() {
        return dddPagador;
    }

    public void setDddPagador(String dddPagador) {
        this.dddPagador = dddPagador;
    }

    public String getTelefonePagador() {
        return telefonePagador;
    }

    public void setTelefonePagador(String telefonePagador) {
        this.telefonePagador = telefonePagador;
    }

    public String getTipoPessoaPagador() {
        return tipoPessoaPagador;
    }

    public void setTipoPessoaPagador(String tipoPessoaPagador) {
        this.tipoPessoaPagador = tipoPessoaPagador;
    }

    public String getCnpjCpfPagador() {
        return cnpjCpfPagador;
    }

    public void setCnpjCpfPagador(String cnpjCpfPagador) {
        this.cnpjCpfPagador = cnpjCpfPagador;
    }

    public String getCodigoEspecie() {
        return codigoEspecie;
    }

    public void setCodigoEspecie(String codigoEspecie) {
        this.codigoEspecie = codigoEspecie;
    }

    public LocalDate getDataLimitePagamento() {
        return dataLimitePagamento;
    }

    public void setDataLimitePagamento(LocalDate dataLimitePagamento) {
        this.dataLimitePagamento = dataLimitePagamento;
    }

    public BigDecimal getValorAbatimento() {
        return valorAbatimento;
    }

    public void setValorAbatimento(BigDecimal valorAbatimento) {
        this.valorAbatimento = valorAbatimento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("nomeBeneficiario", nomeBeneficiario)
                .append("cnpjCpfBeneficiario", cnpjCpfBeneficiario)
                .append("tipoPessoaBeneficiario", tipoPessoaBeneficiario)
                .append("dataHoraSituacao", dataHoraSituacao)
                .append("codigoBarras", codigoBarras)
                .append("linhaDigitavel", linhaDigitavel)
                .append("dataVencimento", dataVencimento)
                .append("dataEmissao", dataEmissao)
                .append("seuNumero", seuNumero)
                .append("valorNominal", valorNominal)
                .append("nomePagador", nomePagador)
                .append("emailPagador", emailPagador)
                .append("dddPagador", dddPagador)
                .append("telefonePagador", telefonePagador)
                .append("tipoPessoaPagador", tipoPessoaPagador)
                .append("cnpjCpfPagador", cnpjCpfPagador)
                .append("codigoEspecie", codigoEspecie)
                .append("dataLimitePagamento", dataLimitePagamento)
                .append("valorAbatimento", valorAbatimento)
                .append("situacao", situacao)
                .append("mensagem", mensagem)
                .append("desconto1", desconto1)
                .append("desconto2", desconto2)
                .append("desconto3", desconto3)
                .append("multa", multa)
                .append("mora", mora)
                .append("nossoNumero", nossoNumero)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(valorNominal).append(dataHoraSituacao).append(situacao).append(telefonePagador).append(mensagem).append(multa).append(dataLimitePagamento).append(dataEmissao).append(emailPagador).append(seuNumero).append(codigoEspecie).append(desconto3).append(linhaDigitavel).append(desconto1).append(desconto2).append(cnpjCpfBeneficiario).append(codigoBarras).append(nomeBeneficiario).append(mora).append(tipoPessoaPagador).append(cnpjCpfPagador).append(dddPagador).append(valorAbatimento).append(nomePagador).append(tipoPessoaBeneficiario).append(dataVencimento).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BoletoResponse) == false) {
            return false;
        }
        BoletoResponse rhs = ((BoletoResponse) other);
        return new EqualsBuilder().append(valorNominal, rhs.valorNominal).append(dataHoraSituacao, rhs.dataHoraSituacao).append(situacao, rhs.situacao).append(telefonePagador, rhs.telefonePagador).append(mensagem, rhs.mensagem).append(multa, rhs.multa).append(dataLimitePagamento, rhs.dataLimitePagamento).append(dataEmissao, rhs.dataEmissao).append(emailPagador, rhs.emailPagador).append(seuNumero, rhs.seuNumero).append(codigoEspecie, rhs.codigoEspecie).append(desconto3, rhs.desconto3).append(linhaDigitavel, rhs.linhaDigitavel).append(desconto1, rhs.desconto1).append(desconto2, rhs.desconto2).append(cnpjCpfBeneficiario, rhs.cnpjCpfBeneficiario).append(codigoBarras, rhs.codigoBarras).append(nomeBeneficiario, rhs.nomeBeneficiario).append(mora, rhs.mora).append(tipoPessoaPagador, rhs.tipoPessoaPagador).append(cnpjCpfPagador, rhs.cnpjCpfPagador).append(dddPagador, rhs.dddPagador).append(valorAbatimento, rhs.valorAbatimento).append(nomePagador, rhs.nomePagador).append(tipoPessoaBeneficiario, rhs.tipoPessoaBeneficiario).append(dataVencimento, rhs.dataVencimento).isEquals();
    }

}
