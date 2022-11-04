package get_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;


public class Get07c extends JsonplaceholderBaseUrl {
    /*
    Given
          https://jsonplaceholder.typicode.com/todos
  When
      I send GET Request to the URL == > URL'e Get Request gonderin
  Then
      1)Status code is 200 == > Status kodu 200 olmali
      2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
        Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin
      3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
        Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
      4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
        Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
        basliginin "delectus aut autem" icerdigini dogrulayin
 */
    @Test
    public void test1() {
        spec.pathParam("first", "todos");
        Response response = given().spec(spec).when().get("/{first}");

        JsonPath jsonPath = response.jsonPath();
        jsonPath.prettyPrint();
        // id >190 olanları ekranda yazdır
        // 1.yol
        List<Integer> idList = jsonPath.getList("id");
        // System.out.println("idList = " + idList);
        for (int i = 0; i < idList.size(); i++) {
            if (idList.get(i) > 190) System.out.print(idList.get(i) + " ");
        }
        System.out.println();
        // id >190 olanları ekranda yazdır
        // 2.yol
        List<Integer> idList190Buyuk = jsonPath.getList("findAll{it.id>190}.id");
        System.out.println("id'si 190'dan büyük olanlar= " + idList190Buyuk);

        //10 tane id nin 190 dan buyuk oldugunu dogrulayin
        assertEquals(10, idList190Buyuk.size());

        // id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
        List<Integer> idList5tenKucuk = jsonPath.getList("findAll{it.id<5}.userId");
        System.out.println("id'si 5ten Küçük olan UserID'ler = " + idList5tenKucuk);

        //id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
        assertEquals("id'si 5'ten büyük olanların sayisi 4 adet değil", 4, idList5tenKucuk.size());

        // ıd si 5 den kucuk olan tum basliklari yazdirin
        List<String> textListid5tenKucuk = jsonPath.getList("findAll{it.id<5}.title");
        System.out.println("textListid5tenKucuk = " + textListid5tenKucuk);

        // id si 5 den kucuk olan datalarin birinin basliginin "delectus aut autem" icerdigini dogrulayin
        assertTrue(textListid5tenKucuk.contains("delectus aut autem"));

    }
}
