package aut.testcreation.pages.trenes;

import aut.testcreation.pages.SearchNavigationHome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchNavigationTrenes extends SearchNavigationHome {

    @FindBy(xpath = "//button[@aria-label='¿Cuándo?']")
    private WebElement btnDatesTren;

    @FindBy(id = ":R5kd9dalamt2mm:")
    private WebElement itemOrigin;

    @FindBy(xpath = "//li[@id='listbox-option-25']")
    private WebElement itemMadrid;

    @FindBy(id = ":R6kd9dalamt2mm:")
    private WebElement itemDestination;

    @FindBy(xpath = "//li[@id='listbox-option-6']")
    private WebElement itemBilbao;

    @FindBy(xpath = "//ul[@id=':R5kd9dalamt2mmH2:']")
    private WebElement listJourneyOrigin;

    @FindBy(xpath = "//ul[@id=':R6kd9dalamt2mmH2:']")
    private WebElement listJourneyDestination;

    @FindBy(xpath = "//button[@class='d-1qoyuz']")
    private WebElement btnSearch;

    @FindBy(xpath = "//span[@class='d-glv9jj']")
    private WebElement people;

    public void journeyOriginOption(String origin){
        this.clickToElementClickable(this.itemOrigin);
        List<WebElement> listItems = listJourneyOrigin.findElements(By.tagName("li"));

        for (WebElement item : listItems) {
            String itemText = item.findElement(By.tagName("span")).getText();

            if (itemText.equals(origin)) {
                this.clickToElementClickable(item);
                return;
            }
        }
    }

    public void journeyDestinationOption(String origin){
        this.clickToElementClickable(this.itemDestination);
        List<WebElement> listItems = listJourneyDestination.findElements(By.tagName("li"));

        for (WebElement item : listItems) {
            String itemText = item.findElement(By.tagName("span")).getText();

            if (itemText.equals(origin)) {
                this.clickToElementClickable(item);
                return;
            }
        }
    }

    public void clickPersonsOptions(){
        this.clickElementByJavaScript(this.people);
    }

    public void completeSearchJourney(String origin, String destination,String dateIda, String dateVuelta){
        journeyOriginOption(origin);
        journeyDestinationOption(destination);
        selectDates(dateIda,dateVuelta);
        clickPersonsOptions();
        selectPeople(2);
        clickSearch();
    }

    public void clickSearch(){
        this.clickToElementClickable(btnSearch);
    }

    public void openDates(){
        this.clickElementByJavaScript(btnDatesTren);
    }

    public SearchNavigationTrenes(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
