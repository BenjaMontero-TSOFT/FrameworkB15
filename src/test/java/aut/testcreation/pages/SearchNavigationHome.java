package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SearchNavigationHome extends SeleniumWrapper {

    @FindBy(xpath = "//div[@aria-label='Vuelos']//button[@aria-label='¿Cuándo?']")
    private WebElement btnDates;

    @FindBy (xpath = "//div[@aria-label='Vuelo + Hotel']//button[@aria-label='¿Cuándo?']")
    private WebElement fechasVueloHotelGC;

    @FindBy(xpath = "//div[@class='d-b1sfx4']/*[2]//button[@tabindex='-1']")
    private List<WebElement> btnsFirstDates;

    @FindBy(xpath = "//div[@class='d-b1sfx4']/*[3]//button[@tabindex='-1']")
    private List<WebElement> btnsSecondDates;

    @FindBy(xpath = "//form[@aria-label='Hoteles']/div/div[3]")
    private WebElement btnPersonsToRoom;
    //TODO: Revisar xpath domingo

    @FindBy(xpath = "//Button[@aria-label='Aumentar el número de adultos']")
    protected WebElement btnUploadQuantityOfAdults;

    @FindBy(xpath = "//form[@aria-label='Hoteles']//button[@aria-label='Buscar']")
    private WebElement btnSearch;

    @FindBy(xpath = "//button[text()='Fechas flexibles']")
    private WebElement btnDatesFlexible;

    @FindBy(xpath = "//span[@class='d-glv9jj'][text()='1 pasajero · Cualquier clase']")
    private WebElement people;

    @FindBy(xpath = "//button[@aria-label='Aumentar el número de adultos']")
    private WebElement addPeople;

    @FindBy (xpath = "//button[@aria-label='Aumentar el número de niños']")
    private WebElement sumaMenor;

    @FindBy (xpath = "//button[text()='4-6 noches']")
    private WebElement btnFourToSixNigths;

    @FindBy (xpath = "//button[text()='Añadir habitación']")
    private WebElement btnAddRoom;

    @FindBy (xpath = "//span[@role='alert']")
    private WebElement alertMessage;

    @FindBy(xpath = "//LI[@id='listbox-option-0']")
    private WebElement firstOptionOfLocation;

    @FindBy (xpath = "//li[text()='Bebé, 0-11 meses']")
    private WebElement BtnBabyOption;

    @FindBy (xpath = "//div[@class='d-1ea2lc2']//span")
    protected WebElement numberPeople;

    @FindBy (xpath = "//Button[@aria-label='Reducir el número de adultos']")
    protected WebElement btnDegradeQuantityOfAdults;

    public SearchNavigationHome(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void clickFirstOption(){
        try{
            Thread.sleep(1000);
            this.clickToElementClickable(this.firstOptionOfLocation);
        }catch(Exception e){

        }
    }

    public void openDates(){
        this.clickElementByJavaScript(this.btnDates);
    }

    public void openDatesGC(){
        this.clickToElementClickable(this.fechasVueloHotelGC);
    }

    public void selectDates(String firstDate, String secondDate){
        //itero y selecciono el btn que contenga el nro del dia que me llega por parametro
        //openDates();

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

    public void selectDatesGC(String firstDate, String secondDate){
        //itero y selecciono el btn que contenga el nro del dia que me llega por parametro
        openDatesGC();

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

    public void selectDate(String date){
        openDates();

        //itero y selecciono el btn que contenga el nro del dia que me llega por parametro
        for(WebElement btnDate : this.btnsFirstDates){
            if(this.getTextByElement(btnDate).equalsIgnoreCase(date)){
                this.clickToElementClickable(btnDate);
                break;
            }
        }
    }

    public void selectPeople(int peopleNumber){
        int number = 0;

        //this.clickElementByJavaScript(this.btnPersonsToRoom);
        for(int i = 0; number != peopleNumber ; i++ ){
            number = Integer.parseInt(this.numberPeople.getText());
            if(number > peopleNumber){
                this.clickToElementClickable(this.btnDegradeQuantityOfAdults);
            }
            if(number < peopleNumber){
                this.clickToElementClickable(this.btnUploadQuantityOfAdults);
            }
        }
    }

    public void addBaby (String childrenAge){
        this.clickToElementClickable(sumaMenor);
        clickToElementClickable(BtnBabyOption);
    }

    public void moveToDatesFlexibles(){
        this.clickToElementClickable(this.btnDatesFlexible);
    }

    public void clickPersonsOptions(){
        this.clickToElementClickable(this.btnPersonsToRoom);
    }

    public void selectFourToSixNigths(){
        this.clickToElementClickable(this.btnFourToSixNigths);
    }

    public void search(){
        this.clickElementByJavaScript(this.btnSearch);
    }

    public String getAlertMessage(){
        return this.getTextByElement(this.alertMessage);
    }

    public void addRoom(){
        this.clickToElementClickable(this.btnAddRoom);
    }


}
