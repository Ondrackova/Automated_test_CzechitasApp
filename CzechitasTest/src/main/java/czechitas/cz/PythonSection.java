package czechitas.cz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PythonSection {
    WebDriver browser;
    WebDriverWait browserWait;

    //browser initialization
    public PythonSection(WebDriver browser) {
        this.browser = browser;
        this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    //click on more information button on Python section
    public void moreInformationPython() {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[contains(text(), 'Programování')]//ancestor::*[@class='card']//a"))).click();

    }
     //create application for python course
    public void createApplicationPython () {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.cssSelector(".card-body a")));
    }
}