package api.contacts;

import dataObjects.contact.ContactData;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import services.contacts.Contacts;

public class ContactsTest {
    private Contacts contacts = new Contacts();
    private ContactData contactData;


    //post testing:
    @BeforeGroups("post")
    @Test(groups = "post")
    public void postContact(){

    }

    @Test(groups = "post")
    public void test1_checkPostResponseHead(){

    }

    @Test(groups = "post")
    public void test2_checkPostResponseBody(){

    }


    //get testing:
    @BeforeGroups("get")
    public void get(){

    }

    @Test(groups = "get")
    public void test3_checkGetResponseHead(){

    }

    @Test(groups = "get")
    public void test4_checkGetResponseBody(){

    }


    //filtering testing:
    @BeforeGroups("filter")
    public void createSeveralContacts(){

    }

    @Test(groups = "filter")
    public void test4_filterContacts(){

    }


}
