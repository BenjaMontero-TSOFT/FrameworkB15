package aut.testcreation.pages.hotel;

import aut.testcreation.pages.FormContact;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReserveHotelPage extends SeleniumWrapper {

    private FormContact formContact;

    public ReserveHotelPage(WebDriver driver) {
        super(driver);
        this.formContact = new FormContact(driver);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, this.formContact);
    }

    public void completeFormContact(String name, String surname, String email, String prefijo, String tel){
        this.formContact.completeInputName(name);
        this.formContact.completeInputSurname(surname);
        this.formContact.completeInputEmail(email);
        this.formContact.completeInputPrefijo(prefijo);
        this.formContact.completeInputTel(tel);
    }

    public String getMessageTelError(){
        return this.formContact.getMessageTelError();
    }
}
