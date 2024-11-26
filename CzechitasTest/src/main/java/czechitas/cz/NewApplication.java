package czechitas.cz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewApplication {

        WebDriver browser;
        WebDriverWait browserWait;

        //browser initialization
        public NewApplication(WebDriver browser) {
            this.browser = browser;
            this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
        }

        public void findApplication(String randomSurName) {
            browserWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']"))).sendKeys(randomSurName);

        }

        //click on select Term
        public void termPython () {
            browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.xpath("//a[@href='https://team8-2022brno.herokuapp.com/zaci/pridat/4-python']"))).click();

        }

        //open terms
        public void openTerms () {
            browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.cssSelector(".filter-option-inner-inner"))).click();

        }
        //select term which is available
        public void selectTerm () {
            browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.id("bs-select-1-0"))).click();
        }
        // insert student first name
        public void studentFirstName (String firstName) {
            browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.xpath("//*[@id='forename']"))).sendKeys(firstName);
        }
        //insert last name
        public void studentLastName (String randomSurName) {
            browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.xpath("//*[@id='surname']"))).sendKeys(randomSurName);
        }
        //insert birthdate
        public void studentBirthDate (String dateBirth) {
            browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.xpath("//*[@id='birthday']"))).sendKeys(dateBirth);

        }
        //select cash payment method
        public void cashPayment () {
            browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.xpath("//label[@for='payment_cash']"))).click();
        }
        //Check GDPR
        public void enabledGDPR () {
                browserWait.until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//label[@for='terms_conditions']"))).click();
        }

        //create application
        public void createApplication() {
            browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.xpath("//input[@type='submit']"))).click();
        }

}
