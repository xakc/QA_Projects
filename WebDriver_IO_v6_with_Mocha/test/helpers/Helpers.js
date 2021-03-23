const assert = require("assert");

class Helpers {

    assertTitleIsAsExpected(expectedTitle) {
        assert.strictEqual(browser.getPageTitleCustom(), expectedTitle);
    }
}

export default new Helpers();