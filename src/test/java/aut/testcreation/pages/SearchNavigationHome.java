package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchNavigationHome extends SeleniumWrapper {

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

    @FindBy(xpath = "//form[@aria-label='Hoteles']//button[@aria-label='Buscar']")
    private WebElement btnSearch;

    @FindBy(xpath = "//button[text()='Fechas Flexibles']")
    private WebElement btnDatesFlexible;

    @FindBy(xpath = "//span[@class='d-glv9jj'][text()='1 pasajero · Cualquier clase']")
    private WebElement people;

    @FindBy(xpath = "//button[@aria-label='Aumentar el número de adultos']")
    private WebElement addPeople;

    @FindBy (xpath = "//button[@aria-label='Aumentar el número de niños']")
    private WebElement sumaMenor;

    @FindBy (xpath = "//div[@class='d-uc5a44']//button[text()='4-6 noches']")
    private WebElement btnFourToSixNigths;

    @FindBy (xpath = "//span[@role='alert' and @class='d-t1bnmf']")
    private WebElement alertMessage;

    @FindBy (xpath = "//ul[@class='d-5wyavi']")
    private List<WebElement> childrenAgeList;

    public SearchNavigationHome(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openDates(){
        this.clickElementByJavaScript(this.btnDates);
    }

    public void selectDates(String firstDate, String secondDate){
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

    public void selectDate(String date){
        //itero y selecciono el btn que contenga el nro del dia que me llega por parametro
        for(WebElement btnDate : this.btnsFirstDates){
            if(this.getTextByElement(btnDate).equalsIgnoreCase(date)){
                this.clickToElementClickable(btnDate);
                break;
            }
        }
    }

    public void selectPeople(int peopleNumber){
        this.clickToElementClickable(this.people);
        for(int i = 0; i < peopleNumber ; i++ ){
            this.clickToElementClickable(this.addPeople);
        }
    }

    public void addChildren (String childrenAge){
        this.clickToElementClickable(sumaMenor);
        for (WebElement edad : childrenAgeList){
            String edadText = this.getTextByElement(edad);

            if (edadText.equalsIgnoreCase(childrenAge)){
                clickToElementClickable(edad);
            }
        }
    }

    public void moveToDatesFlexibles(){
        this.clickToElementClickable(this.btnDatesFlexible);
    }

    public void clickPersonsOptions(){
        this.clickElementByJavaScript(this.btnPersonsToRoom);
    }

    public void selectFourToSixNigths(){
        this.clickToElementClickable(this.btnFourToSixNigths);
    }

    public void search(){
        this.clickElementByJavaScript(this.btnSearch);
    }

    public void getAlertMessage(){
        this.getTextByElement(this.alertMessage);
    }


}
