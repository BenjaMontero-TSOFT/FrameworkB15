package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelFare extends SeleniumWrapper {
    @FindBy(xpath = "//button[@class='Button__LmnDsButton-sc-1bbve8d-0 iWdhyu']")
    private WebElement btnElegirFlexible;

    @FindBy(xpath = "//button[.='Elegir Classic']")
    private WebElement btnElegirClassic;

    @FindBy(xpath = "//button[.='Elegir Premium']")
    private WebElement btnElegirPremium;

    public void selectBtnFlexible(){
        this.clickToElementClickable(this.btnElegirFlexible);
    }
    public void selectBtnClassic(){
        this.clickToElementClickable(this.btnElegirClassic);
    }
    public void selectBtnPremium(){
        this.clickToElementClickable(this.btnElegirPremium);
    }
    public TravelFare(WebDriver driver) {
        super(driver);
    }
}
