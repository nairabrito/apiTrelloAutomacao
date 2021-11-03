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
import  static io.restassured.module.jsv.JsonSchemaValidator.*;

public class PostCardContractTest {
    @BeforeEach
    public void setUp() {
        Settings settings = ConfigFactory.create(Settings.class);

        baseURI = settings.baseURI();
        basePath = settings.basePath();
    }

    @Test
    @DisplayName("Cadastro de Card Valida Contrato com JsonSchema")
    public void testCreateCardValidContract () throws IOException {
        CardPojo cardValid = CardDataFactory.createCardValid();

        given()
            .contentType(ContentType.JSON)
            .body(cardValid)
        .when()
            .post("/cards")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/PostCardValido.json"));


    }

}
