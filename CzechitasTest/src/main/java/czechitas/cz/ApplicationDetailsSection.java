package czechitas.cz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationDetailsSection {
    WebDriver browser;
    WebDriverWait browserWait;

    public ApplicationDetailsSection(WebDriver browser) {
        this.browser = browser;
        this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    //select bank account payment method
    public void bankPayment () {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//label[@for='payment_transfer']"))).click();
    }
    //click on Edit application
    public void createUpdateApplication () {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//input[@type='submit']"))).click();

    }


}
