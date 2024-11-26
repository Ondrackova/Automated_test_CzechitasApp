import czechitas.cz.*;
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
    //add time for waiting 4 s
    WebDriverWait browserWait = new WebDriverWait(browser, Duration.ofSeconds(4));

    login loginPage;
    ExpectedOutput expectedOutput;
    MainSection mainSection;
    NewApplication newApplication;
    ProgrammingSection programingSection;
    PythonSection pythonSection;
    ApplicationSection applicationSection;
    ApplicationDetailsSection applicationDetailsSection;

    //RandomNameGenerator randomNameGenerator;

    @BeforeEach
    void beforeTest () {
        //loading the web
        browser.get("https://team8-2022brno.herokuapp.com/");

        loginPage = new login(browser);
        expectedOutput = new ExpectedOutput(browser);
        mainSection = new MainSection(browser);
        newApplication = new NewApplication(browser);
        programingSection = new ProgrammingSection(browser);
        pythonSection = new PythonSection(browser);
        applicationSection = new ApplicationSection(browser);
        applicationDetailsSection = new ApplicationDetailsSection(browser);
    }

    //random surname generator
    String randomSurName = RandomNameGenerator.randomNameGenerator();

    @Test
    void ApplicationTest () {

        //click on button for login user
        loginPage.firstButtonLogin();

        //login user
        loginPage.userEmail("dobra@gmail.com");
        loginPage.userPassword("Jana123");
        loginPage.buttonForLogin();

        // variables for new application
        var firstName = "Jirka";
        var dateBirth = "01.01.2000";

        // go to application section
        mainSection.applicationSection();

        //find application
        newApplication.findApplication(randomSurName);

        //variable for getting information about created applications
        var emptyApplication = browser.findElement(By.cssSelector(".odd")).getText();


        //assertation - applications not exist or the application is canceled
        Assertions.assertTrue(ExpectedOutput.isExpectedOutput(emptyApplication));

        //write an output to the terminal
        System.out.println(emptyApplication);

        //click on button More information in programing section
        programingSection.MoreInformationProgramming();

        //click on button More information in Python section
        pythonSection.MoreInformationPython();

        //click on Create application for Python course
        pythonSection.createApplicationPython();

        //click on select Term
        newApplication.termPython();

        //open terms
        newApplication.openTerms();

        //select term which is available
        newApplication.selectTerm();

        // insert student first name
        newApplication.studentFirstName(firstName);

        //insert last name
        newApplication.studentLastName(randomSurName);

        //insert birthdate
        newApplication.studentBirthDate(dateBirth);

        //select cash payment method
        newApplication.cashPayment();

        //Check GDPR
        newApplication.enabledGDPR();

        //create application
        newApplication.createApplication();

        //go to application section
        mainSection.applicationSection();

        //variable for full name
        var expectedName = firstName + " " + randomSurName;

        //variable Actual name, which is on user applications
        var actualName = browser.findElement
                (By.cssSelector(".dtr-control")).getText();

        //assertion - checking created application finding surname
        Assertions.assertEquals(expectedName, actualName);

        //write output of assertion to the terminal
        System.out.println("Expected name: ");
        System.out.println(expectedName);
        System.out.println("Actual name: ");
        System.out.println(actualName);


        //open this application and edit to bank account
        // --go to application section
        mainSection.applicationSection();

        // --edit application
        applicationSection.editApplication();

        //--select bank account payment method
        applicationDetailsSection.BankPayment();

        //--click on Edit application
        applicationDetailsSection.createUpdateApplication();

        //click on View application
        applicationSection.viewCreatedApplications();

        //checking that created application has payment with bank account
        WebElement checkBankAccount = browser.findElement
                (By.xpath(".//div[contains(@class, 'col')]//div[contains(@class, 'card')]//strong[text()='Bankovní převod']"));

        //assert - finding created application with bank account payment
        Assertions.assertTrue(checkBankAccount.isDisplayed());

        //pom variables for output
        var paymentMethod = checkBankAccount.getText();

        //write output assert to the terminal
        System.out.println("Payment method :");
        System.out.println(paymentMethod);
    }

    //change to @beforeEach after debugging
    @Test
    void clearApplicationList () {

        //button for login user
        browserWait.
                until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//a[@href='https://team8-2022brno.herokuapp.com/prihlaseni']"))).click();

        //login user
        loginPage.userEmail("da-app.master@czechitas.cz");
        loginPage.userPassword("AppRoot123");
        loginPage.buttonForLogin();

        //go to application page
       mainSection.applicationSectionAdmin();

        //find Surname in applications
        newApplication.findApplication(randomSurName);

        //click on view first application
        applicationSection.viewCreatedApplications();

        //click on cancellation
        applicationSection.cancellationApplicationAdmin();

        //click on checkbox for reason
        WebElement checkBox = browserWait.until
               (ExpectedConditions.elementToBeClickable
                       (By.xpath("//label[@for='canceled_yes']")));

        String checked = checkBox.getAttribute("checked");

        if (checked == null) {  //if checkbox is null
            checkBox.click();  //check the checkbox
        }
        System.out.println(checked);

            //insert a reason for cancellation
        browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.xpath("//input[contains(@class, 'form-control mt-2') and @id='canceled']")))
                .sendKeys("Because I want");

        //click on button Edit
        browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.xpath("//*[@id='studentCancel']/div/div/div[2]/form/input[4]")))
                .click();

        //click on button for logout
        browserWait.until
                    (ExpectedConditions.elementToBeClickable
                            (By.xpath("//*[@id='navbarSupportedContent']/div[2]/div/a")))
                .click();

            //logout
        browserWait.until
                    (ExpectedConditions.elementToBeClickable(By.id("logout-link"))).click();
        }

    }
