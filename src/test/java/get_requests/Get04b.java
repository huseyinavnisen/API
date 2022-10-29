package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get04b extends RestfulBaseUrl {
      /*
    Given
        https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
    When
        User sends get request to the URL
    Then
        Status code is 200
And
   Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"

 */


    @Test
    public void test01() {
//Set the Url
        spec.pathParam("first", "booking").queryParams("firstname", "Almedin", "lastname", "Alikadic");
//Set The Expected Data
//Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}");
//Do Assertion
        assertEquals(200, response.statusCode());
        assertTrue(response.asString().contains("bookingid"));


    }
}
