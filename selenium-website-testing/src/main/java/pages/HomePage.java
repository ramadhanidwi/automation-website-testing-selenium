package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    private WebDriver driver;

    private By cartLink = By.xpath("//a[@class='shopping_cart_link']");
    private By listProduct = By.xpath("(//div[@class='inventory_item_name '])");
    private By addProductButton(String productName){
        String xpath = String.format(
        "//div[contains(@class,'inventory_item')]" +
        "[.//div[contains(@class,'inventory_item_name') and normalize-space()='%s']]" +
        "//button[normalize-space()='Add to cart']",
        productName
    );
        return By.xpath(xpath);
    }

    private By removeProductButton(String productName){
        String xpath = String.format("//div[contains(@class,'inventory_item')]" +
           "[.//div[contains(@class,'inventory_item_name') and normalize-space()='%s']]" + 
        "//button[normalize-space()='Remove']"
        );
        return By.xpath(xpath);
    }

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    
    public void addProductOnHomePage(List<String> productName){
        for(String name : productName){
            List<WebElement> listOfProducts = (List<WebElement>) driver.findElements(listProduct);
            boolean found = false;
            for (WebElement product : listOfProducts){
                if(product.getText().equalsIgnoreCase(name)){
                    driver.findElement(addProductButton(name)).click();
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("Product " + name + " tidak ditemukan!");
            }
        }
    }

    public void removeProductOnHomePage(List<String> productName){
        for(String name : productName){
            List<WebElement> listOfProducts = (List<WebElement>) driver.findElements(listProduct);
            boolean found = false;
            for (WebElement product : listOfProducts){
                if(product.getText().equalsIgnoreCase(name)){
                    driver.findElement(removeProductButton(name)).click();
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("Product " + name + " tidak ditemukan!");
            }
        }
    }

    public void goToCartPage(){
        driver.findElement(cartLink).click();
    }

}   


