package testcases;

import com.jayway.jsonpath.JsonPath;
import commons.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ContactListDocTest extends ApiConfig {
    @Test
    public void get_contact_list() {
        RestAssured.baseURI = baseContactList_uri;
        Response response = RestAssured.given()
                .accept("Application/json")
                .get("/contacts");
        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();
    }

    @Test
    public void add_contact() {
        //5f7099ab170734047657d61e
        String path = System.getProperty("user.dir") + "/src/test/resources/payloads/newContactList.json";
        String payload = read(path).trim();

        RestAssured.baseURI = baseContactList_uri;
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post("/contacts");
        System.out.println(response.getStatusLine());
        System.out.println(response.getStatusCode());
        response.getBody().prettyPrint();
    }

    @Test
    public void get_contact_id() {
        String payload = getPayload("newContactListID");
        RestAssured.baseURI = baseContactList_uri;
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post("/contacts");
        String payloadFromResponse = response.getBody().asString();
        String id = JsonPath.read(payloadFromResponse, "$._id");
        System.out.println(id);

        String endpoint = "/contacts/" + id;
        Response getResponseContactList = RestAssured.given()
                .get(endpoint);
        System.out.println(getResponseContactList.getStatusCode());
        System.out.println(getResponseContactList.getStatusLine());
        response.getBody().prettyPrint();
    }

    @Test
    public void add_update_contact(){
        String path = System.getProperty("user.dir") + "/src/test/resources/payloads/newContactList.json";
        String payload = read(path).trim();

        RestAssured.baseURI = baseContactList_uri;
        Response response = RestAssured.given()
                .header("Content-Type", "Application/json")
                .body(payload)
                .put("/contacts/5f7099ab170734047657d61e");
                

        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();
    }
    @Test
    public void delete_contact(){
        RestAssured.baseURI = baseContactList_uri;
        Response response = RestAssured.given()
                .delete("/contacts/5f46249e17073404765782ef");
        System.out.println(response.getStatusLine());
        System.out.println(response.getStatusCode());
        response.getBody().prettyPrint();

    }

}
