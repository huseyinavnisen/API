package get_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get06b extends ReqresBaseUrl {
    /*
      Given
             https://reqres.in/api/unknown/
      When
           I send GET Request to the URL
      Then
           1)Status code is 200
           2)Print all pantone_values
           3)Print all ids greater than 3 on the console
             Assert that there are 3 ids greater than 3
           4)Print all names whose ids are less than 3 on the console
             Assert that the number of names whose ids are less than 3 is 2
   */
    @Test
    public void test1() {
        // set url
        spec.pathParam("first", "unknown");
        // Expected Data
        // Send the request and Get Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        // Do assertion
        JsonPath jsonPath=response.jsonPath();
      // 1)Status code is 200
        assertEquals(response.statusCode(), 200);
      // 2)Print all pantone_values
        System.out.println(jsonPath.getList("data.pantone_value")); // [15-4020, 17-2031, 19-1664, 14-4811, 17-1456, 15-5217]
      // 3)Print all ids greater than 3 on the console
        List<Integer> idler=jsonPath.getList("data.id");

        for (Integer w:idler) {
            if (w>3) System.out.print(w+" ");
        }



      // Assert that there are 3 ids greater than 3
      // 4)Print all names whose ids are less than 3 on the console
      // Assert that the number of names whose ids are less than 3 is 2

    }
}
