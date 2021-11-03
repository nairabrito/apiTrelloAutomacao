package crud.deleteCard;

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

public class DeleteCardTest {

    @BeforeEach
    public void setUp() {
        Settings settings = ConfigFactory.create(Settings.class);

        baseURI = settings.baseURI();
        basePath = settings.basePath();
    }

    @Test
    @DisplayName("Deleta Card falha 401")
    public void testDeleteCardEmptyCredential() throws IOException {
        CardPojo deleteCard = CardDataFactory.deleteCardEmptyCredential();

        given()
            .contentType(ContentType.JSON)
            .body(deleteCard)
        .when()
            .delete("/cards/618201659543bb8640e08a75")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    @DisplayName("Deleta Card falha 400")
    public void testDeleteCardIdInvalid() throws IOException {
        CardPojo deleteCard = CardDataFactory.deleteCardValid();

        given()
            .contentType(ContentType.JSON)
            .body(deleteCard)
        .when()
            .delete("/cards/618201659543bb8640e08a75e")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);

    }

    @Test
    @DisplayName("Deleta Card Válido Retorna Sucesso status code 200")
    public void testDeleteCardValidRetornSucess() throws IOException {
        CardPojo deleteCard = CardDataFactory.deleteCardValid();

        given()
            .contentType(ContentType.JSON)
            .body(deleteCard)
        .when()
            .delete("/cards/618201659543bb8640e08a75")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }
}
