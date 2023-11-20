package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
        System.out.println("Opening the Browser");
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        // click on signIn link
        WebElement signInLink = driver.findElement(By.xpath("//a[normalize-space()='Sign In']"));
        signInLink.click();
        //Enter valid emailId
        WebElement emailIdField = driver.findElement(By.id("user[email]"));
        emailIdField.sendKeys("abc@gmail.com");
        // Enter valid password
        WebElement  passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("abc345");
        String expectedText = "Welcome Back!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualText = actualTextElement.getText();
        // Verifying actual and expected text
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        // click on signIn link
        WebElement signInLink = driver.findElement(By.xpath("//a[normalize-space()='Sign In']"));
        signInLink.click();
        //Enter invalid emailId
        WebElement emailIdField = driver.findElement(By.id("user[email]"));
        emailIdField.sendKeys("abb@gmail.com");
        // Enter invalid password
        WebElement  passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("abb345");
        //click on signIn button
        WebElement signInButton = driver .findElement(By.xpath("//button[@type='submit']"));
        signInButton.click();
        String expectedText = "Invalid email or password.";
        WebElement actualTextElement = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualText = actualTextElement.getText();
        // Verifying actual and expected text
        Assert.assertEquals(expectedText, actualText);
    // Last step is not going further because 'CAPTCHA' appears during automation and selenium doesn
    }
    public void closeBrowser(){
        driver.quit();
    }
}
