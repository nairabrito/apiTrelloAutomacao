package crud.putCard;

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
import static io.restassured.RestAssured.given;

public class PutCardTest {
    @BeforeEach
    public void setUp() {
        Settings settings = ConfigFactory.create(Settings.class);

        baseURI = settings.baseURI();
        basePath = settings.basePath();
    }

    @Test
    @DisplayName("Edição Card Válido Retorna Sucesso status code 200")
    public void testEditCardValidRetornSucess() throws IOException {
        CardPojo cardValid = CardDataFactory.editCardValid();

        given()
            .contentType(ContentType.JSON)
            .body(cardValid)
        .when()
            .put("/cards/61828b90e9fa0f3497e5a1dd")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    @DisplayName("Edição de Card Inválido Retorna 400")
    public void testEditCardIdInvalid() throws IOException {
        CardPojo idCardInvalid = CardDataFactory.editCardIdInvalid();

        given()
            .contentType(ContentType.JSON)
            .body(idCardInvalid)
        .when()
            .put("/cards/61828b90e9fa0f3497e5a1dde")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);

    }

    @Test
    @DisplayName("Edição de Card Inválido Retorna 401")
    public void testEditCardEmptyCredential() throws IOException {
        CardPojo EmptyCredentials = CardDataFactory.editCardEmptyCredential();

        given()
            .contentType(ContentType.JSON)
            .body(EmptyCredentials)
        .when()
            .put("/cards/61828b90e9fa0f3497e5a1dd")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }
}
