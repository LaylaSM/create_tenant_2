package demosite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class WebUtility<result> {

    static {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    }
    private static ChromeDriver _driver;

    public static ChromeDriver getChromeInstance(){
        if (_driver == null){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            _driver = new ChromeDriver(options);
        }
        return _driver;
    }

    public static void redirectTo (String url){
        _driver.navigate().to(url);
    }
    public static void waitForElementVisible(By id){
        WebDriverWait wait = new WebDriverWait(_driver, 20);
        wait.until(visibilityOfElementLocated(id));
    }

    public static void waitForAction(int millsec){
        try {
            Thread.sleep(millsec);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void waitAndClick(By id){
        waitForElementVisible(id);
        waitForAction(800);
        _driver.findElement(id).click();
    }

    public static void waitAndFill(By id, String value){
        waitForElementVisible(id);
        WebElement element = _driver.findElement(id);
        element.click();
        _driver.findElement(id).sendKeys(Keys.chord(Keys.CONTROL+"a"));
        waitForAction(500);
        _driver.findElement(id).sendKeys(Keys.chord(Keys.DELETE));
        _driver.findElement(id).sendKeys(value);
    }

    public static String getValue (By id){
        waitForElementVisible(id);
        waitForAction(1000);
        String getValue = _driver.findElement(id).getText();
        return getValue;
    }

    public static void scroolAndClick(By id){
        ((JavascriptExecutor) _driver).executeScript("arguments[0].click();", _driver.findElement(id));
    }
    public static void clickEnter (By id){
        WebElement object = _driver.findElement(id);
        object.sendKeys(Keys.ENTER);
    }

}
