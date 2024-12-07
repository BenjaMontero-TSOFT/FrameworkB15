package aut.testcreation.pages.Avion;

import cucumber.api.java.eo.Se;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlashSaleLandingPage extends SeleniumWrapper {

    @FindBy (xpath = "//div[@data-analytics='deal-card']")
    private List<WebElement> flashSalesOptions;

    public FlashSaleLandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectFlashSale(){
        clickToElementClickable(this.flashSalesOptions.get(0));
        this.switchTab();
        //clickToElementClickable(firstOption);

    }


}
