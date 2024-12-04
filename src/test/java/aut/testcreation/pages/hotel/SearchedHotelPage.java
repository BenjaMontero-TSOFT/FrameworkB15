package aut.testcreation.pages.hotel;

import cucumber.api.java.eo.Do;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void goToFirstResult(){
        WebElement firsResult = this.resultsOfSearched.get(0);
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

}
