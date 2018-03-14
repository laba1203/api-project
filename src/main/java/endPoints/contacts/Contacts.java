package endPoints.contacts;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import endPoints.AbstractResource;
import util.PropertyLoader;

public class Contacts extends AbstractResource {

    private static final String URL = PropertyLoader.loadEnvProperty("address") + PropertyLoader.loadApplicationProperty("resource.contacts");

    public Contacts(){
        setUrl(URL);
    }

    public Response get(String param1, String param2, String param3){
        return RestAssured.get(URL + "?" + param1 + "&" + param2 + "&" + param3);
    }

    public Response post(String firstName, String lastName){
        return RestAssured.given()
                .contentType("application/json")
                .body("{\"email\":\""+ firstName +"."+lastName+"@gmail.com\",\"firstName\":\""+firstName+"\",\"lastName\":\""+lastName+"\"}").
             when().
                 post(URL);

    }



    public static String getUrl(){
        return URL;
    }

}
