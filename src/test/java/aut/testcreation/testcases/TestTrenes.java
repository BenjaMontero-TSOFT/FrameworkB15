package aut.testcreation.testcases;

import aut.testcreation.pages.*;
import aut.testcreation.pages.trenes.MessageAlertTrenes;
import aut.testcreation.pages.trenes.ReservaViajeTren;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestTrenes extends SeleniumTestBase {


    @Test
    @DisplayName("TC-T01")
    public void reservaTrenPagoViajeTitularInvalido() throws InterruptedException{
        ReservaViajeTren reservaViajeTren = new ReservaViajeTren(driver);
        reservaViajeTren.selectSectionTrenes();
        reservaViajeTren.completeSearchJourney(dataSet.get(1),dataSet.get(2),dataSet.get(3),dataSet.get(4));
        reservaViajeTren.completeSelectJourney();
        reservaViajeTren.completeFormContact(dataSet.get(5),dataSet.get(6),dataSet.get(7),dataSet.get(8),dataSet.get(9));
        reservaViajeTren.completeFormPassenger("1",dataSet.get(11),dataSet.get(12),dataSet.get(13),dataSet.get(14),dataSet.get(15),dataSet.get(16),dataSet.get(17));
        reservaViajeTren.completeFormPassenger("2",dataSet.get(11),dataSet.get(12),dataSet.get(13),dataSet.get(14),dataSet.get(15),dataSet.get(16),dataSet.get(17));
        reservaViajeTren.secureNoThanks();
        reservaViajeTren.clickBtnSiguiente();
        reservaViajeTren.completeFormPaymentData(dataSet.get(18),dataSet.get(19),dataSet.get(20),dataSet.get(21),dataSet.get(22));

        MessageAlertTrenes messageAlertTrenes = new MessageAlertTrenes(driver);
        messageAlertTrenes.errorCardHolder();

    }
    @Test
    @DisplayName("TC-T02")
    public void ReservaTrenPagoViajeTarjetaAAlejanoinvalido() throws InterruptedException {
        ReservaViajeTren reservaViajeTren = new ReservaViajeTren(driver);
        MessageAlertTrenes messageAlertTrenes = new MessageAlertTrenes(driver);
        reservaViajeTren.selectSectionTrenes();
        reservaViajeTren.completeSearchJourney(dataSet.get(1),dataSet.get(2),dataSet.get(3),dataSet.get(4));
        reservaViajeTren.completeSelectJourney();
        reservaViajeTren.completeFormContact(dataSet.get(5),dataSet.get(6),dataSet.get(7),dataSet.get(8),dataSet.get(9));
        reservaViajeTren.completeFormPassenger("1",dataSet.get(11),dataSet.get(12),dataSet.get(13),dataSet.get(14),dataSet.get(15),dataSet.get(16),dataSet.get(17));
        reservaViajeTren.completeFormPassenger("2",dataSet.get(11),dataSet.get(12),dataSet.get(13),dataSet.get(14),dataSet.get(15),dataSet.get(16),dataSet.get(17));
        reservaViajeTren.secureNoThanks();
        reservaViajeTren.clickBtnSiguiente();
        reservaViajeTren.completeFormPaymentData(dataSet.get(18),dataSet.get(19),dataSet.get(20),dataSet.get(21),dataSet.get(22));
        messageAlertTrenes.errorDistantYear();

    }

    @Test
    @DisplayName("TC-T03")
    public void ReservaTrenTituloPageTren () throws InterruptedException {
        ReservaViajeTren reservaViajeTren = new ReservaViajeTren(driver);
        reservaViajeTren.selectSectionTrenes();
        reservaViajeTren.completeSearchJourney(dataSet.get(1),dataSet.get(2),dataSet.get(3),dataSet.get(4));
        MessageAlertTrenes messageAlertTrenes = new MessageAlertTrenes(driver);
        messageAlertTrenes.errorTitle();
    }

    @Test
    @DisplayName("TC-T04")
    public void ReservaTrenDatosPagoCuponDescuentoInvalido () throws InterruptedException {
        MessageAlertTrenes messageAlertTrenes = new MessageAlertTrenes(driver);
        ReservaViajeTren reservaViajeTren = new ReservaViajeTren(driver);
        reservaViajeTren.selectSectionTrenes();
        reservaViajeTren.completeSearchJourney(dataSet.get(1),dataSet.get(2),dataSet.get(3),dataSet.get(4));
        reservaViajeTren.completeSelectJourney();
        reservaViajeTren.completeFormContact(dataSet.get(5),dataSet.get(6),dataSet.get(7),dataSet.get(8),dataSet.get(9));
        reservaViajeTren.completeFormPassenger("1",dataSet.get(11),dataSet.get(12),dataSet.get(13),dataSet.get(14),dataSet.get(15),dataSet.get(16),dataSet.get(17));
        reservaViajeTren.completeFormPassenger("2",dataSet.get(11),dataSet.get(12),dataSet.get(13),dataSet.get(14),dataSet.get(15),dataSet.get(16),dataSet.get(17));
        reservaViajeTren.secureNoThanks();
        reservaViajeTren.clickBtnSiguiente();
        Thread.sleep(3000);
        reservaViajeTren.completeFormPaymentData(dataSet.get(18),dataSet.get(19),dataSet.get(20),dataSet.get(21),dataSet.get(22));
        reservaViajeTren.setCuponDescuento(dataSet.get(23));
        messageAlertTrenes.errorCuponDescuento();
    }

    @Test
    @DisplayName("TC-T05")
    public void ReservaTrenCargaDatosIngresoEdadNinioInvalido () throws InterruptedException {
        ReservaViajeTren reservaViajeTren = new ReservaViajeTren(driver);
        MessageAlertTrenes messageAlertTrenes = new MessageAlertTrenes(driver);
        reservaViajeTren.selectSectionTrenes();
        reservaViajeTren.completeSearchJourney(dataSet.get(1),dataSet.get(2),dataSet.get(3),dataSet.get(4));
        reservaViajeTren.completeSelectJourney();
        reservaViajeTren.completeFormContact(dataSet.get(5),dataSet.get(6),dataSet.get(7),dataSet.get(8),dataSet.get(9));
        reservaViajeTren.completeFormPassenger("1",dataSet.get(11),dataSet.get(12),dataSet.get(13),dataSet.get(14),dataSet.get(15),dataSet.get(16),dataSet.get(17));
        reservaViajeTren.completeFormPassenger("2",dataSet.get(11),dataSet.get(12),dataSet.get(13),dataSet.get(14),dataSet.get(15),dataSet.get(16),dataSet.get(17));
        messageAlertTrenes.errorPassengerEdad();

    }

    @Test
    @DisplayName("TC-T06")
    public void ReservaTrenCargaDatosIngresoEdadBebeInvalido () throws InterruptedException {
        ReservaViajeTren reservaViajeTren = new ReservaViajeTren(driver);
        MessageAlertTrenes messageAlertTrenes = new MessageAlertTrenes(driver);
        reservaViajeTren.selectSectionTrenes();
        reservaViajeTren.completeSearchJourney(dataSet.get(1),dataSet.get(2),dataSet.get(3),dataSet.get(4));
        reservaViajeTren.completeSelectJourney();
        reservaViajeTren.completeFormContact(dataSet.get(5),dataSet.get(6),dataSet.get(7),dataSet.get(8),dataSet.get(9));
        reservaViajeTren.completeFormPassenger("1",dataSet.get(11),dataSet.get(12),dataSet.get(13),dataSet.get(14),dataSet.get(15),dataSet.get(16),dataSet.get(17));
        reservaViajeTren.completeFormPassenger("2",dataSet.get(11),dataSet.get(12),dataSet.get(13),dataSet.get(14),dataSet.get(15),dataSet.get(16),dataSet.get(17));
        messageAlertTrenes.errorPassengerEdad();
    }

    @BeforeEach
    public void preCondiciones() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        this.driver.get("https://www.rumbo.es/");
        Thread.sleep(1000);
        homePage.closeCookies();
    }

}
