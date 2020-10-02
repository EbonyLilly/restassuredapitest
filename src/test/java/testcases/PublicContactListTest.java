package testcases;

import commons.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class PublicContactListTest extends ApiConfig{
    @Test
    public void register_single_user() {
        String payload = "{" +
                "    \"email\": \"ebony123@yahoo.com\"," +
                "    \"password\": \"SuperSecretPassword123\"" +
                "}";

        RestAssured.baseURI = "https://craftplacer.trexion.com";
        RequestSpecification spec = RestAssured.given();
        spec.header("Content-Type", "Application/Json");
        spec.body(payload);
        Response response = spec.post("/pcl/auth/register");
        System.out.println(response.statusLine());
    }

    @Test
    public void register_single_user_file_payload(){
        String path = System.getProperty("user.dir") + "/src/test/resources/payloads/newUser.json";
        String payload = read(path).trim();

        RestAssured.baseURI = "https://craftplacer.trexion.com";
        RequestSpecification spec = RestAssured.given();
        spec.header("Content-Type", "Application/Json");
        spec.body(payload);

        System.out.println("PAYLOAD: >" + payload);
        Response response = spec.post("/pcl/auth/register");
        System.out.println(response.statusLine());

    }

    @Test
    public void login_registered_user_extract_sessionToken(){
       String payload ="{" +
               "    \"email\": \"user123@yahoo.com\"," +
               "    \"password\": \"SuperSecretPassword123\"" +
               "}";

        RestAssured.baseURI = "https://craftplacer.trexion.com";
        RequestSpecification spec = RestAssured.given();
        spec.headers("Content-Type", "application/json");
        spec.body(payload);
        Response response = spec.post("pcl/auth/login");
        System.out.println(response.getStatusLine());
        String sessionToken = response.body().asString();
        System.out.println(sessionToken);

    }
    @Test
    public void logout_single_user(){
        // login a user
        String path = System.getProperty("user.dir") + "/src/test/resources/payloads/newUser.json";
        String payload = read(path).trim();

        RestAssured.baseURI = base_uri;
        Response responseWeGot = RestAssured.given()
                .contentType("Application/json")
                .body(payload)
                .post("pcl/auth/login");
        String sessionToken = responseWeGot.getBody().asString();

        // login out a single login in user
        RestAssured.given()
                .header("Authorization", sessionToken)
                .get("/pcl/auth/logout");

        System.out.println("Response status line:  " + responseWeGot.getStatusLine());

    }

}
