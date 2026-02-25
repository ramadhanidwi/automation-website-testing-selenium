package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    
    private By usernameBox = By.xpath("//input[@id='user-name']");
    private By passwordBox = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@id='login-button']");

    public void goToLoginPage(){
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String username, String password){
        driver.findElement(usernameBox).sendKeys(username);
        driver.findElement(passwordBox).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
