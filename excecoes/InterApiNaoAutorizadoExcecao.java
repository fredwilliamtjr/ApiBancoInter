package br.com.fwtj.smartnfe.util.inter.excecoes;

public class InterApiNaoAutorizadoExcecao extends Exception {

    public InterApiNaoAutorizadoExcecao() {
        super("Autenticação não autorizada, verifique a configuração!");
    }

}
