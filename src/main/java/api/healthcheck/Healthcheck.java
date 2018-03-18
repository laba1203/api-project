package api.healthcheck;

import endPoints.AbstractResource;
import util.PropertyLoader;

import static com.jayway.restassured.RestAssured.get;

class Healthcheck extends AbstractResource {

    private static final String URL = PropertyLoader.loadEnvProperty("address") + PropertyLoader.loadApplicationProperty("resource.healthcheck");

    Healthcheck(){
        setUrl(URL);
    }



}
