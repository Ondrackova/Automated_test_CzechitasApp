Test automation for Czechitas application.
Frameworks for web application created for Czechitas Data Testing Academy.

This automated test is the result of a homework assignment, which contains:

1. Write a test for logging any user (a regular user, not an administrator),
   generates a random last name and verifies that no application for that last name exists in the student's application table.

2. For the same student's surname, it creates this application and select cash as the payment method.
   After creation, the test verifies that there is already one application for the given surname in the application table.

3. It will open this searched application and change the payment method to Bank Transfer.
   Finally, it verifies this change and when the application detail is opened, the payment method is set to Bank Transfer.


Hierarchy of Elements

Working with the framework is divided according to elements of the testing application as follows:

1. RandomNameGenerator - function for generating random surname

   randomNameGenerator () - generates a random surname from a list of created names

2. Login - functions which are used for login any user

   firstButtonLogin () - click on first button on main page for login user
   userEmail (String email) - click and filling user's email in login form
   userPassword (String password) - click and filling user's password in login form
   buttonForLogin () - click on login user

3. PythonSection - functions for Python programming section

   moreInformationPython () - click on button "Více informací" in python section
   createApplicationPython () - click on button "Vytvořit přihlášku" for python course

4. ProgrammingSection - functions for all programming sections

   MoreInformationProgramming () - click on button "Více informací" in programming section

5. NewApplication - functions for creating new application

   findApplication (String randomSurname) -  click and fill the box to find the application
   termPython () - click on the box for selecting python
   openTerms () - open pull-out bar for selecting the terms
   selectTerm () - click on term which is availible
   studentFirstName (String firstName) - click and fill student's first name
   studentLastName (String randomSurname) - click and fill student's first name
   studentBirthDate (String dateBirth) - click and fill student's birthdate
   cashPayment () - click to option for cash payment
   enabledGDPR () - click on checkbox for enable GDPR
   createApplication () - click on button "vytvořit přihlášku"

6. MainSection - functions for main section of web page

   applicationSection () - click on bookmark "Přihlášky" for user
   applicationSectionAdmin () - click on bookmark "Přihlášky" for admin

7. ExpectedOutput - functions to verify the expected output

   insExpectedOutput (String emptyApplication) - return a message "žádné záznamy nebyly nalezeny" or "Přihláška je zrušena z důvodu: Because I want"

8. ApplicationSection - functions for Application section of web page

   editApplication () - click on edit an appliation
   viewCreatedApplications () - click on view an application
   cancellationApplicationAdmin () - click on cancellation an application

9. Application DetailsSection - functions for applications details

   BankPayment () - click on bank payment method
   createUpdateApplication () - click on edit application
   
    
   
   
   
   

   

   
   
   
   


