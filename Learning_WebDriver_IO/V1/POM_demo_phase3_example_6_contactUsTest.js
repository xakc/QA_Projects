class ContactUs_Page {
	get firstName() { return $("[name='first_name']");}
	get lastName() { return $("[name='last_name']");}
	get comments() { return $("textarea");}
	get emailAddress() { return $("[name='email']");}
	get submitButton() { return $("[type='submit']");}

	setFirstName(firstName) {
		return this.firstName.setValue(firstName);
	}

	setLastName(lastName) {
		return this.lastName.setValue(lastName);
	}

	setEmailAddress(emailAddress) {
		return this.emailAddress.setValue(emailAddress);
	}

	setComments(comments) {
		return this.comments.setValue(comments);
	}

	clickSubmitButton() {
		return this.submitButton.click();
	}

	submitAllInformationViaContactUsForm(firstName, lastName, emailAddress, comments) {
		if(firstName) {
			this.firstName.setValue(firstName);
		}
		if(lastName) {
			this.lastName.setValue(lastName);
		}
		if(emailAddress) {
			this.emailAddress.setValue(emailAddress);
		}
		if(comments) {
			this.comments.setValue(comments);
		}
		this.submitButton.click();
		this.confirmSuccessfulSubmission();
	}

	confirmSuccessfulSubmission() {
		var successfulSubmissionHeader = "#contact_reply h1";
		var validateSubmissionHeader = browser.waitUntil(function() {
			return browser.getText(successfulSubmissionHeader) == 'Thank You for your Message!'
		}, 3000)
		expect(validateSubmissionHeader, 'Successful Submission Message does not Exist!').to.be.true;
	}

	confirmUnsuccessfulSubmission() {
		var unsuccessfulSubmissionHeader = "body";
		var validateSubmissionHeader = browser.waitUntil(function() {
			return browser.getText(unsuccessfulSubmissionHeader) == 'Error: all fields are required'
		}, 3000)
		expect(browser.getText(unsuccessfulSubmissionHeader)).to.include('Error: all fields are required');
	}
}

module.exports = new ContactUs_Page();