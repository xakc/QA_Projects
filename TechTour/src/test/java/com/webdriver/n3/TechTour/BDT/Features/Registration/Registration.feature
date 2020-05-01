
Feature: Registration/SignUp functionality of TechTour Event-Register - TER -
  As a unregistered user,
  I want to be able to do a registration for event at TechTour
  so that I can use the web-application features
  and login in the TechTour event application.



  Scenario Outline: Registration with valid input data

    Given The user launches the TER SignUp page with URL "<url>"

    Examples:

      |url| firstName | lastName| email| phone|  address| userName | password|
      | https://demo-techtour-app-1.upnetix.tech/#/public/events/2633373/registrations/3414490  | Demo | Testov | test@check.bug | 33355588899| 13 Friday Avenue| Reg_Test| Test123!|


#
#  Scenario Outline: Validate error messages for first name registration form field
#    Given The user launches the SafetyCard SignUp page with URL "<url>"
#    When The user writes First name as "<firstName>"
#    When The user writes Last name as "<lastName>"
#    When The user writes email as "<email>"
#    When The user writes phone as "<phone>"
#    When The user writes address as "<address>"
#    When The user write username as "<userName>"
#    When The user write password as "<password>"
#    When The user confirm tha password as "<CONFpassword>"
#    When The user clicks on signUp button
#    Then  Then an error message will be presented as "<errorMSG>"
#    Examples:
#      |url| firstName | lastName| email| phone|  address| userName | password| CONFpassword|errorMSG|
#      | http://localhost:8080/register  |   | Testov | test@check.bug | 33355588899| 13 Friday Avenue| Reg_Test| Test123!|Test123!| Please enter valid first name|
#      | http://localhost:8080/register  | 123123 | Testov | test@check.bug | 33355588899| 13 Friday Avenue| Reg_Test| Test123!|Test123!| Please enter valid first name|
#      | http://localhost:8080/register  | !!! | Testov | test@check.bug | 33355588899| 13 Friday Avenue| Reg_Test| Test123!|Test123!| Please enter valid first name|
#      | http://localhost:8080/register  | InRXS5hz67Rq69ITlA9AVUvN2wGnuHi2iSw6mcfTYEtus3IHlcub | Testov | test@check.bug | 33355588899| 13 Friday Avenue| Reg_Test| Test123!|Test123!|Please enter valid first name First name must be between 2 and 50 symbols |
#
#  Scenario Outline: Validate error messages for last name registration form field
#
#    Given The user launches the SafetyCard SignUp page with URL "<url>"
#    When The user valid/invalid First name as "<firstName>"
#    When The user valid/invalid Last name as "<lastName>"
#    When The user valid/invalid email as "<email>"
#    When The user valid/invalid phone as "<phone>"
#    When The user valid/invalid address as "<address>"
#    When The user valid/invalid username as "<userName>"
#    When The user valid/invalid password as "<password>"
#    When The user confirm tha password as "<CONFpassword>"
#    When The user clicks on signUp button
#    Then  Then an error message will be presented as "<errorMSG>"
#    Examples:
#      |url| firstName | lastName| email| phone|  address| userName | password| CONFpassword|errorMSG|
#      | http://localhost:8080/register  |Demo |   | test@check.bug | 33355588899| 13 Friday Avenue| Reg_Test| Test123!|Test123!| Please enter valid first name|
#      | http://localhost:8080/register  |Demo | 123123 | test@check.bug | 33355588899| 13 Friday Avenue| Reg_Test| Test123!|Test123!| Please enter valid first name|
#      | http://localhost:8080/register  |Demo | !!! | test@check.bug | 33355588899| 13 Friday Avenue| Reg_Test| Test123!|Test123!| Please enter valid first name|
#      | http://localhost:8080/register  |Demo | InRXS5hz67Rq69ITlA9AVUvN2wGnuHi2iSw6mcfTYEtus3IHlcub | test@check.bug | 33355588899| 13 Friday Avenue| Reg_Test| Test123!|Test123!|Please enter valid first name First name must be between 2 and 50 symbols |
#
#  Scenario Outline: Validate error messages for email registration form field
#    Given The user launches the SafetyCard SignUp page with URL "<url>"
#    When The user valid/invalid First name as "<firstName>"
#    When The user valid/invalid Last name as "<lastName>"
#    When The user valid/invalid email as "<email>"
#    When The user valid/invalid phone as "<phone>"
#    When The user valid/invalid address as "<address>"
#    When The user valid/invalid username as "<userName>"
#    When The user valid/invalid password as "<password>"
#    When The user confirm tha password as "<CONFpassword>"
#    When The user clicks on signUp button
#    Then  Then an error message will be presented as "<errorMSG>"
#    Examples:
#      |url| firstName | lastName| email| phone|  address| userName | password| CONFpassword|errorMSG|
#      | http://localhost:8080/register  |Demo |  Testov | test@check.bug | 33355588899| 13 Friday Avenue| Reg_Test| Test123!|Test123!| Email is already in use|
#      | http://localhost:8080/register  |Demo | Testov | testcheck.bug | 33355588899| 13 Friday Avenue| Reg_Test| Test123!|Test123!|  |
#      | http://localhost:8080/register  |Demo | Testov | @testcheck.bug | 33355588899| 13 Friday Avenue| Reg_Test| Test123!|Test123!| |
#      | http://localhost:8080/register  |Demo | Testov | testcheck.bug@ | 33355588899| 13 Friday Avenue| Reg_Test| Test123!|Test123!|  |
#      | http://localhost:8080/register  |Demo | Testov | @test@check.bug | 33355588899| 13 Friday Avenue| Reg_Test| Test123!|Test123!| |
#      | http://localhost:8080/register  |Demo | Testov | DahCozlNyP8LiHgt0DvUYNNdYSzE2gUxQsrAUA98egwcxWIgILyoWMa89SgJJvtrqGj48uj6utdubARxxXUPDXvRyfLe91Bz8oPKu6bjX5nMahkO3WUNJWgmRarsjSdccFqgEIi81krwbmyWGYslu7HZV9UU2TFe9PRTjtEBIeu3oq5CjxVzxSRc7UBE7x7U3Rv75iTIdtlflRiunhsjaSjfZQtVc61TJU7CPbynTaTGvQ7nhFE0jBFNR1piUvEMYeah | 33355588899| 13 Friday Avenue| Reg_Test| Test123!|Test123!| |
#
#  Scenario Outline: Validate error messages for phone registration form field
#    Given The user launches the SafetyCard SignUp page with URL "<url>"
#    When The user writes First name as "<firstName>"
#    When The user writes Last name as "<lastName>"
#    When The user writes email as "<email>"
#    When The user writes phone as "<phone>"
#    When The user writes address as "<address>"
#    When The user write username as "<userName>"
#    When The user write password as "<password>"
#    When The user confirm tha password as "<CONFpassword>"
#    When The user clicks on signUp button
#    Then  Then an error message will be presented as "<errorMSG>"
#    Examples:
#      |url| firstName | lastName| email| phone|  address| userName | password| CONFpassword|errorMSG|
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug |  | 13 Friday Avenue| Reg_Test| Test123!|Test123!| Please enter valid phone|
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug | 1 | 13 Friday Avenue| Reg_Test| Test123!|Test123!|Phone number must be between 4 and 15 symbols|
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug | igs6ypWi7rmTYjNS | 13 Friday Avenue| Reg_Test| Test123!|Test123!| Please enter valid phone number Phone number must be between 4 and 15 symbols|
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug | aaaabbb | 13 Friday Avenue| Reg_Test| Test123!|Test123!| Please enter valid phone number|
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug |  111a222 | 13 Friday Avenue| Reg_Test| Test123!|Test123!| Please enter valid phone number|
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug | -359555498  | 13 Friday Avenue| Reg_Test| Test123!|Test123!| |
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug | *665658+5666 | 13 Friday Avenue| Reg_Test| Test123!|Test123!| |
#
#
#  Scenario Outline: Validate error messages for address registration form field
#    Given The user launches the SafetyCard SignUp page with URL "<url>"
#    When The user writes First name as "<firstName>"
#    When The user writes Last name as "<lastName>"
#    When The user writes email as "<email>"
#    When The user writes phone as "<phone>"
#    When The user writes address as "<address>"
#    When The user write username as "<userName>"
#    When The user write password as "<password>"
#    When The user confirm tha password as "<CONFpassword>"
#When The user clicks on signUp button
#    Then  Then an error message will be presented as "<errorMSG>"
#    Examples:
#      |url| firstName | lastName| email| phone|  address| userName | password| CONFpassword|errorMSG|
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug | 11122233355  |  | Reg_Test| Test123!|Test123!| Please enter address|
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug | 11122233355  | 231 | Reg_Test| Test123!|Test123!| Address must be between 5 and 50 symbols|
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug | 11122233355  | 2dyQW9kbHZbtox3vkHt0txaTcnHzfWBQqjtowTxAzxbVUOZbAfUPmy7 | Reg_Test| Test123!|Test123!| Address must be between 5 and 50 symbols|
#
#
#  Scenario Outline: Validate error messages for password registration form field
#
#    Given The user launches the SafetyCard SignUp page with URL "<url>"
#    When The user writes First name as "<firstName>"
#    When The user writes Last name as "<lastName>"
#    When The user writes email as "<email>"
#    When The user writes phone as "<phone>"
#    When The user writes address as "<address>"
#    When The user write username as "<userName>"
#    When The user write password as "<password>"
#    When The user confirm tha password as "<CONFpassword>"
#    When The user clicks on signUp button
#    Then  Then an error message will be presented as "<errorMSG>"
#    Examples:
#
#      |url| firstName | lastName| email| phone|  address| userName | password| CONFpassword|errorMSG|
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug | 11122233355  | 111222333444  | admin45| Test123!|Test123!|Username is already in use|
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug | 11122233355  | 111222333444  | | Test123!|Test123!|Please fill out this field|
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug | 11122233355  | 111222333444  | jAoZ5Eb3xeLkV0lJwoLQ3lx3c5r7ep2yzAX| Test123!|Test123!|Username must be between 6 and 30 symbols|
#
#
#  Scenario Outline: Validate error messages for user name registration form field
#
#    Given The user launches the SafetyCard SignUp page with URL "<url>"
#    When The user writes First name as "<firstName>"
#    When The user writes Last name as "<lastName>"
#    When The user writes email as "<email>"
#    When The user writes phone as "<phone>"
#    When The user writes address as "<address>"
#    When The user write username as "<userName>"
#    When The user write password as "<password>"
#    When The user confirm tha password as "<CONFpassword>"
#    When The user clicks on signUp button
#    Then  Then an error message will be presented as "<errorMSG>"
#
#
#    Examples:
#
#      |url| firstName | lastName| email| phone|  address| userName | password| CONFpassword|errorMSG|
#      | http://localhost:8080/register  | Demo | Testov | test@check.bug | 33355588899| 13 Friday Avenue| Reg_Test| Test123!| | |
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug | 11122233355  | 111222333444  | admin45| Test123!|Test123!|Username is already in use|
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug | 11122233355  | 111222333444  | | Test123!|Test123!|Please fill out this field|
#      | http://localhost:8080/register  |  Demo | Testov | test@check.bug | 11122233355  | 111222333444  | jAoZ5Eb3xeLkV0lJwoLQ3lx3c5r7ep2yzAX| Test123!|Test123!|Username must be between 6 and 30 symbols|
#
