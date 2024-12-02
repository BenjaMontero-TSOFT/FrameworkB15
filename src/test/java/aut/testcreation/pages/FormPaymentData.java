package aut.testcreation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPaymentData {

    @FindBy(xpath = "//input[@name='creditCard.cardNumber']")
    private WebElement inputNumberCreditCard;
    @FindBy(id = "select-field-search-input-7377")
    private WebElement inputMonthCreditCard;
    @FindBy(id = "select-field-search-input-4743")
    private WebElement inputYearCreditCard;
    @FindBy(xpath = "//input[@name='creditCard.cvv']")
    private WebElement inputCvvCreditCard;
    @FindBy(xpath = "//div[@data-testid='creditCard.cvv']//span[@data-testid='input-helper-text']")
    private WebElement messageCvvError;


}
