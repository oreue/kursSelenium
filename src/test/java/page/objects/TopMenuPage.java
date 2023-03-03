package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class TopMenuPage extends BasePage {

    @FindBy(css = "#MenuContent > a:nth-child(3)")
    private WebElement signInButton;

    @Step("Kliknieto w Sign on Link")
    public LoginPage  clickOnSignInLink() {
        WaitForElement.waitUntilElementIsClickable(signInButton);
        signInButton.click();
        log().info("Kliknieto w Sign on Link");
        return new LoginPage();
    }
}
