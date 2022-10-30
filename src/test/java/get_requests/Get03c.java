package get_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Get03c extends ReqresBaseUrl {
    /*
  Given
      https://reqres.in/api/users/2
  When
      User send GET Request to the URL
  Then
      HTTP Status Code should be 200
  And
      Response format should be “application/json”
  And
      “email” is “janet.weaver@reqres.in”,
  And
      “first_name” is "Janet"
  And
      “last_name” is "Weaver"
  And
      "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
*/
    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        spec.pathParams("first", "users", "second", 2);
        Response response = given().when().spec(spec).get("/{first}/{second}");
        JsonPath jsonPath = response.jsonPath();
        jsonPath.prettyPrint();
        softAssert.assertEquals(200, response.statusCode());
        softAssert.assertEquals("application/json; charset=utf-8", response.contentType());
        softAssert.assertEquals(jsonPath.getString("data.email"), "janet.weaver@reqres.in", "E-Mail Yanlış");
        softAssert.assertEquals(jsonPath.getString("data.first_name"), "Janet", "First Name Yanlış");
        softAssert.assertEquals(jsonPath.getString("data.last_name"), "Weaver", "Last Name Yanlış");
        softAssert.assertEquals(jsonPath.getString("support.text"), "To keep ReqRes free, contributions towards server costs are appreciated!", "Text Yanlış");
        softAssert.assertAll();
    }
}
