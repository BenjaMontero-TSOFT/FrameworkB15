package aut.testcreation.testcases;

import aut.testcreation.pages.Avion.FlightResultsPage;
import aut.testcreation.pages.Avion.SearchNavigationAvion;
import aut.testcreation.pages.HomePage;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestVuelos extends SeleniumTestBase {
    private SearchNavigationAvion searchAvion;
    private FlightResultsPage resultadosVuelos;
    private HomePage homePage;

    @Test
    @DisplayName("TC001")
    public void busquedaSimple() throws InterruptedException {
        driver.get("https://www.rumbo.es/");
        this.homePage = new HomePage(this.driver);
        Thread.sleep(2000);
        this.homePage.closeCookies();

        searchAvion = new SearchNavigationAvion(this.driver);

        searchAvion.fillFlightSearch_Ida("Buenos Aires (BUE)", "Madrid (MAD)", "American Express", "12", 1);
    }
}
