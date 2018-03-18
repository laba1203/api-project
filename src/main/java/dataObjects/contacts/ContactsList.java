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


}
