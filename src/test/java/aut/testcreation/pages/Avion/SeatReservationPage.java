package aut.testcreation.pages.Avion;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeatReservationPage extends SeleniumWrapper {

    @FindBy (xpath = "//button[text()='Saltar este paso']")
    private WebElement btnSkipStep;

    @FindBy (xpath = "//button[text()='Siguiente']")
    private WebElement btnNextStep;

    @FindBy (xpath = "//div[@role='presentation' and @tabindex='-1']//button[text()='Entendido']")
    private WebElement btnOk;

    public void skipStep(){
        clickToElementClickable(btnSkipStep);
    }

    public void goToPaymentPage(){
        clickToElementClickable(btnNextStep);
    }

    public SeatReservationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void seatAdvice(){
        if (isPresentElement(btnOk)){
            clickElementByJavaScript(btnOk);
        }
    }
}
