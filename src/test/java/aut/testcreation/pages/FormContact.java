package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

public class FormContact extends SeleniumWrapper {

    @FindBy(xpath = "//input[@name='name']")
    public WebElement inputName;
    @FindBy(xpath = "//input[@name='surname']")
    public WebElement inputSurname;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement inputEmail;
    @FindBy(xpath = "//button[@data-testid='phone_isoCode']")
    public WebElement btnShowPrefijo;
    @FindBy(xpath = "//input[@name='phone']")
    public WebElement inputTel;
    @FindBy(xpath = "//div[@data-testid='next-phone-input-group-errormessage']")
    public WebElement messageTelError;

    @FindBy(xpath = "//li[@data-testid='menu-item']")
    public List<WebElement> optionsCountrys;

    private static final Logger logger = Logger.getLogger(FormContact.class.getName());


    @FindBy(xpath = "//input[@aria-label='search-input']")
    public WebElement inputInsertPrefijo;

    public FormContact(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void completeInputName(String value) {
        this.sendKeysToElementVisible(this.inputName, value);
        this.sendKeysToElementVisible(this.inputName, Keys.ENTER);
    }

    public void completeInputSurname(String value) {
        this.sendKeysToElementVisible(this.inputSurname, value);
        this.sendKeysToElementVisible(this.inputSurname, Keys.ENTER);
    }

    public void completeInputEmail(String value) {
        this.sendKeysToElementVisible(this.inputEmail, value);
        this.sendKeysToElementVisible(this.inputEmail, Keys.ENTER);
    }

    public void completeInputPrefijo(String value) {
        this.clickElementByJavaScript(this.btnShowPrefijo);
        this.sendKeysToElementVisible(this.inputInsertPrefijo, "+"+value);
        try {
            Thread.sleep(2000);
        }catch (Exception e){}
        Assertions.assertTrue(this.optionsCountrys.size() == 1,
                "Se esperaba que la lista de países tenga 1 elemento, pero tiene " + this.optionsCountrys.size() + " elementos.");
        WebElement element = this.optionsCountrys.get(0);
        String text = this.getTextByElement(element);

        boolean validate = text.toLowerCase().contains(value);
        Assertions.assertTrue(validate,
                "El prefijo no coincide con el encontrado");
        this.clickToElementClickable(element); //selecciono el tipo

    }

    public void completeInputTel(String value) {
        this.sendKeysToElementVisible(this.inputTel, value);
        this.sendKeysToElementVisible(this.inputTel, Keys.ENTER);
    }

    public void completeFormContact(String name, String surName, String email, String prefijo, String tel) {
        completeInputName(name);
        completeInputSurname(surName);
        completeInputEmail(email);
        completeInputPrefijo(prefijo);
        completeInputTel(tel);
    }

    public String getMessageTelError() {
        return this.getTextByElement(this.messageTelError);
    }


}
