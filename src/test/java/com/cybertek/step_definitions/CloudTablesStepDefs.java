package com.cybertek.step_definitions;

import com.cybertek.pages.CloudeTablePage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CloudTablesStepDefs {

    CloudeTablePage tablePage = new CloudeTablePage();

    @Given("User is on cloud tables homepage")
    public void user_is_on_cloud_tables_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("cloudTables.url"));
        Assert.assertEquals("Editor | Editing for DataTables", Driver.getDriver().getTitle());

    }
    @When("User clicks on New button")
    public void user_clicks_on_new_button() {

        tablePage.addingNew.click();

    }
    @When("User enters {string} to firstname field")
    public void user_enters_to_firstname_field(String firstName) {

        tablePage.firstNameField.sendKeys(firstName);
        //tablePage.enterFirstName(firstName);
    }
    @When("User enters {string} to lastname field")
    public void user_enters_to_lastname_field(String lastName) {

        tablePage.lastNameField.sendKeys(lastName);

    }
    @When("User enters {string} to position field")
    public void user_enters_to_position_field(String position) {

        tablePage.positionField.sendKeys(position);
    }
    @When("User enters {string} to salary field")
    public void user_enters_to_salary_field(String salary) {

        tablePage.positionField.sendKeys(salary);
    }
    @When("User clicks on create button")
    public void user_clicks_on_create_button() {
tablePage.created.click();
    }



}
