package aut.testcreation.pages.trenes;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FiltersJourney extends SeleniumWrapper {

    @FindBy(xpath = "(//DIV[@class='FullTransportWay__SummaryGrid-sc-acha5w-1 jouvfC'])[1]")
    private WebElement Setjourney;

    @FindBy(xpath = "//button[@data-testid='lmn-ds-btn']")
    private WebElement btnSelect;

    public FiltersJourney(WebDriver driver) {
        super(driver);
    }
}