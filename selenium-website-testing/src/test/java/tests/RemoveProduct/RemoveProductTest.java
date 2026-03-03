package tests.RemoveProduct;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

public class RemoveProductTest extends base.BaseTest{

    @Test(priority = 1)
    public void successRemoveProductOnHomePage(){
        driver.get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        List<String> productsToAdd = Arrays.asList("Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt");
        homePage.addProductOnHomePage(productsToAdd);
            Assert.assertTrue(cartPage.checkProductInCart(productsToAdd));
        cartPage.continueShopping();
        homePage.removeProductOnHomePage(productsToAdd);
        cartPage.goToCartPage();
            Assert.assertFalse(cartPage.checkProductInCart(productsToAdd));
    }

    @Test(priority = 2)
    public void successRemoveProductInCart(){
        driver.get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        List<String> productsToAdd = Arrays.asList("Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt");
        homePage.addProductOnHomePage(productsToAdd);
            Assert.assertTrue(cartPage.checkProductInCart(productsToAdd));
        cartPage.removeProductInCart(productsToAdd);
        cartPage.goToCartPage();
            Assert.assertFalse(cartPage.checkProductInCart(productsToAdd));
    }

    @Test(priority = 3)
    public void successRemoveProductOnProductPage(){
        driver.get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        ProductPage productPage = new ProductPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        List<String> productsToAdd = Arrays.asList("Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt");
        productPage.addProductOnProductPage(productsToAdd);
        cartPage.goToCartPage();
            Assert.assertTrue(cartPage.checkProductInCart(productsToAdd));
        productPage.removeProductOnProductPage(productsToAdd);
        cartPage.goToCartPage();
            Assert.assertFalse(cartPage.checkProductInCart(productsToAdd)); 
    }
}
