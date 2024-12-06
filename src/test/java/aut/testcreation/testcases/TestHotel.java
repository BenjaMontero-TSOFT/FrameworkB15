package aut.testcreation.testcases;

import aut.testcreation.pages.HomePage;
import aut.testcreation.pages.SearchNavigationHome;
import aut.testcreation.pages.hotel.*;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Arrays;

public class TestHotel extends SeleniumTestBase {

    private HomePage homePage;
    private SearchNavigationHotel searchNavigationHotel;
    private SearchedHotelPage searchedHotelPage;
    private FiltersOfHotel filtersOfHotel;
    private InformationHotelPage informationHotelPage;
    private ReserveHotelPage reserveHotelPage;

    @Test
    @DisplayName("TC-H01")
    public void datesFlexibleWithTwoOrMoreRoomsMessageError() throws InterruptedException {
        //agregar que el home page reciba un search navigation y hacer lo mismo que con el form contact
        this.driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        Thread.sleep(2000);
        this.homePage.closeCookies();
        this.searchNavigationHotel = new SearchNavigationHotel(driver);

        this.searchNavigationHotel.moveSearchNavigationToHotel();
        this.searchNavigationHotel.insertMean(dataSet.get(1));

        this.searchNavigationHotel.clickFirstOption();
        this.searchNavigationHotel.openDates();
        this.searchNavigationHotel.moveToDatesFlexibles();
        this.searchNavigationHotel.selectFourToSixNigths();

        this.searchNavigationHotel.clickPersonsOptions();
        this.searchNavigationHotel.selectPeople(Integer.parseInt(dataSet.get(2)));
        this.searchNavigationHotel.addRoom();
        String message = this.searchNavigationHotel.getAlertMessage();
        Assertions.assertTrue(message.equalsIgnoreCase(dataSet.get(3)));

    }

    @Test
    @DisplayName("TC-H02")
    public void orderResultsToSearchedByPrices() throws InterruptedException {
        //agregar que el home page reciba un search navigation y hacer lo mismo que con el form contact
        this.driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        Thread.sleep(2000);
        this.homePage.closeCookies();
        this.searchNavigationHotel = new SearchNavigationHotel(driver);
        this.searchedHotelPage = new SearchedHotelPage(driver);
        this.informationHotelPage = new InformationHotelPage(driver);
        this.reserveHotelPage = new ReserveHotelPage(driver);
        this.filtersOfHotel = new FiltersOfHotel(driver);

        this.searchNavigationHotel.moveSearchNavigationToHotel();
        this.searchNavigationHotel.insertMean(dataSet.get(1));

        this.searchNavigationHotel.clickFirstOption();
        this.searchNavigationHotel.openDates();
        this.searchNavigationHotel.selectDates(dataSet.get(2), dataSet.get(3));

        this.searchNavigationHotel.search();
        Thread.sleep(4000);
        this.filtersOfHotel.selectTypeOfMeanToHotel();
        this.filtersOfHotel.selectOrderByPriceAsc();
        Double firstPrice = this.searchedHotelPage.getPriceOfResultOfPositionSearched(0);
        Double secondPrice = this.searchedHotelPage.getPriceOfResultOfPositionSearched(1);
        Assertions.assertTrue(firstPrice <= secondPrice);

    }

    @Test
    @DisplayName("TC-H03")
    public void reserveHotelNroTelError() throws InterruptedException {
        //agregar que el home page reciba un search navigation y hacer lo mismo que con el form contact
        this.driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        //Thread.sleep(2000);
        this.homePage.closeCookies();
        this.searchNavigationHotel = new SearchNavigationHotel(driver);
        this.searchedHotelPage = new SearchedHotelPage(driver);
        this.informationHotelPage = new InformationHotelPage(driver);
        this.reserveHotelPage = new ReserveHotelPage(driver);
        this.filtersOfHotel = new FiltersOfHotel(driver);

        this.searchNavigationHotel.moveSearchNavigationToHotel();
        this.searchNavigationHotel.insertMean(dataSet.get(1));

        this.searchNavigationHotel.clickFirstOption();
        this.searchNavigationHotel.openDates();
        this.searchNavigationHotel.selectDates(dataSet.get(3), dataSet.get(4));

        this.searchNavigationHotel.search();


        String[] values = {dataSet.get(5), dataSet.get(6)};
        this.filtersOfHotel.selectedOptionsServices(values);
        this.searchedHotelPage.goToFirstResult();

        this.informationHotelPage.goToReserve();
        this.reserveHotelPage.completeFormContact(dataSet.get(7),
                dataSet.get(8),
                dataSet.get(9),
                dataSet.get(10),
                dataSet.get(11)
                );
        String messageError = this.reserveHotelPage.getMessageTelError();
        Assertions.assertEquals(messageError, dataSet.get(2));
    }

    @Test
    @DisplayName("TC-H04")
    public void reserveHotelNroCvvError() throws InterruptedException, IOException {
        //agregar que el home page reciba un search navigation y hacer lo mismo que con el form contact
        this.driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        //Thread.sleep(2000);
        this.homePage.closeCookies();
        this.searchNavigationHotel = new SearchNavigationHotel(driver);
        this.searchedHotelPage = new SearchedHotelPage(driver);
        this.informationHotelPage = new InformationHotelPage(driver);
        this.reserveHotelPage = new ReserveHotelPage(driver);
        this.filtersOfHotel = new FiltersOfHotel(driver);

        this.searchNavigationHotel.moveSearchNavigationToHotel();
        this.searchNavigationHotel.insertMean(dataSet.get(1));

        this.searchNavigationHotel.clickFirstOption();
        this.searchNavigationHotel.openDates();
        this.searchNavigationHotel.selectDates(dataSet.get(3), dataSet.get(4));

        this.searchNavigationHotel.search();


        String[] values = {dataSet.get(5), dataSet.get(6)};
        this.filtersOfHotel.selectedOptionsServices(values);

        this.searchedHotelPage.goToFirstResult();
        this.informationHotelPage.goToReserve();
        this.reserveHotelPage.completeFormContact(dataSet.get(7),
                dataSet.get(8),
                dataSet.get(9),
                dataSet.get(10),
                dataSet.get(11)
        );
        this.reserveHotelPage.completeFormPayment(dataSet.get(12), dataSet.get(13), dataSet.get(14), dataSet.get(15));
        String messageError = this.reserveHotelPage.getMessageCvvError();
        Assertions.assertEquals(messageError, dataSet.get(2));
    }

    @Test
    @DisplayName("TC-H05")
    public void addRoomAndGoToReservePage() throws InterruptedException {
        //agregar que el home page reciba un search navigation y hacer lo mismo que con el form contact
        this.driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        Thread.sleep(2000);
        this.homePage.closeCookies();
        this.searchNavigationHotel = new SearchNavigationHotel(driver);
        this.searchedHotelPage = new SearchedHotelPage(driver);
        this.informationHotelPage = new InformationHotelPage(driver);
        this.reserveHotelPage = new ReserveHotelPage(driver);

        this.searchNavigationHotel.moveSearchNavigationToHotel();
        this.searchNavigationHotel.insertMean(dataSet.get(1));

        this.searchNavigationHotel.clickFirstOption();
        this.searchNavigationHotel.openDates();
        this.searchNavigationHotel.selectDates(dataSet.get(2), dataSet.get(3));
        this.searchNavigationHotel.search();
        Thread.sleep(4000);
        this.searchedHotelPage.goToFirstResult();
        this.informationHotelPage.goToReserve();
        boolean validate = this.reserveHotelPage.isStayInReservePage();
        Assertions.assertTrue(validate);

    }

    @Test
    @DisplayName("TC-H06")
    public void findHotelsInCountry() throws InterruptedException {
        //agregar que el home page reciba un search navigation y hacer lo mismo que con el form contact
        this.driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        Thread.sleep(2000);
        this.homePage.closeCookies();
        this.searchNavigationHotel = new SearchNavigationHotel(driver);
        this.searchedHotelPage = new SearchedHotelPage(driver);
        this.informationHotelPage = new InformationHotelPage(driver);
        this.reserveHotelPage = new ReserveHotelPage(driver);

        this.searchNavigationHotel.moveSearchNavigationToHotel();
        this.searchNavigationHotel.insertMean(dataSet.get(1));

        this.searchNavigationHotel.clickFirstOption();
        this.searchNavigationHotel.openDates();
        this.searchNavigationHotel.selectDates(dataSet.get(2), dataSet.get(3));
        this.searchNavigationHotel.search();
        Thread.sleep(4000);
        this.searchedHotelPage.goToResultByArgentina();
        Thread.sleep(4000);
        boolean validate = this.searchedHotelPage.titleOfResultContainsText(dataSet.get(1));
        Assertions.assertTrue(validate);

    }

}
