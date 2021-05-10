var request = require('sync-request');

beforeEach(function() {
	browser.url('/Contact-Us/contactus.html');
})

describe('Test Contact Us form WebdriverUni', function() {
	var res = request('GET', 'http://jsonplaceholder.typicode.com/posts/1/comments');
	var contactusDetails = JSON.parse(res.getBody().toString('utf8'));

	var firstNameSelector = "[name='first_name']";
	var lastNameSelector = "[name='last_name']";
	var emailAddressSelector = "[name='email']";
	var commentsSelector = "textarea";
	var successfulSubmissionSelector = "#contact_reply h1";
	var unsuccessfulSubmissionSelector = "body";
	var submitButtonSelector = "[type='submit']";

	function setFirstName(firstName) {
		return browser.setValue(firstNameSelector, firstName);
	}

	function setLastName(lastName) {
		return browser.setValue(lastNameSelector, lastName);
	}

	function setEmailAddress(emailAddress) {
		return browser.setValue(emailAddressSelector, emailAddress);
	}

	function setComments(comments) {
		return browser.setValue(commentsSelector, comments);
	}

	function clickSubmitButton() {
		return browser.click(submitButtonSelector);
	}

	function confirmSuccessfulSubmission() {
		var validateSubmissionHeader = browser.waitUntil(function() {
			return browser.getText(successfulSubmissionSelector) == 'Thank You for your Message!'
		}, 3000)
		expect(validateSubmissionHeader, 'Successful Submission Message does not Exist!').to.be.true;
	}

	function confirmUnsuccessfulSubmission() {
		var validateSubmissionHeader = browser.waitUntil(function() {
			return browser.getText(unsuccessfulSubmissionSelector) == 'Error: all fields are required'
		}, 3000)
		expect(browser.getText(unsuccessfulSubmissionSelector)).to.include('Error: all fields are required');
	}



contactusDetails.forEach(function (contactDetail) {
  it('Should be able to submit a successful submission via contact us form', function(done) {
  	setFirstName('joe');
  	setLastName('Blogs');
  	setEmailAddress(contactDetail.email);
  	setComments(contactDetail.body);
  	clickSubmitButton();
  	confirmSuccessfulSubmission();
   	});
   }); 


  it('Should not be able to submit a successful submission via contact us form as all fields are required', function(done) {
  	setFirstName('Mike');
  	setLastName('Woods');
  	setEmailAddress('mike_woods@mail.com');
  	clickSubmitButton();
  	confirmUnsuccessfulSubmission();
    });

  
  it('Should not be able to submit a successful submission via contact us form as all fields are required', function(done) {
  	setFirstName('Sarah');
  	setEmailAddress('sarah_woods@mail.com');
  	clickSubmitButton();
  	confirmUnsuccessfulSubmission();
    });

  it('Should not be able to submit a successful submission via contact us form as all fields are required', function(done) {
  	setLastName('Jomes');
  	setEmailAddress('sarah_Jomes@mail.com');
  	clickSubmitButton();
  	confirmUnsuccessfulSubmission();
    });
});