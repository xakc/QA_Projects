describe("Verify whether ABV mail provider links at the landing page works correctly", function() {
	it("Verify GPDR Form is presented", function(done) {
		browser.setViewportSize({
			width: 1200,
			height: 800
		})
		browser.url('/');
		var title = browser.getTitle();
		console.log('Title is: ' + title);
		let  GDPR_acceptBtn= $('/html/body/app-root/app-theme/div/div/app-notice/app-theme/div/div/app-home/div/app-footer/div/div[2]/button[2]');
		GDPR_acceptBtn.isD
		browser.pause(3000);
	});

	it("check that the login button opens the login portal page", function(done) {
		browser.url('/');
		browser.click('#login-portal');
		var title = browser.getTitle();
		console.log('Title is: ' + title);
		browser.pause(3000);
	});
});
