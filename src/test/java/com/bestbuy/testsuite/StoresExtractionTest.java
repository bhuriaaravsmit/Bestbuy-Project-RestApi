package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {

    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";
        response = given()
                .when()
                .get()
                .then().statusCode(200);
    }
    // Extract the limit
    @Test
    public void limitExtract(){
        int limit = response.extract().path("limit");
        System.out.println("Extract the limit "+limit);
    }
    // Extract the total
    @Test
    public void totalExtract(){
        int total = response.extract().path("total");
        System.out.println("Extract the total "+total);
    }
    // Extract the name of 5th store
    @Test
    public void nameExtract(){
        String name = response.extract().path("data[4].name");
        System.out.println("Extract the name of 5th store "+name);
    }
    // Extract the names of all the store
    @Test
    public void allStores(){
      List<String>  name = response.extract().path("data.name");
        System.out.println("Extract the name of all store "+name);
    }
    // Extract the storeId of all the store
    @Test
    public void storeIdExtract(){
        List<String>  id = response.extract().path("data.id");

        System.out.println("Extract the id of all store "+id);
    }
    // Print the size of the data list
    @Test
    public void sizeOfList(){
        List<String> dataList = response.extract().path("data");
        System.out.println("Extract the size of data list "+ dataList.size());
    }
    // Get all the value of the store where store name = St Cloud
    @Test
    public void valueStore(){
        List<HashMap<String, String>> values = response.extract().path("data.findAll{it.name == 'St Cloud'}");
   //     System.out.println(values.get(0).get("name"));
        System.out.println("Get all the value of the store where store name = St Cloud "+values);
    }
    // Get the address of the store where store name = Rochester
    @Test
    public void addressRochester(){
        List<String> address=response.extract().path("data.findAll{it.name=='Rochester'}.address");
        System.out.println("Get the address of the store where store name = Rochester" + address);
    }
    // Get all the services of 8th store
    @Test
    public void servicesOfEighth(){
        List<String> services=response.extract().path("data[7].services.name");
        System.out.println("Get all the services of 8th store" + services);
    }
    // Get storeservices of the store where service name = Windows Store
    @Test
    public void windowsStore(){
        List<HashMap<String ,?>> services=response.extract().path("data.services*.find{it.name=='Windows Store'}.storeservices");
        System.out.println("Get storeservices of the store where service name = Windows Store" + services);
    }
    // Get all the storeId of all the store
    @Test
    public void storeIfOfAllStore(){
        List<Integer>storeId   = response.extract().path("data.services.storeservices.storeId");
        System.out.println("Get all the storeId of all the store "+storeId);
    }
    // Get id of all the store
    @Test
    public void idOfAllStore(){
        List<Integer>id   = response.extract().path("data.id");
        System.out.println("Get id of all the store "+id);
    }
    // Find the store names Where state = ND
    @Test
    public void stateIsEqualToND(){
        List<HashMap<String,String>>storeName  = response.extract().path("data.findAll{it.state=='ND'}.name");
        System.out.println("Find the store names Where state = ND "+storeName);
    }
    // Find the Total number of services for the store where store name = Rochester
    @Test
    public void storeNameIsEqualToRochester(){
        int noOfServices  = response.extract().path("data.find{it.name=='Rochester'}.services.size");
        System.out.println("Find the Total number of services for the store where store name = Rochester "+noOfServices);
    }
    // Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void createdAtWindowStore(){
        List<HashMap<String ,?>> services=response.extract().path("data.services*.find{it.name=='Windows Store'}.storeservices.createdAt");
        System.out.println("Get the createdAt for all services whose name = Windows Store" + services);
    }
    // Find the name of all services Where store name = “Fargo”
    @Test
    public void storeNameFargo(){
        List<HashMap<String,?>>nameOfServices  = response.extract().path("data.findAll{it.name=='Fargo'}.services.name");
        System.out.println("Find the name of all services Where store name = “Fargo” "+nameOfServices);
    }
    // Find the zip of all the store
    @Test
    public void zipAllStore(){
        List<HashMap<String,?>> zipCode  = response.extract().path("data.zip");
        System.out.println("Find the zip of all the store "+zipCode);
    }
    // Find the zip of store name = Roseville
    @Test
    public void zipStoreName(){
        List<HashMap<String,?>>zipCodeName  = response.extract().path("data.findAll{it.name=='Roseville'}.zip");
        System.out.println("Find the zip of store name = Roseville "+zipCodeName);
    }
    // Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void storeServices(){
        List<HashMap<String,?>>storeService  = response.extract().path("data.services*.findAll{it.name=='Magnolia Home Theater'}.storeservices");
        System.out.println("Find the storeservices details of the service name = Magnolia Home Theater "+storeService);
    }
    // Find the lat of all the stores
    @Test
    public void latOfAllStores(){
        List<?>latName  = response.extract().path("data.lat");
        System.out.println("Find the lat of all the stores "+latName);
    }



}
