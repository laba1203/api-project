import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import org.json.JSONArray;

import static com.jayway.restassured.RestAssured.get;

public class Healthcheck extends AbstractResource{

    private String url = "http://192.168.1.102:8182/healthcheck";

    public Healthcheck(){
        setUrl(url);
    }



}
