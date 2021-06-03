# ApiBancoInter
Exemplo de integração com a API de emissão de boleto do Banco Inter

Veja como criar o certificado do banco inter neste link:
https://developers.bancointer.com.br/discuss/5f1f484b846152017169d0a5

Converta o certificado do banco inter para .jks usando as dicas dessa pagina:
https://www.baeldung.com/x-509-authentication-in-spring-security

Autor Paulo Ricardo Gomes Rodrigues
Para quem precisar inserir certificado para consumir alguma API em Java pode seguir o código do Fred, tá show!
https://github.com/fredwilliamtjr/ApiBancoInter
DICA 1:
- Você precisa agrupar a chave e o certificado em um arquivo .p12 (no caso da API do Inter ao criar a aplicação eles já disponibilizam esse certificado e a chave, sem senha mesmo, se não disponibilizassem você teria que criar um certificado)
- esse é o comando para agrupar e transformar a chave e o certificado:
openssl pkcs12 -export -out NOVO-ARQUIVO.p12 -name "NOVO-ARQUIVO" -inkey SUA-CHAVE.key -in SEU-CERTIFICADO.crt
DICA 2:
- Com o arquivo .p12 criado você será capaz de criar sua keystore.jks (o que você precisa na verdade é desse arquivo para colocar na requisição)
- vamos ao comando:
keytool -importkeystore -srckeystore NOVO-ARQUIVO.p12 -srcstoretype PKCS12 -destkeystore keystore.jks -deststoretype JKS
Ao criar o arquivo o terminal pedirá para você incluir uma senha.
DICA 3: DEIXANDO A REQUISIÇÃO SEGURA:
- Não importa muito qual cliente você vai utilizar para fazer a requisição (Feign, RestTemplate, WebClient, Apache...)
O que importa mesmo é você passar o SSL para seu HttpClient, essa é uma das formas de se fazer isso:
// Passando a JKS para o SSLContext
{
KeyStore keyStore = KeyStore.getInstance("PKCS12");
keyStore.load(this.getClass().getResourceAsStream("/keys/keystore.jks"), "senha-da-jks".toCharArray());
sslContext = SSLContextBuilder.create()
.loadKeyMaterial(keyStore, "senha-da-jks".toCharArray())
.loadTrustMaterial(null, new TrustSelfSignedStrategy())
.build();
}
// Retornando o Client do Feign com o SSL
{
SSLContext sslContext = initializeSSLContext();
SSLSocketFactory socketFactory = sslContext.getSocketFactory();
Client trustSSLSockets = new Client.Default(socketFactory, new NoopHostnameVerifier());
return trustSSLSockets;
}
Eu tenho o código de como fazer a mesma coisa usando o RestTemplate caso alguém queira.
Se tiverem dúvidas é só chamar por aqui, abraço.
https://www.facebook.com/groups/1467881680180826/permalink/2598908177078165
