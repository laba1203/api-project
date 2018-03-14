package dataObjects.contact;

public class ContactData {

    private String firstName;
    private String lastName;
    private String email;
    private String id;

    public ContactData(){

    }

    public void setContactData(String firstName, String lastName, String email, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
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
