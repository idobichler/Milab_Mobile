const express = require('express');
const request = require('request');

const PORT = 5000;
const app = express();
const apiKey = "P6JC80M3TZDXGOK3";


app.get("/stock", (req, result) => {
    let symbol = req.query.symbol;

    let url = `https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=${symbol}&apikey=${apiKey}`;

    request.get({
        url: url,
        json: true,
        headers: {'User-Agent': 'request'}
    }, (err, res, data) => {
        if (err) {
            console.log(err);
            result.send(err);
        } else if (res.statusCode !== 200) {
            result.sendStatus(res.statusCode);
        } else {
            let priceData = data['Global Quote']['05. price'];
            if (priceData === undefined){
                result.send({"symbol": "Symbol not found", "price": "-"});
            }
            else{
                result.send({"symbol": symbol, "price": priceData});
            }
        }
    });

});


app.listen(PORT);