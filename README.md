# Flixbus

### Starting the App
In order to run this application, execute: 
`docker-compose up` (or `docker-compose up -d` 
if you want to run container in the detached mode). 
This will start two containers:
1. *app* - contains  the main logic of the application
2. *mongo* - database, where the data from csv files is stored 

After the application is started, you can access it on the port 8080 of your machine.

### Request's Syntax 
If you want to get information about connection between two cities send the 
following request: 

GET `http://localhost:8080/information?city1=cityName1&city2=cityName1`

If connection between the given cities does not exist 404 response will be return.  

**Example Of Existing Connection**

Request: 
GET `http://localhost:8080/information?city1=Munich&city2=Warsaw`

Response:
```json
{
    "numLines": 2,
    "totalBusCost": 7781.558970400001,
    "totalDriverCost": 60.424025432,
    "totalCost": 7841.9829958320015
}
```

**Example Of Not Existing Connection**
Request: 
GET `http://localhost:8080/information?city1=Munich&city2=NotExistingCity`

Response:
```json
{
    "timestamp": "2021-08-09T07:58:47.884+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "",
    "path": "/information"
}
```