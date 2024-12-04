package aut.testcreation.pages.trenes;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FiltersJourney extends SeleniumWrapper {

    @FindBy(xpath = "//DIV[contains(@class, 'FullTransportSummary__SummaryColumn')]")
    private List <WebElement> listJourney;

    @FindBy(xpath = "//button[@data-testid='lmn-ds-btn' and text()='Seleccionar']")
    private WebElement btnSelect;

    public void selectJourney(){
        this.clickToElementClickable(listJourney.get(0));
    }
    public void selectBtn(){
        this.clickToElementClickable(btnSelect);
    }
    public FiltersJourney(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}