package dataFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.CardPojo;
import java.io.FileInputStream;
import java.io.IOException;

public class CardDataFactory {

    public static CardPojo card() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CardPojo card = objectMapper.readValue(new FileInputStream("src/test/resources/requestBody/card.json"), CardPojo.class);
        return card;
    }

    public static CardPojo createCardValid() throws IOException {
        CardPojo cardValid = card();
        cardValid.setKey("c6ebc8969b0eea9b92fd61899d05495c");
        cardValid.setToken("5d658a31140745c12e87aaf0fab9e5a5a08cabc29da7d706108484027c7040e9");
        return cardValid;
    }

    public static CardPojo createCardIdEmpty() throws IOException {
        CardPojo cardIdListEmpty = card();
        cardIdListEmpty.setKey("c6ebc8969b0eea9b92fd61899d05495c");
        cardIdListEmpty.setToken("5d658a31140745c12e87aaf0fab9e5a5a08cabc29da7d706108484027c7040e9");
        cardIdListEmpty.setIdList("");
        return cardIdListEmpty;
    }

    public static CardPojo createCardEmptyCredential() throws IOException {
        CardPojo cardEmptyCredential = card();
        cardEmptyCredential.setKey("");
        cardEmptyCredential.setToken("");
        return cardEmptyCredential;
    }

    public static CardPojo editCardValid() throws IOException {
        CardPojo cardEditCardValid = card();
        cardEditCardValid.setKey("c6ebc8969b0eea9b92fd61899d05495c");
        cardEditCardValid.setToken("5d658a31140745c12e87aaf0fab9e5a5a08cabc29da7d706108484027c7040e9");
        cardEditCardValid.setDesc("Estudar Inglês de 20h as 21h");
        return cardEditCardValid;
    }

    public static CardPojo editCardIdInvalid() throws IOException {
        CardPojo cardIdInvalid = card();
        cardIdInvalid.setKey("c6ebc8969b0eea9b92fd61899d05495c");
        cardIdInvalid.setToken("5d658a31140745c12e87aaf0fab9e5a5a08cabc29da7d706108484027c7040e9");
        return cardIdInvalid;
    }

    public static CardPojo editCardEmptyCredential() throws IOException {
        CardPojo cardEmptyCredential = card();
        cardEmptyCredential.setKey("");
        cardEmptyCredential.setToken("");
        return cardEmptyCredential;
    }

    public static CardPojo deleteCardEmptyCredential() throws IOException {
        CardPojo cardDeleteCard = card();
        cardDeleteCard.setKey("");
        cardDeleteCard.setToken("");
        return cardDeleteCard;
    }

    public static CardPojo deleteCardValid() throws IOException {
        CardPojo cardDeleteCard = card();
        cardDeleteCard.setKey("c6ebc8969b0eea9b92fd61899d05495c");
        cardDeleteCard.setToken("5d658a31140745c12e87aaf0fab9e5a5a08cabc29da7d706108484027c7040e9");
        return cardDeleteCard;
    }

    public static CardPojo searchCardValid() throws IOException {
        CardPojo cardsearchCard = card();
        cardsearchCard.setKey("c6ebc8969b0eea9b92fd61899d05495c");
        cardsearchCard.setToken("5d658a31140745c12e87aaf0fab9e5a5a08cabc29da7d706108484027c7040e9");
        return cardsearchCard;
    }

    public static CardPojo searchCardEmptyCredential() throws IOException {
        CardPojo cardSearchCard = card();
        cardSearchCard.setKey("");
        cardSearchCard.setToken("");
        return cardSearchCard;
    }
}

