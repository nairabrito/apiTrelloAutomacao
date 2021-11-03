package crud.postCard;

import config.Settings;
import dataFactory.CardDataFactory;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.CardPojo;
import java.io.IOException;
import static io.restassured.RestAssured.*;

public class PostCardTest {

    @BeforeEach
    public void setUp() {
        Settings settings = ConfigFactory.create(Settings.class);

        baseURI = settings.baseURI();
        basePath = settings.basePath();
    }

    @Test
    @DisplayName("Cadastro de Card Válido Retorna Sucesso status code 200")
    public void testCreateCardValidRetornSucess() throws IOException {
        CardPojo cardValid = CardDataFactory.createCardValid();

        given()
            .contentType(ContentType.JSON)
            .body(cardValid)
        .when()
            .post("/cards")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_OK);
                //.body("name", equalTo("Segunda Feira"))

    }

    @Test
    @DisplayName("Cadastro de Card id Inválido Retorna 400")
    public void testCriateCardIdInvalid () throws IOException {
        CardPojo cardInvalid = CardDataFactory.createCardIdEmpty();

        given()
            .contentType(ContentType.JSON)
            .body(cardInvalid)
        .when()
            .post("/cards")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);

    }

    @Test
    @DisplayName("Cadastro de Card Inválido Retorna 401")
    public void testCreateCardEmptyCredential() throws IOException {
        CardPojo cardEmptyCredential = CardDataFactory.createCardEmptyCredential();

        given()
            .contentType(ContentType.JSON)
            .body(cardEmptyCredential)
        .when()
            .post("/cards")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);

    }

}
