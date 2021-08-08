package basicTest;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CRUDProjectRestApi {

    @Test
    public void crudProjectRestApiItem(){
        //CREACION
        JSONObject body = new JSONObject();
        body.put("Content","Madai_Item5");

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
                .body("Content", equalTo("Madai_Item5"))
                .log()
                .all();

        Integer id = response.then().extract().path("Id");
        System.out.println("***** Content *******:"+ id);
        //ACTUALIZACION
        body.put("Content","Madai_Item5Update");
        response = given()
                .auth()
                .preemptive()
                .basic("ucb@ucb2021.com", "12345")
                .body(body.toString())
                .log()
                .all()
                .when()
                .put("http://todo.ly/api/items/"+id+".json");
        response.then()
                .statusCode(200)
                .body("Content", equalTo("Madai_Item5Update"))
                .log()
                .all();
        //GET
        response = given()
                .auth()
                .preemptive()
                .basic("ucb@ucb2021.com", "12345")
                .log()
                .all()
                .when()
                .get("http://todo.ly/api/items/"+id+".json");
        response.then()
                .statusCode(200)
                .body("Content", equalTo("Madai_Item5Update"))
                .log()
                .all();
        //BORRADO
      /*  response = given()
                .auth()
                .preemptive()
                .basic("ucb@ucb2021.com", "12345")
                .log()
                .all()
        .when()
                .delete("http://todo.ly/api/items/"+id+".json");
        response.then()
                .statusCode(200)
                .body("Content", equalTo("Madai_Item5Update"))
                .body("Deleted", equalTo(true))
                .log()
                .all();*/

    }
}
