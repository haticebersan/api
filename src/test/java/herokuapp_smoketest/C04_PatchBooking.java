package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static herokuapp_smoketest.C01_CreateBooking.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static test_data.HerOKuAppTestData.expectedDataMethod;
import static utils.ObjectMapperUtils.convertJsonToJava;

public class C04_PatchBooking extends HerOkuAppBaseUrl {
     /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
        {
            "firstname" : "Mary",
            "lastname" : "Star"
        }
    When
        Send the patch request
    Then
        Status code is 201
    And
        Response body is:
        {
            "firstname" : "Mary",
            "lastname" : "Star",
            "totalprice" : 111,
            "depositpaid" : true,
            "bookingdates" : {
                "checkin" : "2018-01-01",
                "checkout" : "2019-01-01"
            },
            "additionalneeds" : "Breakfast"
        }

     */
     @Test
     public void patch01() {
         //Set the url
         spec.pathParams("first", "booking", "second", bookingId);
         //Set the expected data
         Map<String, Object> expectedData = expectedDataMethod("Mary","Star",null,null,null,null);
         System.out.println("expectedData = " + expectedData);

         //Send the request and get the response
         Response response = given(spec).body(expectedData).patch("{first}/{second}");
         response.prettyPrint();
         //Do assertion
         Map<String, Object> actualData = convertJsonToJava(response.asString(), HashMap.class);
         System.out.println("actualData = " + actualData);

         assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
         assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
     }
}
