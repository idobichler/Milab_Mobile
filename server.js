const express = require('express');
const fs = require('fs');
const path = require('path');

const PORT = 5000;
const app = express();


app.get("/*", (req, res) => {
    let reqPath = path.join(__dirname,req.url);
    if (fs.existsSync(reqPath)){
        let readStream = fs.createReadStream(reqPath);
        readStream.pipe(res);
    }
    else{
        res.sendStatus(404);
    }

});


app.listen(PORT);