package tests.Login;
import utils.ConfigReader;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends base.BaseTest{
   
    @Test(priority = 1)
    public void loginSuccess(){
        driver.get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test(priority = 2)
    public void loginFailedWrongPassword(){
        driver.get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_service");
        Assert.assertEquals(driver.findElement(By.cssSelector("h3[data-test='error']")).getText(), 
        "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 3)
    public void loginFailedWrongUsername(){
        driver.get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("anomali_user", "secret_sauce");
        Assert.assertEquals(driver.findElement(By.cssSelector("h3[data-test='error']")).getText(),
        "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 4)
    public void loginFailedEmptyPassword(){
        driver.get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "");
        Assert.assertEquals(driver.findElement(By.cssSelector("h3[data-test='error']")).getText(),
        "Epic sadface: Password is required");
    }

    @Test(priority = 5)
    public void loginFailedEmptyUsername(){
        driver.get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(driver.findElement(By.cssSelector("h3[data-test='error']")).getText(),
        "Epic sadface: Username is required");
    }

}
