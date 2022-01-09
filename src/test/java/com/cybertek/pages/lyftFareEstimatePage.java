package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class lyftFareEstimatePage {

    protected WebDriver driver;

    // first creating a constructor

    public lyftFareEstimatePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
@FindBy (xpath = "//input[@name = 'fare-start']")
    public WebElement pickUpLocation;

    @FindBy(xpath = "//input[@name = 'fare-end']")
    public WebElement dropLocation;

    ////button[.='Get estimate']
    @FindBy(xpath = "//span[.= 'Get estimate']")
public WebElement clickGetEstimate;

    @FindBy(xpath = "//h3[.='RIDE TYPES']")
    public WebElement rideTypesHeader;

    @FindBy(xpath = "//table/tbody/tr[1]/td[3]")
    public WebElement liftPrice;

    @FindBy(xpath = "//small[.='Please select a valid location.']")
    public WebElement errorMsg;

    public  void enterPickUpLocation(String enter){

        pickUpLocation.sendKeys(enter);

    }
}
