package com.lld.stopcoro;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GenderTest {

    @BeforeClass
    public static void  beforeclass(){

        System.out.println("Before class");
    }

    @AfterClass
    public static void  afterclass(){
        System.out.println("After class");
    }

    @Before
    public void  before(){
        System.out.println("Before");
    }

    @After
    public  void  after(){
        System.out.println("After");
    }

    @Test
    public void onclickButtonContinuelistener() {
        int age = 10;
        assertTrue("invalid age", age >= 1);
        assertFalse("fail",age>=0);
        System.out.println("The class");

    }


}