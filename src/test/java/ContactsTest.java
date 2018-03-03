import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsTest {
    private Contacts resource = new Contacts();
    private Response postResponse;
    private String number = String.valueOf(System.currentTimeMillis()).substring(10);
    private String firstName = "first_name" + number;
    private String lastName = "last_name" + number;
    private String email = firstName + "." + lastName + "@gmail.com";
    private String id;

    private Contact contact;



    @Test
    public void test1_checkPostResponseBody(){
        postResponse = resource.post(firstName, lastName);
        contact = new Contact(postResponse);
        id = contact.getId();

        Assert.assertEquals(
                contact.getFirstName() + ", " + contact.getLastName() + ", " + contact.getEmail(),
                firstName + ", " + lastName + ", " + firstName+"."+lastName+"@gmail.com"
        );
    }

    @Test
    public void test2_checkResponseStatus(){
        Assert.assertEquals(postResponse.getStatusLine(), "HTTP/1.1 201 Created");
    }

    @Test
    public void test3_getContacts(){
        Response getResp = resource.get();
        Assert.assertEquals(resource.get().getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test
    public void test4_getContact(){
        Response getResp = resource.get(firstName, lastName, email);
        Assert.assertEquals(resource.get().getStatusLine(), "HTTP/1.1 200 OK");
        getResp.body().print();
    }

    @Test
    public void test5_updateContact(){
        Response response = contact.put("NewName", "NewLName", "test@t.com");
        response.body().print();
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test
    public void test6_patchContact(){
        Response response = contact.patch("firstName", "UpdateName");
        response.body().print();
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test
    public void test7_delete(){
        Response response = contact.delete();
        response.body().print();
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test
    public void test8_checkThatContactDeleted(){
        Response response = contact.get();
        response.body().print();
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 404 Not Found");
    }


}




