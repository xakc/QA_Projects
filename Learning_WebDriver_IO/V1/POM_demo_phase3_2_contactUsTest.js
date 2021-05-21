class ContactUs_Page {
	get firstName() { return $("[name='first_name']");}
	get lastName() { return $("[name='last_name']");}
	get comments() { return $("textarea");}
	get emailAddress() { return $("[name='email']");}
	get submitButton() { return $("[type='submit']");}
	get successfulSubmissionHeader() { return $("#contact_reply h1");}
	get unsuccessfulSubmissionHeader() { return $("body");}
}

function setFirstName(firstName) {
		return this.firstName.setValue(firstName);
	}

	function setLastName(lastName) {
		return this.lastName.setValue(lastName);
	}

	function setEmailAddress(emailAddress) {
		return this.emailAddress.setValue(emailAddress);
	}

	function setComments(comments) {
		return this.comments.setValue(comments);
	}

	function clickSubmitButton() {
		return this.submitButton.click();
	}

	function confirmSuccessfulSubmission() {
		var validateSubmissionHeader = browser.waitUntil(function() {
			return this.successfulSubmissionHeader.getText() == 'Thank You for your Message!'
		}, 3000)
		expect(validateSubmissionHeader, 'Successful Submission Message does not Exist!').to.be.true;
	}

	function confirmUnsuccessfulSubmission() {
		var validateSubmissionHeader = browser.waitUntil(function() {
			return this.unsuccessfulSubmissionHeader.getText() == 'Error: all fields are required'
		}, 3000)
		expect(this.unsuccessfulSubmissionHeader.getText()).to.include('Error: all fields are required');
	}

module.exports = new ContactUs_Page();