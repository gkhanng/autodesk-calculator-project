package com.calculator.pages;

import com.calculator.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class GoogleCalculatorPage {
    //#1- Create the constructor and initialize the driver with object

    public GoogleCalculatorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public WebElement numberBtn(int number) {
       return Driver.getDriver().findElement(By.xpath("//div[@role='button'][normalize-space()='"+number+"']"));
    }

    public WebElement operationBtn(String operation) {
        return Driver.getDriver().findElement(By.xpath("//div[@aria-label='"+getOperation(operation)+"']"));
    }

    private String getOperation(String sign){
        Map <String, String> signs = new HashMap<String, String>();

        signs.put("-",  "minus");
        signs.put("/",  "divide");
        signs.put("÷",  "divide");
        signs.put("CE",  "clear entry");
        signs.put("*",  "multiply");
        signs.put("+",  "plus");
        signs.put("=",  "equals");
        signs.put(".",  "point");
        signs.put("AC",  "all clear");


        return signs.get(sign);
    }


    @FindBy(name = "q")
    public WebElement searchBox;


    @FindBy (xpath = "//span[@id='cwos']")
    public WebElement result;

}

