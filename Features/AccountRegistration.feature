Feature: Account Registration

@regression
 Scenario: Sucessful Account Registration
 Given the user navigates to Register Account page
 When the user enters the details into below fields
 |firstName |Jhon    |
 |lastName  |Kendedy |
 |telephone |59531641|
 |password  |test@123|
 And the user selects Privacy Policy
 And the user clicks on Continue button
 Then the user account should get created sucessfully