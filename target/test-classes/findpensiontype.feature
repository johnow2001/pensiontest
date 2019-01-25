Feature: Find my pension type

  Scenario: Find my pension type, expect defined contribution
    Given I am on the Pension Wise website home page
    When I select the service "Your pension details" and "Find Your pension Type"
    Then I am on the "Find out your pension type - Pension Wise" page
    When I click Start Now
    And I select answer "No"
    And I select Next Step
    Then Pension type is a "defined contribution pension"


  Scenario: Try to book online a face to face meeting
    Given I am on the Pension Wise website home page
    When I select the service "Your pension details" and "Find out your pension type"
    Then I am on the "Find out your pension type - Pension Wise" page
    When I click Start Now
    And I select answer "No"
    And I select Next Step
    Then Pension type is a "defined contribution pension"
    When I book and appointment
    Then I am on the "Book a free Pension Wise appointment - Pension Wise" page
    When I select book a face to face appointment
    And I enter a postcode of "BN1 6AJ" and select search
    Then I can see "Hove" in the list
    When I select book online
    And I enter a date of "2019-3-8"
    And I enter a a time of "12pm"
    And I select continue
    Then I am on the "Your details - Pension Wise" page
    When I enter my details
      | FirstName | LastName | Email          | PhoneNumber  | Word     | DOB        | DCM question | HearOfPensionWise | Consent |
      | test      | tester   | test@email.com | 123456789012 | testword | 01-01-2000 | No           | An employer       | No      |
    And select submit booking request
    Then I am on the "Sorry, you’re unable to have an appointment - Pension Wise" page


    Scenario: Get an adjustable income
      Given I am on the Pension Wise website home page
      When I select the service "Taking your pension money" and "Get an adjustable income"
      Then I am on the "Get an adjustable income - Pension Wise" page
      When I enter "10000" in pot and "55" for age and select calculate
      Then I get a "£2,500 tax free" amount

  @JO
  Scenario: Find my pension type, expect defined contribution
    Given I am on the Pension Wise website home page
    When I select the service "Your pension details" and "Find out your pension type"
    Then I am on the "Find out your pension type - Pension Wise" page
    When I click Start Now
    And I select answer "Yes"
    And I select Next Step
    Then I am on the "Find out your pension type - Pension Wise" page
    And I select answer "No" to employer list question
    #need a new page for this as its not the same one
    And I select answer "Yes" to list of pension providers
    Then Pension type is a "defined contribution pension"
