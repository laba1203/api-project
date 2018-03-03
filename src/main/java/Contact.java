
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class Contact extends AbstractResource{

    private String url;

    private String firstName;
    private String lastName;
    private String email;
    private String id;

    private String uuidLink;

    public Contact(Response postResponse)
    {
        setContactAttributes(postResponse);
        url = Contacts.getUrl() + "/" + id;
        setUrl(url);
    }


    private void setContactAttributes(Response response){

        JsonPath jsonPath = new JsonPath(response.body().print()).setRoot("data");
        firstName = getString(jsonPath,"info.firstName");
        lastName = getString(jsonPath,"info.lastName");
        email = getString(jsonPath,"info.email");
        id = getString(jsonPath,"id");
    }

    private String getString(JsonPath jsonPath, String path){
        String jsonaValue = jsonPath.getString(path);
        int size = jsonaValue.toCharArray().length;
        return jsonaValue.substring(1, size-1);
    }

    public Response put(String firstName, String lastName, String email){
        Response response = RestAssured.given()
                .contentType("application/json")
                .body("{\"email\":\""+email+"\",\"firstName\":\""+firstName+"\",\"lastName\":\""+lastName+"\"}").
                        when().
                        post(url);
        setContactAttributes(get());
        return response;
    }

    public Response patch(String key, String value){
        Response response = RestAssured.given()
                .contentType("application/json")
                .body("{\"" + key +"\":\"" + value + "\"}" ).
                        when().
                        patch(url);
        setContactAttributes(get());

        return response;
    }





    public void printContact(){
        System.out.println("<<------- Contact Details ----->>");
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("email: " + email);
        System.out.println("id: " + id);
        System.out.println("<<---- ---- ---- ---- ---- ---->>\r\n");
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUrl(){
        return url;
    }
}
