package basicTest;

import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RestAssuredBasic {

    @Test
    public void  createProject(){
        given()
                .auth()
                .preemptive()
                .basic("ucb@ucb2021.com", "12345")
                .body(new File("C:\\Projects\\diplomado\\ucb_rest_apiTarea2\\src\\test\\resources\\projectBody.json"))
                .log()
                .all()
                .when()
                .post("http://todo.ly/api/items.json")
                .then()
                .log()
                .all();
    }

}
