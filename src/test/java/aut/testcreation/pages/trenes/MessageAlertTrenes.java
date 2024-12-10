package aut.testcreation.pages.trenes;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MessageAlertTrenes extends SeleniumWrapper {

    public void errorCardHolder() {
        By byMessageErrorCardHolder = By.xpath("//div[@data-testid='creditCard.cardHolder']//span[@data-testid='input-helper-text']");
        try {
            WebElement messageErrorCardHolder = driver.findElement(byMessageErrorCardHolder);
            if (messageErrorCardHolder.getText().equalsIgnoreCase("Titular ingresado invalido")) {
                System.out.println("Test aprobado");
            } else {
                System.out.println("Test NO aprobado: Unexpected error message");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Test No aprobado: Element not found");
        }
    }

    public void errorCuponDescuento() {
        By byMessageCuponResult = By.xpath("//label[@for='voucher' and text()='El bono ha caducado.']");
        WebElement messageCuponResult = driver.findElement(byMessageCuponResult);

        if (messageCuponResult.getText().equalsIgnoreCase("El bono ha caducado.")) System.out.println("Test aprobado");
        else {
            System.out.println("Test NO aprobado");
        }
    }

    public void errorPassengerEdad(){
        By byMessageAdultoIncorrecto = By.xpath("//span[@data-testid='groups.1.travellers.2.dateOfBirth_error']");
        WebElement messageAdultoIncorrecto = driver.findElement(byMessageAdultoIncorrecto);

        if(messageAdultoIncorrecto.getText().equalsIgnoreCase("El adulto debe tener más de 12 años"))System.out.println("Test aprobado");
        else System.out.println("Test NO aprobado");
    }

    public void errorDistantYear(){
        By byMessageErrorCardExpiration = By.xpath("//span[@data-testid='creditCard.expirationDate_error']");
        WebElement messageErrorCardExpiration = driver.findElement(byMessageErrorCardExpiration);

        if(messageErrorCardExpiration.getText().equalsIgnoreCase("Año demasiado lejano en el tiempo"))System.out.println("Test aprobado");
        else System.out.println("Test NO aprobado");
    }

    public void errorTitle(){
        String titlePage = driver.getTitle();
        if(titlePage.equalsIgnoreCase("Rumbo trenes baratos Madrid - Bilbao"))System.out.println("Test aprobado");
        else System.out.println("Test NO aprobado");
    }

    public MessageAlertTrenes(WebDriver driver) {
        super(driver);
    }
}
