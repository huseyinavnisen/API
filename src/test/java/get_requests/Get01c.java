package get_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import jdk.jfr.ContentType;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get01c extends ReqresBaseUrl {
    /*
Given
    https://reqres.in/api/users/3
When
    User sends a GET Request to the url
Then
    HTTP Status Code should be 200
And
    Content Type should be JSON
And
    Status Line should be HTTP/1.1 200 OK
*/
    @Test
    public void test01() {
        // set url
        SoftAssert softAssert = new SoftAssert();
        spec.pathParams("first", "users", "second", 3);
        Response response = given().spec(spec).when().get("/{first}/{second}");

        softAssert.assertEquals(200, response.statusCode());
        softAssert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        softAssert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
        softAssert.assertAll();

    }


}
