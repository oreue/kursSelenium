package driver.manager;

import io.qameta.allure.Step;

public class DriverUtils {

    @Step("Powiekszam okno przegladarki")
    public static void setInitialConfiguration() {
        DriverManager.getWebDriver().manage().window().maximize();
    }

    @Step("Przechodze na strone: {pageUrl}")
    public static void navigateToPage(String pageUrl) {
        DriverManager.getWebDriver().navigate().to(pageUrl);
    }
}
