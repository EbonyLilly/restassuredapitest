package testcases;

import com.jayway.jsonpath.JsonPath;
import groovy.json.JsonOutput;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import utility.Steps;

public class GETRequestPracticeTest {
    @Test
    public void get_request_practice1() {
        // 1. Register a base URi where the request will be sent
        RestAssured.baseURI = "https://reqres.in";

        // 2. Specify the request that will be send
        Steps.log("Preparing a request");
        RequestSpecification spec = RestAssured.given();

        Steps.log("Sending a Get Request to endpoint/api/user/2 and receiving a response");
        Response response = spec.get("/api/users/2");

        // 3. Using the response object let's extract each part
        // of the response (Status line, Headers, Body )
        Steps.log("Response status line is:  " + response.statusLine());

        // Headers
        Headers headers = response.headers();
        String entireHeaders = headers.toString();
        System.out.println(entireHeaders);

        String contentType = headers.getValue("Content-Type");
        String server = headers.getValue("Sever");
        String date = headers.getValue("Date");
        System.out.println(contentType);
        System.out.println(server);
        System.out.println(date);

        // Body
        String payload = response.getBody().asString();
        Steps.logJson(payload);
        //System.out.println(payload);
        // To
        String emailVal = JsonPath.read(payload, "$.data.email");
        String firstNameVal = JsonPath.read(payload, "$.data.first_name");
        String lastNameVal = JsonPath.read(payload, "$.data.last_name");
        String adCompVal = JsonPath.read(payload, "$.ad.company");

        System.out.println("Email:" + emailVal);
        System.out.println("First Name: " + firstNameVal);
        System.out.println("Last Name:  " + lastNameVal);
        System.out.println("Ad Company: " + adCompVal);

    }

}

