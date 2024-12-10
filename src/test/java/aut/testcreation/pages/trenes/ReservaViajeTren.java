package aut.testcreation.pages.trenes;

import aut.testcreation.pages.*;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ReservaViajeTren extends SeleniumWrapper {

    protected NavBarHomePage navBarHomePage = new NavBarHomePage(driver);
    protected SearchNavigationTrenes searchNavigationTrenes = new SearchNavigationTrenes(driver);
    protected FiltersJourney filtersJourney = new FiltersJourney(driver);
    protected FormContact formContact = new FormContact(driver);
    protected FormPaymentData formPaymentData = new FormPaymentData(driver);


    @FindBy(xpath = "//label[@class='insurance__noThanks-radio-label']//input")
    private WebElement btnSecureNoThanks;

    @FindBy(xpath = "//button[@data-test='lead-generation-submit-btn']")
    private WebElement btnSiguiente;

    @FindBy(xpath = "//div[@data-test='smart-voucher-title']")
    private WebElement btnCupon;

    @FindBy(xpath = "//input[@id='voucher']")
    private WebElement inputCupon;

    @FindBy(xpath = "//button[@data-test='smart-voucher-button']")
    WebElement btnAplicar;

    public void completeFormContact(String name, String surName, String email, String prefijo, String tel){
        formContact.completeInputName(name);
        formContact.completeInputSurname(surName);
        formContact.completeInputEmail(email);
        //formContact.completeInputPrefijo(prefijo);
        formContact.completeInputTel(tel);
    }

    public void completeSearchJourney(String origin, String destination,String dateIda, String dateVuelta){
        searchNavigationTrenes.journeyOriginOption(origin);
        searchNavigationTrenes.journeyDestinationOption(destination);
        searchNavigationTrenes.selectDates(dateIda,dateVuelta);
        searchNavigationTrenes.clickPersonsOptions();
        searchNavigationTrenes.selectPeople(2);
        searchNavigationTrenes.clickSearch();
    }

    public void selectSectionTrenes(){
        navBarHomePage.selectVerMas();
        navBarHomePage.selectTrenesSection();
    }

    public void completeFormPassenger(String numberPassengerString, String gender,String name, String surName, String day, String month, String years, String documentType) throws InterruptedException {

        int numberPassenger = Integer.parseInt(numberPassengerString);
        //Locators
        By byGenderList = By.xpath("//input[@name='groups.1.travellers."+numberPassenger+".title']");
        By byNamePassenger = By.xpath("//input[@name='groups.1.travellers."+numberPassenger+".name']");
        By bySurNamePassenger = By.xpath("//input[@name='groups.1.travellers."+numberPassenger+".surname']");
        By byDateOfBirth = By.xpath("//input[@name='groups.1.travellers."+numberPassenger+".dateOfBirth']");
        By byBtnMonthText = By.xpath("//button[@data-testid='groups.1.travellers."+numberPassenger+".dateOfBirth_month']");
        By byYearsPassengerList = By.xpath("//span[text()='Año']");//AQUI
        By byBtnTypeDocumentPassenger = By.xpath("//button[@data-testid='groups.1.travellers."+numberPassenger+".documentType']");
        By byInputTypeDocumentPassenger = By.xpath("//input[@name='groups.1.travellers."+numberPassenger+".documentNumber']");

        //Elements web
        List<WebElement> genderList = driver.findElements(byGenderList);
        WebElement namePassenger = driver.findElement(byNamePassenger);
        WebElement surNamePassenger = driver.findElement(bySurNamePassenger);
        List<WebElement> dateOfBirth = driver.findElements(byDateOfBirth);
        WebElement btnMonth = driver.findElement(byBtnMonthText);
        List<WebElement> yearsPassengerList = driver.findElements(byYearsPassengerList);
        WebElement btnTypeDocumentPassenger = driver.findElement(byBtnTypeDocumentPassenger);
        WebElement inputTypeDocumentPassenger = driver.findElement(byInputTypeDocumentPassenger);

        //Gender
        if(gender.equalsIgnoreCase("Sr"))clickElementByJavaScript(genderList.get(0));
        else clickElementByJavaScript(genderList.get(1));

        //Name user
        sendKeysToElementVisible(namePassenger, name);
        //Surname user
        sendKeysToElementVisible(surNamePassenger, surName);
        //Day DateofBirth
        clickElementByJavaScript(dateOfBirth.get(0));
        sendKeysToElementVisible(dateOfBirth.get(0),day);
        sendKeysToElementVisible(dateOfBirth.get(0) , Keys.ENTER);
        //Month
        clickElementByJavaScript(btnMonth);
        WebElement monthInput = driver.findElement(By.xpath("//input[@aria-label='search-input']"));
        sendKeysToElementVisible(monthInput,month);
        sendKeysToElementVisible(monthInput,Keys.ENTER);
        //Years
        clickElementByJavaScript(yearsPassengerList.get(0));
        sendKeysToElementVisible(dateOfBirth.get(1), years);
        sendKeysToElementVisible(dateOfBirth.get(1) , Keys.ENTER);
        //Document passenger
        clickElementByJavaScript(btnTypeDocumentPassenger);
        By byOptionTypeDocPassenger = By.xpath("//li[@data-testid='menu-item']");
        List<WebElement> optionTypeDocumentPassenger = driver.findElements(byOptionTypeDocPassenger);
        clickElementByJavaScript(optionTypeDocumentPassenger.get(0));
        sendKeysToElementVisible(inputTypeDocumentPassenger,documentType);
    }


    public void completeFormPaymentData(String numberCard, String month, String year, String CVV, String cardHolder){
        formPaymentData.insertNumberOfCreditCard(numberCard);
        formPaymentData.insertMonth(month);
        formPaymentData.insertYear(year);
        formPaymentData.insertCvv(CVV);
        formPaymentData.insertCardHolder(cardHolder);
    }

    public void completeSelectJourney(){
        filtersJourney.selectJourney();
        filtersJourney.selectBtn();
    }

    public void secureNoThanks(){
        this.clickElementByJavaScript(btnSecureNoThanks);
    }

    public void clickBtnSiguiente(){
        this.clickToElementClickable(btnSiguiente);
    }

    public String titlePageFilterJourney(){
        //String titlePageFilterJourney = titlePageFilterJourney.getText();
        return null;
    }

    public void setCuponDescuento(String value){
        this.clickElementByJavaScript(btnCupon);
        this.sendKeysToElementVisible(inputCupon,value);
        this.sendKeysToElementVisible(inputCupon, Keys.ENTER);
        this.clickToElementClickable(btnAplicar);
    }

    public ReservaViajeTren(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
