const express = require('express');
const fs = require('fs');
const bodyParser = require('body-parser');


const PORT = 5000;
const app = express();


 app.use(bodyParser.json());

function isEmpty(obj) {
    return !Object.keys(obj).length > 0;
}

 function readTaskFile(){
     let data = fs.readFileSync("tasks.json");
     return JSON.parse(data);
}

function writeToTaskFile(data){
     fs.writeFileSync("tasks.json", JSON.stringify(data, null, 4));
}


function addTask(id, task){
   let data = readTaskFile();
    data[id] = task;
    writeToTaskFile(data);
}

function removeTask(id){
    let data = readTaskFile();
    delete data[id];
    writeToTaskFile(data);
}


app.get("/tasks", (req,res) => {
    let data = readTaskFile();
    if(!isEmpty(data)){
        res.send(data);
    }
    else{
        res.send("No tasks to show, please add.");
    }
});

app.post("/tasks/new" , (req,res) => {
    let id = req.query.id;
    let task = req.query.task;
    addTask(id, task);
    res.send(`Task with id ${id} and data ${task} was added`);
});

app.delete("/tasks/remove", (req, res) => {
    let id = req.query.id;
    removeTask(id);
    res.send(`Task with id ${id} was removed`);
});



app.listen(PORT)
