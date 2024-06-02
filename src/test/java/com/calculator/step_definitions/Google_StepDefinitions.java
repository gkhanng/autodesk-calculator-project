package com.calculator.step_definitions;


import com.calculator.pages.GoogleCalculatorPage;
import com.calculator.utilities.BrowserUtils;
import com.calculator.utilities.ConfigurationReader;
import com.calculator.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;


public class Google_StepDefinitions {

    GoogleCalculatorPage calculatorPage = new GoogleCalculatorPage();

    @Given("I am on the Google homepage")
    public void i_am_on_the_google_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    @When("I search for {string}")
    public void i_search_for(String word) {
        calculatorPage.searchBox.sendKeys(word + Keys.ENTER);
    }

    @Then("user should see {string} in the title")
    public void user_should_see_in_the_title(String word) {
        BrowserUtils.verifyTitle(word + " - Google Search");
    }


    @When("I enter the number {long}")
    public void i_enter_the_number(long theNumber) {

        String num = theNumber + "";
        String[] chars = num.split("");

        for (String aChar : chars) {
            calculatorPage.numberBtn(Integer.parseInt(aChar)).click();
        }
    }

    @When("I enter the decimal number {double}")
    public void i_enter_the_decimal_number(double theNumber) {

        String num = theNumber + "";
        String[] chars = num.split("");

        for (String aChar : chars) {
            if (aChar.equals(".")) {
                Click_the_operation_button(".");
            } else {
                i_enter_the_number(Long.parseLong(aChar));
            }
        }
    }

    @And("Click the {string} operation button")
    public void Click_the_operation_button(String operation) {
        calculatorPage.operationBtn(operation).click();
    }


    @Then("the result displayed should be {string}")
    public void the_result_displayed_should_be(String number) {

        String res = calculatorPage.result.getText();
        System.out.println("actual:  " + res + ", expected: " + number);
        Assert.assertEquals(number, res);
    }


    @Then("the result displayed should NOT be {string}")
    public void theResultDisplayedShouldNOTBe(String number) {
        String res = calculatorPage.result.getText();
        double resNumber = Double.parseDouble(res);
        double expectNumber = Double.parseDouble(number);

        System.out.println("actual:  " + res + ", expected NOT to be: " + number);
        Assert.assertNotEquals(expectNumber, resNumber);

    }
}
