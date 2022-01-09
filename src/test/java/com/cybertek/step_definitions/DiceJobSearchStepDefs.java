package com.cybertek.step_definitions;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class DiceJobSearchStepDefs {

    @Given("User is on dice homepage")
    public void user_is_on_dice_homepage() {
        System.out.println("User is on the dice homepage......");
        Driver.getDriver().get(ConfigurationReader.getProperty("dice.url"));
    }
    @When("User enters keyword and zipcode")
    public void user_enters_keyword_and_zipcode() {

        System.out.println("User enters java and 202102 ...");
        WebElement keyword = Driver.getDriver().findElement(By.id("typeaheadInput"));
        WebElement zipcode = Driver.getDriver().findElement(By.id("google-location-search"));
        keyword.sendKeys("java");
        zipcode.sendKeys("542367" + Keys.ENTER);
        ////*[@*='submitSearch-button']
        WebElement searchButton = Driver.getDriver().findElement(By.xpath("//*[@*='submitSearch-button']"));
   searchButton.click();
    }
    @Then("User should see search results")
    public void user_should_see_search_results() {

        System.out.println("user should see search result ");
////*[@id="search-div"]/dhi-search-page-results/div/div[1]/div/div/h4

        WebElement result = Driver.getDriver().findElement(By.id("totalJobCount"));
        System.out.println("job total count result: " + result.getText());


    }

}
