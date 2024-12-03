package aut.testcreation.pages.Avion;

import aut.testcreation.pages.SearchNavigationHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SearchNavigationAvion extends SearchNavigationHome {

    @FindBy (xpath = "//button[text()='Ida y vuelta']")
    private WebElement IdaYVuelta;

    @FindBy (xpath = "//button[text()='Solo ida']")
    private WebElement SoloIda;

    @FindBy (xpath = "//button[text()='Multidestino']")
    private WebElement MultiDestino;

    @FindBy (xpath = "//input[@id = 'isDpSearch']")
    private WebElement addHotel;

    @FindBy (className = "d-1dupc4x")
    private WebElement MetodoDePago;

    @FindBy (xpath = "//input[@id=':R15l56dalbldq3mm:']")
    private WebElement origen;

    @FindBy (xpath = "//input[@id=':R16l56dalbldq2mm:']")
    private WebElement destino;

    @FindBy (xpath = "//ul[@role='listbox']")
    private List<WebElement> opciones;

    @FindBy (xpath = "//button[@aria-label='Buscar']")
    private WebElement search;

    @FindBy (xpath = "//div[@class='d-rs5dud']//span[@role='alert']")
    private WebElement errorMsg;

    public SearchNavigationAvion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillFlightSearch_IdaVuelta_Hotel(String origenValue, String destinoValue, String metodo, String fehcaIda, String fechaVuelta){
        selectedOptionPaymentMethod(metodo);
        clickToElementClickable(IdaYVuelta);
        sendKeysToElementVisible(origen, origenValue);
        sendKeysToElementVisible(destino, destinoValue);
        selectDates(fehcaIda, fechaVuelta);
        clickToElementClickable(addHotel);
        clickToElementClickable(search);
    }

    public void fillFlightSearch_Ida(String origenValue, String destinoValue, String metodo, String fehcaIda, Integer people){
        selectedOptionPaymentMethod(metodo);
        clickToElementClickable(SoloIda);
        sendKeysToElementVisible(origen, origenValue);
        sendKeysToElementVisible(destino, destinoValue);
        selectDate(fehcaIda);
        selectPeople(people);
        clickToElementClickable(search);
    }

    public void AmountOfBabysWrong(String babyAge){
        selectPeople(1);
        addChildren(babyAge);
        addChildren(babyAge);
    }

    public void selectedOptionPaymentMethod(String metodo){
        //despliego los metodos de pago
        this.clickToElementClickable(MetodoDePago);
        //itero para comparar el texto de cada una de las opciones
        for (WebElement option : opciones){
            //obtengo el texto del servicio
            String textOfOption = this.getTextByElement(option);

            //itero para buscar si el texto del servicio es igual a alguno que recibo por parametro
            if(textOfOption.equalsIgnoreCase(metodo)){
                //si es igual click
                this.clickToElementClickable(option);
            }
        }
    }

    public String getErrorMsg(){
        return getTextByElement(errorMsg);
    }

}
