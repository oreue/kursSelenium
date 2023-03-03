package page.objects;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement signOnButton;

    @FindBy(css = "#Content ul[class='messages'] li")
    private WebElement messageLabel;

    @FindBy(css = "area[alt='Fish']")
    private WebElement btnFishImage;

    @Step("Wpisano w pole User Name: {username}")
    public LoginPage typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        log().info("Wpisano w pole User Name: " + username);
        return this;
    }

    @Step("Wpisano w pole Password: {password}")
    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        log().info("Wpisano w pole Password: " + password);
        return this;
    }

    @Step("Kliknieto w Login Button")
    public FooterPage  clickOnLoginButton() {
        signOnButton.click();
        log().info("Kliknieto w Login Button");
        return new FooterPage();
    }

    @Step("Assert: wiadomosc {warningMessage} jest wyswietlona")
    public LoginPage assertThatWarningIsDisplayer(String warningMessage) {
        log().info("Sprawdzenie czy wiadomosc jest wyswietlona: " + warningMessage);
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        AssertWebElement.assertThat(messageLabel).isDisplayed().hasText(warningMessage);
        return this;
    }

    public FishListPage clickOnFishImageButton() {
        WaitForElement.waitUntilElementIsClickable(btnFishImage);
        btnFishImage.click();
        log().info("Kliknieto w Fish Image");
        return new FishListPage();
    }
}