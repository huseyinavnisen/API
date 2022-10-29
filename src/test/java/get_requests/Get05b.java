package get_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class Get05b extends ReqresBaseUrl {
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
    public void test1() {
        //Set the Url
        spec.pathParams("first", "unknown", "second", 3);
        //Set The Expected Data
        //Send The Request and Get The Response
        RequestSpecification given = given();
        given.spec(spec);
        given.when();
        Response response= given.get("/{first}/{second}");
        response.prettyPrint();
        //Do Assertion
        SoftAssert softAssert=new SoftAssert();
        JsonPath jsonPath=response.jsonPath(); // json path tipine dönüştürüldü
        System.out.println(jsonPath.getInt("data.id")); // 3

        softAssert.assertEquals(response.statusCode(),200);
        softAssert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        softAssert.assertEquals(jsonPath.getInt("data.id"),3,"ID değeri Yanlış");
        softAssert.assertEquals(jsonPath.getString("data.name"),"true red","Name Yanlış");
        softAssert.assertEquals(jsonPath.getInt("data.year"),2002,"Tarih Yanlış");
        softAssert.assertEquals(jsonPath.getString("data.color"),"#BF1932","Color Yanlış");
        softAssert.assertEquals(jsonPath.getString("data.pantone_value"),"19-1664","Pantone Value Yanlış");
        softAssert.assertEquals(jsonPath.getString("support.url"),"https://reqres.in/#support-heading","Url Yanlış");
        softAssert.assertEquals(jsonPath.getString("support.text"),"To keep ReqRes free, contributions towards server costs are appreciated!","Text Yanlış");
        softAssert.assertAll();// Mutlaka Kullamılmalı. Hata Verir yoksa
    }
}
