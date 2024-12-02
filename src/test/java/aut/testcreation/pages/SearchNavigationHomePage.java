package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchNavigationHomePage extends SeleniumWrapper {

    @FindBy(xpath = "//Button[@aria-label='Hoteles']")
    private WebElement btnHotel;

    @FindBy(xpath = "//Button[@aria-label='Buscar alojamiento en']")
    private WebElement inputSearchMean;

    @FindBy(xpath = "//Button[@aria-label='¿Cuándo?']")
    private WebElement btnDates;

    @FindBy(xpath = "//div[@class='d-b1sfx4']/*[2]//button[@tabindex='-1']")
    private List<WebElement> btnsFirstDates;

    @FindBy(xpath = "//div[@class='d-b1sfx4']/*[3]//button[@tabindex='-1']")
    private List<WebElement> btnsSecondDates;

    @FindBy(xpath = "//div[@class='d-k7h9p']")
    private WebElement btnPersonsToRoom;

    @FindBy(xpath = "//Button[@aria-label='Aumentar el número de adultos']")
    private WebElement btnUploadQuantityOfAdults;

    @FindBy(xpath = "//Button[@aria-label='Buscar']")
    private WebElement btnSearch;

    @FindBy(xpath = "//button[text()='Fechas Flexibles']")
    private WebElement btnDatesFlexible;

    @FindBy(xpath = "//div[@class='d-uc5a44']//button[text()='4-6 noches']")
    private WebElement btnFourToSixNigths;

    @FindBy(xpath = "//span[@role='alert' and @class='d-t1bnmf']")
    private WebElement alertMessage;

    public SearchNavigationHomePage(WebDriver driver) {
        super(driver);
    }

    void moveSearchNavigationToHotel(){
        this.clickToElementClickable(this.btnHotel);
    }

    void insertMean(String text){
        this.sendKeysToElementVisible(this.inputSearchMean, text);
    }

    void openDates(){
        this.clickToElementClickable(this.btnDates);
    }

    void selectDates(String firstDate, String secondDate){
        //itero y selecciono el btn que contenga el nro del dia que me llega por parametro
        for(WebElement btnDate : this.btnsFirstDates){
            if(this.getTextByElement(btnDate).equalsIgnoreCase(firstDate)){
                this.clickToElementClickable(btnDate);
                break;
            }
        }


        for(WebElement btnDate : this.btnsSecondDates){
            if(this.getTextByElement(btnDate).equalsIgnoreCase(secondDate)){
                this.clickToElementClickable(btnDate);
                break;
            }
        }
    }

    void moveToDatesFlexibles(){
        this.clickToElementClickable(this.btnDatesFlexible);
    }

    void selectFourToSixNigths(){
        this.clickToElementClickable(this.btnFourToSixNigths);
    }

    void search(){
        this.clickToElementClickable(this.btnSearch);
    }

    void getAlertMessage(){
        this.getTextByElement(this.alertMessage);
    }


}
