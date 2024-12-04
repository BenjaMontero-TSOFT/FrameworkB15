package aut.testcreation.pages.trenes;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FiltersJourney extends SeleniumWrapper {

    @FindBy(xpath = "//div[@class='trip-collection-view__trips-container-top']//div[@class='FullTransportSummary__SummaryColumn-sc-aaxr6w-0 gibWPP']")
    private WebElement setJourney;

    @FindBy(xpath = "//button[@data-testid='lmn-ds-btn']")
    private WebElement btnSelect;

    public void selectJourney(){
        this.clickToElementClickable(setJourney);
    }
    public void selectBtn(){
        this.clickToElementClickable(btnSelect);
    }
    public FiltersJourney(WebDriver driver) {
        super(driver);
    }
}