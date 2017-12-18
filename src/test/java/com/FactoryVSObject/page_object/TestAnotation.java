package com.FactoryVSObject.page_object;

import org.testng.annotations.*;

public class TestAnotation {

    @BeforeClass
    public void setupclass(){
        System.out.println("Before class");
    }

    @BeforeTest
    public void setuptest(){
        System.out.println("Before test");}

    @BeforeMethod
    public void setupmetods(){
        System.out.println("Before methods");}

    @AfterClass
    public void terdownclass(){
        System.out.println("After class");
    }

    @AfterTest
    public void terdowntest(){
        System.out.println("After test");}

    @AfterMethod
    public void terdownmetods(){
        System.out.println("After method");
    }

    @Test
    public void test_1(){
        System.out.println("test 1");
    }

    @Test
    public void test_2(){
        System.out.println("test 2");
    }

    @Test
    public void test_3(){
        System.out.println("test 3");
    }
}
