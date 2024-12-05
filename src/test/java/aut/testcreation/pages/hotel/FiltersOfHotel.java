package aut.testcreation.pages.hotel;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FiltersOfHotel extends SeleniumWrapper {

    @FindBy(xpath = "//div[@id='Pill-PropertyTypeContainer']")
    private WebElement typeOfMean;

    @FindBy(id = "exp_elem_accomodation_type_1")
    private WebElement optionHotelOfTypeOfMean;

    @FindBy (xpath = "//div[text()='Estrellas']")
    private WebElement btnStars;

    @FindBy (xpath = "//li[@id='exp_elem_hotel_stars_5']")
    private WebElement optFiveStarsFilter;

    @FindBy(xpath = "//button[text()='Aplicar']")
    private WebElement btnApply;

    @FindBy(id = "Pill-SortContainer")
    private WebElement btnOrder;

    @FindBy(id = "label_sort_price_asc")
    private WebElement optionOrderPriceAsc;

    @FindBy(id = "Pill-FacilitiesContainer")
    private WebElement btnServices;

    @FindBy(xpath = "//ul[@id='lb_list_general_accomodation_facilities']//div[@class='listbox-label']")
    private List<WebElement> optionServices;

    public FiltersOfHotel(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectedOptionsServices(String[] values){
        //despliego los servicios
        this.clickToElementClickable(btnServices);
        //itero para comparar el texto de cada una de las opciones de los servicios
        for (WebElement option : optionServices){
            //obtengo el texto del servicio
            String textOfOption = this.getTextByElement(option);

            //itero para buscar si el texto del servicio es igual a alguno que recibo por parametro
            for (String optionValue : values){
                if(textOfOption.equalsIgnoreCase(optionValue)){
                    //si es igual lo clickeo
                    this.clickToElementClickable(option);
                }
            }
        }
        //aplico los nuevos filtros
        this.clickToElementClickable(btnApply);
    }

    public void StarsFilter() {
        clickToElementClickable(btnStars);
        clickToElementClickable(optFiveStarsFilter);
        clickToElementClickable(btnApply);
    }

    public void selectOrderByPriceAsc(){
        this.clickToElementClickable(this.btnOrder);
        this.clickToElementClickable(this.optionOrderPriceAsc);
        //this.clickToElementClickable(this.btnApply);
    }

    public void selectTypeOfMeanToHotel(){
        this.clickElementByJavaScript(this.typeOfMean);
        this.clickElementByJavaScript(this.optionHotelOfTypeOfMean);
        this.clickToElementClickable(this.btnApply);
    }


}
