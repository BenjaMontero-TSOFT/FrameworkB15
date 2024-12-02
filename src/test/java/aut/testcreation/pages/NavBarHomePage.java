package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavBarHomePage extends SeleniumWrapper {

    @FindBy(xpath = "//p[contains(text(),'Ver m')]")
    private WebElement itemVermas;

    @FindBy(xpath = "//div[contains(text(),'Trenes')]")
    private WebElement itemTrenes;

    public NavBarHomePage(WebDriver driver) {
        super(driver);
    }
}