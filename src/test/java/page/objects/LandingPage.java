package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class LandingPage extends BasePage {

    @FindBy(css = "#Content > p:nth-child(2) > a")
    private WebElement enterTheStore;

    @Step("Kliknieto w Enter Store Link")
    public TopMenuPage clickOnEnterTheStore() {
        WaitForElement.waitUntilElementIsClickable(enterTheStore);
        enterTheStore.click();
        log().info("Kliknieto w Enter Store Link");
        return new TopMenuPage();
    }

}