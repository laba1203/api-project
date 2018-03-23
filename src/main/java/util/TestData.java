package util;

public class TestData {

    public static String generatePostBody(String firstName, String lastName, String email){
        return "{\"email\":\""+ email + "\",\"firstName\":\""+firstName+"\",\"lastName\":\""+lastName+"\"}";
        //TODO this is not supportable structure. One should use JSON library to generate json formated body from hash map, for example.
    }

    public static String getPutBody(String firstName, String lastName, String email){
        return "{\"email\":\""+email+"\",\"firstName\":\""+firstName+"\",\"lastName\":\""+lastName+"\"}";
        // TODO same as previous.
    }

    public static String getPatchBody(String key, String value){
        return "{\"" + key +"\":\"" + value + "\"}";
    }
    // TODO same as previous.

    public static String getPatchBody(String key1, String value1, String key2, String value2){
        return "{\"" + key1 +"\":\"" + value1 + "\",\"" + key2 + "\":\"" + value2 + "\"}";
    } // TODO same as previous.

    public static String random(){
        return String.valueOf(System.currentTimeMillis()).substring(10);
    }



}
