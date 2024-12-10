package aut.testcreation.pages.hotel;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InformationHotelPage extends SeleniumWrapper {

    @FindBy (xpath = "//button[@data-test-id='book-cta']")
    private WebElement btnNavigateToReserve;

    @FindBy (xpath = "//div[contains(text(), 'Esta es nuestra mejor oferta')]")
    private WebElement mejorOferta;

    @FindBy(xpath = "//div[@id='rooms']//button[@data-testid='checkout-button']")
    private List<WebElement> btnContinueToReserve;

    @FindBy (xpath = "//div[@aria-label='go to change flight']")
    private WebElement BtnChangeFlight;

    @FindBy (xpath = "//button[text()='Modificar']")
    private WebElement modificar;

    @FindBy (xpath = "//button[@data-testid='lmn-ds-btn' and contains(text(), 'Seleccionar este vuelo')]")
    private WebElement BtnSelectNewFlight;

    @FindBy (xpath = "//div[text()='Más barato']")
    private WebElement BtnCheaper;

    public InformationHotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToReserve(){
        this.clickElementByJavaScript(this.btnNavigateToReserve);
        continueToReserveToFirstOption();
    }

    public void changeFlight() throws InterruptedException {
        this.clickElementByJavaScript(this.btnNavigateToReserve);
        clickToElementClickable(BtnChangeFlight);
        By byCheaper = By.xpath("//div[text()='Más barato']");
        click(byCheaper);
        Thread.sleep(750);
        clickElementByJavaScript(BtnSelectNewFlight);
    }

    //clickeo la primer opcion
    public void continueToReserveToFirstOption(){
        for(WebElement webElement: this.btnContinueToReserve){
            this.clickToElementClickable(webElement);
            break;
        }
    }

    public String getMejorOferta(){
        return getTextByElement(mejorOferta);
    }
}
