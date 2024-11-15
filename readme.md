# Healthcare Backend

This is a Spring Boot application for managing healthcare services. The application provides a RESTful API to perform CRUD operations on health services.

## Features

- **Get a specific health service** by ID
- **Get all health services**
- **Add a new health service**
- **Update an existing health service**
- **Delete a health service**

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Maven (for dependency management)
- MySql (for Storage)

### Run Command for Create Database in Mysql command line client
- `CREATE database healthcare_db;`

## API Endpoints

### Get a Specific Health Service

- **URL:** `http://localhost:8080/healthService/{serviceID}`
- **Method:** `GET`
- **URL Params:** 
  - `serviceID` (integer): ID of the health service to retrieve
- **Success Response:**
  - **Code:** 200
  - **Content:** `{ "serviceID": 1, "serviceName": "Service Name", "serviceDescription": "Service Description" , "servicePrice" : 9999 }`

### Get All Health Services

- **URL:** `http://localhost:8080/healthServices`
- **Method:** `GET`
- **Success Response:**
  - **Code:** 200
  - **Content:** `[ { "serviceID": 1, "serviceName": "Service Name", "serviceDescription": "Service Description" , "servicePrice" : 9999 }, ... ]`

### Add a New Health Service

- **URL:** `http://localhost:8080/healthService/addService`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
    "serviceName": "Service Name", 
    "serviceDescription": "Service Description",
    "servicePrice" : 9999
  }

- **Success Response:**
  - **Code:** 200
  - **Content:** `{ "serviceID": 1, "serviceName": "Service Name", "serviceDescription": "Service Description" , "servicePrice" : 9999 }`


### Update an Existing Health Service

- **URL:** `http://localhost:8080/healthService/updateService`
- **Method:** `PUT`
- **Request Body:**
  ```json
  {
    "serviceID": 1
    "serviceName": "Updated Service Name", 
    "serviceDescription": "Updated Service Description",
    "servicePrice" : 19999
  }
- **Success Response:**
  - **Code:** 200
  - **Content:** `{ "serviceID": 1, "serviceName": "Updated Service Name", "serviceDescription": "Updated Service Description" , "servicePrice" : 19999 }`

### Delete a Health Service

- **URL:** `http://localhost:8080/healthService/deleteService/serviceID`
- **Method:** `DELETE`
- **URL Params:** 
  - `serviceID` (integer): ID of the health service to retrieve
- **Success Response:**
  - **Code:** 200
  - **Content:** `"Service Deleted..."`

### Data for Testing Post API
```JSON
 {
     "serviceName": "Full Body Checkup",
     "serviceDescription": "1. Blood Tests: Blood tests are essential in assessing various body functions, such as blood sugar (for diabetes risk), cholesterol levels (for heart health), liver function, kidney function, and complete blood count to evaluate immunity and overall health. 2. Heart Health Assessment: This includes an ECG or an EKG to monitor heart rhythm, and sometimes a treadmill test (TMT) or echocardiogram to evaluate cardiovascular health. These tests help detect early signs of heart disease, which can be critical in preventing complications. 3. Liver and Kidney Function Tests: The liver and kidneys are vital organs that filter toxins and regulate body chemistry. Function tests assess levels of enzymes and waste products like bilirubin, urea, and creatinine to ensure these organs are performing well. 4. Imaging Tests: Chest X-rays, ultrasound scans, or, in some cases, MRI or CT scans provide detailed imaging of internal organs, allowing doctors to check for abnormalities in the lungs, liver, kidneys, and more. 5. Hormone and Vitamin Levels: Checking for hormonal balance and vitamin deficiencies can reveal metabolic issues and nutrient deficits that may not present with immediate symptoms but affect long-term health. 6. Urine and Stool Analysis: These tests help in assessing kidney function and detecting infections or other gastrointestinal issues." , 
     "servicePrice" : 19999
}