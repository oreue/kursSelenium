package generic.assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

public class AssertWebElement extends AbstractAssert<AssertWebElement, WebElement> {

    private Logger logger = LogManager.getLogger(AssertWebElement.class);

    public AssertWebElement(WebElement webElement) {
        super(webElement, AssertWebElement.class);
    }

    public static AssertWebElement assertThat(WebElement webElement){
        return new AssertWebElement(webElement);
    }

    public AssertWebElement isDisplayed(){
        logger.info("Sprawdzenie czy WebElement jest wyswietlony");
        isNotNull();

        if(!actual.isDisplayed()){
            failWithMessage("Element nie wyswietlony!");
        }
        logger.info("Element wyswietlony!");
        return this;
    }

    public AssertWebElement hasText(String expectedTextValue){
        logger.info("Sprawdzenie czy WebElement zawiera tekst: " + expectedTextValue);
        isNotNull();

        String actualElementText = actual.getText();
        if(!actualElementText.equals(expectedTextValue)){
            failWithMessage("Tekst elementu: <%s>, oczekiwany tekst: <%s>!", actualElementText, expectedTextValue);
        }

        logger.info("WebElement posiada oczekiwany tekst!");
        return this;
    }

}