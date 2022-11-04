package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get10 extends GoRestBaseUrl {
    /*
  Given
      https://gorest.co.in/public/v1/users/2986
  When
      User send GET Request to the URL
  Then
      Status Code should be 200
  And
      Response body should be like
   {
  "meta": null,
  "data": {
          "id": 2986,
       "name": "Navin Talwar",
       "email": "navin_talwar@mclaughlin.name",
       "gender": "male",
       "status": "inactive"
           }
    }
*/
    @Test
    public void get09() {

//Set the Url
        spec.pathParams("first", "users", "second", 2986);

//Set The Expected Data
        Map<String, String> dataMap = new HashMap<>(); // İçteki Küçük Map
        dataMap.put("name", "Kanaka Jain");
        dataMap.put("email", "kanaka_jain@stark.net");
        dataMap.put("gender", "male");
        dataMap.put("status", "active");

        Map<String, Object> expectedData = new HashMap<>(); // Dıştaki büyük Map
        expectedData.put("meta", null);
        expectedData.put("data", dataMap);


//Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

//Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.get("meta"), actualData.get("meta"));
        assertEquals(dataMap.get("name"), ((Map) (actualData.get("data"))).get("name"));
        assertEquals(dataMap.get("email"), ((Map) (actualData.get("data"))).get("email"));
        assertEquals(dataMap.get("gender"), ((Map) (actualData.get("data"))).get("gender"));
        assertEquals(dataMap.get("status"), ((Map) (actualData.get("data"))).get("status"));

        assertEquals(response.statusCode(),200);

        


    }
}
