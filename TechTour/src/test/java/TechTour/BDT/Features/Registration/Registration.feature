
Feature: Registration/SignUp functionality of TechTour Event-Register (TER)
  As a event unregistered company user,
  I want to be able to do a registration for event at TechTour
  so that I can use the web-application features for particular event.


  Scenario Outline:Register a new account authentication parameters (email and password) with valid data input

    Given A not registered user launches the TER Sign up page with URL "<url>"
    When The user enters email as "<email>"
    When The user enters password as "<password>"
    When The user clicks on the Sign up button
    Then The user is redirected to the Personal details event registration page


    Examples:

      |url| email| password|
      | https://demo-techtour-app-1.upnetix.tech/#/public/events/2633373/registrations/3414490  | test@check.bug | Test123!|



  Scenario Outline: Validate error messages for email registration form field
    Given A not registered user launches the TER Sign up page with URL "<url>"
    When The user enters invalid email as "<email>"
    When The user enters password as "<password>"
    Then An error message is presented as "<errorMSG>"
    Then The Sign up button is disabled

    Examples:
      |url| email| password| errorMSG|
      |https://demo-techtour-app-1.upnetix.tech/#/public/events/2633373/registrations/3414490 |test@check.bug |Test123!|The email is already registered, use your password to authenticate.|
      |https://demo-techtour-app-1.upnetix.tech/#/public/events/2633373/registrations/3414490 |testcheck.bug |Test123!|Please enter a valid business email.|
      |https://demo-techtour-app-1.upnetix.tech/#/public/events/2633373/registrations/3414490 |@testcheck.bug |Test123!|Please enter a valid business email.|
      |https://demo-techtour-app-1.upnetix.tech/#/public/events/2633373/registrations/3414490 |testcheck.bug@ |Test123!|Please enter a valid business email.|
      |https://demo-techtour-app-1.upnetix.tech/#/public/events/2633373/registrations/3414490 |@test@check.bug |Test123!|Please enter a valid business email.|
      |https://demo-techtour-app-1.upnetix.tech/#/public/events/2633373/registrations/3414490 |test@che.c.k.b.u.g |Test123!|Please enter a valid business email.|
      |https://demo-techtour-app-1.upnetix.tech/#/public/events/2633373/registrations/3414490 |DahCozlNyP8LiHgt0DvUYNNdYSzE2gUxQsrAUA98egwcxWIgILyoWMa89SgJJvtrqGj48uj6utdubARxxXUPDXvRyfLe91Bz8oPKu6bjX5nMahkO3WUNJWgmRarsjSdccFqgEIi81krwbmyWGYslu7HZV9UU2TFe9PRTjtEBIeu3oq5CjxVzxSRc7UBE7x7U3Rv75iTIdtlflRiunhsjaSjfZQtVc61TJU7CPbynTaTGvQ7nhFE0jBFNR1piUvEMYeah |Test123!|Email cannot be longer than 100 characters.|
