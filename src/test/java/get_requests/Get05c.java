package get_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Get05c extends ReqresBaseUrl {
    /*
   Given
     https://reqres.in/api/unknown/3
   When
       User send a GET request to the URL
   Then
       HTTP Status Code should be 200
   And
       Response content type is "application/json; charset=utf-8"
   And
       Response body should be like;(Soft Assertion)
   {
   "data": {
       "id": 3,
       "name": "true red",
       "year": 2002,
       "color": "#BF1932",
       "pantone_value": "19-1664"
   },
   "support": {
       "url": "https://reqres.in/#support-heading",
       "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
   }
}
 */
    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        spec.pathParams("first", "unknown", "second", 3);
        Response response = given().when().spec(spec).get("/{first}/{second}");
        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();

        softAssert.assertEquals(response.statusCode(), 200, "Status Code Hatalı");
        softAssert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        softAssert.assertEquals(jsonPath.getInt("data.id"), 3, "ID Hatalı");
        softAssert.assertEquals(jsonPath.getString("data.name"), "true red", "NAME Hatalı");
        softAssert.assertEquals(jsonPath.getInt("data.year"), 2002, "YEAR Hatalı");
        softAssert.assertEquals(jsonPath.getString("data.color"), "#BF1932", "COLOR Hatalı");
        softAssert.assertEquals(jsonPath.getString("data.pantone_value"), "19-1664", "PANTONE Hatalı");
        softAssert.assertEquals(jsonPath.getString("support.url"), "https://reqres.in/#support-heading", "URL Hatalı");
        softAssert.assertEquals(jsonPath.getString("support.text"), "To keep ReqRes free, contributions towards server costs are appreciated!", "TEXT Hatalı");
        softAssert.assertAll();
    }
}
