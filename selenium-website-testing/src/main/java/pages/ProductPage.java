package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver = driver;
    }
    
    private By listProduct = By.xpath("(//div[@class='inventory_item_name '])");
    private By addProductButton = By.xpath("//button[@id='add-to-cart']");
    private By backToHomeButton = By.xpath("//button[@id='back-to-products']");
    private By removeProductButton = By.xpath("//button[@id='remove']");
    
    public void addProductOnProductPage(List<String> productName){
        for(String name : productName){
            List<WebElement> listOfProducts = (List<WebElement>) driver.findElements(listProduct);
            boolean found = false; 
            for(WebElement product : listOfProducts){
                if(product.getText().equalsIgnoreCase(name)){
                    product.click();
                    driver.findElement(addProductButton).click();
                    driver.findElement(backToHomeButton).click();
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("Product " + name + " tidak ditemukan!");
            }
        }
    }

    public void removeProductOnProductPage(List<String> productName){
        for(String name : productName){
            List<WebElement> listOfProducts = (List<WebElement>) driver.findElements(listProduct);
            boolean found = false; 
            for(WebElement product : listOfProducts){
                if(product.getText().equalsIgnoreCase(name)){
                    product.click();
                    driver.findElement(removeProductButton).click();
                    driver.findElement(backToHomeButton).click();
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("Product " + name + " tidak ditemukan!");
            }
        }
    }
}
