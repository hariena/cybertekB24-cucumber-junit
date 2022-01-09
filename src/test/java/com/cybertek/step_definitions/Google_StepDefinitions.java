package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.util.List;

public class Google_StepDefinitions {

    GoogleSearchPage searchPage = new GoogleSearchPage();

    @Given("User is on Google home page")
    public void user_is_on_google_home_page() {
        Driver.getDriver().get("https://www.google.com");
    }
    @When("User searches for apple")
    public void user_searches_for_apple() {

        searchPage.searchBar.sendKeys("apple"+ Keys.ENTER);

    }
    @Then("User should see apple in the title")
    public void user_should_see_apple_in_the_title() {
       String actualResult = Driver.getDriver().getTitle();
       String expectedResult = "apple";

        Assert.assertTrue(actualResult.contains(expectedResult));

    }


    @Then("User should be able to search for following:")
    public void userShouldBeAbleToSearchForFollowing(List<String> item) {

        System.out.println("item : " + item);

        // loop and search each item on google

        GoogleSearchPage searchPage = new GoogleSearchPage();

        for (String eachItem : item){
            searchPage.searchBar.clear();
            searchPage.searchBar.sendKeys(eachItem + Keys.ENTER);
// the below message is after searching going back to the main page
           // Driver.getDriver().navigate().back();


        }


    }

    @When("User searches for {string} capital")
    public void userSearchesForCapital(String countryName) {

        System.out.println("Searching for capital city of " + countryName);
        searchPage.searchBar.sendKeys("What is the capital city of " + countryName + Keys.ENTER);

    }

    @Then("User should see {string} in the result")
    public void userShouldSeeInTheResult(String capitalCity) {

        System.out.println("Expected for capital city " + capitalCity);

    }


}
