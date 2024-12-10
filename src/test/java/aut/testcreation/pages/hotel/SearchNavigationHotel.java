package aut.testcreation.pages.hotel;

import aut.testcreation.pages.SearchNavigationHome;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchNavigationHotel extends SearchNavigationHome {

    @FindBy(xpath = "//input[@aria-label='Buscar alojamiento en']")
    private WebElement inputSearchMean;
    @FindBy(xpath = "//Button[@aria-label='Hoteles']")
    private WebElement btnHotel;


    public SearchNavigationHotel(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void insertMean(String text){
        this.sendKeysToElementVisible(this.inputSearchMean, text);
        //this.sendKeysToElementVisible(this.inputSearchMean, Keys.ENTER);
    }


    public void moveSearchNavigationToHotel(){
        this.clickToElementClickable(this.btnHotel);

    }
}
