package framework.engine.selenium;

import framework.engine.utils.DataDriven;
import framework.engine.utils.LoadProperties;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Properties;

public class SeleniumTestBase {

    private DriverFactory driverFactory;
    public WebDriver driver;
    static Properties properties;
    protected ArrayList<String> dataSet;

    @BeforeAll
    public static void LoadProperties() {
        properties = LoadProperties.loadProperties();
    }

    @BeforeEach
    void webDriverSetup(TestInfo testInfo){
        String browserName = properties.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.inicializarDriver(browserName);
        this.dataSet = DataDriven.getTestData(
                testInfo.getDisplayName(),
                properties.getProperty("pathToDataSet"),
                properties.getProperty("tittleOfCp"));
    }

    @AfterEach
    void close(){
        driver.quit();
    }

}
