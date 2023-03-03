package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class ShoppingCartPage extends BasePage{

    @FindBy(css = "a[href$='newOrderForm=']")
    private WebElement proceedToCheckoutButton;

    public CheckoutPage clickOnProceedToCheckout() {
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        log().info("Kliknieto w Proceed To Checkout");
        return new CheckoutPage();
    }
}