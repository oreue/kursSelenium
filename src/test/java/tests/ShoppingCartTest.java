package tests;

import org.testng.annotations.Test;
import page.objects.*;

public class ShoppingCartTest extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {

        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterTheStore();

        LoginPage loginPage = new LoginPage();
        loginPage
                .clickOnFishImageButton()
                .clickOnAngelfishId()
                .clickOnAddToCartSmallAngelfish()
                .clickOnProceedToCheckout();

        loginPage.assertThatWarningIsDisplayer("You must sign on before attempting to check out. Please sign on and try checking out again.");
    }
}