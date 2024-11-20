import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewApplication {
    WebDriver browser;
    WebDriverWait browserWait;

    //browser inicialization
    public NewApplication(WebDriver browser) {
        this.browser = browser;
        this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    WebElement findApplication (String findName) {
        browserWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']"))).sendKeys(findName);
        return null;
    }

}
