package aut.testcreation.pages.Avion;

import aut.testcreation.pages.FormContact;
import aut.testcreation.pages.hotel.ReserveHotelPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReserveFlightPage extends ReserveHotelPage {

    @FindBy (xpath = "//button[@class='btn btn-cta lead-generation-submit__btn-revamped-cta ']")
    private WebElement BtnNext;

    @FindBy (xpath = "//div[@data-test='radio-card-option-bottom.option-id']")
    private WebElement BtnSeguro;

    @FindBy (xpath = "//input[@name='address']")
    private WebElement inptAddress;

    @FindBy (xpath = "//input[@name='houseNumber']")
    private WebElement inptHouseNumber;

    @FindBy (xpath = "//input[@name='postCode']")
    private WebElement inptPostCode;

    @FindBy (xpath = "//input[@name='city']")
    private WebElement inptCity;

    @FindBy(xpath = "//h3[@data-testid='contact-form-title']")
    private WebElement formContactResult;


    public ReserveFlightPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillFlightForm (String variable, String nom_, String ape_, String dia_, String mes_, String anio_, String tc){
        By byName = By.xpath("//input[@name='groups.1.travellers." + variable + ".name']");
        By bySurName = By.xpath("//input[@name='groups.1.travellers." + variable + ".surname']");
        By bySr_a = By.xpath("//input[@name='groups.1.travellers." + variable + ".title' and @value='MALE']");
        By byDayBirth= By.xpath("//div[@data-testid='groups.1.travellers." + variable + ".dateOfBirth_day']//input[@name='groups.1.travellers." + variable + ".dateOfBirth']");
        By byMonthBirth = By.xpath("//button[@data-testid='groups.1.travellers." + variable + ".dateOfBirth_month']");
        By byYearBirth = By.xpath("//div[@data-testid='groups.1.travellers." + variable + ".dateOfBirth_year']//input[@name='groups.1.travellers." + variable + ".dateOfBirth']");
        By byMaletaIda = By.xpath("//div[@data-testid='traveller-container-1-" + variable + "-1-ADT_1']//div[text()='Sin maleta facturada']");

        WebElement nombre = findElement(byName);
        WebElement apellido = findElement(bySurName);
        WebElement Sr_a = findElement(bySr_a);
        WebElement dia = findElement(byDayBirth);
        WebElement mes = findElement(byMonthBirth);
        WebElement anio = findElement(byYearBirth);
        WebElement maletaIda = findElement(byMaletaIda);

        sendKeysToElementVisible(nombre, nom_);
        sendKeysToElementVisible(apellido, ape_);

        Sr_a.click();
        sendKeysToElementVisible(dia, dia_);
        sendKeysToElementVisible(mes, mes_);
        mes.sendKeys(Keys.RETURN);
        sendKeysToElementVisible(anio, anio_);
        clickElementByJavaScript(BtnSeguro);
        clickElementByJavaScript(maletaIda);

        if (tc.equalsIgnoreCase("5")){
            By byMaletaVuelta = By.xpath("//div[@data-testid='traveller-container-1-" + variable +"-2-ADT_2']//div[text()='Sin maleta facturada']");
            WebElement maletaVuelta = findElement(byMaletaVuelta);
            clickElementByJavaScript(maletaVuelta);
        }

    }

    public void fillAddressData(String address, String houseNumber, String postCode, String city){
        sendKeysToElementVisible(inptAddress, address);
        sendKeysToElementVisible(inptHouseNumber, houseNumber);
        sendKeysToElementVisible(inptPostCode, postCode);
        sendKeysToElementVisible(inptCity, city);
    }

    public void siguiente(){
        clickToElementClickable(BtnNext);
    }

    public String getNameError(){
        By error = By.xpath("//span[text()='Introduce el nombre.']");
        WebElement errorElement = findElement(error);
        return getTextByElement(errorElement);
    }

    public boolean getResult(){
        return this.formContactResult.isDisplayed();
    }

}
