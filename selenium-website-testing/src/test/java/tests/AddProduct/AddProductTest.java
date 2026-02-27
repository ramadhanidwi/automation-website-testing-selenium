package tests.AddProduct;

import org.testng.annotations.Test;

import pages.HomePage;
import utils.ConfigReader;

public class AddProductTest extends base.BaseTest{

    @Test(priority = 1)
    public void successAddSingleProductToCart(){
        driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage(driver);
        
        
    }
}
