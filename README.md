# UI Framework 

### The approach to framework:
- The framework is designed with BDD with POM approach which utilzes Feature files to define scenarios
- The scenarios are defined using Gherkin language with the Given, When, Then, And keyworkds
- Java Reflection API concept implemented to generalize method calling and reduce step definitions
- The data required for scenarios are injected with the help of data table
- Selenium library is used for executing the UI Scenarios
- Validations are done with JUnit Assertions
- The reporting is achieved using Extent Reports with additional PDF generation capability and configurable path 
- Required dependencies are managed with help of Maven
- For continuous integration Jenkins is configured

### The Scenarios considered for this POC:
- Registration on Takealot.com website
- Search product, add to cart and verify product in cart

### CI/CD Integration with Jenkins:
- Requirements:
  - Jenkins installed
  - Maven plugin
  - Git plugin
  - Git repo URL with credentials
- Global tool configurations:
  - Maven
  - Git
  - JDK

### Challenges discovered:
- We cannot re-use Email ID for registration purposes
- Product may be out of stock when searched / Product maybe in further pages and not in first result page
- Verification of successful registration including Email activation/validation and phone number validation

### Framework Enhancements:
- Test Data generation mechanism for all data including Email, Product, etc
- Parallel execution for feature files is achieved with sure-fire plugin for Maven
- Modularization of scenarios/feature files based on functionality
- Extensive tagging for features / scenarios to control the execution at granular level. Example execute only smoke, only P1 scenarios etc
- Jenkins CI enhancement to send email notification post build 
- Integrate framework to execute automatically post dev build
- Integrate with cloud execution environment such as BrowserStack / Saucelabs
- Custom Selenium Grid implementation with Docker

### Screenshots:
-----------------------------------------------------------------------------------------------------------------------------------
- Framework Folder structure
- ![This is folder structure image](test-output/reports/Folder_structure.png)

-----------------------------------------------------------------------------------------------------------------------------------
- Framework Feature File
- ![This is framework feature file image](test-output/reports/Sample_Scenario.png)

-----------------------------------------------------------------------------------------------------------------------------------
- Framework PDF Report
- ![This is framework PDF Report image](test-output/reports/report_pdf.png)

-----------------------------------------------------------------------------------------------------------------------------------
- Framework HTML Report
- ![This is framework HTML Report image](test-output/reports/report_html.png)

-----------------------------------------------------------------------------------------------------------------------------------
- Jenkins CI Execution Report
- ![This is framework CI execution Report image](test-output/reports/Jenkins.png)

-----------------------------------------------------------------------------------------------------------------------------------
