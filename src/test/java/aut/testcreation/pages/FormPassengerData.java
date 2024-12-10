package aut.testcreation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FormPassengerData extends FormContact{

    //Passenger 1
    By byName = By.xpath("//input[@name='groups.1.travellers.1.title']");




    public FormPassengerData(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
