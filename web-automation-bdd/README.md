# 🧪 Web + API Test Automation Project with Java

This repository is part of my personal portfolio as a **QA Automation Engineer**, showcasing real-world automated testing using **Java, Selenium, Cucumber, and RestAssured**, with best practices and a scalable architecture.

---

## 🚀 Technologies and Tools

- **Java 11+**
- **Maven**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **RestAssured (API Testing)**
- **TestNG**
- **WebDriverManager**
- **ExtentReports** (test reports)
- **GitHub Actions** (CI/CD)

---

## 🧩 Project Structure

```
src
├── main
│   └── java
│       └── utils
│           └── DriverFactory.java
├── test
│   └── java
│       ├── base
│       │   └── BaseTest.java
│       ├── runners
│       │   └── TestRunner.java
│       ├── steps
│       │   └── LoginSteps.java
│       ├── pages
│       │   └── LoginPage.java
│       └── features
│           └── login.feature
└── resources
    └── config.properties
```

---

## 📌 Automated Features

| Test Type | Description |
|-----------|-------------|
| ✅ Web UI | Functional UI tests (e.g., login workflows) |
| ✅ API | REST endpoint testing (GET, POST, PUT, DELETE) |
| ✅ BDD | Gherkin-based scenarios using Cucumber |
| ✅ Reports | HTML reports with execution evidence |
| ✅ CI/CD | Automated test runs via GitHub Actions |

---

## ⚙️ How to Run the Tests

### Prerequisites:
- Java 11 or higher
- Maven installed
- A demo app available for testing (e.g., [https://the-internet.herokuapp.com/login](https://the-internet.herokuapp.com/login))

### Commands:

```bash
# Install dependencies
mvn clean install

# Run tests
mvn test
```

---

## 📸 Reports

After execution, the test report will be available at:
```
/target/reports/extent-report.html
```

---

## 📚 What You’ll Find Here

- Clean architecture and **best practices**
- **Page Object Model** for maintainability
- End-to-end and API test coverage
- **Cucumber** for readable and collaborative test scenarios
- **CI/CD** pipeline with automated test execution

---

## 👨‍💻 Author

**Virgilio Cruvinel**  
QA Manager | QA Automation Engineer  
[LinkedIn](https://www.linkedin.com/in/virgilio-cruvinel/) • [GitHub](https://github.com/virgiliocomp)
