package basicTest;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssuredExtract {

    @Test
    public void restAssuredVerification(){
        JSONObject body = new JSONObject();
        body.put("Content","Madai_Item5");

        given()
                .auth()
                .preemptive()
                .basic("ucb@ucb2021.com", "12345")
                .body(body.toString())
                .log()
                .all()
        .when()
                .post("http://todo.ly/api/items.json")
        .then()
                .statusCode(200)
                .body("Content", equalTo("Madai_Item5"))
                .log()
                .all();
    }
    @Test
    public void restAssuredExtractor(){
        JSONObject body = new JSONObject();
        body.put("Content","Madai_Item4");

        Response response = given()
                .auth()
                .preemptive()
                .basic("ucb@ucb2021.com", "12345")
                .body(body.toString())
                .log()
                .all()
        .when()
                .post("http://todo.ly/api/items.json");
        response.then()
                .statusCode(200)
                .body("Content", equalTo("Madai_Item4"))
                .log()
                .all();

        String content = response.then().extract().path("Content");
        System.out.println("***** Content *******:"+ content);
    }
}
