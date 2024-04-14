package com.und_chr;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.frogking.chromedriver.ChromeDriverBuilder;

public class GmailHelper {
    //TODO - adjust these if needed
    static final String CHROME_DRIVER_PATH = "c:\\Users\\barra_da_tijuca\\AppData\\Local\\Google\\Chrome\\ChromeDriver\\123.0.6312.122\\chromedriver-win64\\chromedriver.exe";
    static final String CHROME_DRIVER_PATH2 = "c:\\Users\\barra_da_tijuca\\AppData\\Local\\Google\\Chrome\\ChromeDriver\\123.0.6312.122\\chromedriver-win64\\chromedriver2.exe";
    static final String CHROME_PATH = "c:\\Users\\barra_da_tijuca\\AppData\\Local\\Google\\Chrome\\ChromeDriver\\123.0.6312.122\\chrome-win64\\chrome.exe";

    //your login/pass
    static final String LOGIN = "TODO";
    static final String PASSWORD = "TODO";

    static final String PASSWORD_FIELD_XPATH = "//input[@type='password']";

    public static void main(String[] args) throws InterruptedException {
        // (1) the normal version
//      System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
//      ChromeOptions options = new ChromeOptions();
//      options.setBinary(CHROME_PATH);
//      options.addArguments("--disable-blink-features=AutomationControlled");
//      WebDriver driver = new ChromeDriver(options);


        // (2) the patched version
        ChromeOptions options2 = new ChromeOptions();
        options2.addArguments("--window-size=1920,1080");
        options2.addArguments("--disable-blink-features=AutomationControlled");
        options2.setBinary(CHROME_PATH);
        WebDriver driver = new ChromeDriverBuilder().build(options2, CHROME_DRIVER_PATH2);


        //action
        driver.get("https://gmail.com");
        WebElement loginField = driver.findElement(By.xpath("//input[@id='identifierId']"));
        loginField.sendKeys(LOGIN);

        WebElement nextButton = driver.findElement(By.xpath("//*[@id='identifierNext']/div/button"));
        nextButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PASSWORD_FIELD_XPATH)));
        passwordField.sendKeys(PASSWORD);
        Thread.sleep(1000); // Note: Java uses milliseconds for sleep

        passwordField.sendKeys(Keys.ENTER);

        System.out.println("Login - Ok");
        Thread.sleep(100000); // Adjust sleep time as needed
        driver.quit();
    }
}
