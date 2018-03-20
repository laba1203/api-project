package api.contacts;

import com.jayway.restassured.response.Response;
import dataObjects.contact.ContactData;
import dataObjects.contacts.ContactsList;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import services.contacts.Contacts;
import util.TestData;

public class ContactsTest {
    private Contacts contacts = new Contacts();
    private String firstName = "first_name" + TestData.random();
    private String lastName = "last_name" + TestData.random();
    private String email = "email" + TestData.random() + "@test.com";

    private ContactData contactData;
    private ContactsList contactsList;

    private Response postResponse;
    private Response getResponse;

    //post testing:
    @BeforeGroups("post")
    @Test(groups = "post")
    public void postContact(){
        contactsList = new ContactsList(contacts.get());
        postResponse = contacts.post(firstName, lastName, email);
        contactData = new ContactData().setContactData(postResponse);
    }

    @Test(groups = "post")
    public void test11_checkPostResponseHead(){
        Assert.assertEquals(postResponse.getStatusLine(), "HTTP/1.1 201 Created");
    }

    @Test(groups = "post")
    public void test12_checkPostResponseBody(){
        Assert.assertEquals(
                contactData.getFirstName()+ ", " + contactData.getLastName() + ", " + contactData.getEmail(),
                firstName+ ", " + lastName + ", " + email
        );
    }

    @Test(groups = "post")
    public void test13(){
        Assert.assertEquals(
                new ContactsList(contacts.get()).getList().size(),
                contactsList.getList().size() + 1
        );
    }


    //get testing:
    @BeforeGroups("get")
    public void get(){
        getResponse = contacts.get();
        contactsList = new ContactsList(getResponse);
    }

    @Test(groups = "get")
    public void test21_checkGetResponseHead(){
        Assert.assertEquals(getResponse.getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test(groups = "get")
    public void test22_checkGetResponseBody(){
        Assert.assertEquals(
                contactsList.findContact(contactData),
                true,
                "FAILED: Contact is not found. Contact ID = <" + contactData.getId() + ">"
        );
    }


    //filtering testing:
    @BeforeGroups("filter")
    public void createSeveralContacts(){
        //todo:
    }

    @Test(groups = "filter")
    public void test31_filterContactsByEmail(){
        //todo:
    }

    @Test(groups = "filter")
    public void test32_filterContactsByFirstName(){
        //todo:
    }

    @Test(groups = "filter")
    public void test33_filterContactsByLastName(){
        //todo:
    }

    @Test(groups = "filter")
    public void test34_filterContactsByMultipleAttributes(){
        //todo:
    }


}
