package testcases;

import commons.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class VideoGameDBTest extends ApiConfig {

    @Test
    public void get_all_video_games(){
        RestAssured.baseURI = gameBd_base_uri;
        Response response = RestAssured.given()
                .accept("Application/json")
                .contentType("Application/json")
                .get("/videogames");

        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();
    }
    @Test
    public void register_single_game(){
       String path = System.getProperty("user.dir") + "/src/test/resources/payloads/newgame.json";
       String payload = read(path).trim();


        RestAssured.baseURI = gameBd_base_uri;
        Response response  = RestAssured.given()
                .contentType("Application/json")
                .accept("Application/json")
                .body(payload)
                .post("/videogames");


        System.out.println(response.getStatusLine());
        System.out.println(response.getStatusCode());
        response.getBody().prettyPrint();

    }
    @Test
    public void delete_sinsle_videogame(){
        RestAssured.baseURI = gameBd_base_uri;
        Response response = RestAssured.given()
                .accept("Application/json")
                .delete("/videogames/13");
        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();

    }
    @Test
    public void get_single_game(){
        RestAssured.baseURI = gameBd_base_uri;
        Response response = RestAssured.given()
                .header("Accept", "Application/json")
                .get("/videogames/13");
        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();
    }
    @Test
    public void update_single_game(){
       String payload = getPayload("gameinfo");
        RestAssured.baseURI = gameBd_base_uri;
        Response response = RestAssured.given()
                .contentType("Application/json")
                .header("Accept", "Application/json")
                .body(payload)
                .put("/videogames/10");

        System.out.println(response.getStatusCode());
        response.getBody().prettyPrint();


    }

}
