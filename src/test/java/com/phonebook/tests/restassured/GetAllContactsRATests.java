package com.phonebook.tests.restassured;

import com.phonebook.dto.AllContactsDto;
import com.phonebook.dto.ContactDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllContactsRATests extends TestBase{

    @Test
    public void getAllContactsSuccess(){
        AllContactsDto contacts = given()
                .header(AUTHORIZATION, TOKEN)
                .when()
                .get("contacts")
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(AllContactsDto.class);
        for(ContactDto contactDto:contacts.getContacts()){
            System.out.println(contactDto.getId()+"*******"+contactDto.getName());
        }

    }
}
// надо добавить контакт из постмана
// Contact was added! ID: 41ab4fcc-10c6-439b-a806-4fe7e092c757