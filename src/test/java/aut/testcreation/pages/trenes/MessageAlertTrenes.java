package aut.testcreation.pages.trenes;

import framework.engine.selenium.SeleniumTestBase;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
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
    private WebElement messageErrorCardHolder;

    //@FindBy(xpath = "//div[@data-testid='creditCard.cardHolder']//span[@data-testid='input-helper-text']")
    //private WebElement messageErrorCardHolder;

    public String messageErrorCardHolder(){
        return null;
    }

    public String errorCuponDescuento(){
        return  messageCuponResult.getText();
    }

    public String errorPassengerEdad(){
        return this.messageAdultoIncorrecto.getText();
    }

    public String errorAnioLejano(){
        return messageErrorCardHolder.getText();
    }

    public MessageAlertTrenes(WebDriver driver) {
        super(driver);
    }
}
