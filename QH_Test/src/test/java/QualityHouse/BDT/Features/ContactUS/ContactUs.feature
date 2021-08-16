Feature: Contact us feature
  As a Quality House website user,
  I want to be able to do sent a request message
  so that I can use the web-application features and get some more information.


  Scenario Outline:Register a new account authentication parameters (email and password) with valid data input

    Given An user launches the Quality House Home page with URL "<url>"
    When The user clicks on the ContactUs navigation button
    Then Then the contactUs request massage form is presented
    When The user populates the contact us request message form with valid data
    And The user accepts GPDR and submits the message
    Then The request made by the contact us form is successfully sent

    Examples:
      | url                      |
      | https:/qualityhouse.com/ |


