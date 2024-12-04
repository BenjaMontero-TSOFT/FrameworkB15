package aut.testcreation.pages.hotel;

import aut.testcreation.pages.FormContact;
import aut.testcreation.pages.FormPaymentData;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReserveHotelPage extends SeleniumWrapper {

    private FormContact formContact;
    @FindBy(xpath = "//h3[@data-testid='contact-form-title']")
    public WebElement titleFormContact;
    private FormPaymentData forPaymentData;
    @FindBy(xpath = "//div[@class='multi-payment__panel']")
    public WebElement paymentForm;
    @FindBy(xpath = "//span[text()='Detalles y pago']")
    public WebElement titleDetailAndPayment;


    public ReserveHotelPage(WebDriver driver) {
        super(driver);
        this.formContact = new FormContact(driver);
        this.forPaymentData = new FormPaymentData(driver);
        PageFactory.initElements(driver, this);
    }

    public void completeFormContact(String name, String surname, String email, String prefijo, String tel){
        this.formContact.completeInputName(name);
        this.formContact.completeInputSurname(surname);
        this.formContact.completeInputEmail(email);
        this.formContact.completeInputPrefijo(prefijo);
        this.formContact.completeInputTel(tel);
        this.clickToElementClickable(this.titleFormContact);
    }

    public String getMessageTelError(){
        return this.formContact.getMessageTelError();
    }

    public void completeFormPayment(String nroCreditCard, String month, String year, String cvv) {
        this.scrollToElement(this.paymentForm);
        this.forPaymentData.insertNumberOfCreditCard(nroCreditCard);
        this.forPaymentData.insertMonth(month);
        this.forPaymentData.insertYear(year);
        this.forPaymentData.insertCvv(cvv);
        this.clickToElementClickable(this.paymentForm);
    }

    public String getMessageCvvError(){
        return this.forPaymentData.getMessageCvvError();
    }

    public boolean isStayInReservePage(){
        return this.isPresentElement(this.titleDetailAndPayment);
    }
}
