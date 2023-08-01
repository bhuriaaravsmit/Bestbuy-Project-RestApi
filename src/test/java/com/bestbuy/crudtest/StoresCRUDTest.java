package com.bestbuy.crudtest;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresCRUDTest extends TestBase {


    @Test
    public void getAllStoreInfo() {
        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createStoresInfo() {




    }

    @Test
    public void test003() {

    }

    @Test
    public void test004() {

    }


}
