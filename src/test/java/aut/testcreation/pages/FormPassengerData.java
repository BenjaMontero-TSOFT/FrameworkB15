package aut.testcreation.pages;

import cucumber.api.java.de.Wenn;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FormPassengerData extends FormContact{

    //Passenger 1
    By byName = By.xpath("//input[@name='groups.1.travellers.1.title']");
    @FindBy(xpath = "//input[@name='groups.1.travellers.1.title']")
    private List<WebElement> genderList;

    @FindBy(xpath = "//input[@name='groups.1.travellers.1.name']")
    private WebElement namePassenger;

    @FindBy(xpath = "//input[@name='groups.1.travellers.1.surname']")
    private WebElement surNamePassenger;

    @FindBy(xpath = "//input[@name='groups.1.travellers.1.dateOfBirth']")
    private List<WebElement> dateOfBirth;

    @FindBy(xpath = "//button[@data-testid='groups.1.travellers.1.dateOfBirth_month']//span[@class='Selectstyles__SelectedOption-sc-d5yk3i-6 btKVzJ']")
    private WebElement getDateOfBirthMonthPassenger;

    @FindBy(xpath = "//span[@class='FormFieldstyles__LabelText-sc-1pt5zgp-0 hAXCiV' and text()='Año']")
    private List<WebElement> yearsPassengerList;

    @FindBy(xpath = "//button[@data-testid='groups.1.travellers.1.documentType']")
    private WebElement btnTypeDocumentPassenger;

    @FindBy(xpath = "//span[@class='MenuItemstyles__Label-sc-fguzn7-1 eALBLu' and text()='Pasaporte']")
    private WebElement optionTypeDocumentPassenger;

    @FindBy(xpath = "//input[@name='groups.1.travellers.1.documentNumber']")
    private WebElement inputTypeDocumentPassenger;

    @FindBy(xpath = "//button[@data-testid='groups.1.travellers.1.dateOfBirth_month']")
    private WebElement btnMonth;

    //Passenger 2
    @FindBy(xpath = "//input[@name='groups.1.travellers.2.title']")
    private List<WebElement> genderList2;

    @FindBy(xpath = "//input[@name='groups.1.travellers.2.name']")
    private WebElement namePassenger2;

    @FindBy(xpath = "//input[@name='groups.1.travellers.2.surname']")
    private WebElement surNamePassenger2;

    @FindBy(xpath = "//input[@name='groups.1.travellers.2.dateOfBirth']")
    private List<WebElement> dateOfBirth2;

    @FindBy(xpath = "//button[@data-testid='groups.1.travellers.2.dateOfBirth_month']//span[@class='Selectstyles__SelectedOption-sc-d5yk3i-6 btKVzJ']")
    private WebElement getDateOfBirthMonthPassenger2;

    @FindBy(xpath = "//span[@class='FormFieldstyles__LabelText-sc-1pt5zgp-0 hAXCiV' and text()='Año']")
    private List<WebElement> yearsPassengerList2;

    @FindBy(xpath = "//button[@data-testid='groups.1.travellers.2.documentType']")
    private WebElement btnTypeDocumentPassenger2;

    @FindBy(xpath = "//span[@class='MenuItemstyles__Label-sc-fguzn7-1 eALBLu' and text()='Pasaporte']")
    private WebElement optionTypeDocumentPassenger2;

    @FindBy(xpath = "//input[@name='groups.1.travellers.2.documentNumber']")
    private WebElement inputTypeDocumentPassenger2;

    @FindBy(xpath = "//button[@data-testid='groups.1.travellers.2.dateOfBirth_month']")
    private WebElement btnMonth2;

    @FindBy(xpath = "//span[@class='MenuItemstyles__Label-sc-fguzn7-1 eALBLu']")
    private WebElement monthSelect;


    //Passenger 1

    public void completeInputGenderPassenger(String gender){
        if(gender.equalsIgnoreCase("Sr")){
            this.clickElementByJavaScript(genderList.get(0));
        }
        else {
            this.clickElementByJavaScript(genderList.get(1));
        }
    }
    public void completeInputNamePassenger(String name){
        this.sendKeysToElementVisible(this.namePassenger, name);
    }
    public void completeInputSurNamePassenger(String surName){
        this.sendKeysToElementVisible(this.surNamePassenger, surName);
    }
    public void completeInputDayPassenger(String day){
        this.clickElementByJavaScript(this.dateOfBirth.get(0));
        this.sendKeysToElementVisible(this.dateOfBirth.get(0),day);
        this.sendKeysToElementVisible(this.dateOfBirth.get(0) , Keys.ENTER);
    }
    public void completeInputMonthPassenger(String month) throws InterruptedException {
        this.clickElementByJavaScript(this.btnMonth);
        this.clickToElementClickable(compareMonthPassenger(month));
    }
    public void completeInputYearsPassenger(String years){
        this.clickElementByJavaScript(yearsPassengerList.get(0));
        this.sendKeysToElementVisible(this.dateOfBirth.get(1), years);
        this.sendKeysToElementVisible(this.dateOfBirth.get(1) , Keys.ENTER);
    }
    public void completeInputDocumentType(String documentType){
        this.clickToElementClickable(this.btnTypeDocumentPassenger);
        this.clickToElementClickable(this.optionTypeDocumentPassenger);
        this.sendKeysToElementVisible(this.inputTypeDocumentPassenger,documentType);
    }
    public WebElement compareMonthPassenger(String month) throws InterruptedException {
        this.clickToElementClickable(btnMonth);
        List<WebElement> monthOptions = monthSelect.findElements(By.xpath("//span[@class='MenuItemstyles__Label-sc-fguzn7-1 eALBLu']"));
        for(WebElement monthOption : monthOptions){
            if(monthOption.getText().equalsIgnoreCase(month)){
                return monthOption;
            }
        }
        return null;
    }
    //Passenger 2

    public void completeInputGenderPassenger2(String gender){
        if(gender.equalsIgnoreCase("Sr")){
            this.clickElementByJavaScript(genderList2.get(0));
        }
        else {
            this.clickElementByJavaScript(genderList2.get(1));
        }
    }
    public void completeInputNamePassenger2(String name){
        this.sendKeysToElementVisible(this.namePassenger2, name);
    }
    public void completeInputSurNamePassenger2(String surName){
        this.sendKeysToElementVisible(this.surNamePassenger2, surName);
    }
    public void completeInputDayPassenger2(String day){
        this.clickElementByJavaScript(this.dateOfBirth2.get(0));
        this.sendKeysToElementVisible(this.dateOfBirth2.get(0),day);
        this.sendKeysToElementVisible(this.dateOfBirth2.get(0) , Keys.ENTER);
    }
    public void completeInputMonthPassenger2(String month) throws InterruptedException {
        this.clickElementByJavaScript(this.btnMonth2);
        this.clickToElementClickable(compareMonthPassenger2(month));
    }
    public void completeInputYearsPassenger2(String years){
        this.clickElementByJavaScript(yearsPassengerList2.get(0));
        this.sendKeysToElementVisible(this.dateOfBirth2.get(1), years);
        this.sendKeysToElementVisible(this.dateOfBirth2.get(1) , Keys.ENTER);
    }
    public void completeInputDocumentType2(String documentType){
        this.clickToElementClickable(this.btnTypeDocumentPassenger2);
        this.clickToElementClickable(this.optionTypeDocumentPassenger2);
        this.sendKeysToElementVisible(this.inputTypeDocumentPassenger2,documentType);
    }
    public WebElement compareMonthPassenger2(String month) throws InterruptedException {
        this.clickToElementClickable(btnMonth2);
        List<WebElement> monthOptions = monthSelect.findElements(By.xpath("//span[@class='MenuItemstyles__Label-sc-fguzn7-1 eALBLu']"));
        for(WebElement monthOption : monthOptions){
            if(monthOption.getText().equalsIgnoreCase(month)){
                return monthOption;
            }
        }
        return null;
    }


    public FormPassengerData(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
