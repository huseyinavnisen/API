package get_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Get06c extends ReqresBaseUrl {
    /*
Given
     https://reqres.in/api/unknown/
When
   I send GET Request to the URL
Then
   1)Status code is 200
   2)Print all pantone_value
   3)Print all ids greater than 3 on the console
     Assert that there are 3 ids greater than 3
   4)Print all names whose ids are less than 3 on the console
     Assert that the number of names whose ids are less than 3 is 2
*/

    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        spec.pathParam("first", "unknown");
        Response response = given().when().spec(spec).get("/{first}");
        JsonPath jsonPath = response.jsonPath();
        response.prettyPrint();
        softAssert.assertEquals(response.getStatusCode(), 200, "Status Code Hatalı");
        List<String> pantoneValueList = jsonPath.getList("data.pantone_value");
        System.out.println("Pantone listi" + pantoneValueList.toString());
        List idList = jsonPath.getList("data.id");
        System.out.println("id List() = " + idList.toString());


        softAssert.assertAll();
    }


}

