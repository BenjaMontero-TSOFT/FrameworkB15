package aut.testcreation.testcases;

import aut.testcreation.pages.*;
import aut.testcreation.pages.trenes.FiltersJourney;
import aut.testcreation.pages.trenes.SearchNavigationTrenes;
import framework.engine.selenium.SeleniumTestBase;
import framework.engine.selenium.SeleniumWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestTrenes extends SeleniumTestBase {

    private HomePage homePage;
    private NavBarHomePage navBarHomePage;
    private SearchNavigationTrenes searchNavigationTrenes;
    private FiltersJourney filtersJourney;
    private FormContact formContact;
    private FormPassengerData formPassengerData;
    private FormPaymentData formPaymentData;

    @Test
    @DisplayName("TC-T01")
    public void reservaTrenPagoViajeTitularInvalido() throws InterruptedException{
        this.driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(driver);
        Thread.sleep(1000);
        this.homePage.closeCookies();
        this.navBarHomePage = new NavBarHomePage(driver);
        this.searchNavigationTrenes = new SearchNavigationTrenes(driver);
        this.filtersJourney = new FiltersJourney(driver);
        this.formContact = new FormContact(driver);
        this.formPassengerData = new FormPassengerData(driver);
        this.formPaymentData = new FormPaymentData(driver);

        navBarHomePage.selectSectionTrenes();
        searchNavigationTrenes.completeSearchJourney("Madrid","Bilbao","25","5");
        filtersJourney.completeSelectJourney();
        formContact.completeFormContact("Gonzalo","Acevedo","useruser1515@gmail.com","+54","4567879091");
        formPassengerData.completeFormPassenger("Sr","UserName","SurNameUser","10","Marzo","2000","39090453");
        formPassengerData.completeFormPassenger2("Sra","userTwo","suNameUserTwo","15","enero","1995","29087976");
        formPassengerData.secureNoThanks();
        formPassengerData.clickBtnSiguiente();
        Thread.sleep(3000);
        formPaymentData.insertNumberOfCreditCard("4517629108566275");
        formPaymentData.insertMonth("02");
        formPaymentData.insertYear("30");
        formPaymentData.insertCvv("345");
        formPaymentData.insertCardHolder("+");
        if(formPaymentData.messageInvalidCardHolderError()){
            System.out.println("Test aprobado");
        }
        else System.out.println("Test NO aprobado");
    }
}
