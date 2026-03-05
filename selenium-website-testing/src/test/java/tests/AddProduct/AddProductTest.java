package tests.AddProduct;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.CartPage;
import utils.ConfigReader;

public class AddProductTest extends base.BaseTest{
    private By productTitle = By.xpath("//span[@class='title']");
    
    @Test(priority = 1, dataProviderClass = testData.LoginDataProvider.class, dataProvider = "loginData")
    public void successAddSingleProductToCart(String username, String password){
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        loginPage.login(username, password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        List<String> productsToAdd = Arrays.asList("Sauce Labs Backpack");
        homePage.addProductOnHomePage(productsToAdd);
        cartPage.goToCartPage();
        Assert.assertTrue(cartPage.checkProductInCart(productsToAdd));
    }

    @Test(priority = 2, dataProviderClass = testData.LoginDataProvider.class, dataProvider = "loginData")
    public void successAddMultipleProductToCart(String username, String password){
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        loginPage.login(username, password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        List<String> productsToAdd = Arrays.asList("Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt");
        homePage.addProductOnHomePage(productsToAdd);
        cartPage.goToCartPage();
        Assert.assertTrue(cartPage.checkProductInCart(productsToAdd));
    }

    @Test(priority = 3, dataProviderClass = testData.LoginDataProvider.class, dataProvider = "loginData")
    public void successAddProductOnProductPage(String username, String password){
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        loginPage.login(username, password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        List<String> productsToAdd = Arrays.asList("Sauce Labs Backpack","Sauce Labs Bolt T-Shirt");
        homePage.addProductOnHomePage(productsToAdd);
        cartPage.goToCartPage();
        Assert.assertTrue(cartPage.checkProductInCart(productsToAdd));
    }
}
