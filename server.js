var express = require('express');
var router = express.Router();

var auth = require('../auth/authentication');


router.post('/login', function(req, res) {



    // De username en password worden meegestuurd in de request body
    var username = req.body.username;
    var password = req.body.password;

    // Dit is een dummy-user die uit de database komt
    // Momenteel zetten we ze als environment variabelen. 
    var _dummy_username = process.env.APP_USERNAME || "username";
    var _dummy_password = process.env.APP_PASSWORD || "test";

    // Kijk of de gegevens matchen. Zo ja, dan token genereren en terugsturen.
    if (username == _dummy_username && password == _dummy_password) {
        var token = auth.encodeToken(username);
        res.status(200).json({
            "token": token,
        });
    } else {
        // console.log('Input: username = ' + username + ', password = ' + password);
        res.status(401).json({ "error": "Invalid credentials, bye" })
    }

});

// Zo wordt de route zichtbaar
module.exports = router;