package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    private By cartLink = By.xpath("//a[@class='shopping_cart_link']");
    private By listProductInCart = By.xpath("(//div[@class='inventory_item_name'])");
    private By removeProductButton(String productName){
        String xpath = String.format("//div[contains(@class,'cart_item')]" + 
            "[.//div[contains(@class,'inventory_item_name') and normalize-space(.)='%s']]" + 
            "//button[normalize-space(.)='Remove']"
        );
        return By.xpath(xpath);
    }
    
    
    public void goToCartPage(){
        driver.findElement(cartLink).click();
    }

    public void removeProductInCart(List<String> productName){
        for(String name : productName){
            List<WebElement> listOfProducts = (List<WebElement>) driver.findElements(listProductInCart);
            boolean found = false;
            for (WebElement product : listOfProducts){
                if(product.getText().equalsIgnoreCase(name)){
                    driver.findElement(removeProductButton(name)).click();
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("Product " + name + " tidak ditemukan di cart!");
            }
        }
    }

    public boolean checkProductInCart(List<String> productName){
        boolean found = false;
        for(String name : productName){
            List<WebElement> listOfProducts = (List<WebElement>) driver.findElements(listProductInCart);
            for (WebElement product : listOfProducts){
                if(product.getText().equalsIgnoreCase(name)){
                    found = true;
                    return true; 
                }
            }
            if (!found) {
                System.out.println("Product " + name + " tidak ditemukan di cart!");
                return false;
            }
        }
        return false;
    }

}
