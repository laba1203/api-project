package api.healthcheck;

import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;


public class HealthcheckTest {

    private Healthcheck resource;
    private Response positiveResponse;

    @BeforeClass
    public void setup() {
        resource = new Healthcheck();
    }

    @BeforeGroups("positive")
    public void get(){
        positiveResponse = resource.get();
    }

    @Test(groups = "positive")
    public void test1_checkGetStatus(){
        Assert.assertEquals(positiveResponse.getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test(groups = "positive")
    public void test2_checkGetContentType(){
        Assert.assertEquals(positiveResponse.getContentType(), "text/plain");
    }

    @Test(groups = "positive")
    public void test3_checkBody(){
        Assert.assertEquals(positiveResponse.body().print(), "live");
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
