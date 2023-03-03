package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static org.testng.Assert.*;
import static navigation.ApplicationURLs.LOGIN_URL;

public class PositiveLoginTest extends TestBase {

    @TmsLink("ID-2")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("Celem testu jest poprawne logowanie i sprzedzenie czy " +
            "pojawi sie baner wystepujacy po zalogowaniu.")
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .assertThatDogBannerIsDisplayed();
    }

}