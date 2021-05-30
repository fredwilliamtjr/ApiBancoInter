package br.com.fwtj.smartnfe.util.inter;

import br.com.fwtj.smartnfe.util.inter.dto.*;
import br.com.fwtj.smartnfe.util.inter.excecoes.InterApiExcecao;
import br.com.fwtj.smartnfe.util.juno.excecoes.JunoApiExcecao;
import br.com.fwtj.smartnfe.util.juno.excecoes.JunoApiNaoAutorizadoExcecao;
import feign.Client;
import feign.Feign;
import feign.FeignException;
import feign.Request;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;

import javax.net.ssl.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.math.BigDecimal;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

public class InterUtils {

    private static Log log = LogFactory.getLog("(InterUtils)");

    private static final String WS_URL = "https://apis.bancointer.com.br:8443";

    private static SSLContext initializeSSLContext(final byte[] keyStoreByteArray, final String pwKeyStore, final boolean trustall) throws Exception {

        TrustManager[] trustAllCerts = null;
        trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }};

        String keymanageralgorithm = "SunX509";

        char[] keyStorePw = pwKeyStore.toCharArray();
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextInt();
        KeyStore ks = null;
        try {
            ks = KeyStore.getInstance("JKS");
        } catch (KeyStoreException exp) {
            throw new Exception("KeyStoreException exception occurred while reading the config file : " + exp.getMessage());
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(keyStoreByteArray);
        try {
            ks.load(byteArrayInputStream, keyStorePw);
        } catch (NoSuchAlgorithmException exp) {
            throw new Exception("NoSuchAlgorithmException exception occurred " + exp.getMessage());
        } catch (CertificateException | IOException exp) {
            if (exp.getMessage().contains("password was incorrect")) {
                throw new Exception("Senha incorreta!");
            } else {
                throw new Exception("CertificateException exception occurred " + exp.getMessage());
            }
        }

        System.out.println("[initializeSSLContext] KMF keystorepw loaded.");
        KeyManagerFactory kmf = null;
        try {
            kmf = KeyManagerFactory.getInstance(keymanageralgorithm);
        } catch (NoSuchAlgorithmException exp) {
            throw new Exception("IOException exception occurred " + exp.getMessage());
        }
        try {
            kmf.init(ks, keyStorePw);
        } catch (UnrecoverableKeyException exp) {
            throw new Exception("UnrecoverableKeyException exception occurred " + exp.getMessage());
        } catch (KeyStoreException exp) {
            throw new Exception("KeyStoreException exception occurred " + exp.getMessage());
        } catch (NoSuchAlgorithmException exp) {
            throw new Exception("NoSuchAlgorithmException exception occurred " + exp.getMessage());
        }
        System.out.println("[initializeSSLContext] KMF init done.");
        KeyStore ts = null;
        try {
            ts = KeyStore.getInstance("JKS");
        } catch (KeyStoreException exp) {
            throw new Exception("NoSuchAlgorithmException exception occurred " + exp.getMessage());
        }
        SSLContext sslContext = null;
        try {
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(keyStoreByteArray);
            ts.load(byteArrayInputStream2, keyStorePw);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(keymanageralgorithm);
            tmf.init(ts);
            System.out.println("[initializeSSLContext] Truststore initialized");
            sslContext = SSLContext.getInstance("TLS");

            if (trustall) {
                sslContext.init(kmf.getKeyManagers(), trustAllCerts, secureRandom);
            } else {
                sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), secureRandom);
            }

        } catch (NoSuchAlgorithmException | CertificateException | IOException | KeyStoreException | KeyManagementException exp) {
            throw new Exception("NoSuchAlgorithmException exception occurred " + exp.getMessage());
        }
        return sslContext;
    }

    public static SSLContext setupSslContext(boolean trustAllCertificate, byte[] keyStoreByteArray, String keyStorePassword) throws Exception {
        SSLContext sslContext = initializeSSLContext(keyStoreByteArray, keyStorePassword, trustAllCertificate);
        return sslContext;

    }

    public static Client getFeignClient(boolean trustAllCertificate, byte[] jksKeyStoreByteArray, String jksKeyStoreSenha) throws Exception {
        SSLContext sslContext = setupSslContext(trustAllCertificate, jksKeyStoreByteArray, jksKeyStoreSenha);
        SSLSocketFactory socketFactory = sslContext.getSocketFactory();
        Client trustSSLSockets = new Client.Default(socketFactory, new NoopHostnameVerifier());
        return trustSSLSockets;
    }

    public static BoletosResponse boletos(Client client, String numeroContaCorrente, LocalDate dataInicial, LocalDate dataFinal) throws InterApiExcecao {

        try {
            Map<String, String> queryParameters = new LinkedHashMap<>();
            queryParameters.put("filtrarPor", "TODOS");
            queryParameters.put("dataInicial", dataInicial.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            queryParameters.put("dataFinal", dataFinal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            queryParameters.put("ordenarPor", "DATAVENCIMENTO_DSC");
            BoletosResponse boletos = Feign.builder()
                    .client(client)
                    .encoder(new InterCustonEncoder())
                    .decoder(new InterCustonDecoder())
                    .options(new Request.Options(3000, 3000))
                    .target(InterWS.class, WS_URL)
                    .boletosGet(numeroContaCorrente, queryParameters);
            return boletos;
        } catch (UndeclaredThrowableException undeclaredThrowableException) {
            Throwable undeclaredThrowable = undeclaredThrowableException.getUndeclaredThrowable();
            if (undeclaredThrowable instanceof InterApiExcecao) {
                InterApiExcecao interApiExcecao = (InterApiExcecao) undeclaredThrowable;
                throw interApiExcecao;
            } else {
                throw new InterApiExcecao(undeclaredThrowable.getMessage());
            }
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new InterApiExcecao(exception.getMessage());
        }

    }

    public static BoletoResponse boletoGet(Client client, String numeroContaCorrente, String nossoNumero) throws InterApiExcecao {

        try {
            BoletoResponse boletoResponse = Feign.builder()
                    .client(client)
                    .encoder(new InterCustonEncoder())
                    .decoder(new InterCustonDecoder())
                    .options(new Request.Options(3000, 3000))
                    .target(InterWS.class, WS_URL)
                    .boletoGet(numeroContaCorrente, nossoNumero);
            return boletoResponse;
        } catch (UndeclaredThrowableException undeclaredThrowableException) {
            Throwable undeclaredThrowable = undeclaredThrowableException.getUndeclaredThrowable();
            if (undeclaredThrowable instanceof InterApiExcecao) {
                InterApiExcecao interApiExcecao = (InterApiExcecao) undeclaredThrowable;
                throw interApiExcecao;
            } else {
                throw new InterApiExcecao(undeclaredThrowable.getMessage());
            }
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new InterApiExcecao(exception.getMessage());
        }

    }

    public static byte[] pdfBase64Get(Client client, String numeroContaCorrente, String nossoNumero) throws InterApiExcecao {

        try {
            String pdfBase64 = Feign.builder()
                    .client(client)
                    .encoder(new InterCustonEncoder())
                    .options(new Request.Options(3000, 3000))
                    .target(InterWS.class, WS_URL)
                    .pdfBase64Get(numeroContaCorrente, nossoNumero);
            byte[] decode = Base64.getDecoder().decode(pdfBase64);
            return decode;
        } catch (UndeclaredThrowableException undeclaredThrowableException) {
            Throwable undeclaredThrowable = undeclaredThrowableException.getUndeclaredThrowable();
            if (undeclaredThrowable instanceof InterApiExcecao) {
                InterApiExcecao interApiExcecao = (InterApiExcecao) undeclaredThrowable;
                throw interApiExcecao;
            } else {
                throw new InterApiExcecao(undeclaredThrowable.getMessage());
            }
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new InterApiExcecao(exception.getMessage());
        }

    }

    public static BoletoResponse boletoPost(Client client, String numeroContaCorrente, BoletoBody boletoBody) throws InterApiExcecao {

        try {
            BoletoResponse boletoResponse = Feign.builder()
                    .client(client)
                    .encoder(new InterCustonEncoder())
                    .decoder(new InterCustonDecoder())
                    .errorDecoder(new InterErrorDecoder())
                    .options(new Request.Options(3000, 3000))
                    .target(InterWS.class, WS_URL)
                    .boletoPost(numeroContaCorrente, boletoBody);
            return boletoResponse;
        } catch (UndeclaredThrowableException undeclaredThrowableException) {
            Throwable undeclaredThrowable = undeclaredThrowableException.getUndeclaredThrowable();
            if (undeclaredThrowable instanceof InterApiExcecao) {
                InterApiExcecao interApiExcecao = (InterApiExcecao) undeclaredThrowable;
                throw interApiExcecao;
            } else {
                throw new InterApiExcecao(undeclaredThrowable.getMessage());
            }
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new InterApiExcecao(exception.getMessage());
        }

    }

    public static void baixasPost(Client client, String numeroContaCorrente, String nossoNumero) throws InterApiExcecao {

        try {
            Feign.builder()
                    .client(client)
                    .encoder(new InterCustonEncoder())
                    .decoder(new InterCustonDecoder())
                    .errorDecoder(new InterErrorDecoder())
                    .options(new Request.Options(3000, 3000))
                    .target(InterWS.class, WS_URL)
                    .baixasPost(numeroContaCorrente, nossoNumero, new BaixaBody());
        } catch (UndeclaredThrowableException undeclaredThrowableException) {
            Throwable undeclaredThrowable = undeclaredThrowableException.getUndeclaredThrowable();
            if (undeclaredThrowable instanceof InterApiExcecao) {
                InterApiExcecao interApiExcecao = (InterApiExcecao) undeclaredThrowable;
                throw interApiExcecao;
            } else {
                throw new InterApiExcecao(undeclaredThrowable.getMessage());
            }
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new InterApiExcecao(exception.getMessage());
        }

    }


    public static void main(String[] args) throws Exception {

        LocalDate localDate = LocalDate.of(2021, Month.MAY, 4);
        String numeroContaCorrente = "11111111";

        byte[] readFileToByteArray = FileUtils.readFileToByteArray(new File("/smartfull/inter-boleto-keystore.jks"));

        Client client = getFeignClient(true, readFileToByteArray, "aqui-vai-a-senha-do-jks");

        Pagador pagador = new Pagador("00000000000", "Fred William Torno Junior", "fredwilliam@gmail.com",
                "981365786", "26000000", "367", "não tem", "Bairro", "Cidade",
                "RJ", "Rua sem nome", "21", "FISICA");
        Mensagem mensagem = new Mensagem("Linha 1", "Linha 2", "Linha 3", "Linha 4", "Linha 5");
        Desconto1 desconto1 = new Desconto1("NAOTEMDESCONTO", new BigDecimal("0"), new BigDecimal("0"));
        Desconto2 desconto2 = new Desconto2("NAOTEMDESCONTO", new BigDecimal("0"), new BigDecimal("0"));
        Desconto3 desconto3 = new Desconto3("NAOTEMDESCONTO", new BigDecimal("0"), new BigDecimal("0"));
        Multa multa = new Multa("NAOTEMMULTA", new BigDecimal("0"), new BigDecimal("0"));
        Mora mora = new Mora("ISENTO", new BigDecimal("0"), new BigDecimal("0"));
        BoletoBody boletoBody = new BoletoBody(pagador, localDate, "0", "SESSENTA",
                localDate, mensagem, desconto1, desconto2, desconto3, new BigDecimal("16.87"), new BigDecimal("0"),
                multa, mora, "29422426000115", "SESSENTA");
        BoletoResponse boletoResponse = boletoPost(client, numeroContaCorrente, boletoBody);
        System.out.println(boletoResponse);
        if (boletoResponse != null && boletoResponse.getNossoNumero() != null) {
            String nossoNumero = boletoResponse.getNossoNumero();
            BoletoResponse boletoResponse2 = boletoGet(client, numeroContaCorrente, nossoNumero);
            System.out.println(boletoResponse2);
            byte[] decode = pdfBase64Get(client, numeroContaCorrente, nossoNumero);
            System.out.println(decode);
            FileUtils.writeByteArrayToFile(new File("/smartfull/boleto-inter-" + nossoNumero + ".pdf"), decode);
        }

//        LocalDate dataInicial = LocalDate.of(2021, Month.APRIL, 1);
//        LocalDate dataFinal = LocalDate.of(2021, Month.APRIL, 30);
//        BoletosResponse boletosResponse = boletos(client, numeroContaCorrente, dataInicial, dataFinal);
//        if (boletosResponse != null && !boletosResponse.getContent().isEmpty()) {
//            boletosResponse.getContent().forEach(boletosResponseContent -> {
//                System.out.print(boletosResponseContent.getDataEmissao());
//                System.out.print(" - ");
//                System.out.print(boletosResponseContent.getNomeSacado());
//                System.out.print(" - ");
//                System.out.print(boletosResponseContent.getValorNominal());
//                System.out.print(" - ");
//                System.out.println(boletosResponseContent.getSituacao());
//            });
//            String nossoNumero = boletosResponse.getContent().get(1).getNossoNumero();
//            BoletoResponse boletoResponse = boletoGet(client, numeroContaCorrente, nossoNumero);
//            System.out.println(boletoResponse);
//            byte[] decode = pdfBase64(client, numeroContaCorrente, nossoNumero);
//            System.out.println(decode);
//            FileUtils.writeByteArrayToFile(new File("/smartfull/boleto-inter-" + nossoNumero +".pdf"), decode);
//        }


    }

}
