package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends SeleniumWrapper {
    @FindBy(xpath = "//button[contains(@class, 'iubenda-cs-accept-btn')]")
    private WebElement btnCookies;

    @FindBy(xpath = "//h2[@id='iubenda-cs-title']")
    private WebElement titleCookies;



    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void closeCookies(){
        try{
            if(titleCookies.isEnabled()){
                this.clickToElementClickable(this.btnCookies);
            }else{

            }
        }catch(Exception e){
            System.out.println("Error de cookies");
        }
    }
}
