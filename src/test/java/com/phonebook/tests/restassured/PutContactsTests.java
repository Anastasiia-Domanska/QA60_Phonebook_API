package com.phonebook.tests.restassured;

import com.phonebook.dto.ContactDto;
import com.phonebook.dto.PutContactsDto;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutContactsTests extends TestBase {
    static String contactId;

    @BeforeMethod
    public void precondition() {
        ContactDto contactDto = ContactDto.builder()
                .name("Ala")
                .lastName("Loriss")
                .email("ala@gmail.com")
                .phone("1234567890")
                .address("Berlin")
                .description("QA")
                .build();

        String message = given()
                .header(AUTHORIZATION,TOKEN)
                .contentType(ContentType.JSON)
                .body(contactDto)
                .when()
                .post("contacts")
                .then()
                .extract().path("message");

        contactId = message.split(": ")[1];
    }

    @Test
    public void updateContactPositive200Test() {

        PutContactsDto updated = PutContactsDto.builder()
                .id(contactId)
                .name("Ala")
                .lastName("Loriss")
                .email("ala@gmail.com")
                .phone("9876543210")
                .address("Leipzig")
                .description("QA")
                .build();

        given()
                .header(AUTHORIZATION,TOKEN)
                .contentType(ContentType.JSON)
                .body(updated)
                .when()
                .put("contacts")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("message", equalTo("Contact was updated"));

    }

    @Test
    public void updateContactUnauthorized401Test() {
        PutContactsDto updated = PutContactsDto.builder()
                .id(contactId)
                .name("Unauthorized")
                .lastName("User")
                .email("unauth@test.com")
                .phone("1234567")
                .address("Unknown")
                .description("Unauthorized update")
                .build();

        given()
                .header(AUTHORIZATION, "Bearer WRONG_TOKEN")
                .contentType(ContentType.JSON)
                .body(updated)
                .when()
                .put("contacts/" + contactId)
                .then()
                .assertThat().statusCode(401);
    }
}
