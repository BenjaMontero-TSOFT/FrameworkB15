package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
//    @FindBy(xpath = "//li[@data-testid='menu-item']")
//    public List<WebElement> optionCountryPrefijo;

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
        this.sendKeysToElementVisible(this.inputInsertPrefijo, Keys.ENTER);
    }

    public void completeInputTel(String value) {
        this.sendKeysToElementVisible(this.inputTel, value);
        this.sendKeysToElementVisible(this.inputTel, Keys.ENTER);
    }

    public String getMessageTelError() {
        return this.getTextByElement(this.messageTelError);
    }


}
