package testcases;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import javax.print.attribute.standard.RequestingUserName;

public class GetReqAssignTest {
    //Reqres Get TestCases
    @Test
    public void get_request_Reqres_Single_User() {
        RestAssured.baseURI = "https://reqres.in/";

        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/users/2");
        System.out.println(response.statusLine());
        System.out.println(response.statusCode());

        // Headers
        Headers headers = response.headers();
        String allHeaders = headers.toString();
        System.out.println(allHeaders);

        String contentType = response.headers().getValue("Content Type");
        System.out.println("This is the content: " + contentType);

        String totalPages = response.headers().getValue("Total");
        System.out.println("This is total pages: " + totalPages);

        String total = response.headers().getValue("Total");
        System.out.println("This is total: " + total);

        //Body
        String payload = response.getBody().asString();
        System.out.println(payload);
        String adCompVal = JsonPath.read(payload, "$.ad.company");
        String adUrl = JsonPath.read(payload, "$.url");
        String adText = JsonPath.read(payload, "url");

        System.out.println("This is the company: " + adCompVal);
        System.out.println("This is the url: " + adUrl);
        System.out.println("This is the text: " + adText);
    }

    @Test
    public void get_request_List_Users() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/users?page=2");

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());

        // Header
        Headers headers = response.headers();
        String allHeaders = headers.toString();
        System.out.println(allHeaders);

        String transferEncoding = response.headers().getValue("Transfer-Encoding");
        System.out.println("This is: " + transferEncoding);

        String connection = response.headers().getValue("connection");
        System.out.println("This is: " + connection);

        String setCookie = response.headers().getValue("Set-Cookie");
        System.out.println("Cookie is: " + setCookie);

        // Body
        String payload = response.body().asString();
        response.body().prettyPrint();
        String email1 = JsonPath.read(payload, "$.data[0].email");
        System.out.println("First email is: " + email1);

        String email2 = JsonPath.read(payload, "$.data[1].email");
        System.out.println("Second email is: " + email2);

        String email3 = JsonPath.read(payload, "$.data[2].email");
        System.out.println("Third email is: " + email3);

    }

    @Test
    public void get_request_Single_User() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/users/23");
        System.out.println(response.statusLine());
        System.out.println(response.statusCode());

        // Headers
        Headers headers = response.headers();
        String allHeaders = headers.toString();
        System.out.println(allHeaders);
        String cacheControl = response.headers().getValue("Cache-Control");
        System.out.println("This is the Cache-Control value " + cacheControl);
        String cfCacheStatus = response.headers().getValue("CF-Cache-Status");
        System.out.println("This is the CF-Cache=Control value: " + cfCacheStatus);
        String cfRequestId = response.headers().getValue("cf-request-id");
        System.out.println("This is the cf-request-id: " + cfRequestId);

        //Body
        String payload = response.body().asString();
        response.body().prettyPrint();


    }

    // Countries
    @Test
    public void get_request_practice4() {
        RestAssured.baseURI = "https://restcountries.eu";
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/rest/v2/name/India");
        System.out.println(response.statusCode());
        System.out.println(response.statusLine());

        // Headers

        Headers headers = response.headers();
        String allHeaders = headers.toString();
        System.out.println(allHeaders);
        String contentType = response.headers().getValue("Content-Type");
        System.out.println("This is the Content_Type: " + contentType);
        String transfer = response.headers().getValue("Transfer");
        System.out.println("This is the Transfer: " + transfer);
        String connection = response.headers().getValue("Connection");
        System.out.println("This is the Connection " + connection);

        // Body
        String payload = response.body().asString();
        response.body().prettyPrint();

        String name1 = JsonPath.read(payload, "$[0].name");
        System.out.println("This is the Name1: " + name1);


    }

    @Test
    public void get_request_practice5() {
        RestAssured.baseURI = "https://restcountries.eu";
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("rest/v2/name/eesti");
        System.out.println(response.statusCode());
        System.out.println(response.statusLine());

        // Headers

        Headers headers = response.headers();
        String allHeaders = headers.toString();
        System.out.println(allHeaders);
        String setCookie = response.headers().getValue("Set-Cookie");
        System.out.println("This is the Set_Cookie: " + setCookie);
        String accessControlAllowMethod = response.headers().getValue("Access-Control-Allow-Methods");
        System.out.println("This is the Access-Control-Allow-Methods: " + accessControlAllowMethod);
        String accessControlHeaders = response.headers().getValue("Access-Control-Allow-Headers");
        System.out.println("This is the Access-Control-Allow-Headers " + accessControlHeaders);

        // Body
        String payload = response.body().asString();
        response.body().prettyPrint();

        String name2 = JsonPath.read(payload, "$[0].name");
        //System.out.println("This is the Name3: " + name2);
        //String nativeName1 = JsonPath.read(payload,"$.");

    }

    @Test
    public void get_request_practice6() {
        RestAssured.baseURI = "https://restcountries.eu";
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("rest/v2/name/united");
        System.out.println(response.statusCode());
        System.out.println(response.statusLine());

        // Headers

        Headers headers = response.headers();
        String allHeaders = headers.toString();
        System.out.println(allHeaders);
        String cacheControl = response.headers().getValue("Cache-Control");
        System.out.println("This is the Cache-Control: " + cacheControl);

        String cfCacheStatus = response.headers().getValue("CF-Cache-Status");
        System.out.println("This is the CF-Cache-Status : " + cfCacheStatus);

        String cfRequestId = response.headers().getValue("cf-request-id");
        System.out.println("This is the cf-request-id:  " + cfRequestId);

        // Body
        String payload = response.body().asString();
        response.body().prettyPrint();

        String name2 = JsonPath.read(payload, "$.name.[2].name");
        System.out.println("This is the Name3: " + name2);

    }

    @Test
    public void get_request_practice7() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/users?page=2");

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());

        // Header
        Headers headers = response.headers();
        String allHeaders = headers.toString();
        System.out.println(allHeaders);

        String transferEncoding = response.headers().getValue("Transfer-Encoding");
        System.out.println("This is: " + transferEncoding);

        String connection = response.headers().getValue("connection");
        System.out.println("This is: " + connection);

        String setCookie = response.headers().getValue("Set-Cookie");
        System.out.println("Cookie is: " + setCookie);

        // Body
        String payload = response.body().asString();
        response.body().prettyPrint();
        String firstName1 = JsonPath.read(payload, "$.data[0].first_name");
        System.out.println("First name is: " + firstName1);

        String secondName2 = JsonPath.read(payload, "$.data[1].first_name");
        System.out.println("Second name is: " + secondName2);

        String thirdName3 = JsonPath.read(payload, "$.data[2].first_name");
        System.out.println("Third name is: " + thirdName3);


    }
    @Test
    public void get_request_practice8() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/unknown/23");

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());

        // Header
        Headers headers = response.headers();
        String allHeaders = headers.toString();
        System.out.println(allHeaders);

        String transferEncoding = response.headers().getValue("Transfer-Encoding");
        System.out.println("This is: " + transferEncoding);

        String connection = response.headers().getValue("connection");
        System.out.println("This is: " + connection);

        String setCookie = response.headers().getValue("Set-Cookie");
        System.out.println("Cookie is: " + setCookie);

        // Body
        String payload = response.body().asString();
        response.body().prettyPrint();


    }

    @Test
    public void get_request_practice9() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/unknown/2");

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());

        // Header
        Headers headers = response.headers();
        String allHeaders = headers.toString();
        System.out.println(allHeaders);

        String transferEncoding = response.headers().getValue("Transfer-Encoding");
        System.out.println("This is: " + transferEncoding);

        String connection = response.headers().getValue("connection");
        System.out.println("This is: " + connection);

        String setCookie = response.headers().getValue("Set-Cookie");
        System.out.println("Cookie is: " + setCookie);

        // Body
        String payload = response.body().asString();
        response.body().prettyPrint();
        String id = JsonPath.read(payload,"$.data.id");
        System.out.println("This is the first id: " + id);


    }

}