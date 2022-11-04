package get_requests;
import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
public class Get08c extends JsonplaceholderBaseUrl {
      /*
     Given
        https://jsonplaceholder.typicode.com/todos/2
    When
        I send GET Request to the URL
    Then
        Status code is 200
        And "completed" is false
        And "userId" is 1
        And "title" is "quis ut nam facilis et officia qui"
        And header "Via" is "1.1 vegur"
        And header "Server" is "cloudflare"
        {
            "userId": 1,
            "id": 2,
            "title": "quis ut nam facilis et officia qui",
            "completed": false
        }
 */
    @Test
    public void test01() {
        spec.pathParams("first", "todos", "second", 2);
        Response response = given().when().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

    }
}
