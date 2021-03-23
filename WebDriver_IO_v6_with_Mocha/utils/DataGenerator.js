module.exports = {
    //Generate Random Email
    generateRandomEmailAddress: function () {
        let emialAddress = "fake" + Math.random().toString().replace("0.", "") + "@gmail.com";
        return emialAddress;
    },

    //Generate Random String
    generateRandomString: function () {
        return Math.random().toString(36).substring(2, 15)
    }
}