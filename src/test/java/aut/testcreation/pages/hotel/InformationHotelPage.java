package aut.testcreation.pages.hotel;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InformationHotelPage extends SeleniumWrapper {

    @FindBy(xpath = "//button[@data-test-id='book-cta']")
    private WebElement btnNavigateToReserve;

    @FindBy(xpath = "//div[@id='rooms']//button[@data-testid=\"checkout-button\"]")
    private List<WebElement> btnContinueToReserve;


    public InformationHotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToReserve(){
        this.clickElementByJavaScript(this.btnNavigateToReserve);
        continueToReserveToFirstOption();
    }

    //clickeo la primer opcion
    private void continueToReserveToFirstOption(){
        for(WebElement webElement: this.btnContinueToReserve){
            this.clickToElementClickable(webElement);
            break;
        }
    }
}
