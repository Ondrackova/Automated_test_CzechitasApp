import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CzechitasTest {
    WebDriver browser = WebDriverManager.firefoxdriver().create();
    //add time for waiting 5 s
    WebDriverWait browserWait = new WebDriverWait(browser, Duration.ofSeconds(3));

    login loginPage;
    NewApplication newApplication;
    //RandomNameGenerator randomNameGenerator;

    @BeforeEach
    void beforeTest () {
        //loading the web
        browser.get("https://team8-2022brno.herokuapp.com/");

        loginPage = new login(browser);
        newApplication = new NewApplication(browser);
    }

    String randomSurName = RandomNameGenerator.randomNameGenerator();

    @Test
    void ApplicationTest () {

        //click on button for login user
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//a[@href='https://team8-2022brno.herokuapp.com/prihlaseni']"))).click();
        //login user
        loginPage.userEmail("dobra@gmail.com");
        loginPage.userPassword("Jana123");
        loginPage.buttonForLogin();

        // variables for new application
        var firstName = "Jirka";
        var dateBirth = "01.01.2000";

        // go to application section
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id='navbarSupportedContent']//a[contains(text(), 'Přihlášky')]"))).click();
        //find application
        newApplication.findApplication(randomSurName);

        //variable for getting information about created applications
        var emptyApplication = browser.findElement(By.cssSelector(".odd")).getText();

        //assertation - applications not exist
        Assertions.assertEquals("Žádné záznamy nebyly nalezeny", emptyApplication);

        //click on button More information in programing section
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.cssSelector(".card-header a"))).click();

        //click on button More information in Python section
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[contains(text(), 'Programování')]//ancestor::*[@class='card']//a"))).click();
        //click on Create application for Python course
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.cssSelector(".card-body a")));
        //click on select Term
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//a[@href='https://team8-2022brno.herokuapp.com/zaci/pridat/4-python']"))).click();
        //open terms
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.cssSelector(".filter-option-inner-inner"))).click();
        //select term which is available
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.id("bs-select-1-0"))).click();
        // insert student first name
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id='forename']"))).sendKeys(firstName);
        //insert last name
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id='surname']"))).sendKeys(randomSurName);
        //insert birthdate
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id='birthday']"))).sendKeys(dateBirth);
        //select cash payment method
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//label[@for='payment_cash']"))).click();
        //Check GDPR
        browserWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//label[@for='terms_conditions']"))).click();
        //create application
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//input[@type='submit']"))).click();

        //assertation create application
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id='navbarSupportedContent']//a[contains(text(), 'Přihlášky')]"))).click(); //back to application page

        //variable for full name
        var ExpectedName = firstName + " " + randomSurName;
        //variable Actual name, which is on user applications
        var ActualName = browser.findElement
                (By.cssSelector(".dtr-control")).getText();

        //assertion - checking created application finding surname


        //open this application and edit to bank account
        // --go to application section
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id='navbarSupportedContent']//a[contains(text(), 'Přihlášky')]"))).click();
        // --edit application
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//tr[1]//a[@title='Upravit']"))).click();
        //--select bank account payment method
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//label[@for='payment_transfer']"))).click();
        //--click on Edit application
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//input[@type='submit']"))).click();

        //click on View application
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//tr[1]//a[@title='Zobrazit']"))).click();
        WebElement checkBankAccount = browser.findElement
                (By.xpath(".//div[contains(@class, 'col')]//div[contains(@class, 'card')]//strong[text()='Bankovní převod']"));

         //assert - finding created application with bank account payment
        Assertions.assertTrue(checkBankAccount.isDisplayed());
    }

    //change to @beforeEach after debugging
    @Test
    void clearApplicationList () {
        var surName = "Dobra";
        //click on button for login
        browserWait.
                until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//a[@href='https://team8-2022brno.herokuapp.com/prihlaseni']"))).click();

        //login user
        loginPage.userEmail("da-app.master@czechitas.cz");
        loginPage.userPassword("AppRoot123");
        loginPage.buttonForLogin();

        //go to application page
        browserWait.
                until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id='adminNavbar']//a[contains(text(), 'Přihlášky')]"))).click();

        //find Surname in applications
        newApplication.findApplication(surName);

        //click on view first application
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.xpath("//tr[1]//a[@title='Zobrazit']"))).click();

        //click on cancellation
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.cssSelector(".btn.btn-sm.btn-dark"))).click();

        //click on checkbox for reason
       WebElement checkBox = browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.id("canceled_yes")));

        if (!checkBox.isSelected()) { // isSelected()
            checkBox.click(); // check the checkbox
        }

        //insert a reason for cancellation
        browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.id("canceled"))).sendKeys("Because I want");
        */
        //click on button Edit
        browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.xpath("//input[@type='submit']")));

        //click on button for logout
        browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.cssSelector(".dropdown-toggle"))).click();
            //logout
        browserWait.until
                    (ExpectedConditions.elementToBeClickable(By.id("logout-link"))).click();
        }
    }
