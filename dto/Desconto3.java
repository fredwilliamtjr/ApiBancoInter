
package br.com.fwtj.smartnfe.util.inter.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.math.BigDecimal;

public class Desconto3 {

    public Desconto3() {
    }

    public Desconto3(String codigoDesconto, BigDecimal taxa, BigDecimal valor) {
        this.codigoDesconto = codigoDesconto;
        this.taxa = taxa;
        this.valor = valor;
    }

    private String codigo;
    private String codigoDesconto;
    private BigDecimal taxa;
    private BigDecimal valor;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoDesconto() {
        return codigoDesconto;
    }

    public void setCodigoDesconto(String codigoDesconto) {
        this.codigoDesconto = codigoDesconto;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("codigo", codigo).append("taxa", taxa).append("valor", valor).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(taxa).append(valor).append(codigo).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Desconto3) == false) {
            return false;
        }
        Desconto3 rhs = ((Desconto3) other);
        return new EqualsBuilder().append(taxa, rhs.taxa).append(valor, rhs.valor).append(codigo, rhs.codigo).isEquals();
    }

}
