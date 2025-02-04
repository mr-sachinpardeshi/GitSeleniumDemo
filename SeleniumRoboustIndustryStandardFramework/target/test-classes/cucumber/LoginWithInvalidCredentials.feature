Feature: Login Error Message Validation

Background:
		Given Landed on Amazon Website
		
  Scenario Outline: Validate login error messages for invalid inputs
    Given User is on the login page
    When User enters "<loginData>" and submits
    Then User should see an appropriate error message

    Examples:
      | loginData                   |
      | ade@       									|
      | pwe									        |
      | missingAtSymbol.com         |
      | invalidEmail@domain         |
      | 3453454454534535434         |
      | abc123456789								|