package aut.testcreation.pages.trenes;

import aut.testcreation.pages.SearchNavigationHome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchNavigationTrenes extends SearchNavigationHome {

    @FindBy(id = ":R5kd9dalamt2mm:")
    private WebElement origin;

    @FindBy(xpath = "//li[@id='listbox-option-25']")
    private WebElement itemMadrid;

    @FindBy(id = ":R6kd9dalamt2mm:")
    private WebElement destination;

    @FindBy(xpath = "//li[@id='listbox-option-6']")
    private WebElement itemBilbao;

    @FindBy(xpath = "//span[@class='d-glv9jj'][text()='1 pasajero · Cualquier clase']")
    private WebElement people;

    @FindBy(xpath = "//button[@aria-label='Aumentar el número de adultos']")
    private WebElement addPeople;

    @FindBy(xpath = "//button[@aria-label='Reducir el número de adultos']")
    private WebElement subtractPeople;

    public void selectOrigin(){
        this.clickToElementClickable(this.origin);
        this.clickToElementClickable(this.itemMadrid);
        /*List<WebElement> options = driver.findElements(By.cssSelector("ul[role='listbox'] li"));

        for (WebElement option : options) {
            System.out.println(option.getText());
        }*/
    }
    public void selectDestination(){
        this.clickToElementClickable(this.destination);
        this.clickToElementClickable(this.itemBilbao);
    }
    public void selectPeople(int peopleNumber){
        this.clickToElementClickable(this.people);
        for(int i = 0; i < peopleNumber ; i++ ){
            this.clickToElementClickable(this.addPeople);
        }
    }

    public SearchNavigationTrenes(WebDriver driver) {
        super(driver);
    }
}
