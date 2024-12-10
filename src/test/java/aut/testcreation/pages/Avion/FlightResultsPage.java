package aut.testcreation.pages.Avion;

import aut.testcreation.pages.SearchNavigationHome;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightResultsPage extends SeleniumWrapper {
    @FindBy (xpath = "//div[@class='trip-collection-view__trips-container-top']//button")
    private WebElement selectedFlightButton;

    @FindBy (xpath = "//button[contains(text(), 'Seleccionar')]")
    private WebElement confirmFlight;

    public void selectFlight() throws InterruptedException {
        clickToElementClickable(selectedFlightButton);
        Thread.sleep(1000);
        clickToElementClickable(confirmFlight);
        Thread.sleep(2000);
    }

    public FlightResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
