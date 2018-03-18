package api.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import services.contacts.Contacts;

public class ContactsNegativeTest {
    private Contacts contacts = new Contacts();

    @Test
    public void test4_option(){
        Assert.assertEquals(contacts.options().statusLine(), "HTTP/1.1 405 Method Not Allowed");
    }

    @Test
    public void test5_head(){
        Assert.assertEquals(contacts.head().statusLine(), "HTTP/1.1 405 Method Not Allowed");
    }
}
