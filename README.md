# UI Automation Framework

The UI Automation Framework is a robust and extensible solution designed for testing web applications. Built using Java, Selenium, and TestNG, this framework empowers testers to create maintainable and scalable automated tests.
## Features

- Selenium Integration: Seamlessly integrates with Selenium WebDriver for browser automation
- Page Object Model (POM): Adheres to the POM design pattern, promoting better organization and readability.
- Customizable Configuration: Easily configure test settings (e.g., browser choice, URLs) via the config.properties file.
- Parallel test execution
- Reporting and logging
- Cross-Browser Testing: Enables testing across different browsers (Chrome, Firefox, etc.).
- Easy setup and usage

## Getting Started

1. **Prerequisites:**
   - Java (JDK 8 or higher)
   - Maven (for project management)
   - Chrome, Firefox, or other supported browsers

2. **Clone the Repository:**
   `git clone https://github.com/dnyanesh1212/UI-Automation-Framework.git`

4. **Configure Test Environment:**
- Update the `config.properties` file with your desired settings (e.g., browser, URL, timeouts).

4. **Run Tests:**
   mvn clean test

5. **View Reports:**
- TestNG HTML reports are generated in the `target/surefire-reports` directory.

## Project Structure

- `src/main/java`: Contains framework core components (base classes, utilities).
- `src/test/java`: Includes test classes and page objects.
- `src/test/resources`: Stores test data and configuration files.

## Contributing

Contributions are welcome! If you find any issues or want to enhance the framework, feel free to submit a pull request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.


