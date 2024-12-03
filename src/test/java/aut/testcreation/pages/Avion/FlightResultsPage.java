package aut.testcreation.pages.Avion;

import aut.testcreation.pages.SearchNavigationHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightResultsPage extends SearchNavigationHome {
    @FindBy (xpath = "//div[@class='trip-collection-view__trips-container-top']//button")
    private WebElement selectedFlightButton;

    @FindBy (xpath = "//button[@data-testid='lmn-ds-btn']")
    private WebElement confirmFlight;

    public void selectFlight(){
        clickToElementClickable(selectedFlightButton);
        clickToElementClickable(confirmFlight);
    }

    public FlightResultsPage(WebDriver driver, WebElement selectedFlightButton) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
