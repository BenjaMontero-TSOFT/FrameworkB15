package aut.testcreation.pages.hotel;

import cucumber.api.java.eo.Do;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchedHotelPage extends SeleniumWrapper {

    private FiltersOfHotel filtersOfHotel;

    @FindBy(xpath = "//div[@data-testid='card-container']")
    private List<WebElement> resultsOfSearched;

    @FindBy(xpath = "//div[@class='openx-ui-card-details-desk']//div[contains(text(),'Argentina')]")
    private WebElement resultsOfSearchedByArgentina;

    @FindBy(xpath = "//div[@data-testid='card-container']//span[contains(text(), 'HOTEL')]")
    private List<WebElement> titleOfResults;

    @FindBy(xpath = "//div[@data-testid='card-container']//span[contains(@class, 'sc-85da2539-5')]")
    private List<WebElement> pricesOfResults;

    @FindBy (xpath = "//div[@id='openx-ui-search']")
    private WebElement research;

    //@FindBy (xpath = "//div[text()='Buscar otras fechas']")
    @FindBy (xpath = "//div[@role='button']//span")
    private List<WebElement> changeDatesBtn;

    public SearchedHotelPage(WebDriver driver) {
        super(driver);
        this.filtersOfHotel = new FiltersOfHotel(driver);
        PageFactory.initElements(driver, this);
    }

    public Double getPriceOfResultOfPositionSearched(int position){
        WebElement price = this.pricesOfResults.get(position);
        String text = this.getTextByElement(price);
        String number = text.replaceAll("[^\\d]", ""); // Queda solo "36"
        return Double.valueOf(number);
    }

    public void goToFirstResult() throws InterruptedException {
        WebElement firsResult = this.resultsOfSearched.get(0);
        Thread.sleep(1000);
        this.clickToElementClickable(firsResult);
        this.switchTab();
    }

    public void goToResultByArgentina(){
        this.clickElementByJavaScript(resultsOfSearchedByArgentina);
    }

    public boolean titleOfResultContainsText(String title){
        for (WebElement element : titleOfResults){
            String value = this.getTextByElement(element);
            if(value.toLowerCase().contains(title.toLowerCase())){
                return true;
            }
        }

        return false;
    }

    public void changeDates(String fechaViejaIda, String fechaViejaVuelta, String fechaIda, String fechaVuelta) throws InterruptedException {
        //clickToElementClickable(changeDatesBtn); //este boton no existe o no lo econtre

        //se podria iterar esos botones, obtener el texto y compararlo con las fechas q ingresaste primero
        String text;
        String newText;
        for (WebElement boton : changeDatesBtn){
            Thread.sleep(1000);
            text = getTextByElement(boton);
            newText = extractNumbersAndDashes(text);
            System.out.println(text);
            System.out.println(newText);

            if (newText.equals(fechaViejaIda + "-" + fechaViejaVuelta)){
                Thread.sleep(2000);
                clickToElementClickable(boton);

                By byIda = By.xpath("//div[@data-date='2024-12-" + fechaIda + "']");
                Thread.sleep(1000);
                By byVuelta = By.xpath("//div[@data-date='2024-12-" + fechaVuelta + "']");
                clickToElementClickable(findElement(byIda));
                clickToElementClickable(findElement(byVuelta));
                Thread.sleep(500);
                clickElementByJavaScript(research);
                break;
            }
        }

        /*//ej 9 dic - 19 dic, pedirle a chat gpt, que te haga un metodo, que en base a ese string, elimine todo
        //lo que no sea un numero pero que deje el - -> entonces quedaria 9-19

        //text = getTextByElement() obtenes el texto del elemento

        //newText = funcionPedidaAchatGpt()

        //si newText.equals(primerFechaIda + "-" + primerFechaVuelta)

        //ahi le haces click al elemento ese

        //se te despleiga el menu de las fechas normales y ahi seleccionas las nuevas fechas
        //capaz que podes reutilizar el metodo de selectDates de SearchNavigationHome
        By byIda = By.xpath("//div[@data-date='2024-12-" + fechaIda + "']");
        By byVuelta = By.xpath("//div[@data-date='2024-12-" + fechaVuelta + "']");
        click(byIda);
        click(byVuelta);
        clickToElementClickable(research);*/
    }

    public String extractNumbersAndDashes(String input) {
        return input.replaceAll("[^0-9-]", "");
    }

    public Integer getResultSize(){
        return this.resultsOfSearched.size();
    }

}
