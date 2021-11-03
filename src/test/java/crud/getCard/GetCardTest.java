package crud.getCard;

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

public class GetCardTest {
    @BeforeEach
    public void setUp() {
        Settings settings = ConfigFactory.create(Settings.class);

        baseURI = settings.baseURI();
        basePath = settings.basePath();
    }

    @Test
    @DisplayName("Consulta Card Válido Retorna Sucesso status code 200")
    public void testSearchCardValidRetornSucess() throws IOException {
        CardPojo searchCard = CardDataFactory.searchCardValid();

        given().log().all()
            .contentType(ContentType.JSON)
            .body(searchCard)
        .when()
            .get("/cards/61828b90e9fa0f3497e5a1dd")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    @DisplayName("Consulta Card falha 401")
    public void testSearchCardEmptyCredential() throws IOException {
        CardPojo searchCard = CardDataFactory.searchCardEmptyCredential();

        given()
            .contentType(ContentType.JSON)
            .body(searchCard)
        .when()
            .get("/cards/61828b90e9fa0f3497e5a1dd")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED).log().all();
    }

    @Test
    @DisplayName("Consulta Card falha 400")
    public void testSearchCardIdInvalid() throws IOException {
        CardPojo searchCard = CardDataFactory.searchCardValid();

        given()
            .contentType(ContentType.JSON)
            .body(searchCard)
        .when()
            .get("/cards/61828b90e9fa0f3497e5a1dde")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST).log().all();

    }

}
