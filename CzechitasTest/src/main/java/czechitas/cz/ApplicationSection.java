package czechitas.cz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationSection {
    WebDriver browser;
    WebDriverWait browserWait;

    public ApplicationSection(WebDriver browser) {
        this.browser = browser;
        this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    // edit application
    public void editApplication () {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//tr[1]//a[@title='Upravit']"))).click();
    }

    //click on View application
    public void viewCreatedApplications() {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//tr[1]//a[@title='Zobrazit']"))).click();

    }
    //click on cancellation
    public void cancellationApplicationAdmin () {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.cssSelector(".btn.btn-sm.btn-dark"))).click();

    }

}
