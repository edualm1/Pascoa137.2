// nome do pacote
package apiTest;

// Bibliotecas

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesPattern;

// Classe
public class TesteUser { // Início da classe
    // Atributos
    String ct = "application/json"; // content type
    String uriUser = "https://petstore.swagger.io/v2/user";

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
                .contentType(ct)                        // o tipo do conteúdo
                .log().all()                            // mostre tudo
                .body(jsonBody)                         // corpo da requisição

        .when()
                .post(uriUser) // Endpoint / Onde
        .then()                                          // Então
                .log().all()                            // mostre tudo na volta
                .statusCode(200)                      // comunic. ida e volta ok
                .body("code", is(200))          // tag code é 200
                .body("type", is("unknown"))    // tag type é "unknown"
                .body("message", is(userId))         // message é o userId
        ;
    }       // fim do post

    @Test
    public void testarConsultarUser()  throws IOException {
        String username = "du";

        // resultado esperado
        int userId = 1373709898;       // codigo do usuario
        String email = "almeida@test.com";
        String senha = "123456";
        String telefone = "11912345678";

    given()
            .contentType(ct)
            .log().all()
    .when()
            .get(uriUser + username)      // onde
    .then()
                .log().all()
                .statusCode(200)
                .body("id", is("du"))
                .body("email", is("almeida@test.com"))
                .body("phone", is("telefone"))
                .body("senha", is("123456"))
    ;
    }

} // fim da classe

