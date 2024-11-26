package czechitas.cz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class ExpectedOutput {

    WebDriver browser;
    WebDriverWait browserWait;

    //browser inicialization
    public ExpectedOutput(WebDriver browser) {
        this.browser = browser;
        this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    // Method to check if the output matches expected values
    public static boolean isExpectedOutput(String emptyApplication) {

        return emptyApplication.equals("Žádné záznamy nebyly nalezeny")||
                emptyApplication.equals("Přihláška je zrušena z důvodu: Because I want");

    }

}
