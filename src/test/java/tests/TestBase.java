package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driver.BrowserType;
import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import io.qameta.allure.Step;
import org.testng.annotations.*;

import java.util.Properties;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    @Step("Ładowanie konfiguracji z configuration.properties.")
    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Step("Ustawiam przeglądarke na: {browserType} i przechodzę na strone główną.")
    @Parameters("browser")
    @BeforeMethod
    public void beforeTest(@Optional BrowserType browserType) {
        DriverManager.setWebDriver(browserType);
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @Step("Zamykam przeglądarkę.")
    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}