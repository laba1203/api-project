package services.contacts;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import dataObjects.contacts.ContactsList;
import endPoints.AbstractResource;
import org.testng.Assert;
import util.PropertyLoader;
import util.TestData;

public class Contacts extends AbstractResource {
    private ContactsList contactsList;

    private static final String URL = PropertyLoader.loadEnvProperty("address") + PropertyLoader.loadApplicationProperty("resource.contacts");

    public Contacts(){
        setUrl(URL);
    }

    public Response get(String param1, String param2, String param3){

        return RestAssured.get(URL + "?" + param1 + "&" + param2 + "&" + param3);
    }

    public Response post(String firstName, String lastName, String email){
        return RestAssured.given()
                .contentType("application/json")
                .body(TestData.generatePostBody(firstName, lastName, email)).
             when().
                 post(URL);
    }

    public Response post(String firstName, String lastName){
        return  post(firstName, lastName, firstName + "." + lastName + "@gmail.com");
    }



    private void setContactsList(Response response){
        contactsList = new ContactsList(response);
    }


    public static String getUrl(){
        return URL;
    }

    @Override
    public Response get(){
        Response out = RestAssured.get(URL);
        setContactsList(out);
        return out;
    }

    public ContactsList getContactsList() {
        if(contactsList == null){
            Assert.fail("FAILED: Contacts List is null");
        }
        return contactsList;
    }
}
