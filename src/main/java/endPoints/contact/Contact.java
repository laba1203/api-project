package endPoints.contact;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import dataObjects.contact.ContactData;
import endPoints.AbstractResource;
import services.contacts.Contacts;
import util.TestData;

public class Contact extends AbstractResource {

    private String url;
    private ContactData contactData = new ContactData();

    private String uuidLink;

    public Contact(Response postResponse)
    {
        setContactAttributes(postResponse);
        url = Contacts.getUrl() + "/" + contactData.getId();
        setUrl(url);
    }


    private void setContactAttributes(Response response){
        JsonPath jsonPath = new JsonPath(response.body().print()).setRoot("data");

        contactData.setContactData(
                getString(jsonPath,"info.firstName"),
                getString(jsonPath,"info.lastName"),
                getString(jsonPath,"info.email"),
                getString(jsonPath,"id")
        );
    }

    private String getString(JsonPath jsonPath, String path){
        String jsonaValue = jsonPath.getString(path);
        int size = jsonaValue.toCharArray().length;
        return jsonaValue.substring(1, size-1);
    }

    public Response put(String firstName, String lastName, String email){ // TODO All API methods (POST, GET, PUT, DELETE, etc.) for one type of resources (contacts) should be within one API definition file.
    //TODO same as for POST you nee dto have one input BODY object instead of separate fields
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(TestData.getPutBody(firstName, lastName, email)).
                        when().
                        post(url);
        setContactAttributes(get());
        return response;
    }

    public Response patch(String key, String value){ // TODO All API methods (POST, GET, PUT, DELETE, etc.) for one type of resources (contacts) should be within one API definition file.
    //TODO same as for POST you nee dto have one input BODY object instead of separate fields
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(TestData.getPatchBody(key, value)).
                        when().
                        patch(url);
        setContactAttributes(get());

        return response;
    }



    public ContactData getContactData(){
        return contactData;
    }
}
