const { json } = require('body-parser');
const express = require('express');
const app = express();

const PORT = 3000;

let personList = [];

app.use(express.json());

app.post('/person/create', function(req, res){
  const newPerson = req.body;
  personList.push(newPerson);
  res.status(200).json(req.body);
});

app.get('/person/all', function(req, res){
  res.status(200).json(personList);
});

app.get('/', function(req, res){
  res.send("Hello World!");
});


app.put('/person/update',function(req,res){
  for (const person of personList) {
    if(person.hkid === req.body.hkid){
      person.lastName = req.body.lastName;
      person.firstName = req.body.firstName;
      res.status(200).json(person);
    }
  }
  res.status(400).json({msg: "person not found"});
});

app.put('/person/update', function(req,res){
personList.forEach((person) => {
  if(person[hkid] === req.body[hkid]){
    person.lastName = req.body.lastName;
    person.firstName = req.body.firstName;
    res.status(200).json(person);
  }
})
res.status(400).json({msg: "person not found"});
});

app.delete('/person/delete', function(req,res) {
  const hkid = req.query.hkid;
  let deletedPerson = null;

  personList = personList.filter((person) => {
    if(person.hkid !== hkid) {
      deletedPerson = person;
      return false;
    } else {
      return true;
    }
  });
  if(deletedPerson){
    res.status(200).json(deletedPerson);
  } else {
    res.status(400).json({msg: "person not found"});
  }
});

app.listen(PORT);