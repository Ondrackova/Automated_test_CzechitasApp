package czechitas.cz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainSection {

    WebDriver browser;
    WebDriverWait browserWait;

    //browser initialization
    public MainSection(WebDriver browser) {
        this.browser = browser;
        this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    // go to application section
    public void applicationSection() {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id='navbarSupportedContent']//a[contains(text(), 'Přihlášky')]")))
                .click();

    }
    public void applicationSectionAdmin () {
        browserWait.
                until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id='adminNavbar']//a[contains(text(), 'Přihlášky')]")))
                .click();

    }
}
