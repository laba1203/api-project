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
    } // TODO It's common practice to verify response code instead of text status line.

    @Test(groups = "positive") // TODO Usually one do not need to have separate test for each validation of the same request. For one request it's better to do several assertions in one test.
    public void test2_checkGetContentType(){
        Assert.assertEquals(positiveResponse.getContentType(), "text/plain");
    }

    @Test(groups = "positive") // TODO Same as previous. So better have test1 test2 test3 for healtchcheck as one test.
    public void test3_checkBody(){
        Assert.assertEquals(positiveResponse.body().print(), "live");
    }


    //Not allowed methods:

    @Test
    public void test4_option(){
        Assert.assertEquals(resource.options().statusLine(), "HTTP/1.1 405 Method Not Allowed");
    } // TODO It's common practice to verify response code instead of text status line.

    @Test
    public void test5_head(){
        Assert.assertEquals(resource.head().statusLine(), "HTTP/1.1 405 Method Not Allowed");
    } // TODO If you have duplicated messages in a lot of test cases, need to move these into constants.

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
