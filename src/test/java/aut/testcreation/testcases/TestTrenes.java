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
        Thread.sleep(2000);
        this.homePage.closeCookies();
        this.navBarHomePage = new NavBarHomePage(driver);
        this.searchNavigationTrenes = new SearchNavigationTrenes(driver);
        this.filtersJourney = new FiltersJourney(driver);
        this.formContact = new FormContact(driver);
        this.formPassengerData = new FormPassengerData(driver);
        this.formPaymentData = new FormPaymentData();

        navBarHomePage.selectVerMas();
        navBarHomePage.selectTrenesSection();
        searchNavigationTrenes.journeyOriginOption("Madrid");
        searchNavigationTrenes.journeyDestinationOption("Bilbao");
        searchNavigationTrenes.selectDates("25","5");
        searchNavigationTrenes.selectPeople(4);
        searchNavigationTrenes.clickSearch();
        Thread.sleep(2000);
        filtersJourney.selectJourney();
        filtersJourney.selectBtn();
        formContact.completeInputName("Gonzalo");
        formContact.completeInputSurname("Acevedo");
        formContact.completeInputEmail("useruser12@gmail.com");
        formContact.completeInputPrefijo("CL");
        formContact.completeInputTel("3834230988");

    }
}
