package testcases;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GETRequestPracticeTest {
    @Test
    public void get_request_practice1(){
        // 1. Register a base URi where the request will be sent
        RestAssured.baseURI = "https://reqres.in";

        // 2. Specify the request that will be send
       RequestSpecification spec = RestAssured.given();
       Response response = spec.get("/api/users/2");

       // 3. Using the response object let's extract each part
       // of the response (Status line, Headers, Body )
       // System.out.println( response.statusLine() );
        // System.out.println( response.statusCode() );

        // Headers
        Headers headers = response.headers();
        String entireHeaders = headers.toString();
        //System.out.println(entireHeaders);

        String contentType = headers.getValue("Content-Type");
        String server = headers.getValue("Sever");
        String date = headers.getValue("Date");
   //     System.out.println(contentType);
   //     System.out.println(server);
    //    System.out.println(date);

        // Body
        String payload = response.getBody().asString();
        //System.out.println(payload);
        // To
        String emailVal = JsonPath.read(payload,$.data.email );
        String firstNameVal =







    }
}

/*
$.data.email
$.data.first_name
$.data.last_name
$.ad.company
 */