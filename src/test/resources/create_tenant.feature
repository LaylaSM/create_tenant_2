Feature: Register Test

  Scenario: User access Login Page
    Given User access APM Cloud Login Page
    Then System display textbox email
    And System display textbox password
    And System display button login
    And System display button sign up

  Scenario: User login fill email only and input wrong password
    When User fill "raisara@mailinator.com" on textbox email
    And User click button login
    Then System display label validation password mandatory
    And User fill "12345" on textbox password
    Then System display label validation password wrong

  Scenario: User login fill wrong format email and valid password
    When User fill "raisara@mailinator" on textbox email
    Then User fill "P@ssw0rd" on textbox password
    And User click button login
    Then System display label validation email wrong

  Scenario: User login fill no field
    When User click button login
    Then System display label validation email mandatory
    And System display label validation password mandatory

  Scenario: User login fill valid email and valid password
    When User fill "raisara@mailinator.com" on textbox email
    Then User fill "P@ssw0rd" on textbox password
    And User click button login
    And System display payroll system page

  Scenario: User fill no field at payroll system page
    When User fill "raisara@mailinator.com" on textbox email
    Then User fill "P@ssw0rd" on textbox password
    And User click button login
    And User click button create payroll system
    And System display label validation companyName mandatory
    And System display label validation businessLine mandatory
    And System display label validation NPWP mandatory
    And System display label validation streetAddress mandatory
    And System display label validation province mandatory
    And System display label validation city mandatory
    And System display label validation zipCode mandatory
    And System display label validation payrollSystemAddress mandatory





#    Scenario: User login fill password only
#
#  Scenario: User login fill no field
#    When User click button login
#    Then System display label validation password mandatory
#    And System display label validatio email mandatory