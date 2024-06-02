package com.calculator.step_definitions;

import com.calculator.pages.GoogleCalculatorPage;
import com.calculator.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @After
    public void tearDownMethod(Scenario scenario) {

        GoogleCalculatorPage page = new GoogleCalculatorPage();

        try {
            page.operationBtn("AC").click();
        } catch (Exception e) {
            page.operationBtn("+").click();
            page.numberBtn(0).click();
            page.operationBtn("=").click();
            page.operationBtn("AC");
        }

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }


}

