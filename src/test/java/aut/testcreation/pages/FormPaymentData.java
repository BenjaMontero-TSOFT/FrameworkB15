package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FormPaymentData extends SeleniumWrapper {

    @FindBy(xpath = "//input[@name='creditCard.cardNumber']")
    private WebElement inputNumberCreditCard;
    @FindBy(xpath = "//button[@data-testid='creditCard.expirationDate']")
    private List<WebElement> buttonsOfYearAndMonth;
    @FindBy(xpath = "//li[@data-testid='menu-item']")
    private List<WebElement> itemsYearOrMonth;
    @FindBy(xpath = "//button[data-testid='creditCard.expirationDate']")
    private WebElement buttonInputYear;
    @FindBy(id = "select-field-search-input-4743")
    private WebElement inputYearCreditCard;
    @FindBy(xpath = "//input[@name='creditCard.cvv']")
    private WebElement inputCvvCreditCard;
    @FindBy(xpath = "//div[@data-testid='creditCard.cvv']//span[@data-testid='input-helper-text']")
    private WebElement messageCvvError;
    @FindBy(xpath = "//input[@name='creditCard.cardHolder']")
    private WebElement cardHolder;
    @FindBy(xpath = "//div[@data-testid='creditCard.cardHolder']//span[@data-testid='input-helper-text']")
    private WebElement messageErrorCardHolder;


    public FormPaymentData(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void insertNumberOfCreditCard(String value){
        this.sendKeysToElementVisible(this.inputNumberCreditCard, value);
    }

    public void insertMonth(String value){
        this.clickToElementClickable(this.buttonsOfYearAndMonth.get(0));
        this.selectValueOptionOfYearOrMonth(value);
    }

    private void selectValueOptionOfYearOrMonth(String value){
        for(WebElement element : this.itemsYearOrMonth ){
            String text = this.getTextByElement(element);
            String parseToLowerCase = text.toLowerCase();
            if(parseToLowerCase.contains(value.toLowerCase())){
                this.clickToElementClickable(element);
                break;
            }
        }
    }

    public void insertYear(String value){
        this.clickToElementClickable(this.buttonsOfYearAndMonth.get(1));
        this.selectValueOptionOfYearOrMonth(value);
    }

    public void insertCvv(String number){
        this.sendKeysToElementVisible(this.inputCvvCreditCard, number);
    }

    public String getMessageCvvError(){
        return this.getTextByElement(this.messageCvvError);
    }

    public void insertCardHolder(String holder){
        this.sendKeysToElementVisible(this.cardHolder, holder);
    }

    public boolean messageInvalidCardHolderError(){
        String message = this.messageErrorCardHolder.getText();
        if(message.equalsIgnoreCase("Titular invalido")){
            return true;
        }
        else return false;
    }
}
