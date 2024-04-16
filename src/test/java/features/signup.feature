Feature: TalentTEK Signup
 Background:
   Given student at TalentTEK  Homepage
   And student clicks on Create New Account button
   And  student enter their first name
   And student enter their last name



  @login @regression @smoke
  Scenario: Create new account with valid email and password

    And student enter their email
    And student enter their password
    And student enter confirm password
    And student enter their dob such as month,date,year
    And student enter their gender as male
    And student agrees with terms and condition
    When student click on Create My Account
    Then student should be able to get an student Id
@hw @login  @regression
  Scenario: Login after creating a brand new account

    And student enter their invalid email
    And student enter their password
    And student enter confirm password
    And student enter their dob such as month,date,year
    And student enter their gender as male
    And student agrees with terms and condition
    When student click on Create My Account
    Then student should be able to get an error message about email is being incorrect
    And student enter their newly created studentId
    And student enter their password during login
    When They click on login button
    Then they should be able to successfully login

  @hw @login  @regression
  Scenario: Send values from feature file

    And student enter their invalid email
    And student enter their password
    And student enter confirm password
    And student enter their dob such as month "Dec" day as "3" and year as "1996"
    And student enter their gender as male
    And student agrees with terms and condition
    When student click on Create My Account
    Then student should be able to get an error message about email is being incorrect
    And student should be able to get an student Id
  @hw @login  @ dataprovider
  Scenario Outline: Create students by using  all the 12 months
    And student enter their invalid email
    And student enter their password
    And student enter confirm password
    And student validate if they can select different months as"<Month>"
   Examples:
     | month |
     | Jan   |
     | Feb   |
     | Mar   |
     | Apr   |
     | May   |
     | Jun   |
     | July  |
     | Agu   |
     | Sep   |
     | Oct   |
     | Nov   |
     | Dec   |

  Scenario: Create new account with valid invalid email and valid password

    And student enter their email
    And student enter their password
    And student enter confirm password
    And student enter their dob such as month,date,year
    And student enter their gender as male
    And student agrees with terms and condition
    When student click on Create My Account
    Then student should be able to get an student Id
