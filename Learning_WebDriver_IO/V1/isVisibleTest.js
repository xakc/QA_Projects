beforeEach(function() {
  browser.url("/Hidden-Elements/index.html");
})

describe('Test whether hidden elements are visible', function() {
  it('Button display is set to non display therefore should return false', function(done) {
  	var isVisible = browser.isVisible('#not-displayed');
  	console.log(isVisible);
  	expect(isVisible).to.equal(false);
  });

  it('Button display is set to visibility hidden therefore should return false', function(done) {
  	var isVisible = browser.isVisible('#visibility-hidden');
  	console.log(isVisible);
  	expect(isVisible).to.equal(false);
  });

  it('Button display is set to zero opacity therefore should return false', function(done) {
  	var isVisible = browser.isVisible('#zero-opacity');
  	console.log(isVisible);
  	expect(isVisible).to.equal(false);
  });

  it('Header text is visible therefore should return true', function(done) {
  	var isVisible = browser.isVisible('h1');
  	console.log(isVisible);
  	expect(isVisible).to.equal(true);
  });
});