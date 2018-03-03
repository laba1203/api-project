import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public abstract class AbstractResource {
    private String url;

    protected void setUrl(String url){
        this.url = url;
    }

    public Response get(){
        return RestAssured.get(url);
    }

    public Response post(){
        return RestAssured.post(url);
    }

    public Response delete(){
        return RestAssured.delete(url);
    }

    public Response patch(){
        return RestAssured.patch(url);
    }

    public Response put(){
        return RestAssured.put(url);
    }

    public Response options(){
        return RestAssured.options(url);
    }

    public Response head(){
        return RestAssured.head(url);
    }
}
