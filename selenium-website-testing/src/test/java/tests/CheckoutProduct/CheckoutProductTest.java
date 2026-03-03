package tests.CheckoutProduct;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.HomePage;
import utils.ConfigReader;

public class CheckoutProductTest extends base.BaseTest{
    private By pageTitle = By.xpath("//span[@class='title']");
    private By errorMessage = By.cssSelector("//span[@class='title']");
    @Test(priority = 1)
    public void successCheckoutProduct(){
        driver.get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
            List<String> productsToAdd = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Fleece Jacket");
            loginPage.login("standard_user", "secret_sauce");
            homePage.addProductOnHomePage(productsToAdd);
            homePage.goToCartPage();
                Assert.assertTrue(cartPage.checkProductInCart(productsToAdd));
            cartPage.goToCheckoutPage();
                Assert.assertEquals(driver.findElement(pageTitle).getText(), "Checkout: Your Information");
            cartPage.checkoutProduct("John", "Doe", "12345");
            cartPage.goToOverviewPage();
                Assert.assertEquals(driver.findElement(pageTitle).getText(), "Checkout: Overview");
            cartPage.completingOrder();
                Assert.assertEquals(driver.findElement(pageTitle).getText(), "Checkout: Complete!");
    }

    @Test(priority = 2)
    public void failedCheckoutProductWithoutLastName(){
        driver.get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
            List<String> productsToAdd = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Fleece Jacket"); 
            loginPage.login("standard_user", "secret_sauce");
            homePage.addProductOnHomePage(productsToAdd);
            homePage.goToCartPage();
                Assert.assertTrue(cartPage.checkProductInCart(productsToAdd));
            cartPage.goToCheckoutPage();
            cartPage.checkoutProduct("John", "", "12345");
            cartPage.goToOverviewPage();
                Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
                Assert.assertEquals(driver.findElement(errorMessage).getText(), "Error: Last Name is required)");
        }

    @Test(priority = 3)
    public void failedCheckoutProductWithoutFirstName(){
        driver.get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
            List<String> productsToAdd = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Fleece Jacket"); 
            loginPage.login("standard_user", "secret_sauce");
            homePage.addProductOnHomePage(productsToAdd);
            homePage.goToCartPage();
                Assert.assertTrue(cartPage.checkProductInCart(productsToAdd));
            cartPage.goToCheckoutPage();
            cartPage.checkoutProduct("", "Doe", "12345");
            cartPage.goToOverviewPage();
                Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
                Assert.assertEquals(driver.findElement(errorMessage).getText(), "Error: First Name is required)");
    }

    @Test(priority = 4)
    public void failedCheckoutProductWithoutPostalCode(){
        driver.get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
            List<String> productsToAdd = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Fleece Jacket"); 
            loginPage.login("standard_user", "secret_sauce");
            homePage.addProductOnHomePage(productsToAdd);
            homePage.goToCartPage();
                Assert.assertTrue(cartPage.checkProductInCart(productsToAdd));        cartPage.goToCheckoutPage();
            cartPage.checkoutProduct("John", "Doe", "");
            cartPage.goToOverviewPage();
                Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
                Assert.assertEquals(driver.findElement(errorMessage).getText(), "Error: Postal Code is required)");
    }

    @Test(priority = 5)
    public void failedCheckoutProductWithoutProductInCart(){
        driver.get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
            List<String> productsToAdd = Arrays.asList("","");
            loginPage.login("standard_user",  "secret_sauce");
            homePage.addProductOnHomePage(productsToAdd);
            homePage.goToCartPage();
            cartPage.checkProductInCart(productsToAdd);
                Assert.assertFalse(cartPage.checkProductInCart(productsToAdd));
            cartPage.goToCheckoutPage();
            cartPage.checkoutProduct("John", "Doe", "12345");
                Assert.assertFalse(driver.findElement(pageTitle).isDisplayed());
    }
}
