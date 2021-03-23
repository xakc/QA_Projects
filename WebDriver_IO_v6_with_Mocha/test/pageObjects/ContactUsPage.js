import { FILE_UPLOAD_PATH } from "../helpers/Constants";

class ContactUsPage {

    get subjectHeadingDropdown() { return $("#id_contact"); }
    get emailAddressInput() { return $("#email"); }
    get messageInput() { return $("#message"); }
    get submitBtn() { return $('#submitMessage'); }
    get successMessage() { return $("//p[contains(text(),'Your message has been successfully sent to our team.')]"); }
    get uploadFileInput() { return $("#fileUpload"); }

    selectSubject(option) {
        this.subjectHeadingDropdown.waitForExist(10000);
        this.subjectHeadingDropdown.selectByVisibleText(option);
    };

    enterEmail(email) {
        this.emailAddressInput.addValue(email);
    };

    enterMessage(message) {
        this.messageInput.addValue(message);
    };

    submitEmail() {
        this.submitBtn.click();
    };

    isEmailIsSent() {
        this.successMessage.waitForDisplayed(10000);
        return this.successMessage.isDisplayed();
    }

    uploadFile() {
        this.uploadFileInput.setValue(browser.uploadFile(FILE_UPLOAD_PATH));
    }
}

export default new ContactUsPage();