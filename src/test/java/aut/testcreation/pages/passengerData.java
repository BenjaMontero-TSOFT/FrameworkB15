package aut.testcreation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class passengerData extends FormContact{

    @FindBy(xpath = "//input[@name='groups.1.travellers.1.name']")
    private WebElement namePassenger1;
    @FindBy(xpath = "//input[@name='groups.1.travellers.2.name']")
    private WebElement namePassenger2;
    @FindBy(xpath = "//input[@name='groups.1.travellers.3.name']")
    private WebElement namePassenger3;
    @FindBy(xpath = "//input[@name='groups.1.travellers.4.name']")
    private WebElement namePassenger4;

    @FindBy(xpath = "//input[@name='groups.1.travellers.1.surname']")
    private WebElement surNamePassenger1;
    @FindBy(xpath = "//input[@name='groups.1.travellers.2.surname']")
    private WebElement surNamePassenger2;
    @FindBy(xpath = "//input[@name='groups.1.travellers.3.surname']")
    private WebElement surNamePassenger3;
    @FindBy(xpath = "//input[@name='groups.1.travellers.4.surname']")
    private WebElement surNamePassenger4;

    @FindBy(xpath = "//input[@value='10']")
    private WebElement dayPassenger1;
    @FindBy(xpath = "//section[2]//span[@class='FormFieldstyles__ValueWrapper-sc-1pt5zgp-4 bNeTrq']/span[.='Día']")
    private WebElement dayPassenger2;
    @FindBy(xpath = "//section[3]//div[@class='sc-bSywJw HnarW']/div[1]//input[@class='Inputstyles__Input-sc-1jtieai-0 eHTQzG']")
    private WebElement dayPassenger3;
    @FindBy(xpath = "//input[@value='10']")
    private WebElement dayPassenger4;

    public passengerData(WebDriver driver) {
        super(driver);
    }
}
