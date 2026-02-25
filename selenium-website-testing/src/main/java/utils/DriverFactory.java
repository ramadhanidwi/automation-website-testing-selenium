package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    public static WebDriver initDriver(){
        String browser = ConfigReader.getProperty("browser");
        
        if(browser.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        }

        throw new RuntimeException("Browser tidak ditemukan di config!");
    }
}
