package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    1-Postman, manuel API testleri için kullandık
    2 -Otomasyon testleri içinde Rest Assured Library kullanacağız
    3 - Otomasyon testlerimizi yaparken aşağıdaki adımları izliyoruz.
        a - Gereksinimleri anlamak
        b - Test Case Yazıyoruz
         - Karşımızdakilerde olayı anlasın diye Test Case yazımında "Gherkin" dilini kullanacağız.
                -Given  :Ön Koşullar
                -When  : Yapılacak aksiyonlar (  get(), put(),post(),patch() ve delete() )
                -Then  : İstek yaptıktan ( request gönderdikten sonra) doğrulama için
                - And  : Çoklu işlemerde kullanacağız.
        c - Test kodlarımızı Yazmaya Başlayacağız
            i)  Set the URL,
            ii) Set the expected Data ( beklenen datanın oluşturulması , Post, Put, Patch )
            iii) Type code to send request ( talep göndermek içn kod yazımı )
            iv) Do Assertion ( doğrulama yapmak )
     */

    /*
Given
        https://restful-booker.herokuapp.com/booking/101
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
    public void get01() {
        //  i)  Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/101";

        // ii) Set the expected Data ( beklenen datanın oluşturulması , Post, Put, Patch )
        // Bizden post'ta böyle bir işlem istemediği için bu kısım boş geçiyoruz.

        //iii) Type code to send request ( talep göndermek için kod yazımı )
        Response response = given().when().get(url);
        response.prettyPrint();

        // iv) Do Assertion ( doğrulama yapmak )
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        // Status Code konsola yazdırın
        System.out.println("Status Code :"+response.getStatusCode());

        // Content Type konsola yazdırın
        System.out.println("Content Type  :"+response.getContentType());

        // Status Line konsola yazdırın
        System.out.println("Status Line : "+response.getStatusLine());

        //Header konsola yazdırın
        System.out.println("Header : "+response.getHeader("Server")); // Cowboy

        //Headers konsola yazdırın
        System.out.println("Header : "+response.getHeaders());

        // Time Konsola yazdırın
        System.out.println("Time :"+response.getTime());


    }
}
