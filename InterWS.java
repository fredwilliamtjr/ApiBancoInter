package br.com.fwtj.smartnfe.util.inter;

import br.com.fwtj.smartnfe.util.inter.dto.BaixaBody;
import br.com.fwtj.smartnfe.util.inter.dto.BoletoBody;
import br.com.fwtj.smartnfe.util.inter.dto.BoletoResponse;
import br.com.fwtj.smartnfe.util.inter.dto.BoletosResponse;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

public interface InterWS {

    @Headers({"x-inter-conta-corrente: {numeroContaCorrente}", "Content-Type: application/json"})
    @RequestLine("GET /openbanking/v1/certificado/boletos")
    BoletosResponse boletosGet(@Param("numeroContaCorrente") String numeroContaCorrente, @QueryMap Map<String, String> queryParameters);

    @Headers({"x-inter-conta-corrente: {numeroContaCorrente}", "Content-Type: application/json"})
    @RequestLine("GET /openbanking/v1/certificado/boletos/{nossoNumero}")
    BoletoResponse boletoGet(@Param("numeroContaCorrente") String numeroContaCorrente, @Param("nossoNumero") String nossoNumero);

    @Headers({"x-inter-conta-corrente: {numeroContaCorrente}", "Content-Type: application/base64"})
    @RequestLine("GET /openbanking/v1/certificado/boletos/{nossoNumero}/pdf")
    String pdfBase64Get(@Param("numeroContaCorrente") String numeroContaCorrente, @Param("nossoNumero") String nossoNumero);

    @Headers({"x-inter-conta-corrente: {numeroContaCorrente}", "Content-Type: application/json"})
    @RequestLine("POST /openbanking/v1/certificado/boletos")
    BoletoResponse boletoPost(@Param("numeroContaCorrente") String numeroContaCorrente, BoletoBody boletoBody);

    @Headers({"x-inter-conta-corrente: {numeroContaCorrente}", "Content-Type: application/json"})
    @RequestLine("GET /openbanking/v1/certificado/boletos/{nossoNumero}/baixas")
    void baixasPost(@Param("numeroContaCorrente") String numeroContaCorrente, @Param("nossoNumero") String nossoNumero, BaixaBody baixaBody);

}
