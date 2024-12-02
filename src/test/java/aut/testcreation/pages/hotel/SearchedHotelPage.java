package aut.testcreation.pages.hotel;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchedHotelPage extends SeleniumWrapper {

    private FiltersOfHotel filtersOfHotel;

    @FindBy(xpath = "//div[@class='sc-928ccd0e-0 dAlzUa']//div[@data-testid='card-container']")
    private List<WebElement> resultsOfSearched;

    public SearchedHotelPage(WebDriver driver) {
        super(driver);
        this.filtersOfHotel = new FiltersOfHotel(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPriceOfResultOfPositionSearched(int position){
        if(this.resultsOfSearched.size() < position){
            WebElement price = this.resultsOfSearched.get(position).findElement(By.xpath("//span[@class='sc-85da2539-5 kKrvRJ']"));
            String text = this.getTextByElement(price);
            //reemplaza todos los caracteres por que no son digitos, ej '36&nbsp;€'
            String number = text.replaceAll("[^\\d]", ""); // Queda solo "36"
            return number;
        }else{
            return null;
        }
    }

    public void goToFirstResult(){
        WebElement firsResult = this.resultsOfSearched.get(0);
        this.clickToElementClickable(firsResult);
    }


}
