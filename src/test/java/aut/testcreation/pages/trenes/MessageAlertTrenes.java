package aut.testcreation.pages.trenes;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MessageAlertTrenes extends SeleniumWrapper {

    @FindBy(xpath = "title")
    private WebElement titlePageFilterJourney;

    @FindBy(xpath = "//label[@for='voucher' and text()='El bono ha caducado.']")
    private WebElement messageCuponResult;

    @FindBy(xpath = "//span[@data-testid='groups.1.travellers.2.dateOfBirth_error']")
    private WebElement messageAdultoIncorrecto;

    @FindBy(xpath = "//span[@data-testid='creditCard.expirationDate_error']")
    private WebElement messageErrorCardExpiration;

    @FindBy(xpath = "//div[@data-testid='creditCard.cardHolder']//span[@data-testid='input-helper-text']")
    private WebElement messageErrorCardHolder;

    public String errorCardHolder(){
        if(messageErrorCardHolder == null){
            return "";
        }
        else return messageErrorCardHolder.getText();
    }

    public String errorCuponDescuento(){
        if(messageCuponResult == null){
            return "";
        }
        else {
            return messageCuponResult.getText();}
    }

    public String errorPassengerEdad(){
        if(messageAdultoIncorrecto == null){
            return "";
        }
        else {
            return messageAdultoIncorrecto.getText();}
    }

    public String errorDistantYear(){
        if(messageErrorCardExpiration == null){
            return "";
        }
        else {
            return messageErrorCardExpiration.getText();}
    }

    public MessageAlertTrenes(WebDriver driver) {
        super(driver);
    }
}
