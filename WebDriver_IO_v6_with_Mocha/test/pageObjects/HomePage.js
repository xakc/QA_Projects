class HomePage{
    get contactUsBtn(){ return $("#contact-link");}

    navigateToContactUsPage(){
        this.contactUsBtn.click();
    };
}

export default new HomePage();