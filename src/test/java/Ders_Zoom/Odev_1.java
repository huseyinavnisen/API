package Ders_Zoom;

import base_urls.AutomationExercieseBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Odev_1 extends AutomationExercieseBaseUrl {
    /*
 Given
     https://automationexercise.com/api/productsList
 When
     User sends a GET Request to the url
 Then
     HTTP Status Code should be 200
 And
     Content Type should be "text/html; charset=utf-8"
 And
     Status Line should be HTTP/1.1 200 OK
 And
      There must be 12 Women, 9 Men, 13 Kids usertype in products
   */
    @Test
    public void test1() {
//Set the Url
//Set The Expected Data
//Send The Request and Get The Response
//Do Assertion
        SoftAssert softAssert = new SoftAssert();
        spec.pathParams("first", "api", "second", "productsList");
        Response response = given().spec(spec).when().get("/{first}/{second}");
        JsonPath jsonPath = response.jsonPath();
        // jsonPath.prettyPrint();

        // 1. Yol. Tek lis oluşturma

        List<String> usertypeListi = jsonPath.getList("products.category.usertype.usertype"); // JSON bodysinin usertype içeriği Liste eklendi
               int womenSayisi = 0, menSayisi = 0, kidsSayisi = 0;
        for (int i = 0; i < usertypeListi.size(); i++) {
            if (usertypeListi.get(i).equals("Women")) womenSayisi++;
            if (usertypeListi.get(i).equals("Men")) menSayisi++;
            if (usertypeListi.get(i).equals("Kids")) kidsSayisi++;
        }
        softAssert.assertEquals(12, womenSayisi, "Women Sayisi 12 değil");
        softAssert.assertEquals(9, menSayisi, "Men Sayisi 9 değil");
        softAssert.assertEquals(13, kidsSayisi, "Çocuk Sayisi 13 değil");

        softAssert.assertEquals(200, response.getStatusCode(), "Status Code HATALI");
        softAssert.assertEquals("text/html; charset=utf-8", response.getContentType(), "Content Type HATALI");
        softAssert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine(), "Get Status Line HATALI");
        softAssert.assertAll();


        // 2. Yol. Her Tür için ayrı ayrı List oluşturma
        List<String> womenList = jsonPath.getList("products.category.usertype.findAll{it.usertype=='Women'}.usertype");
        List<String> menList = jsonPath.getList("products.category.usertype.findAll{it.usertype=='Men'}.usertype");
        List<String> kidsList = jsonPath.getList("products.category.usertype.findAll{it.usertype=='Kids'}.usertype");
        softAssert.assertEquals(12,womenList.size(),"Women Sayisi 12 değil");
        softAssert.assertEquals(9,menList.size(),"Men Sayisi 9 değil");
        softAssert.assertEquals(13,kidsList.size(),"Çocuk Sayisi 13 değil");


    }
}




