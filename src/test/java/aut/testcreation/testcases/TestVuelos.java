package aut.testcreation.testcases;

import aut.testcreation.pages.Avion.*;
import aut.testcreation.pages.FormContact;
import aut.testcreation.pages.FormPassengerData;
import aut.testcreation.pages.FormPaymentData;
import aut.testcreation.pages.HomePage;
import aut.testcreation.pages.hotel.FiltersOfHotel;
import aut.testcreation.pages.hotel.InformationHotelPage;
import aut.testcreation.pages.hotel.ReserveHotelPage;
import aut.testcreation.pages.hotel.SearchedHotelPage;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestVuelos extends SeleniumTestBase {
    private SearchNavigationAvion searchAvion;
    private FlightResultsPage resultadosVuelos;
    private HomePage homePage;
    private FiltersOfHotel hotelFiltro;
    private SearchedHotelPage hoteles;
    private InformationHotelPage infoHotel;
    private FlashSaleLandingPage flashSale;
    private Fee fee;
    private FormContact contactData;
    private FormPassengerData passengerData;
    private ReserveFlightPage reserveFlight;
    private SeatReservationPage seatReservation;
    private FormPaymentData paymentData;


    @Test
    @DisplayName("TC-V01")
    public void busquedaSimple() throws InterruptedException {
        driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        Thread.sleep(2000);
        this.homePage.closeCookies();

        searchAvion = new SearchNavigationAvion(this.driver);
        resultadosVuelos = new FlightResultsPage(this.driver);

        searchAvion.fillFlightSearch_Ida("Buenos Aires (BUE)", "Madrid (MAD)", "American Express", "12", 1);
        searchAvion.clickBuscar();
        resultadosVuelos.selectFlight();
    }

    @Test
    @DisplayName("TC-V02")
    public void busaquedaFallida_IdaVuelta() throws InterruptedException {
        driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        Thread.sleep(2000);
        this.homePage.closeCookies();

        searchAvion = new SearchNavigationAvion(this.driver);
        searchAvion.fillFlightSearch_IdaVuelta_Hotel("Buenos Aires (BUE)", "Madrid (MAD)", "American Express", "12", "20");
        searchAvion.AmountOfBabysWrong("Bebé, 0-11 meses");

    }

    @Test
    @DisplayName("TC-V03")
    public void modificarVuelo() throws  InterruptedException{
        driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        this.hotelFiltro = new FiltersOfHotel(this.driver);
        this.hoteles = new SearchedHotelPage(this.driver);
        this.infoHotel = new InformationHotelPage(this.driver);

        Thread.sleep(2000);
        this.homePage.closeCookies();

        searchAvion = new SearchNavigationAvion(this.driver);
        searchAvion.fillFlightSearch_IdaVuelta_Hotel("Buenos Aires (BUE)", "Madrid (MAD)", "American Express", "12", "2");
        searchAvion.addHotel();
        searchAvion.clickBuscar();

        hotelFiltro.StarsFilter();
        Thread.sleep(1000);

        hoteles.goToFirstResult();
        Thread.sleep(2000);

        infoHotel.changeFlight();

    }

    @Test
    @DisplayName("TC-V04")
    public void modificarFechas() throws InterruptedException{
        driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        this.searchAvion = new SearchNavigationAvion(this.driver);
        this.hoteles = new SearchedHotelPage(this.driver);

        homePage.closeCookies();
        searchAvion.fillFlightSearch_IdaVuelta_Hotel("Buenos Aires (BUE)", "Madrid (MAD)", "American Express", "5", "31");
        searchAvion.addHotel();
        searchAvion.clickBuscar();
        Thread.sleep(1000);
        hoteles.changeDates("13", "20");
    }

    @Test
    @DisplayName("TC-V05")
    public void reservaFlashSale () throws InterruptedException{
        driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        this.searchAvion = new SearchNavigationAvion(this.driver);
        this.flashSale = new FlashSaleLandingPage(this.driver);
        this.infoHotel = new InformationHotelPage(this.driver);
        this.fee = new Fee(this.driver);
        this.contactData = new FormContact(this.driver);
        this.passengerData = new FormPassengerData(this.driver);
        this.reserveFlight = new ReserveFlightPage(this.driver);
        this.seatReservation = new SeatReservationPage(this.driver);

        homePage.closeCookies();

        searchAvion.vuelosFlashSaleNavBar();
        Thread.sleep(2000);
        flashSale.selectFlashSale();
        Thread.sleep(1000);

        infoHotel.goToReserve();
        infoHotel.continueToReserveToFirstOption();

        fee.SelectFee();

        reserveFlight.completeFormContact( "Asdasd", "Asdasd", "agustinvillanaon@gmail.com", "+54", "1121856755");
        reserveFlight.fillFlightForm("1", "Asdasd", "Asdasd", "13", "enero", "1989");
        reserveFlight.fillFlightForm("2", "eeeeee", "rrrrrrrrrr", "14", "febrero", "1999");
        reserveFlight.fillAddressData("Avenida TSOFT", "1234", "2234", "Madrid");
        reserveFlight.siguiente();
        seatReservation.seatAdvice();
        seatReservation.skipStep();
        seatReservation.goToPaymentPage();
        reserveFlight.completeFormPayment("4445 8889 4448 9999", "enero", "25", "4444");
        String messageError = this.reserveFlight.getMessageCvvError();
        Assertions.assertEquals(messageError, "Introduce los 3 dígitos del código CVV de tu tarjeta.");
    }

    @Test
    @DisplayName("TC-V06")
    public void granCanaria(){

    }

}
