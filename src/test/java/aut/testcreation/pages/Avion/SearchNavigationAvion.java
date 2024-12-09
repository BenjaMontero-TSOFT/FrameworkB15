package aut.testcreation.pages.Avion;

import aut.testcreation.pages.SearchNavigationHome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SearchNavigationAvion extends SearchNavigationHome {

    @FindBy (xpath = "//button[text()='Ida y vuelta']")
    private WebElement IdaYVuelta;

    @FindBy (xpath = "//button[text()='Solo ida']")
    private WebElement SoloIda;

    @FindBy (xpath = "//button[text()='Multidestino']")
    private WebElement MultiDestino;

    @FindBy (xpath = "//input[@type='checkbox']") //input[@id = 'isDpSearch']
    private WebElement addHotel;

    @FindBy (xpath = "//span[text()='Método más económico']")
    private WebElement MetodoDePago;

    @FindBy (xpath = "//input[@aria-label='Origen']")
    private WebElement origen;

    @FindBy (xpath = "//input[@aria-label='Destino']")
    private WebElement destino;

    @FindBy (xpath = "//div[@aria-label='Vuelos']//button[@aria-label='¿Cuándo?']")
    private WebElement BtnFechaIda;


    @FindBy (xpath = "//li[@role='option']")
    private List<WebElement> opciones;

    @FindBy (xpath = "//button[@aria-label='Buscar']")
    private WebElement search;

    @FindBy (xpath = "//div[@aria-label='Vuelo + Hotel']//button[@aria-label='Buscar']")
    private WebElement searchGranCanaria;

    @FindBy (xpath = "//div[@class='d-rs5dud']//span[@role='alert']")
    private WebElement errorMsg;

    public SearchNavigationAvion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openDates(){
        clickToElementClickable(BtnFechaIda);
    }

    public void fillFlightSearch_IdaVuelta_Hotel(String origenValue, String destinoValue, String metodo, String fehcaIda, String fechaVuelta) throws InterruptedException {

        selectedOptionPaymentMethod(metodo);
        sendKeysToElementVisible(origen, origenValue);
        sendKeysToElementVisible(destino, destinoValue);
        selectDates(fehcaIda, fechaVuelta);
        Thread.sleep(1000);

    }

    public void addHotel(){
        clickElementByJavaScript(addHotel);
        //addHotel.click();
    }

    public void clickBuscar(){
        clickToElementClickable(search);
    }

    public void clickBuscarGranCanaria(){
        clickToElementClickable(searchGranCanaria);
    }

    public void fillFlightSearch_Ida(String origenValue, String destinoValue, String metodo, String fehcaIda, Integer people) throws InterruptedException {
        Thread.sleep(1000);
        clickToElementClickable(SoloIda);
        Thread.sleep(1000);
        selectedOptionPaymentMethod(metodo);
        sendKeysToElementVisible(origen, origenValue);
        sendKeysToElementVisible(destino, destinoValue);
        selectDate(fehcaIda);
        clickPersonsOptions();
        selectPeople(1);
    }

    public void AmountOfBabysWrong(String babyAge){
        clickPersonsOptions();
        addBaby(babyAge);
        addBaby(babyAge);
    }

    public void selectedOptionPaymentMethod(String metodo){
        //despliego los metodos de pago
        this.clickToElementClickable(MetodoDePago);
        //itero para comparar el texto de cada una de las opciones
        By byLocator = By.xpath("//ul[@role='listbox']//li[text()='"+metodo+"']");
 /*
        if (isDisplayed(byLocator)){
            WebElement elemento = findElement(byLocator);
            clickToElementClickable(elemento);
        }
        for (WebElement option : opciones){
            //obtengo el texto del servicio
            //String textOfOption = this.getTextByElement(option);
            String textOfOption = option.getText();

            //itero para buscar si el texto del servicio es igual a alguno que recibo por parametro
            if(textOfOption.equalsIgnoreCase(metodo)){
                //si es igual click
                this.clickToElementClickable(option);
            }
        }*/
    }

    public String getErrorMsg(){
        return getTextByElement(errorMsg);
    }

}
