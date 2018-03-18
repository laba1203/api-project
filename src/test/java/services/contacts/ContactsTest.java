package services.contacts;

import com.jayway.restassured.response.Response;
import dataObjects.contact.ContactData;
import endPoints.contact.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.TestData;

public class ContactsTest {
    private Contacts contacts = new Contacts();
    private Response postResponse;
    private String firstName = "first_name" + TestData.random();
    private String lastName = "last_name" + TestData.random();
    private String email = firstName + "." + lastName + "@gmail.com";
    private String id;

    private Contact contact;



    @Test
    public void test1_checkPostResponseBody(){
        postResponse = contacts.post(firstName, lastName);
        contact = new Contact(postResponse);
        id = contact.getContactData().getId();
        ContactData data = contact.getContactData();

        Assert.assertEquals(
                data.getFirstName() + ", " + data.getLastName() + ", " + data.getEmail(),
                firstName + ", " + lastName + ", " + email
        );
    }

    @Test
    public void test2_checkResponseStatus(){
        Assert.assertEquals(postResponse.getStatusLine(), "HTTP/1.1 201 Created");
    }

    @Test
    public void test3_getContacts(){
        Response getResp = contacts.get();
        Assert.assertEquals(contacts.get().getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test
    public void test4_getContact(){
        Response getResp = contacts.get(firstName, lastName, email);
        Assert.assertEquals(contacts.get().getStatusLine(), "HTTP/1.1 200 OK");
        System.out.print("LOG: ");
        getResp.body().print();
    }

    @Test
    public void test5_updateContact(){
        Response response = contact.put("NewName", "NewLName", "test@t.com");
        System.out.print("LOG: ");
        response.body().print();
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test
    public void test6_patchContact(){
        Response response = contact.patch("firstName", "UpdateName");
        System.out.print("LOG: ");
        response.body().print();
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test
    public void test7_delete(){
        Response response = contact.delete();
        System.out.print("LOG: ");
        response.body().print();

        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test
    public void test8_checkThatContactDeleted(){
        Response response = contact.get();
        System.out.print("LOG: ");
        response.body().print();

        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 404 Not Found");
    }

}




