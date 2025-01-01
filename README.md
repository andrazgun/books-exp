## Test Automation for E-commerce website

### SUT: [Books Express](https://www.books-express.ro/)

### Key Technologies:
- **[Java](https://docs.oracle.com/en/java/index.html)**: High-level, class-based, object-oriented programming language.
- **[Selenium WebDriver](https://www.selenium.dev/documentation/en/webdriver/)**: Automates browser interactions for functional testing.
- **[WebDriverManager](https://github.com/bonigarcia/webdrivermanager)**: Manages WebDriver binaries automatically, avoiding manual setup.
- **[TestNG](https://testng.org/doc/)**: A popular testing framework used to run and manage tests.
- **[Cucumber JVM BDD](https://cucumber.io/)**: Enables Behavior-Driven Development (BDD) with readable feature files.
- **[Cucumber PicoContainer](https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-picocontainer)**: Dependency injection of step definition classes and their dependencies.
- **[Page Object Model](https://www.guru99.com/page-object-model-pom-page-factory-in-selenium.html)**: A design pattern to create object-oriented classes that serve as an interface to the pages of the application.
- **[Page Factory](https://www.selenium.dev/documentation/en/webdriver/page_objects/)**: Enhances POM by providing an optimized way to initialize page elements.
- **[ChatGPT](https://chatgpt.com/)**: Powerful AI offering a wide range of benefits such as coding assistant, mentor, content creator and a tireless learning companion.
- **[Allure Report](https://allurereport.org/docs/cucumberjvm/)**: Popular open source tool for visualizing the results of a test run.
  
**Test Results**

- Run in CLI "mvn clean test"
- Reports are generated in target folder
- To view the Allure report run in CLI "allure serve .\target\allure-results\".
- To view the Cucumber report open in browser target\cucumber-reports.html .
