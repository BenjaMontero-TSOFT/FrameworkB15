package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends SeleniumWrapper {

    private SearchNavigationHome searchNavigationHome;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void setSearchNavigation(SearchNavigationHome value){
        this.searchNavigationHome = value;
    }
}
