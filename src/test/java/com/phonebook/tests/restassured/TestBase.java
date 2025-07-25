package com.phonebook.tests.restassured;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public static String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiYW5hc3Rhc2lpYTIzQGdtYWlsLmNvbSIsImlzcyI6IlJlZ3VsYWl0IiwiZXhwIjoxNzUzOTYxNjE4LCJpYXQiOjE3NTMzNjE2MTh9.kNHb99Uxj_FmmPGsKjoA2xom5jadHxrnvsDgF1q-i1c";
    public static final String AUTHORIZATION = "Authorization";

    @BeforeMethod
    public void init(){
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
        RestAssured.basePath = "v1";
    }
}
