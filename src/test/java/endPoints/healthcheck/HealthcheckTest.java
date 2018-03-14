package endPoints.healthcheck;

import com.jayway.restassured.response.Response;
import endPoints.healthcheck.Healthcheck;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HealthcheckTest {

    private Healthcheck resource;
    private Response response;

    @BeforeClass
    public void setup() {
        resource = new Healthcheck();
        response = resource.get();
    }

    @Test
    public void test1_checkGetStatus(){
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test
    public void test2_checkGetContentType(){
        Assert.assertEquals(response.getContentType(), "text/plain");
    }

    @Test
    public void test3_checkBody(){
        Assert.assertEquals(response.body().print(), "live");
    }


    //Not allowed methods:


    @Test
    public void test4_option(){
        Assert.assertEquals(resource.options().statusLine(), "HTTP/1.1 405 Method Not Allowed");
    }

    @Test
    public void test5_head(){
        Assert.assertEquals(resource.head().statusLine(), "HTTP/1.1 405 Method Not Allowed");
    }

    @Test
    public void test6_post(){
        Assert.assertEquals(resource.post().statusLine(), "HTTP/1.1 405 Method Not Allowed");
    }

    @Test
    public void test7_put(){
        Assert.assertEquals(resource.put().statusLine(), "HTTP/1.1 405 Method Not Allowed");
    }

    @Test
    public void test8_patch(){
        Assert.assertEquals(resource.patch().statusLine(), "HTTP/1.1 405 Method Not Allowed");
    }

    @Test
    public void test9_delete(){
        Assert.assertEquals(resource.delete().statusLine(), "HTTP/1.1 405 Method Not Allowed");
    }





}
