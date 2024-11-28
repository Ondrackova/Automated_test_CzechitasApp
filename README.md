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

3. PythonSection () - functions for Python programming section

   
   
   
   


