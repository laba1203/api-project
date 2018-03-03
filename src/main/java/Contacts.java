import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Contacts extends AbstractResource {

    private static final String url = "http://192.168.1.102:8182/api/v1/contacts";

    public Contacts(){
        setUrl(url);
    }

    public Response get(String param1, String param2, String param3){
        return RestAssured.get(url + "?" + param1 + "&" + param2 + "&" + param3);
    }

    public Response post(String firstName, String lastName){
        return RestAssured.given()
                .contentType("application/json")
                .body("{\"email\":\""+ firstName +"."+lastName+"@gmail.com\",\"firstName\":\""+firstName+"\",\"lastName\":\""+lastName+"\"}").
             when().
                 post(url);

    }



    public static String getUrl(){
        return url;
    }

}
