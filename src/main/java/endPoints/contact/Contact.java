package endPoints.contact;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import dataObjects.contact.ContactData;
import endPoints.AbstractResource;
import endPoints.contacts.Contacts;

public class Contact extends AbstractResource {

    private String url;
    private ContactData contact = new ContactData();

    private String uuidLink;

    public Contact(Response postResponse)
    {
        setContactAttributes(postResponse);
        url = Contacts.getUrl() + "/" + contact.getId();
        setUrl(url);
    }


    private void setContactAttributes(Response response){

        JsonPath jsonPath = new JsonPath(response.body().print()).setRoot("data");

        contact.setContactData(
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

    public Response put(String firstName, String lastName, String email){
        Response response = RestAssured.given()
                .contentType("application/json")
                .body("{\"email\":\""+email+"\",\"firstName\":\""+firstName+"\",\"lastName\":\""+lastName+"\"}").
                        when().
                        post(url);
        setContactAttributes(get());
        return response;
    }

    public Response patch(String key, String value){
        Response response = RestAssured.given()
                .contentType("application/json")
                .body("{\"" + key +"\":\"" + value + "\"}" ).
                        when().
                        patch(url);
        setContactAttributes(get());

        return response;
    }



    public ContactData getContactData(){
        return contact;
    }
}
