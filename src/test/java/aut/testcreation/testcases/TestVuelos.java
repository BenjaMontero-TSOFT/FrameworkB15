package aut.testcreation.testcases;

import aut.testcreation.pages.*;
import aut.testcreation.pages.Avion.*;
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
    private NavBarHomePage navBar;
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
        this.fee = new Fee(this.driver);

        searchAvion = new SearchNavigationAvion(this.driver);
        resultadosVuelos = new FlightResultsPage(this.driver);

        searchAvion.fillFlightSearch_Ida(dataSet.get(1), dataSet.get(2), dataSet.get(3), dataSet.get(4), Integer.parseInt(dataSet.get(5)));
        searchAvion.clickBuscar();
        resultadosVuelos.selectFlight();

        Assertions.assertTrue(fee.getResult());
    }

    @Test
    @DisplayName("TC-V02")
    public void busaquedaFallida_IdaVuelta() throws InterruptedException {
        driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        Thread.sleep(2000);
        this.homePage.closeCookies();

        searchAvion = new SearchNavigationAvion(this.driver);
        searchAvion.fillFlightSearch_IdaVuelta_Hotel(dataSet.get(1), dataSet.get(2), dataSet.get(3), dataSet.get(4), dataSet.get(5));
        searchAvion.AmountOfBabysWrong(dataSet.get(6));

        Assertions.assertEquals(dataSet.get(7), searchAvion.getErrorMsg());

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
        searchAvion.fillFlightSearch_IdaVuelta_Hotel(dataSet.get(1), dataSet.get(2), dataSet.get(3), dataSet.get(4), dataSet.get(5));
        searchAvion.addHotel();
        Thread.sleep(1000);
        searchAvion.clickBuscar();

        hotelFiltro.StarsFilter();
        Thread.sleep(1000);

        hoteles.goToFirstResult();
        Thread.sleep(3000);

        infoHotel.changeFlight();

        Assertions.assertEquals(dataSet.get(6), infoHotel.getMejorOferta());

    }

    @Test
    @DisplayName("TC-V04")
    public void modificarFechas() throws InterruptedException{
        driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        this.searchAvion = new SearchNavigationAvion(this.driver);
        this.hoteles = new SearchedHotelPage(this.driver);

        homePage.closeCookies();
        searchAvion.fillFlightSearch_IdaVuelta_Hotel(dataSet.get(1), dataSet.get(2), dataSet.get(3), dataSet.get(4), dataSet.get(5));
        searchAvion.addHotel();
        searchAvion.clickBuscar();
        Thread.sleep(1000);
        hoteles.changeDates(dataSet.get(4), dataSet.get(5), dataSet.get(6), dataSet.get(7));

        Assertions.assertTrue(hoteles.getResultSize()!=0);
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
        this.navBar = new NavBarHomePage(this.driver);

        homePage.closeCookies();

        //Seleccionar FlashSale desde NavBar
        navBar.vuelosFlashSaleNavBar();
        Thread.sleep(2000);
        flashSale.selectFlashSale();
        Thread.sleep(1000);

        //Confirmacion de hotel
        infoHotel.goToReserve();
        infoHotel.continueToReserveToFirstOption();

        //Tarifa
        fee.selectFee();

        //Formulario
        reserveFlight.completeFormContact( dataSet.get(1), dataSet.get(2), dataSet.get(3), dataSet.get(4), dataSet.get(5));
        reserveFlight.fillFlightForm(dataSet.get(6), dataSet.get(7), dataSet.get(8), dataSet.get(9), dataSet.get(10), dataSet.get(11));
        reserveFlight.fillFlightForm(dataSet.get(12), dataSet.get(13), dataSet.get(14), dataSet.get(15), dataSet.get(16), dataSet.get(17));
        reserveFlight.fillAddressData(dataSet.get(18), dataSet.get(19), dataSet.get(20), dataSet.get(21));
        reserveFlight.siguiente();
        //Asientos y datos de pago
        seatReservation.seatAdvice();
        seatReservation.skipStep();
        Thread.sleep(1000);
        seatReservation.goToPaymentPage();
        reserveFlight.completeFormPayment(dataSet.get(22), dataSet.get(23), dataSet.get(24), dataSet.get(25));
        String messageError = this.reserveFlight.getMessageCvvError();
        Assertions.assertEquals(dataSet.get(26), messageError);
    }

    @Test
    @DisplayName("TC-V06")
    public void reservaIdaVuelta_Hotel_granCanaria() throws InterruptedException {
        driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        this.navBar = new NavBarHomePage(this.driver);
        this.searchAvion = new SearchNavigationAvion(this.driver);
        this.hotelFiltro = new FiltersOfHotel(this.driver);
        this.hoteles = new SearchedHotelPage(this.driver);
        this.infoHotel = new InformationHotelPage(this.driver);
        this.fee = new Fee(this.driver);
        this.reserveFlight = new ReserveFlightPage(this.driver);
        this.paymentData = new FormPaymentData(this.driver);

        homePage.closeCookies();

        navBar.granCanariaNavBar();
        searchAvion.selectDatesGC(dataSet.get(1), dataSet.get(2));
        searchAvion.clickBuscarGranCanaria();
        hotelFiltro.StarsFilter();
        Thread.sleep(5000);
        hoteles.goToFirstResult();
        infoHotel.goToReserve();
        Thread.sleep(2000);
        infoHotel.continueToReserveToFirstOption();
        fee.selectExtraPackFee();
        reserveFlight.completeFormContact(dataSet.get(3), dataSet.get(4), dataSet.get(5), dataSet.get(6), dataSet.get(7));
        Thread.sleep(1000);
        reserveFlight.fillFlightForm(dataSet.get(8), dataSet.get(9), dataSet.get(10), dataSet.get(11), "", dataSet.get(12));
        reserveFlight.siguiente();

        Assertions.assertEquals(dataSet.get(13), reserveFlight.getNameError());

    }

}
