# 🧪 Event Management System - REST Assured API Automation Framework

This project is an **RestAssured API Testing** developed using **Java**, **Rest Assured**, **TestNG**, **Cucumber BDD**, and **ExtentReports** to test the **Event Management System's REST APIs**.  
It includes **positive and negative test cases** for **Booking Service**, **Authentication Service**, and related APIs.

---

## 📌 Project Objective

To automate testing for the Event Management System's REST APIs, ensuring data integrity, response validation, and adherence to API contract specifications.

---

## 🧱 Framework Design

### ✅ Tools & Technologies Used

| Technology | Purpose |
|------------|---------|
| **Java** | Core programming language |
| **Rest Assured** | REST API automation |
| **TestNG** | Test execution framework |
| **Cucumber BDD** | Gherkin-based test scenarios |
| **ExtentReports** | HTML reporting |
| **Hamcrest Matchers** | Assertions for API validation |
| **Maven** | Build management & dependencies |


---

## 🔧 Framework Modules

### 1. **BDD with Cucumber**
All test cases are defined in `.feature` files using Gherkin syntax and linked to Java step definitions.

### 2. **API Request Utilities**
Reusable API request methods are implemented in `RestAssuredUtils.java` to handle GET, POST, DELETE, and Authorization flows.

### 3. **Validation Utilities**
`ValidationUtils.java` provides reusable assertion methods for status codes, content types, and response payload checks.

### 4. **Logging**
Logs request/response payloads into scenario-specific log files (e.g., `PostBooking.log`, `GetBooking.log`).

### 5. **Reporting**
Extent HTML reports generated post-test execution under `/reports/`.

### 6. **Negative Testing**
Scenarios included for invalid booking IDs, unauthorized requests, and incorrect payload formats.

---

## 📁 Project Structure
```bash
RestAssuredTestingCucumber/               # Project Root
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── baseclass/                 # Base setup and config
│   │       │   ├── TestBase.java
│   │       │   └── ConfigReader.java
│   │       │
│   │       ├── pojoclass/                 # Request/Response POJOs
│   │       │   └── BookingAPIPage.java
│   │       │
│   │       └── utils/                     # Utility Classes
│   │           ├── RestAssuredUtils.java  # Common API request methods
│   │           ├── ValidationUtils.java   # Assertion helpers
│   │           ├── TokenManager.java      # Token generation & management
│   │           └── Resource.java          # API endpoints
│   │
│   ├── test/
│   │   └── java/
│   │       ├── stepdefinations/            # Cucumber Step Definitions
│   │       │   ├── PostBookingSteps.java
│   │       │   ├── GetListSteps.java
│   │       │   ├── GetIdSteps.java
│   │       │   ├── DeleteIdSteps.java
│   │       │   ├── AuthAccessSteps.java
│   │       │   ├── GetInvalidSteps.java
│   │       │   └── GetTrainSteps.java
│   │       │
│   │       ├── testrunner/                 # Cucumber Test Runner
│   │       │   └── CucumberTestNGRunner.java
│   │       │
│   │       ├── testcases/                  # Direct TestNG test cases
│   │       │   ├── DelInvalidIdTest.java
│   │       │   ├── GetInvalidIdTest.java
│   │       │   ├── PostBookingTest.java
│   │       │   ├── GetListTest.java
│   │       │   ├── GetIdTest.java
│   │       │   ├── GetTrainTest.java
│   │       │   ├── DeleteIdTest.java
│   │       │   ├── AuthAccessTest.java
│   │       │   └── GetInvalidTest.java
│   │       │
│   │       └── listeners/                  # TestNG Listeners
│   │           └── ExtentReportListener.java
│   │
│   └── resources/
│       ├── feature/                        # Feature Files
│       │   ├── BookingAPI.feature
│       │   └── authtoken.feature
│       │
│       ├── data/                           # Test Data
│       │   └── BookingData.json
│       │
│       ├── config/                         # Configuration
│       │   └── config.properties
│       │
│       ├── reports/                        # Extent Reports output
│       │   └── extentReport.html
│       │
│       └── logs/                           # API request/response logs
│           ├── PostBooking.log
│           ├── GetBooking.log
│           ├── DelBooking.log
│           ├── AuthReq.log
│           └── AuthRes.log
│
├── pom.xml                                 # Maven Dependencies & Plugins
└── testng.xml                              # TestNG Suite Configuration

```

🧪 Sample Test Scenarios
> POST Booking with valid JSON payload (positive)

> GET Booking list validation

> GET Booking by valid bookingId

> GET Booking by invalid bookingId (negative)

> DELETE Booking by valid bookingId

> DELETE Booking by invalid bookingId (negative)

> Auth token generation & validation

📊 Reporting

Extent HTML Report → reports/extentReport.html

Cucumber HTML Report → target/cucumber-reports.html

Log Files → logs/

🙋‍♀️ Author
Asiya
Intern - Selenium Automation, Cognizant

---

