package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends SeleniumWrapper {

    private SearchNavigationHomePage searchNavigationHomePage;

    public HomePage(WebDriver driver){
        super(driver);
        this.searchNavigationHomePage = new SearchNavigationHomePage(driver);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, searchNavigationHomePage);
    }


}
