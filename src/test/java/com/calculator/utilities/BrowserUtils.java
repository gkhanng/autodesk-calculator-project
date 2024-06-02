package com.calculator.utilities;

import org.junit.Assert;

public class BrowserUtils {


    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals( expectedTitle,Driver.getDriver().getTitle());
    }
    public static void verifyTitleContains( String expectedInTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

}