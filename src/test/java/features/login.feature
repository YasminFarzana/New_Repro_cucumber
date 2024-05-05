Feature:Login
  Background:
   Given student at TalentTEK  Homepage
 @login @regression @smoke @hb
 Scenario: Student should be able to login with valid credential
  And student enter their valid  email address
  And student enter their password during login
  When They click on login button
  Then student should be successfully login

  @login @regression @smoke @fail
  Scenario: Student should be able to login with valid credential
    And student enter their valid  email address
    And student enter their password during login
    When They click on login button
    Then student should be successfully login but failing on purpose

  @login @regression @smoke
  Scenario: Student should be not be able to login with valid credential
    And student enter their invalid  email address
    And student enter their password during login
    When They click on login button
    Then student should be not be able to successfully login