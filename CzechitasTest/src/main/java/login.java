import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login {
    WebDriver browser;
    WebDriverWait browserWait;

    //browser inicialization
    public login(WebDriver browser) {
        this.browser = browser;
        this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }
    //click on button for login user
        void firstButtonLogin () {
            browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.xpath("//a[@href='https://team8-2022brno.herokuapp.com/prihlaseni']"))).click();

        }

    void userEmail (String email) {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id='email']")))
                .sendKeys(email);
    }
    void userPassword (String password) {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id='password']")))
                .sendKeys(password);
    }
    void buttonForLogin () {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//button[@type='submit']")))
                .click();
    }

}
