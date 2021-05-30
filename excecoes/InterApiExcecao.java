package br.com.fwtj.smartnfe.util.inter.excecoes;

import br.com.fwtj.smartnfe.util.inter.dto.ErrorResponse;

public class InterApiExcecao extends Exception {

    public InterApiExcecao(String texto) {
        super(texto);
    }

    private ErrorResponse errorResponse;

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
