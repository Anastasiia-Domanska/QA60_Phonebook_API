package com.phonebook.tests.restassured;

import com.phonebook.dto.ContactDto;
import com.phonebook.dto.ErrorDto;
import io.restassured.http.ContentType;
import org.apache.http.auth.AUTH;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class DeleteContactRATests extends TestBase {

    String id;

    @BeforeMethod
    public void precondition(){

        ContactDto contactDto = ContactDto.builder()
                .name("Carl")
                .lastName("Agg")
                .email("carl1@gmail.com")
                .phone("0123456789")
                .address("Berlin")
                .description("QA")
                .build();
        String message = given()
                .header(AUTHORIZATION, TOKEN)
                .body(contactDto)
                .contentType(ContentType.JSON)
                .post("contacts")
                .then()
                .extract().path("message");
        //System.out.println(message);
        // получить контакт с айди
        // Contact was added! ID: 41ab4fcc-10c6-439b-a806-4fe7e092c757

        String[] split = message.split(": ");
        id = split[1];
    }

    @Test
    public void deleteContactSuccessTest(){
        //String message =
                given()
                .header(AUTHORIZATION, TOKEN)
                .when()
                .delete("contacts/" + id)
                .then()
                .assertThat().statusCode(200)
                //.extract().path("message");
                        .assertThat().body("message", equalTo("Contact was deleted!"));
        //System.out.println(message);
        // Contact was deleted!
    }

    @Test
    public void deleteContactByWrongId(){
        ErrorDto errorDto =
                 given()
                .header(AUTHORIZATION, TOKEN)
                .when()
                .delete("contacts/446bfc95-b9fb-4ec0-add8-33fc68d5ccd3")
                .then()
                .assertThat()
                .statusCode(400)
                .extract().body().as(ErrorDto.class);
                //.assertThat().body("message", containsString("not found in your contacts!"));
        System.out.println(errorDto.getMessage());
        //Contact with id: 446bfc95-b9fb-4ec0-add8-33fc68d5ccd3 not found in your contacts!
    }
}
