package allMyTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;



public class TestDm {

    @Test
    public void firstOption(){

        // Send GET request and get the response
        Response response = given().when().get("https://reqres.in/api/users?page=2");

        // Extract the email of the first user from the response
        String result = response.path("data[0].email").toString();

        // Print the result
        System.out.println(result);
    }

    @Test
    public void secondOption(){

        System.out.println("secondOption");
        // Send GET request and get the response
        Response response = given().when().get("https://reqres.in/api/users?page=2");

        // Print the entire response to understand its structure
        System.out.println(response.asString());

        // Extract the email of the first user from the response
        String email = response.path("data[0].email");

        // Print the email
        System.out.println("result is => "+email);
    }
    @Test
    public void secondOption2(){
        System.out.println("secondOption2");
        // Send GET request and get the response
        Response response = given().when().get("https://reqres.in/api/users?page=2");
        JsonPath  jsonPath  = new JsonPath(response.asString());

       String result =  jsonPath.get("data[1].email");
        System.out.println("result is => "+result);


    }
    @Test
    public void thirdOption(){

        System.out.println("thirdOption");
        Response response =  given().get("https://reqres.in/api/users?page=2");
        String result =   JsonPath.from(response.asString()).get("data[3].email");
        System.out.println("result is => "+result);


    }

    @Test
    public void fourthOption(){

        System.out.println("fourthOption");
        Response response =    given().when().get("https://reqres.in/api/users?page=2");
        String result =  response.path("data[3].email");
        System.out.println("result is => "+result);
    }
}
