package aut.testcreation.testcases;

import aut.testcreation.pages.*;
import aut.testcreation.pages.trenes.MessageAlertTrenes;
import aut.testcreation.pages.trenes.ReservaViajeTren;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestTrenes extends SeleniumTestBase {


    @Test
    @DisplayName("TC-T01")
    public void reservaTrenPagoViajeTitularInvalido() throws InterruptedException{
        ReservaViajeTren reservaViajeTren = new ReservaViajeTren(driver);
        reservaViajeTren.selectSectionTrenes();
        reservaViajeTren.completeSearchJourney("Madrid","Bilbao","25","5");
        reservaViajeTren.completeSelectJourney();
        reservaViajeTren.completeFormContact("Gonzalo","Acevedo","useruser1515@gmail.com","54","4567879091");
        reservaViajeTren.completeFormPassenger("Sr","UserName","SurNameUser","10","Marzo","2000","39090453");
        reservaViajeTren.completeFormPassenger2("Sra","userTwo","suNameUserTwo","15","enero","1995","29087976");
        reservaViajeTren.secureNoThanks();
        reservaViajeTren.clickBtnSiguiente();
        Thread.sleep(3000);
        reservaViajeTren.completeFormPaymentData("4517629108566275","02","30","345","+");


        /*String messageTest = messageErrorCardHolder.getText();
        if(messageTest.equalsIgnoreCase("Titular ingresado invalido")){
            System.out.println("Test aprobado");
        }
        else System.out.println("Test NO aprobado");*/
    }
    @Test
    @DisplayName("TC-T02")
    public void ReservaTrenPagoViajeTarjetaAAlejanoinvalido() throws InterruptedException {
        ReservaViajeTren reservaViajeTren = new ReservaViajeTren(driver);
        MessageAlertTrenes messageAlertTrenes = new MessageAlertTrenes(driver);
        reservaViajeTren.selectSectionTrenes();
        reservaViajeTren.completeSearchJourney("Madrid","Bilbao","25","5");
        reservaViajeTren.completeSelectJourney();
        reservaViajeTren.completeFormContact("Gonzalo","Acevedo","useruser1515@gmail.com","+54","4567879091");
        reservaViajeTren.completeFormPassenger("Sr","UserName","SurNameUser","10","Marzo","2000","39090453");
        reservaViajeTren.completeFormPassenger2("Sra","userTwo","suNameUserTwo","15","enero","1995","29087976");
        reservaViajeTren.secureNoThanks();
        reservaViajeTren.clickBtnSiguiente();
        Thread.sleep(3000);
        reservaViajeTren.completeFormPaymentData("4517629108566275","02","43","345","+");
        String messageTest = messageAlertTrenes.errorAnioLejano();
        if(messageTest.equalsIgnoreCase("Año demasiado lejano en el tiempo")){
            System.out.println("Test aprobado");
        }
        else System.out.println("Test NO aprobado");
    }

    @Test
    @DisplayName("TC-T03")
    public void ReservaTrenTituloPageTren () throws InterruptedException {
        ReservaViajeTren reservaViajeTren = new ReservaViajeTren(driver);
        reservaViajeTren.selectSectionTrenes();
        reservaViajeTren.completeSearchJourney("Madrid","Bilbao","25","5");
        String titlePage = driver.getTitle();
        Assertions.assertEquals("Rumbo vuelos baratos Madrid - Bilbao",titlePage);
    }

    @Test
    @DisplayName("TC-T04")
    public void ReservaTrenDatosPagoCuponDescuentoInvalido () throws InterruptedException {
        MessageAlertTrenes messageAlertTrenes = new MessageAlertTrenes(driver);
        ReservaViajeTren reservaViajeTren = new ReservaViajeTren(driver);
        reservaViajeTren.selectSectionTrenes();
        reservaViajeTren.completeSearchJourney("Madrid","Bilbao","25","5");
        reservaViajeTren.completeSelectJourney();
        reservaViajeTren.completeFormContact("Gonzalo","Acevedo","useruser1515@gmail.com","+54","4567879091");
        reservaViajeTren.completeFormPassenger("Sr","UserName","SurNameUser","10","Marzo","2000","39090453");
        reservaViajeTren.completeFormPassenger2("Sra","userTwo","suNameUserTwo","15","enero","1995","29087976");
        reservaViajeTren.secureNoThanks();
        reservaViajeTren.clickBtnSiguiente();
        Thread.sleep(3000);
        reservaViajeTren.completeFormPaymentData("4517629108566275","02","30","345","User Name Card");
        reservaViajeTren.setCuponDescuento("HOLIDAY100");
        String message = messageAlertTrenes.errorCuponDescuento();
        if(message.equalsIgnoreCase("El bono ha caducado.")){
            System.out.println("Test aprobado");
        }
        else System.out.println("Test NO aprobado");
    }

    @Test
    @DisplayName("TC-T05")
    public void ReservaTrenCargaDatosIngresoEdadNinioInvalido () throws InterruptedException {
        ReservaViajeTren reservaViajeTren = new ReservaViajeTren(driver);
        MessageAlertTrenes messageAlertTrenes = new MessageAlertTrenes(driver);
        reservaViajeTren.selectSectionTrenes();
        reservaViajeTren.completeSearchJourney("Madrid","Bilbao","25","5");
        reservaViajeTren.completeSelectJourney();
        reservaViajeTren.completeFormContact("Gonzalo","Acevedo","useruser1515@gmail.com","+54","4567879091");
        reservaViajeTren.completeFormPassenger("Sr","UserName","SurNameUser","10","Marzo","2000","39090453");
        reservaViajeTren.completeFormPassenger2("Sra","userTwo","suNameUserTwo","15","enero","2014","29087976");
        String message = messageAlertTrenes.errorPassengerEdad();
        if(message.equalsIgnoreCase("El adulto debe tener más de 12 años")){
            System.out.println("Test aprobado");
        }
        else System.out.println("Test NO aprobado");
    }

    @Test
    @DisplayName("TC-T06")
    public void ReservaTrenCargaDatosIngresoEdadBebeInvalido () throws InterruptedException {
        ReservaViajeTren reservaViajeTren = new ReservaViajeTren(driver);
        MessageAlertTrenes messageAlertTrenes = new MessageAlertTrenes(driver);
        reservaViajeTren.selectSectionTrenes();
        reservaViajeTren.completeSearchJourney("Madrid","Bilbao","25","5");
        reservaViajeTren.completeSelectJourney();
        reservaViajeTren.completeFormContact("Gonzalo","Acevedo","useruser1515@gmail.com","+54","4567879091");
        reservaViajeTren.completeFormPassenger("Sr","UserName","SurNameUser","10","Marzo","2000","39090453");
        reservaViajeTren.completeFormPassenger2("Sra","userTwo","suNameUserTwo","15","enero","2023","29087976");
        String message = messageAlertTrenes.errorPassengerEdad();
        if(message.equalsIgnoreCase("El adulto debe tener más de 12 años")){
            System.out.println("Test aprobado");
        }
        else System.out.println("Test NO aprobado");
    }

    @BeforeEach
    public void preCondiciones() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        this.driver.get("https://www.rumbo.es/");
        Thread.sleep(1000);
        homePage.closeCookies();
    }
}
