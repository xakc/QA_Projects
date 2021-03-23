import { expect } from "chai";
import browserCapabilities from "../config/browserCapabilities";
import { CONTACT_US_TITLE, CUSTOMER_SERVICE, EMAIL_ADDRESS, SUPPORT_MESSAGE } from "../helpers/Constants";
import Helpers from "../helpers/Helpers";
import ContactUsPage from "../pageObjects/ContactUsPage";
import HomePage from "../pageObjects/HomePage";
import dataGenerators from "../../utils/DataGenerator";
import request from "../../node_modules/sync-request";

// // Navigate to specific URL before each test
// beforeEach(() => {
//   browser.url("/");
// });

// describe("This is how we can set Hooks within describe", () => {
//   beforeEach(() => {
//     console.log("Hook inside describe block");
//   });
// });

// describe("When I am on Home page", () => {
//   it.only("should have the right title", () => {
//     browser.getPageTitleCustom();
//     console.log("Custom command should be printed here!");
//   });
//   it.skip("test 2", () => {
//     console.log("Test Number 2");
//   });
// });

// describe("When I am on Home page 2", () => {
//   it.only("test 3", () => {
//     console.log("Test Number 3");
//   });

//   it("test 4", () => {
//     console.log("Test Number 4");
//   });
// });

// describe("This is how we can use requests in our scripts", () => {
//   it("Use sync-request", () => {
//     let res = request("GET", "https://jsonplaceholder.typicode.com/users");
//     console.log("response body is:", res.getBody("utf-8"));
//     console.log("only response is:", res);
//     //Deserialize response
//     let responseData = JSON.parse(res.getBody("utf-8"));
//     console.log("Response after deserialization:", responseData);
//     //Get all Names
//     responseData.forEach((property) => {
//       console.log("Name is:", property.name);
//     });
//   });
// });

describe("I should be able to open Contact us page", () => {
  it("Should send Email to support center", () => {
    HomePage.navigateToContactUsPage();
    Helpers.assertTitleIsAsExpected(CONTACT_US_TITLE);
    ContactUsPage.selectSubject(CUSTOMER_SERVICE);
    ContactUsPage.uploadFile();
    ContactUsPage.enterEmail(dataGenerators.generateRandomEmailAddress());
    ContactUsPage.enterMessage(dataGenerators.generateRandomString());
    browser.pause(10000);
    ContactUsPage.submitEmail();
    expect(ContactUsPage.isEmailIsSent(), "Message has not been sent!").to.equal(true);
  });
});

// describe("When I am on Home page", () => {
//   it.only("I should be able to execute JS code", () => {
//     browser.pause(3000);
//     browser.execute(() => {
//       return document.body.style.fontSize = "100px";
//     });
//     browser.pause(5000);
//   });
// });
