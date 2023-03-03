package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import utils.testng.listeners.RetryAnalyzer;

import static org.testng.Assert.*;
import static navigation.ApplicationURLs.LOGIN_URL;

public class FailedLoginTests extends TestBase {

    @Issue("DEFECT-1")
    @TmsLink("ID-1")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("Celem testu jest zalogowanie sie za pomoca blednych danych testowych: " +
            "username/password i sprawdzenie czy pojawia sie komunikat bledu.")
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("test")
                .typeIntoPasswordField("test")
                .clickOnLoginButton();
        loginPage.assertThatWarningIsDisplayer("Invalid username or password. Signon failed");
    }

}