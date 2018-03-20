package api.contact;

import com.jayway.restassured.response.Response;
import dataObjects.contact.ContactData;
import dataObjects.contacts.ContactsList;
import endPoints.contact.Contact;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import services.contacts.Contacts;
import util.TestData;

public class ContactTest {

    private Contacts contacts = new Contacts();
    private String firstName = "first_name" + TestData.random();
    private String lastName = "last_name" + TestData.random();
    private String email = "email" + TestData.random() + "@test.com";
    private Contact contact;
    private ContactsList contactsList;

    private Response getResponse;

    @BeforeClass
    public void createContact(){
        Response postResponse = contacts.post(firstName, lastName, email);
        contact = new Contact(postResponse);
        contactsList = new ContactsList(contacts.get());
    }


    //GET testing
    @BeforeGroups("get")
    public void getContact(){
        getResponse = contact.get();
    }

    @Test(groups = "get")
    public void test11_getContactHead(){
        //todo:
    }

    @Test(groups = "get")
    public void test12_getContactBody(){
        //todo:
    }

    //PUT testing
    @BeforeGroups("putWithAllAttributes")
    public void put(){
        //todo:
    }

    @Test(groups = "putWithAllAttributes")
    public void test21_putHead(){
        //todo:
    }

    @Test(groups = "putWithAllAttributes")
    public void test22_putBody(){
        //todo:
    }

    @Test(groups = "putWithAllAttributes")
    public void test23_getContactAndCheckUpdatedValues(){
        //todo:
    }

    @BeforeGroups("putWithFirstNameOnly")
    public void putWithFirstNameOnly(){
        //todo:
    }
    @Test(groups = "put")
    public void test23_putBody(){
        //todo:
    }

    /*TODO: methods for verification of following cases should be added:
    * 1. Verify PUT with email only
    * 2. Verify PUT with lastName only
    * 3. Negative --> PUT with id
    * 4. PATCH for email
    * 5. PATCH first name
    * 5. PATCH last name
    * 6. Negative --> PATCH id
    * 7. Verify contact values in GET response
    * 8. DELETE contact (check response head and body)
    * 9. Verify that contact is not returned in GET response for contacts
    * 10. Verify that contact is not returned in GET response for UUID
    * 11. Negative --> DELETE contact with incorrect ID
    * */









}
