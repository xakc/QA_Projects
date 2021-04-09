beforeEach(function() {
  browser.url("/Hidden-Elements/index.html");
})

describe('Test whether hidden elements exist', function() {
  it('Button display is set to non display but still exists in html dom therefore should return true', function(done) {
    #not-displayed
  
  });

  it('Button display is set to visibility hidden but still exists in html dom therefore should return true', function(done) {
    #visibility-hidden
  });

  it('Button display is set to zero opacity but still exists in html dom therefore should return true', function(done) {
    #zero-opacity
  });

  it('Header text is visible and exists in the html dom therefore should return true', function(done) {
    h1
  });
  
  it('There is no such element with the id of #no-such-element within the html dom therefore should return false', function(done) {
    #no-such-element
  });
});