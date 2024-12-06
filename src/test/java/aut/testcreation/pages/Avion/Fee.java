package aut.testcreation.pages.Avion;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fee extends SeleniumWrapper {

    @FindBy (xpath = "//div[@class='sc-hniSVs gDuGna']//button[@data-testid='classic-card-cta']")
    private WebElement BtnRecommendedFee;

    public Fee(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void SelectFee(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(BtnRecommendedFee)).click();
    }
}
