// nome do pacote
package apiTest;

// Bibliotecas

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.is;

// Classe
public class TesteUser { // Início da classe
    // Atributos

    // Funções e métodos

    // Funções de apoio
    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }

    // Funções de Teste
    @Test
    public void testarIncluirUser() throws IOException {
        // carregar os dados do nosso json
        String jsonBody = lerArquivoJson("src/test/resources/json/user1.json");

        String userId = "1373709898";

        // realizar o teste
        given()                                         // Dado que
                .contentType("application/json")     // o tipo do conteúdo
                .log().all()                            // mostre tudo
                .body(jsonBody)                         // corpo da requisição

        .when()
                .post("https://petstore.swagger.io/v2/user") // Endpoint / Onde
        .then()                                          // Então
                .log().all()                            // mostre tudo na volta
                .statusCode(200)                      // comunic. ida e volta ok
                .body("code", is(200))          // tag code é 200
                .body("type", is("unknwon"))    // tag type é "unknown"
                .body("message", is(userId))         // message é o userId
        ;
    }

} // fim da classe