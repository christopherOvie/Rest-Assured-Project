package allMyTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;


public class TestDmGroovy {

    @Test
    public void firstOption() {
//print first element in array list
        System.out.println("firstOption");
        // Send GET request and get the response
        Response response = given().when().get("https://automationexercise.com/api/productsList");
        JsonPath jsonPath = new JsonPath(response.asString());

        String result = jsonPath.get("products[5].category.usertype.usertype");
        System.out.println("result is => " + result);

    }

    //print last element in array list
    @Test
    public void secondOption() {

        System.out.println("firstOption");
        // Send GET request and get the response
        Response response = given().when().get("https://automationexercise.com/api/productsList");
        JsonPath jsonPath = new JsonPath(response.asString());

        String result = jsonPath.get("products[-1].name");
        System.out.println("result is => " + result);
    }

    @Test
    public void sixthOption() {

        System.out.println("sixthOption");
        // Send GET request and get the response
        Response response = given().when().get("https://automationexercise.com/api/productsList");
        JsonPath jsonPath = new JsonPath(response.asString());

        ArrayList<String> result =  jsonPath.get("products.brand");
       // String result = jsonPath.get("products[5].category.usertype");
        System.out.println("result is => " + result);
    }
//    @Test
//    public void eightOption() {
////print first element in array list
//        System.out.println("firstOption");
//        // Send GET request and get the response
//        Response response = given().when().get("https://automationexercise.com/api/productsList");
//        JsonPath jsonPath = new JsonPath(response.asString());
//
//        String result = jsonPath.get("products.category.usertype.usertype");
//        System.out.println("result is => " + result);
//
//    }

    @Test
    public void secondOption2() {
        System.out.println("secondOption2");
        // Send GET request and get the response
        Response response = given().when().get("https://reqres.in/api/users?page=2");
        JsonPath jsonPath = new JsonPath(response.asString());

        String result = jsonPath.get("products[-1].name");
        System.out.println("result is => " + result);


    }

    @Test
    public void secondOption2b() {
        System.out.println("secondOption2");
        // Send GET request and get the response
        Response response = given().when().get("https://automationexercise.com/api/productsList");
        JsonPath jsonPath = new JsonPath(response.asString());

        ArrayList<String> names =  jsonPath.get("products.brand");
        System.out.println("names of products  => " + names);
        //products.brand


    }

    @Test
    public void thirdOption() {

        System.out.println("thirdOption");
        Response response = given().get("https://reqres.in/api/users?page=2");
        List<String> result = JsonPath.from(response.asString()).get("data.email");
        System.out.println("result is => " + result);


    }
    @Test
    public void fourthOptionA() {

        System.out.println("fourthOption");
        Response response = given().get("https://reqres.in/api/users?page=2");

        List<String>  names =  response.path("data");
        System.out.println("result is => " + names);


    }
    @Test
    public void fourthOption() {

        System.out.println("fourthOption");
        Response response = given().get("https://reqres.in/api/users?page=2");

        ArrayList<HashMap<String,?>> names =  response.path("data");
        System.out.println("result is => " + names.get(1).get("email"));


    }

//    @Test
//    public void fifthOption() {
//
//        System.out.println("fifthOption");
//
//
//        // Send GET request and get the response
//        Response response = given().when().get("https://automationexercise.com/api/productsList");
//
//
//        ArrayList<HashMap<String,?>> names =  response.path("products");
//        System.out.println("names of products  => " + names);
//
//    }
    //using it
    @Test
    public void seventhOption() {
//
        System.out.println("maximum value for id  working");
        // Send GET request and get the response
        Response response = given().get("https://reqres.in/api/users?page=2");
        //JsonPath jsonPath = new JsonPath(response.path("data"));
        HashMap<String,?> maxscore = response.path("data.min{ it.id}");

//        String result = jsonPath.get("products[-1].name");
        System.out.println("result is => " + maxscore);
    }

//    @Test
//    public void eigthOption() {
////
//        System.out.println("eigthOption");
//        // Send GET request and get the response
//        Response response = given().get("https://automationexercise.com/api/productsList");
//        //JsonPath jsonPath = new JsonPath(response.path("data"));
//        HashMap<String,?> maxscore =  response.path("products.max{ it.id}");
//
////        String result = jsonPath.get("products[-1].name");
//        System.out.println("result is => " + maxscore);
//    }

}