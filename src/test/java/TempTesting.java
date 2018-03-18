import com.jayway.restassured.response.Response;
import dataObjects.contact.ContactData;
import endPoints.contact.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.contacts.Contacts;

public class TempTesting {
    private Contacts contacts = new Contacts();

    @Test
    public void test1_checkPostResponseBody() {
        String firstName = "name1";
        String lastName = "lastName1";
        String email = "email";

        Response postResponse = contacts.post(firstName, lastName);
        Contact contact = new Contact(postResponse);
        String id = contact.getContactData().getId();
        ContactData data = contact.getContactData();

        Assert.assertEquals(
                data.getFirstName() + ", " + data.getLastName() + ", " + data.getEmail(),
                firstName + ", " + lastName + ", " + email
        );
    }

    @Test
    public void test2(){
        contacts.get().body().print();

    }
}
