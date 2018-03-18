package dataObjects.contact;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import endPoints.contact.Contact;

public class ContactData {

    private String firstName;
    private String lastName;
    private String email;
    private String id;

    public ContactData(){

    }

    public ContactData setContactData(String firstName, String lastName, String email, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;

        return this;
    }

    public ContactData setContactData(Response response){
        JsonPath jsonPath = new JsonPath(response.body().print()).setRoot("data");
        firstName = jsonPath.getString("info.firstName");
        lastName = jsonPath.getString("info.lastName");
        email = jsonPath.getString("info.email");
        id = jsonPath.getString("id");

        return this;
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }


    public void printContactData(){
        System.out.println("<<------- endPoints.contact.ContactData Details ----->>");
        System.out.println("firstName: " + getFirstName());
        System.out.println("lastName: " + getLastName());
        System.out.println("email: " + getEmail());
        System.out.println("id: " + getId());
        System.out.println("<<---- ---- ---- ---- ---- ---->>\r\n");
    }
}
