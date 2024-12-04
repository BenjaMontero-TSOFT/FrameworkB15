package aut.testcreation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPassengerData extends FormContact{

    @FindBy(xpath = "//input[@name='groups.1.travellers.1.name']")
    private WebElement namePassenger1;
    @FindBy(xpath = "//input[@name='groups.1.travellers.2.name']")
    private WebElement namePassenger2;
    @FindBy(xpath = "//input[@name='groups.1.travellers.3.name']")
    private WebElement namePassenger3;
    @FindBy(xpath = "//input[@name='groups.1.travellers.4.name']")
    private WebElement namePassenger4;

    @FindBy(xpath = "//input[@name='groups.1.travellers.1.surname']")
    private WebElement surNamePassenger1;
    @FindBy(xpath = "//input[@name='groups.1.travellers.2.surname']")
    private WebElement surNamePassenger2;
    @FindBy(xpath = "//input[@name='groups.1.travellers.3.surname']")
    private WebElement surNamePassenger3;
    @FindBy(xpath = "//input[@name='groups.1.travellers.4.surname']")
    private WebElement surNamePassenger4;

    @FindBy(xpath = "//div[@data-testid='groups.1.travellers.1.dateOfBirth_day']")
    private WebElement dayPassenger1;
    @FindBy(xpath = "//div[@data-testid='groups.1.travellers.2.dateOfBirth_day']")
    private WebElement dayPassenger2;
    @FindBy(xpath = "//div[@data-testid='groups.1.travellers.3.dateOfBirth_day']")
    private WebElement dayPassenger3;
    @FindBy(xpath = "//div[@data-testid='groups.1.travellers.4.dateOfBirth_day']")
    private WebElement dayPassenger4;

    @FindBy(xpath = "//button[@data-testid='groups.1.travellers.1.dateOfBirth_month']")
    private WebElement monthPassenger1;
    @FindBy(xpath = "//button[@data-testid='groups.1.travellers.2.dateOfBirth_month']")
    private WebElement monthPassenger2;
    @FindBy(xpath = "//button[@data-testid='groups.1.travellers.3.dateOfBirth_month']")
    private WebElement monthPassenger3;
    @FindBy(xpath = "//button[@data-testid='groups.1.travellers.4.dateOfBirth_month']")
    private WebElement monthPassenger4;

    @FindBy(xpath = "//div[@data-testid='groups.1.travellers.1.dateOfBirth_year']")
    private WebElement yearsPassenger1;
    @FindBy(xpath = "//div[@data-testid='groups.1.travellers.2.dateOfBirth_year']")
    private WebElement yearsPassenger2;
    @FindBy(xpath = "//div[@data-testid='groups.1.travellers.3.dateOfBirth_year']")
    private WebElement yearsPassenger3;
    @FindBy(xpath = "//div[@data-testid='groups.1.travellers.4.dateOfBirth_year']")
    private WebElement yearsPassenger4;

    @FindBy(xpath = "//button[@data-testid='groups.1.travellers.1.documentType']")
    private WebElement btnTypeDocumentPassenger1;
    @FindBy(xpath = "//button[@data-testid='groups.1.travellers.2.documentType']")
    private WebElement btnTypeDocumentPassenger2;
    @FindBy(xpath = "//button[@data-testid='groups.1.travellers.3.documentType']")
    private WebElement btnTypeDocumentPassenger3;
    @FindBy(xpath = "//button[@data-testid='groups.1.travellers.4.documentType']")
    private WebElement btnTypeDocumentPassenger4;

    @FindBy(xpath = "//input[@name='groups.1.travellers.1.documentNumber']")
    private WebElement inputTypeDocumentPassenger1;
    @FindBy(xpath = "//input[@name='groups.1.travellers.2.documentNumber']")
    private WebElement inputTypeDocumentPassenger2;
    @FindBy(xpath = "//input[@name='groups.1.travellers.3.documentNumber']")
    private WebElement inputTypeDocumentPassenger3;
    @FindBy(xpath = "//input[@name='groups.1.travellers.4.documentNumber']")
    private WebElement inputTypeDocumentPassenger4;

    public void completeFormPassenger1(String name, String surName, String day, String month, String years, String docucumentType){
        this.sendKeysToElementVisible(this.namePassenger1, Keys.ENTER);
        this.sendKeysToElementVisible(this.surNamePassenger1, Keys.ENTER);
        this.sendKeysToElementVisible(this.dayPassenger1, day);
        this.sendKeysToElementVisible(this.dayPassenger1 , Keys.ENTER);
        this.sendKeysToElementVisible(this.monthPassenger1 , Keys.ENTER);
        this.sendKeysToElementVisible(this.yearsPassenger1 , Keys.ENTER);
        this.sendKeysToElementVisible(this.inputTypeDocumentPassenger1 , Keys.ENTER);
    }
    public void completeFormPassenger2(String name, String surName, String day, String month, String years, String docucumentType){
        this.sendKeysToElementVisible(this.namePassenger2,name);
        this.sendKeysToElementVisible(this.namePassenger2, Keys.ENTER);
        this.sendKeysToElementVisible(this.surNamePassenger2, surName);
        this.sendKeysToElementVisible(this.surNamePassenger2, Keys.ENTER);
        this.sendKeysToElementVisible(this.dayPassenger2, day);
        this.sendKeysToElementVisible(this.dayPassenger2 , Keys.ENTER);
        this.sendKeysToElementVisible(this.monthPassenger2, month);
        this.sendKeysToElementVisible(this.monthPassenger2 , Keys.ENTER);
        this.sendKeysToElementVisible(this.yearsPassenger2, years);
        this.sendKeysToElementVisible(this.yearsPassenger2 , Keys.ENTER);
        this.sendKeysToElementVisible(this.inputTypeDocumentPassenger2, docucumentType);
        this.sendKeysToElementVisible(this.inputTypeDocumentPassenger2 , Keys.ENTER);
    }

    public FormPassengerData(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
