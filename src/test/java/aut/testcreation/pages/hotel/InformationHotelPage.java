package aut.testcreation.pages.hotel;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationHotelPage extends SeleniumWrapper {

    @FindBy(xpath = "//button[contains(text(), 'Reservar desde')]")
    private WebElement btnNavigateToReserve;

    @FindBy(xpath = "//button[@data-testid='checkout-button' and text()='Continuar']")
    private WebElement btnContinueToReserve;


    public InformationHotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToReserve(){
        this.clickToElementClickable(btnNavigateToReserve);
        this.clickToElementClickable(this.btnNavigateToReserve);
    }
}
