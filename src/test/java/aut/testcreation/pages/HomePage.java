package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends SeleniumWrapper {
    @FindBy(xpath = "//button[text()='Aceptar todo']")
    private WebElement btnCookies;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void closeCookies(){
        this.clickToElementClickable(this.btnCookies);
    }
}
