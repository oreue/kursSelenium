package driver.manager;


import driver.BrowserFactory;
import driver.BrowserType;
import driver.listeners.WebDriverEventListenerRegistrar;
import org.openqa.selenium.WebDriver;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;
import static driver.BrowserType.*;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();

    private DriverManager() {}

    public static void setWebDriver(BrowserType browserType) {
        WebDriver browser = null;

        if (browserType == null) {
            browserType = getBrowserToRun();
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        } else {
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        }

        browser = WebDriverEventListenerRegistrar.registerWebDriverEventListener(browser);

        browserTypeThreadLocal.set(browserType);
        webDriverThreadLocal.set(browser);
    }

    public static WebDriver getWebDriver() {
        if (webDriverThreadLocal.get() == null) {
            throw new IllegalStateException("Instancja WebDrivera jest nullem. Utworz instacje uzywajac setWebDriver!");
        }

        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {
        webDriverThreadLocal.get().close();

        if (!browserTypeThreadLocal.get().equals(FIREFOX)) {
            webDriverThreadLocal.get().quit();
        }

        webDriverThreadLocal.remove();
        browserTypeThreadLocal.remove();
    }

}