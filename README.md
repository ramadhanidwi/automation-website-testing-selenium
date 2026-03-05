# automation-website-testing-selenium
Automation Website Testing using Selenium
website used for testing : https://www.saucedemo.com/

## Tech Stack 
- Programming Language : Java (17.0.12)
- Automation Library : Selenium 
- Testing Framework : TestNG 
- Build Tool : Maven

## Project Structure 
selenium-website-testing
├── src
│   ├── main
│   │   ├── pages
|   |   |   ├── CartPage.java
|   |   |   ├── HomePage.java
|   |   |   ├── LoginPage.java
|   |   |   └── ProductPage.java
|   |   |
│   │   └── utils
|   |       ├── DriverFactory.java
|   |       └── ConfigReader.java
│   └── test
│       ├── java
│       │   ├── base
│       │   │   └── BaseTest.java
│       │   └── tests
|       |       ├── AddProduct
|       |       |   └── AddProductTest.java
|       |       ├── CheckoutProduct
|       |       |   └── CheckoutProductTest.java
|       |       ├── Login
|       |       |   └── LoginTest.java
│       │       └── RemoveProduct
|       |           └── RemoveProductTest.java
|       ├── testData
|       |   └── LoginDataProvider.java
│       └── resources
│           └── config.properties
|
└── pom.xml
