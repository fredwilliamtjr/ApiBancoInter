
package br.com.fwtj.smartnfe.util.inter.dto;

import br.com.fwtj.smartnfe.util.java.TextoUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class Mensagem {

    public Mensagem() {
    }

    public Mensagem(String linha1, String linha2, String linha3, String linha4, String linha5) {
        this.linha1 = linha1;
        this.linha2 = linha2;
        this.linha3 = linha3;
        this.linha4 = linha4;
        this.linha5 = linha5;
    }

    public Mensagem(String descricaoVariasLinhas) {
        String breakStringToLines = TextoUtils.breakStringToLines(descricaoVariasLinhas.replace("\r\n", ""), 78, "\r\n");

        String[] strings1 = StringUtils.split(descricaoVariasLinhas);
        if (strings1[0] != null) {
            this.linha1 = StringUtils.left(strings1[0], 78);
        }
        if (strings1[1] != null) {
            this.linha2 = StringUtils.left(strings1[1], 78);
        }
        if (strings1[2] != null) {
            this.linha3 = StringUtils.left(strings1[2], 78);
        }
        if (strings1[3] != null) {
            this.linha4 = StringUtils.left(strings1[3], 78);
        }
        if (strings1[4] != null) {
            this.linha5 = StringUtils.left(strings1[4], 78);
        }
    }

    private String linha1;
    private String linha2;
    private String linha3;
    private String linha4;
    private String linha5;

    public String getLinha1() {
        return linha1;
    }

    public void setLinha1(String linha1) {
        this.linha1 = linha1;
    }

    public String getLinha2() {
        return linha2;
    }

    public void setLinha2(String linha2) {
        this.linha2 = linha2;
    }

    public String getLinha3() {
        return linha3;
    }

    public void setLinha3(String linha3) {
        this.linha3 = linha3;
    }

    public String getLinha4() {
        return linha4;
    }

    public void setLinha4(String linha4) {
        this.linha4 = linha4;
    }

    public String getLinha5() {
        return linha5;
    }

    public void setLinha5(String linha5) {
        this.linha5 = linha5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Mensagem mensagem = (Mensagem) o;

        return new EqualsBuilder().append(linha1, mensagem.linha1).append(linha2, mensagem.linha2).append(linha3, mensagem.linha3).append(linha4, mensagem.linha4).append(linha5, mensagem.linha5).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(linha1).append(linha2).append(linha3).append(linha4).append(linha5).toHashCode();
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "linha1='" + linha1 + '\'' +
                ", linha2='" + linha2 + '\'' +
                ", linha3='" + linha3 + '\'' +
                ", linha4='" + linha4 + '\'' +
                ", linha5='" + linha5 + '\'' +
                '}';
    }
}
