package RestAssured;

import Entity.Credentials;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.Assert.assertEquals;

public class ApiTest {

    @Test
    public void firstApiTest(){
        //baseURI
        RestAssured.baseURI = "https://api.github.com/repos";
//        String apiKey = "c88a8aa98d14b6c618b0d0528e9271f8";
//        String pathParam = "134.201.250.155";
        Response res = given()
                .body("{\"name\":\"deleteMe\"}")
                .auth().oauth2(Credentials.TOKEN)
                .expect().log().all()
                .when()
                .delete("/vdhawan19999/deleteMe2");
        System.out.println(res.getBody().asString());
        ValidatableResponse response = res.then()
                .statusCode(204);
    }

}
