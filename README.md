## Webcheck Server

This is a web server that manages traced GET requests
The server receives and sends data as json objects

It exposes the following endpoints:

### POST request-details - create request details
Input:
```
{
    "id": "<uuid>",
    "timestamp": 0.0,
    "duration": 0.0,
    "targetUrl": "<url>",
    "responseCode": 200
} 
```

Output
```
None

## [Status codes] ##
SUCCESS - 201
FAILURE - 400, 500
```


### GET request-details/{id} - retrieve specific request details by id
Input:
```
## path-variable: id
```
Output
```
{
    "id": "<uuid>",
    "timestamp": 0.0,
    "duration": 0.0,
    "targetUrl": "<url>",
    "responseCode": 200
} 

## [Status codes] ##
SUCCESS - 200
FAILURE - 400, 500
```

### GET request-details/most-visited - retrieves the most visited url
Input:
```
None
```
Output
```
{
    "id": "<uuid>",
    "timestamp": 0.0,
    "duration": 0.0,
    "targetUrl": "<url>",
    "responseCode": 200
} 

## [Status codes] ##
SUCCESS - 200
FAILURE - 400, 500
```

### GET request-details/requests-in-timeframe - retrieves all the request details in a time window
Input:
```
## query parameters:
    - latest: Double
    - earliest: Double
```
Output
```
{
    "id": "<uuid>",
    "timestamp": 0.0,
    "duration": 0.0,
    "targetUrl": "<url>",
    "responseCode": 200
} 

## [Status codes] ##
SUCCESS - 200
FAILURE - 400, 500
```
