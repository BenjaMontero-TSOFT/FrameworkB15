package aut.testcreation.pages.Avion;

import aut.testcreation.pages.SearchNavigationHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightResultsPage extends SearchNavigationHome {
    @FindBy (xpath = "//div[@class='trip-collection-view__trips-container-top']//button")
    private WebElement selectedFlightButton;

    public void selectFlight(){
        clickToElementClickable(selectedFlightButton);
    }

    public FlightResultsPage(WebDriver driver, WebElement selectedFlightButton) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
