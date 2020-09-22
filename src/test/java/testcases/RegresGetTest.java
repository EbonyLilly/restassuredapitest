package testcases;

import commons.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLOutput;

public class RegresGetTest extends ApiConfig {
    @Test
    public void client_can_get_all_user_status_line() {
        // Test Data
        String baseUrl = "https://reqres.in";
        String endpoint = "/api/users?page=2";
        int expectedStatusCode = 200;
        String expectedProtocolVersion = "HTTP/1.4";

        // Test Steps
        RestAssured.baseURI = baseUrl;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.request(Method.GET, endpoint);
        int actualStatusCode = response.getStatusCode();
        boolean actualProtocol = response.getStatusLine().contains(expectedProtocolVersion);
        String allHeaderInfo = response.getHeaders().toString();


        //Assert.assertEquals(actualStatusCode, expectedStatusCode);

        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(actualStatusCode, expectedStatusCode);
        sAssert.assertTrue(actualProtocol);
        sAssert.assertAll();

        // Assert.assertTrue(actualProtocol);
        // String actualStatusLine = response.getStatusLine();
    }

    @Test
    public void client_can_get_all_user_headers() {
        // Test Data
        String baseUrl = "https://reqres.in";
        String endpoint = "/api/users?page=2";
        String expectedServer = "AWS";
        String expectedConnection = "Keep Alive";
        String expectedContentType = "application/json";


        // Test Steps
        RestAssured.baseURI = baseUrl;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.request(Method.GET, endpoint);

        String actualContentType = response.headers().getValue("Content-Type");
        String actualServer = response.headers().getValue("Server");
        String actualConnection = response.headers().getValue("Connection");


        SoftAssert sAssert = new SoftAssert();
        boolean ret1 = actualContentType.contains(expectedContentType);
        sAssert.assertTrue(ret1);
        boolean ret2 = actualServer.contains(expectedServer);
        sAssert.assertTrue(ret2);
        boolean ret3 = actualConnection.contains(expectedConnection);
        sAssert.assertTrue(ret3);
        sAssert.assertAll();


    }

    @Test
    public void client_can_get_all_user_body() {
        // Test Data
        String baseUrl = "https://reqres.in";
        String endpoint = "/api/users?page=2";

        // Test Steps
        RestAssured.baseURI = baseUrl;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.request(Method.GET, endpoint);

        //Assert.assertEquals(actualStatusCode, expectedStatusCode);

        SoftAssert sAssert = new SoftAssert();

        sAssert.assertAll();

    }

}