package com.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class OrangeHRMLoginTest {
    private WebDriver driver;
    private String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @BeforeClass
    public void setUp() {
        // Set the path of the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        // Open the base URL
        driver.get(baseUrl);
    }

    @Test
    public void testSuccessfulLogin() {
        // Find the username and password fields
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));

        // Enter the username and password
        usernameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Verify successful login by checking the presence of the dashboard
        WebElement dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        Assert.assertTrue(dashboard.isDisplayed(), "Login failed: Dashboard not displayed.");
    }

    @Test
    public void testInvalidLogin() {
        // Find the username and password fields
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));

        // Enter invalid credentials
        usernameField.sendKeys("invalidUser");
        passwordField.sendKeys("invalidPass");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Verify the error message
        WebElement errorMessage = driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

