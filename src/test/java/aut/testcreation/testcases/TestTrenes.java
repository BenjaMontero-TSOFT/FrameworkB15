package aut.testcreation.testcases;

import aut.testcreation.pages.*;
import aut.testcreation.pages.trenes.ReservaViajeTren;
import framework.engine.selenium.SeleniumTestBase;
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
        reservaViajeTren.completeFormContact("Gonzalo","Acevedo","useruser1515@gmail.com","+54","4567879091");
        reservaViajeTren.completeFormPassenger("Sr","UserName","SurNameUser","10","Marzo","2000","39090453");
        reservaViajeTren.completeFormPassenger2("Sra","userTwo","suNameUserTwo","15","enero","1995","29087976");
        reservaViajeTren.secureNoThanks();
        reservaViajeTren.clickBtnSiguiente();
        Thread.sleep(3000);
        reservaViajeTren.completeFormPaymentData("4517629108566275","02","30","345","+");

        WebElement messageErrorCardHolder;
        messageErrorCardHolder = driver.findElement(By.xpath("//div[@data-testid='creditCard.cardHolder']//span[@data-testid='input-helper-text']"));

        String messageTest = messageErrorCardHolder.getText();
        if(messageTest.equalsIgnoreCase("Titular ingresado invalido")){
            System.out.println("Test aprobado");
        }
        else System.out.println("Test NO aprobado");
    }
    @Test
    @DisplayName("TC-T02")
    public void ReservaTrenPagoViajeTarjetaAAlejanoinvalido() throws InterruptedException {
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
        reservaViajeTren.completeFormPaymentData("4517629108566275","02","43","345","+");

        WebElement messageErrorCardHolder;
        messageErrorCardHolder = driver.findElement(By.xpath("//span[@data-testid='creditCard.expirationDate_error']"));

        String messageTest = messageErrorCardHolder.getText();
        if(messageTest.equalsIgnoreCase("Año demasiado lejano en el tiempo")){
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
