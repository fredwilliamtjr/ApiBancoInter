
package br.com.fwtj.smartnfe.util.inter.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.math.BigDecimal;

public class Baixados {

    private Integer quantidade;
    private BigDecimal valor;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("quantidade", quantidade).append("valor", valor).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(valor).append(quantidade).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Baixados) == false) {
            return false;
        }
        Baixados rhs = ((Baixados) other);
        return new EqualsBuilder().append(valor, rhs.valor).append(quantidade, rhs.quantidade).isEquals();
    }

}
