package aut.testcreation.pages.trenes;

import aut.testcreation.pages.*;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ReservaViajeTren extends SeleniumWrapper {

    private NavBarHomePage navBarHomePage = new NavBarHomePage(driver);
    private SearchNavigationTrenes searchNavigationTrenes = new SearchNavigationTrenes(driver);
    private FiltersJourney filtersJourney = new FiltersJourney(driver);
    private FormContact formContact = new FormContact(driver);
    private FormPassengerData formPassengerData = new FormPassengerData(driver);
    private FormPaymentData formPaymentData = new FormPaymentData(driver);


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

    public void completeFormPassenger(String gender,String name, String surName, String day, String month, String years, String documentType) throws InterruptedException {
        formPassengerData.completeInputGenderPassenger(gender);
        formPassengerData.completeInputNamePassenger(name);
        formPassengerData.completeInputSurNamePassenger(surName);
        formPassengerData.completeInputDayPassenger(day);
        formPassengerData.completeInputMonthPassenger(month);
        formPassengerData.completeInputYearsPassenger(years);
        formPassengerData.completeInputDocumentType(documentType);
    }

    public void completeFormPassenger2(String gender, String name, String surName, String day, String month, String years, String documentType) throws InterruptedException {
        formPassengerData.completeInputGenderPassenger2(gender);
        formPassengerData.completeInputNamePassenger2(name);
        formPassengerData.completeInputSurNamePassenger2(surName);
        formPassengerData.completeInputDayPassenger2(day);
        formPassengerData.completeInputMonthPassenger2(month);
        formPassengerData.completeInputYearsPassenger2(years);
        formPassengerData.completeInputDocumentType2(documentType);
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
