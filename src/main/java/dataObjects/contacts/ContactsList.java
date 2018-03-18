package dataObjects.contacts;

import com.jayway.restassured.response.Response;
import dataObjects.contact.ContactData;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.ArrayList;

public class ContactsList{
    private ArrayList<ContactData> contactsList;

    public ContactsList(Response response){
         setContactsList(response);
    }

    public ContactsList setContactsList(Response response){
        JSONObject object = new JSONObject(response.body().print());
        JSONArray array = object.getJSONArray("data");
        contactsList = new ArrayList<>();

        for(int i = 0; i< array.length(); i++){
            contactsList.add(new ContactData().setContactData(
                    array.getJSONObject(i).getJSONObject("info").getString("firstName"),
                    array.getJSONObject(i).getJSONObject("info").getString("lastName"),
                    array.getJSONObject(i).getJSONObject("info").getString("email"),
                    String.valueOf(array.getJSONObject(i).getInt("id"))
            ));
        }
        return this;
    }

    public ArrayList<ContactData> getList() {
        isArrayNull();
        return contactsList;
    }

    private void isArrayNull(){
        if(contactsList == null){
            Assert.fail("FAILED: Contacts List array is null");
        }
    }

    public boolean findContact(String id, String firstName, String lastName, String email){
        for (ContactData contact :
                contactsList) {
            if(contact.getId().equals(id)){
                if(compareAttributes(contact, firstName, lastName, email)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findContact(ContactData contact){
        return findContact(contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmail());
    }

    private boolean compareAttributes(ContactData contact, String firstName, String lastName, String email){
        return contact.getFirstName().equals(firstName) &&
                contact.getLastName().equals(lastName) &&
                contact.getEmail().equals(email);
    }



}
