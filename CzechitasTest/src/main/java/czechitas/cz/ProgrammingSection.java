package czechitas.cz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgrammingSection {

        WebDriver browser;
        WebDriverWait browserWait;

        //browser initialization
        public ProgrammingSection(WebDriver browser) {
            this.browser = browser;
            this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
        }

        public void MoreInformationProgramming() {
            browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.cssSelector(".card-header a"))).click();

        }
}
