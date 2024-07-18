package allMyTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static   io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestDemo {

    @Test(enabled = false)
  public void testCase0_1(){
//endpoint  https://reqres.in/api/users/2
        //status code  200

        given().log().all().baseUri("https://reqres.in/api").
                when().get("/users/2")
               //.log().all().statusCode(200);
                .then().log().all().assertThat().body("data.first_name",equalTo("Janet"),"data.last_name",equalTo("Weaver"));
                //.body("data.last_name",equalTo("Weaver"));
  }

    @Test
    public void testCase0_2(){
//endpoint  https://reqres.in/api/users/2
        //status code  200

        given().baseUri("https://reqres.in/api").
                when().get("/users/2")
                //.log().all().statusCode(200);
                .then().log().status().assertThat().body("data.first_name",equalTo("Janet"),"data.last_name",equalTo("Weaver"));
        //.body("data.last_name",equalTo("Weaver"));
    }

    @Test
    public void testCase0_3(){
//endpoint  https://reqres.in/api/users/2
        //status code  200

        given().baseUri("https://reqres.in/api").
                when().get("/users/2")
                //.log().all().statusCode(200);
                .then().log().body().assertThat().body("data.first_name",equalTo("Janet"),"data.last_name",equalTo("Weaver"));
        //.body("data.last_name",equalTo("Weaver"));
    }

    @Test
    public void testCase0_4(){
//endpoint  https://reqres.in/api/users/2
        //status code  200

        given().baseUri("https://reqres.in/api").
                when().get("/users/2")

                .then().log().ifValidationFails().assertThat().statusCode(200);

    }

}
