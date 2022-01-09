package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class percentageCalculatorPage {

    public percentageCalculatorPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    ////input[@size='7']
    ////input[@size='3']

    @FindBy(xpath = "//input[@size='3']")
    public WebElement percent;

    @FindBy(xpath = "//input[@size='7']")
    public WebElement input;

    @FindBy(xpath = "(//input[@size='6'])[1]")
    public WebElement result;
}
