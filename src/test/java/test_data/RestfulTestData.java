package test_data;

import java.util.HashMap;
import java.util.Map;

public class RestfulTestData {
   public Map<String, Object> bookingDatesMethod(String checkin,String checkout){
        Map<String,Object> expectedDataBookingdates=new HashMap<>();
        expectedDataBookingdates.put("checkin",checkin);
        expectedDataBookingdates.put("checkout",checkout);

        return expectedDataBookingdates;


    }
   public Map<String,Object>expectedDataMethod(String firstname,String lastname,Integer totalprice,Map<String,Object> bookingdates,String additionalneeds){
        Map<String,Object> expectedDataAll=new HashMap<>();
        expectedDataAll.put("firstname",firstname);
        expectedDataAll.put("lastname",lastname);
        expectedDataAll.put("totalprice",totalprice);
        expectedDataAll.put("bookingdates",bookingdates);
        expectedDataAll.put("additionalneeds",additionalneeds);

        return expectedDataAll;
    }
}
