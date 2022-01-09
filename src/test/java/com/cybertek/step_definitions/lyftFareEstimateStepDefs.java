package com.cybertek.step_definitions;

import com.cybertek.pages.lyftFareEstimatePage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class lyftFareEstimateStepDefs {
    @Given("User is on lyft fare estimate page")
    public void user_is_on_lyft_fare_estimate_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("lyft.fare.estimate.url"));
        // to make sure if i am in the correct/right page
        //System.out.println(Driver.getDriver().getTitle());
        String expectedTittle = "Get Fare Estimates for Your City - Lyft Price Estimate | Lyft";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTittle,actualTitle);
    }
    @When("User enters {string} to pickup address")
    public void user_enters_to_pickup_address(String pickupFromParameter) {

        lyftFareEstimatePage fareEstimatePage = new lyftFareEstimatePage();
      //fareEstimatePage.pickUpLocation.sendKeys(pickupFromParameter);

        //OR

        fareEstimatePage.enterPickUpLocation(pickupFromParameter);

    }
    @And("User enters {string} to  drop-off address")
    public void user_enters_to_drop_address(String dropFromParameter) {

lyftFareEstimatePage drop = new lyftFareEstimatePage();
drop.dropLocation.sendKeys(dropFromParameter);

    }
    @And("User click on get estimate button")
    public void user_click_on_get_estimate_button() {

        lyftFareEstimatePage getEstimate = new lyftFareEstimatePage();
//        Actions actions = new Actions(Driver.getDriver());
//        actions.moveToElement(getEstimate.clickGetEstimate).doubleClick().build().perform();


        getEstimate.clickGetEstimate.click();
        BrowserUtils.sleep(2);
        getEstimate.clickGetEstimate.click();
    }
    @Then("User should see estimated price")
    public void user_should_see_estimated_price() {
        lyftFareEstimatePage priceGetEstimate = new lyftFareEstimatePage();

        Assert.assertTrue(priceGetEstimate.rideTypesHeader.isDisplayed());
        System.out.println("price and time: " + priceGetEstimate.liftPrice.getText());


    }

    @Then("User should see error message")
    public void userShouldSeeErrorMessage() {
        lyftFareEstimatePage errorMsg2 = new lyftFareEstimatePage();
Assert.assertTrue("Error message is not displayed, ",errorMsg2.errorMsg.isDisplayed() );
    }
}
