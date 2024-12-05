package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NavBarHomePage extends SeleniumWrapper {

    @FindBy(xpath = "//p[.='Ver más']")
    private WebElement itemVermas;

    @FindBy(xpath = "//div[.='Trenes']")
    private WebElement itemTrenes;

    public void selectVerMas(){
        this.clickToElementClickable(this.itemVermas);
    }
    public void selectTrenesSection(){
        this.clickToElementClickable(this.itemTrenes);
    }

    public void selectSectionTrenes(){
        selectVerMas();
        selectTrenesSection();
    }

    public NavBarHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}