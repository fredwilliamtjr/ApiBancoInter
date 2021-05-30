
package br.com.fwtj.smartnfe.util.inter.dto;

import br.com.fwtj.smartnfe.util.java.TextoUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang3.StringUtils;

public class Pagador {

    public Pagador() {
    }

    public Pagador(String cnpjCpf, String nome, String email, String telefone, String cep, String numero, String complemento, String bairro, String cidade, String uf, String endereco, String ddd, String tipoPessoa) {
        this.cnpjCpf = cnpjCpf;
        this.nome = TextoUtils.ajustaLimiteCaracter(nome, 100);
        this.email = StringUtils.isNotBlank(email) ? email : null;
        this.telefone = StringUtils.isNotBlank(telefone) ? telefone : null;
        this.cep = cep;
        this.numero = TextoUtils.ajustaLimiteCaracter(numero, 10);
        this.complemento = StringUtils.isNotBlank(complemento) ? TextoUtils.ajustaLimiteCaracter(complemento, 30) : "NÃO TEM";
        this.bairro = TextoUtils.ajustaLimiteCaracter(bairro, 60);
        this.cidade = TextoUtils.ajustaLimiteCaracter(cidade, 60);
        this.uf = uf;
        this.endereco = TextoUtils.ajustaLimiteCaracter(endereco, 90);
        this.ddd = StringUtils.isNotBlank(ddd) ? ddd : null;
        this.tipoPessoa = tipoPessoa;
    }

    private String cnpjCpf;
    private String nome;
    private String email;
    private String telefone;
    private String cep;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String endereco;
    private String ddd;
    private String tipoPessoa;

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cnpjCpf", cnpjCpf).append("nome", nome).append("email", email).append("telefone", telefone).append("cep", cep).append("numero", numero).append("complemento", complemento).append("bairro", bairro).append("cidade", cidade).append("uf", uf).append("endereco", endereco).append("ddd", ddd).append("tipoPessoa", tipoPessoa).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(telefone).append(cidade).append(tipoPessoa).append(numero).append(endereco).append(ddd).append(bairro).append(nome).append(cnpjCpf).append(cep).append(uf).append(complemento).append(email).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Pagador) == false) {
            return false;
        }
        Pagador rhs = ((Pagador) other);
        return new EqualsBuilder().append(telefone, rhs.telefone).append(cidade, rhs.cidade).append(tipoPessoa, rhs.tipoPessoa).append(numero, rhs.numero).append(endereco, rhs.endereco).append(ddd, rhs.ddd).append(bairro, rhs.bairro).append(nome, rhs.nome).append(cnpjCpf, rhs.cnpjCpf).append(cep, rhs.cep).append(uf, rhs.uf).append(complemento, rhs.complemento).append(email, rhs.email).isEquals();
    }

}
