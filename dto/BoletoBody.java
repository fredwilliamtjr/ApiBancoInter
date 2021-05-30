
package br.com.fwtj.smartnfe.util.inter.dto;

import br.com.fwtj.smartnfe.modelo.tenant.Cliente;
import br.com.fwtj.smartnfe.modelo.tenant.Cobranca;
import br.com.fwtj.smartnfe.modelo.tenant.Filial;
import br.com.fwtj.smartnfe.util.java.TextoUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BoletoBody {

    public BoletoBody() {
    }

    public BoletoBody(Cobranca cobranca, String cnpjCPFBeneficiario) {

        Filial filial = cobranca.getFilial();
        Cliente cliente = cobranca.getCliente();
        if (cliente != null) {
            this.pagador = new Pagador(cliente.getCnpj_cpfSemFormatacao(), cliente.getRazaoSocialNome(), cliente.getEmail(),
                    TextoUtils.retornaNumeroSemDdd(cliente.getTelefone()), cliente.getCepSemFormatacao(), cliente.getNumero(), cliente.getComplemento(), cliente.getBairro(),
                    cliente.getCidade().getNome(), cliente.getUnidadeFederativa().name(),
                    cliente.getLogradouro(), TextoUtils.retornaDdd(cliente.getTelefone()), cliente.getTipoPessoa().name());
        } else {
            this.pagador = new Pagador(filial.getCnpjSemFormatacao(), filial.getRazaoSocial(), filial.getEmail(),
                    TextoUtils.retornaNumeroSemDdd(filial.getTelefone()), filial.getCepSemFormatacao(), filial.getNumero(), filial.getComplemento(), filial.getBairro(),
                    filial.getCidade().getNome(), filial.getUnidadeFederativa().name(),
                    filial.getLogradouro(), TextoUtils.retornaDdd(filial.getTelefone()), filial.getTipoPessoa().name());
        }

        this.dataEmissao = cobranca.getDataHoraCobranca().toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.seuNumero = "0";
        this.dataLimite = "SESSENTA";
        this.dataVencimento = cobranca.getDataVencimento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.mensagem = new Mensagem(cobranca.getDescricaoLinha1(), cobranca.getDescricaoLinha2(), cobranca.getDescricaoLinha3(), cobranca.getDescricaoLinha4(), cobranca.getDescricaoLinha5());
        this.desconto1 = new Desconto1("NAOTEMDESCONTO", new BigDecimal("0"), new BigDecimal("0"));
        this.desconto2 = new Desconto2("NAOTEMDESCONTO", new BigDecimal("0"), new BigDecimal("0"));
        this.desconto3 = new Desconto3("NAOTEMDESCONTO", new BigDecimal("0"), new BigDecimal("0"));
        this.valorNominal = cobranca.getValor();
        this.valorAbatimento = new BigDecimal("0");
        this.multa = new Multa("NAOTEMMULTA", new BigDecimal("0"), new BigDecimal("0"));
        this.mora = new Mora("ISENTO", new BigDecimal("0"), new BigDecimal("0"));
        this.cnpjCPFBeneficiario = cnpjCPFBeneficiario;
        this.numDiasAgenda = "SESSENTA";
    }

    public BoletoBody(Pagador pagador, LocalDate dataEmissao, String seuNumero, String dataLimite, LocalDate dataVencimento,
                      Mensagem mensagem, Desconto1 desconto1, Desconto2 desconto2, Desconto3 desconto3, BigDecimal valorNominal,
                      BigDecimal valorAbatimento, Multa multa, Mora mora, String cnpjCPFBeneficiario, String numDiasAgenda) {
        this.pagador = pagador;
        this.dataEmissao = dataEmissao.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.seuNumero = seuNumero;
        this.dataLimite = dataLimite;
        this.dataVencimento = dataVencimento.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.mensagem = mensagem;
        this.desconto1 = desconto1;
        this.desconto2 = desconto2;
        this.desconto3 = desconto3;
        this.valorNominal = valorNominal;
        this.valorAbatimento = valorAbatimento;
        this.multa = multa;
        this.mora = mora;
        this.cnpjCPFBeneficiario = cnpjCPFBeneficiario;
        this.numDiasAgenda = numDiasAgenda;
    }

    private Pagador pagador;
    private String dataEmissao;
    private String seuNumero;
    private String dataLimite;
    private String dataVencimento;
    private Mensagem mensagem;
    private Desconto1 desconto1;
    private Desconto2 desconto2;
    private Desconto3 desconto3;
    private BigDecimal valorNominal;
    private BigDecimal valorAbatimento;
    private Multa multa;
    private Mora mora;
    private String cnpjCPFBeneficiario;
    private String numDiasAgenda;

    public Pagador getPagador() {
        return pagador;
    }

    public void setPagador(Pagador pagador) {
        this.pagador = pagador;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getSeuNumero() {
        return seuNumero;
    }

    public void setSeuNumero(String seuNumero) {
        this.seuNumero = seuNumero;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
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

    public BigDecimal getValorNominal() {
        return valorNominal;
    }

    public void setValorNominal(BigDecimal valorNominal) {
        this.valorNominal = valorNominal;
    }

    public BigDecimal getValorAbatimento() {
        return valorAbatimento;
    }

    public void setValorAbatimento(BigDecimal valorAbatimento) {
        this.valorAbatimento = valorAbatimento;
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

    public String getCnpjCPFBeneficiario() {
        return cnpjCPFBeneficiario;
    }

    public void setCnpjCPFBeneficiario(String cnpjCPFBeneficiario) {
        this.cnpjCPFBeneficiario = cnpjCPFBeneficiario;
    }

    public String getNumDiasAgenda() {
        return numDiasAgenda;
    }

    public void setNumDiasAgenda(String numDiasAgenda) {
        this.numDiasAgenda = numDiasAgenda;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("pagador", pagador).append("dataEmissao", dataEmissao).append("seuNumero", seuNumero).append("dataLimite", dataLimite).append("dataVencimento", dataVencimento).append("mensagem", mensagem).append("desconto1", desconto1).append("desconto2", desconto2).append("desconto3", desconto3).append("valorNominal", valorNominal).append("valorAbatimento", valorAbatimento).append("multa", multa).append("mora", mora).append("cnpjCPFBeneficiario", cnpjCPFBeneficiario).append("numDiasAgenda", numDiasAgenda).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(valorNominal).append(mora).append(pagador).append(mensagem).append(multa).append(valorAbatimento).append(dataEmissao).append(seuNumero).append(cnpjCPFBeneficiario).append(desconto3).append(dataVencimento).append(desconto1).append(desconto2).append(dataLimite).append(numDiasAgenda).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BoletoBody) == false) {
            return false;
        }
        BoletoBody rhs = ((BoletoBody) other);
        return new EqualsBuilder().append(valorNominal, rhs.valorNominal).append(mora, rhs.mora).append(pagador, rhs.pagador).append(mensagem, rhs.mensagem).append(multa, rhs.multa).append(valorAbatimento, rhs.valorAbatimento).append(dataEmissao, rhs.dataEmissao).append(seuNumero, rhs.seuNumero).append(cnpjCPFBeneficiario, rhs.cnpjCPFBeneficiario).append(desconto3, rhs.desconto3).append(dataVencimento, rhs.dataVencimento).append(desconto1, rhs.desconto1).append(desconto2, rhs.desconto2).append(dataLimite, rhs.dataLimite).append(numDiasAgenda, rhs.numDiasAgenda).isEquals();
    }

}
