package get_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get02c extends ReqresBaseUrl {
    /*
    Given
        https://reqres.in/api/users/23
    When
        User send a GET Request to the url
    Then
        HTTP Status code should be 404
    And
        Status Line should be HTTP/1.1 404 Not Found
    And
        Server is "cloudflare"
    And
        Response body should be empty
 */
    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        spec.pathParams("first", "users", "second", 23);
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        softAssert.assertEquals(404, response.statusCode());
        softAssert.assertEquals("HTTP/1.1 404 Not Found", response.statusLine());
        softAssert.assertEquals("application/json; charset=utf-8",response.contentType());

        softAssert.assertAll();


    }

}
