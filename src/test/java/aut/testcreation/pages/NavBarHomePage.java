package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NavBarHomePage extends SeleniumWrapper {

    @FindBy(xpath = "//p[.='Ver más']")
    private WebElement itemVermas;

    @FindBy(xpath = "//div[.='Trenes']")
    private WebElement itemTrenes;

    @FindBy (xpath = "//p[text()='Vuelo + Hotel']")
    private WebElement vuelosHotelNavBarOption;

    @FindBy (xpath = "//div[text()='Flash Sales']")
    private WebElement flashSales;

    @FindBy (xpath = "//div[text()='Gran Canaria']")
    private WebElement granCanaria;

    public void selectVerMas(){
        this.clickToElementClickable(this.itemVermas);
    }

    public void selectTrenesSection(){
        this.clickToElementClickable(this.itemTrenes);
    }

    public void selectSectionTrenes(){
        selectVerMas();
        selectTrenesSection();
    }

    public void vuelosFlashSaleNavBar(){
        //clickToElementClickable(vuelosNavBarOption);

        Actions action = new Actions(driver);
        action.moveToElement(vuelosHotelNavBarOption).perform();

        clickToElementClickable(flashSales);
    }

    public void granCanariaNavBar(){
        Actions action = new Actions(driver);
        action.moveToElement(vuelosHotelNavBarOption).perform();

        clickToElementClickable(granCanaria);
    }

    public NavBarHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}