package endPoints.applicationDescription;

import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import util.PropertyLoader;

import static com.jayway.restassured.RestAssured.get;

public class ApplicationDescription {
    private String url = PropertyLoader.loadEnvProperty("address") + PropertyLoader.loadApplicationProperty("resource.application.wadl");
    private Response resp = get(url);


    public void printHeaders(){
        Headers headers = resp.headers();
        for (Header header :
                headers) {
            System.out.println("     ----- start element----");
            System.out.println(header.getName() + ":" + header.getValue());

        }
    }



    public void printBody(){

//        String response = resp.toString();
//        System.out.println(response);
//
//        System.out.println("***** prettyPrint  ****");
//        resp.body().prettyPrint();
//        System.out.println("\r\n");
//
//        System.out.println("*****  print()   ****");
//        resp.body().print();
//        System.out.println("\r\n");
//
//        System.out.println("*****  peek()   ****");
//        resp.body().peek();
//        System.out.println("\r\n");
//
//        System.out.println("*****  prettyPeek()   ****");
//        resp.body().prettyPeek();
//        System.out.println("\r\n");
//
//        System.out.println("-----");
//        resp.getStatusCode();
//        resp.getContentType();

//        System.out.println("*****  peek()   ****");
//        System.out.println((String) resp.body().jsonPath().get());
//        System.out.println("\r\n");
    }
}
