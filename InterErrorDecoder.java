package br.com.fwtj.smartnfe.util.inter;

import br.com.fwtj.smartnfe.util.inter.dto.ErrorResponse;
import br.com.fwtj.smartnfe.util.inter.excecoes.InterApiExcecao;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;

import java.nio.charset.StandardCharsets;

import static feign.FeignException.errorStatus;

public class InterErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            String toString = IOUtils.toString(response.body().asInputStream(), StandardCharsets.UTF_8);
            Genson genson = new GensonBuilder().setSkipNull(true).useDateAsTimestamp(false).create();
            ErrorResponse errorResponse = genson.deserialize(toString, ErrorResponse.class);
            if (errorResponse != null && errorResponse.getMessage() != null) {
                String message = errorResponse.getMessage();
                InterApiExcecao interApiExcecao = new InterApiExcecao(message);
                interApiExcecao.setErrorResponse(errorResponse);
                return interApiExcecao;
            }
        } catch (Exception ignored) {
            //System.out.println(ignored);
        }
        return errorStatus(methodKey, response);
    }
}
