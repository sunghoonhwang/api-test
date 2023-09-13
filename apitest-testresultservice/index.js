require('@google-cloud/trace-agent').start();
const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const data = require('./data/initial-data.json');
const dotenv = require('dotenv');
dotenv.config();

const port = process.env.PORT || 8094;

function wait(sec) {
    let start = Date.now(), now = start;
    while (now - start < sec * 1000) {
        now = Date.now();
    }
}

app.use(bodyParser.json());

app.get('/api/testresults', (req, res) => {
  console.log("All Currencies")
  wait(3);
  res.send(data)
})

app.post('/api/currencies/convert', (req, res) => {
	const from = req.body.from;
	const to_code = req.body.to_code;

  console.log("convert from : " + from.currencyCode + ", to : " + to_code + ", units : " + from.units + ", nanos :" + from.nanos);

  const euros = {
    units: from.units / data[from.currencyCode],
    nanos: Math.round(from.nanos / data[from.currencyCode])
  };

  const result = {
		currencyCode: to_code,
    units: Math.floor(euros.units * data[to_code]),
    nanos: Math.floor(euros.nanos * data[to_code])
  };
  
  res.send(JSON.stringify(result))
})

app.listen(port, function(){
    console.log("Currency service has started on port " + port)
})
