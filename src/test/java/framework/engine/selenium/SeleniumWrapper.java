package framework.engine.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumWrapper {

    protected final WebDriver driver;
    private WebDriverWait wait;

    //Constructor Base
    public SeleniumWrapper(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    protected void sendKeysToElementVisible(WebElement element, String value){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    protected Boolean isPresentElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    protected void sumbitForm(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).submit();
    }

    protected void sendKeysToElementVisible(WebElement element, Keys value){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
    }

    protected void clickToElementClickable(WebElement element)  {
        try {
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }catch (InterruptedException e){

        }

    }

    protected void moveToIframe(WebElement iframe){
        driver.switchTo().frame(iframe);
    }

    protected void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void switchTab(){
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
    }


    protected void clickElementByJavaScript(WebElement element){
        //WebElement presenceElement = wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    protected String getTextByElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

//    protected WebDriver getDriver() {
//        return driver;
//    }


    protected String getFontSize(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getCssValue("font-size");
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

//    //Wrappers Selenium
//
//    public List<WebElement> findElements (By locator){
//        return driver.findElements(locator);
//    }
//
//    public String getText (By locator){
//        return driver.findElement(locator).getText();
//    }
//
//    public void write(String inputText, By locator){
//        driver.findElement(locator).sendKeys(inputText);
//    }
//    public void sendKeys(Keys key, By locator){
//        driver.findElement(locator).sendKeys(key);
//    }
//
     public void click(By locator){
         driver.findElement(locator).click();
     }
//
//    public Boolean isEnabled(By locator) {
//        try {
//            return driver.findElement(locator).isEnabled();
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    public Boolean isSelected(By locator) {
//        try {
//            return driver.findElement(locator).isSelected();
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    public void navigateTo(String url){
//        driver.navigate().to(url);
//    }
//
//    public String getUrlTitle(){
//        return driver.getTitle();
//    }

}
