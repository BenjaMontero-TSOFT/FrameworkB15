package aut.testcreation.pages.trenes;

import aut.testcreation.pages.SearchNavigationHome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchNavigationTrenes extends SearchNavigationHome {

    @FindBy(id = ":R5kd9dalamt2mm:")
    private WebElement itemOrigin;

    @FindBy(xpath = "//li[@id='listbox-option-25']")
    private WebElement itemMadrid;

    @FindBy(id = ":R6kd9dalamt2mm:")
    private WebElement itemDestination;

    @FindBy(xpath = "//li[@id='listbox-option-6']")
    private WebElement itemBilbao;

    @FindBy(xpath = "//span[@class='d-glv9jj']")
    private WebElement people;

    @FindBy(xpath = "//div[@class='d-1ea2lc2']/button[2]")
    private WebElement addPeople;

    @FindBy(xpath = "//div[@class='d-1ea2lc2']/button[1]")
    private WebElement subtractPeople;

    @FindBy(xpath = "//span[@class='d-vuw68f']")
    private WebElement numberPeople;

    @FindBy(xpath = "//ul[@id=':R5kd9dalamt2mmH2:']")
    private WebElement listJourneyOrigin;

    @FindBy(xpath = "//ul[@id=':R6kd9dalamt2mmH2:']")
    private WebElement listJourneyDestination;

    @FindBy(xpath = "//button[@class='d-1qoyuz']")
    private WebElement btnSearch;

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
    public void selectPeople(int peopleNumber){
        int number = 0;
        this.clickElementByJavaScript(this.people);
        for(int i = 0; number != peopleNumber ; i++ ){
            number = Integer.parseInt(this.numberPeople.getText());
            if(number > peopleNumber){
                this.clickToElementClickable(this.subtractPeople);
            }
            if(number < peopleNumber){
                this.clickToElementClickable(this.addPeople);
            }
        }
    }
    public SearchNavigationTrenes(WebDriver driver) {
        super(driver);
    }

    public void clickSearch(){
        this.clickToElementClickable(btnSearch);
    }
}
