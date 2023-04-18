package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl ="http://the-internet.herokuapp.com/login";
    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //locate username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");
        //locate password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
        //login button
        WebElement loginBtn = driver.findElement(By.tagName("i"));
        loginBtn.click();

        //this is requirement
        String expectedText = "Secure Area";
        // actual text
        WebElement actualTextElement = driver.findElement(By.tagName("h2"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void verifyTheUsernameErrorMessage() {
        //locate username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith1");
        //locate password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
        //login button
        WebElement loginBtn = driver.findElement(By.tagName("i"));
        loginBtn.click();

        //this is requirement
        String expectedText = "Your username is invalid!\n" +
                "×";
        // actual text
        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);


    }


    }
