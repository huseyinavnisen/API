package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Get04c extends RestfulBaseUrl {
    /*
   Given
       https://restful-booker.herokuapp.com/booking?firstname=Javier&lastname=Colque
   When
       User sends get request to the URL
   Then
       Status code is 200
And
  Among the data there should be someone whose firstname is "Javier" and lastname is "Colque"
*/
    @Test
    public void test1() {
        SoftAssert softAssert = new SoftAssert();

        spec.pathParam("first", "booking").queryParams("firstname", "Javier", "lastname", "Colque");
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        softAssert.assertTrue(response.asString().contains("383"));


    }

}
