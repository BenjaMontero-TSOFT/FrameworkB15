package aut.testcreation.testcases;

import aut.testcreation.pages.HomePage;
import aut.testcreation.pages.SearchNavigationHome;
import aut.testcreation.pages.hotel.*;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class TestHotel extends SeleniumTestBase {

    private HomePage homePage;
    private SearchNavigationHotel searchNavigationHotel;
    private SearchedHotelPage searchedHotelPage;
    private FiltersOfHotel filtersOfHotel;
    private InformationHotelPage informationHotelPage;
    private ReserveHotelPage reserveHotelPage;

    @Test
    @DisplayName("TC-H03")
    public void reserveHotelNroTelError(){
        //agregar que el home page reciba un search navigation y hacer lo mismo que con el form contact
        this.driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        this.searchNavigationHotel = new SearchNavigationHotel(driver);
        this.searchedHotelPage = new SearchedHotelPage(driver);
        this.informationHotelPage = new InformationHotelPage(driver);
        this.reserveHotelPage = new ReserveHotelPage(driver);
        this.filtersOfHotel = new FiltersOfHotel(driver);

        this.searchNavigationHotel.moveSearchNavigationToHotel();
        this.searchNavigationHotel.insertMean("Barcelona");
        this.searchNavigationHotel.openDates();
        this.searchNavigationHotel.selectDates("25", "5");
        this.searchNavigationHotel.search();
        String[] values = {"Wifi gratis", "Piscina"};
        this.filtersOfHotel.selectedOptionsServices(values);
        this.searchedHotelPage.goToFirstResult();
        this.informationHotelPage.goToReserve();
        this.reserveHotelPage.completeFormContact("Benjamin",
                "Montero",
                "benjamontero.contacto@gmail.com",
                "+54",
                "213124414555123123"
                );
        String messageError = this.reserveHotelPage.getMessageTelError();
        Assertions.assertTrue(messageError.equalsIgnoreCase("Introduce un número de teléfono válido"));
    }

}
