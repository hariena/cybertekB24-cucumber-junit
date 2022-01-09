package com.cybertek.step_definitions;

import com.cybertek.pages.EtsyAllCatogoriesPage;
import com.cybertek.pages.EtsyHomePage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class etsySearch_stepDefin {

    WebDriver driver;
    @Given("User is on etsy homepage")
    public void user_is_on_etsy_homepage() {
driver = Driver.getDriver();
driver.get(ConfigurationReader.getProperty("etsy.url"));
    }
    @Then("Page title should be as expected")
    public void page_title_should_be_as_expected() {
     Assert.assertEquals("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone",driver.getTitle());

     System.out.println(driver.getTitle());



    }
    @When("User searches for wooden spoon")
    public void user_searches_for_wooden_spoon() {

        EtsyHomePage etsypage = new EtsyHomePage();
        etsypage.searchFor("Wooden spoon");

    }
    @Then("Page title should start with wooden spoon")
    public void page_title_should_start_with_wooden_spoon() {
        BrowserUtils.sleep(3); // the better way is to use by explicit wait

        Assert.assertTrue("Title didn't match", driver.getTitle().startsWith("Wooden spoon"));

    }
    @When("user searches for empty values")
    public void userSearchesForEmptyValues() {

        EtsyHomePage etsyPage  = new EtsyHomePage();
        etsyPage.searchFor("");
    }

    @Then("All categories is disiplayed")
    public void allCategoriesIsDisiplayed() {
// Wait for until the all catogories change
        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.titleIs("All categories | Etsy"));
        Assert.assertEquals("All categories | Etsy", driver.getTitle());
        EtsyAllCatogoriesPage allCatogoriesPage = new EtsyAllCatogoriesPage();
        Assert.assertTrue(allCatogoriesPage.allCategories.isDisplayed());

    }


}
