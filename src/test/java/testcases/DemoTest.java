package testcases;

import commons.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.net.URI;

public class DemoTest extends ApiConfig {
    @Test
    public void practiceTest(){
        String url = "https://reqres.in/api/users/2";
        RestAssured
                .given()
                    .get(url)
                    .andReturn()
                    .getBody()
                    .prettyPrint();

    }
    //2nd
    @Test
    public void practiceTest2(){
        String url = "https://swapi.dev/api/people/1/";
        Response response = RestAssured.given()
                .get(url)
                .andReturn();
       response.getBody().prettyPrint();

    }
    @Test
    public void practiceTest3() {
        RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification spec = RestAssured.given();
        Response response = spec.request(Method.GET, "/api/users/2");
        String headers = response.headers().toString();
    }

}
