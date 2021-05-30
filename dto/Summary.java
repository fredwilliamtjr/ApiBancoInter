
package br.com.fwtj.smartnfe.util.inter.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Summary {

    private Recebidos recebidos;
    private Previstos previstos;
    private Baixados baixados;
    private Expirados expirados;

    public Recebidos getRecebidos() {
        return recebidos;
    }

    public void setRecebidos(Recebidos recebidos) {
        this.recebidos = recebidos;
    }

    public Previstos getPrevistos() {
        return previstos;
    }

    public void setPrevistos(Previstos previstos) {
        this.previstos = previstos;
    }

    public Baixados getBaixados() {
        return baixados;
    }

    public void setBaixados(Baixados baixados) {
        this.baixados = baixados;
    }

    public Expirados getExpirados() {
        return expirados;
    }

    public void setExpirados(Expirados expirados) {
        this.expirados = expirados;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("recebidos", recebidos).append("previstos", previstos).append("baixados", baixados).append("expirados", expirados).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(baixados).append(expirados).append(recebidos).append(previstos).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Summary) == false) {
            return false;
        }
        Summary rhs = ((Summary) other);
        return new EqualsBuilder().append(baixados, rhs.baixados).append(expirados, rhs.expirados).append(recebidos, rhs.recebidos).append(previstos, rhs.previstos).isEquals();
    }

}
