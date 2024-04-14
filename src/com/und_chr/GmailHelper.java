package com.und_chr;

import com.frogking.chromedriver.ChromeDriverBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class GmailHelper {
    //TODO - adjust these if needed
    static final String CHROME_DRIVER_PATH = "c:\\Users\\barra_da_tijuca\\AppData\\Local\\Google\\Chrome\\ChromeDriver\\123.0.6312.122\\chromedriver-win64\\chromedriver.exe";
    static final String CHROME_PATH = "c:\\Users\\barra_da_tijuca\\AppData\\Local\\Google\\Chrome\\ChromeDriver\\123.0.6312.122\\chrome-win64\\chrome.exe";

    public static void main(String[] args) throws InterruptedException {
        String LOGIN = "TODO";
        String PASSWORD = "TODO";
        String PASSWORD_FIELD_XPATH = "//input[@type='password']";


        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(CHROME_PATH);
        options.addArguments("--disable-blink-features=AutomationControlled");

        WebDriver driver = new ChromeDriver(options);
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

        System.out.println("Ok");
        Thread.sleep(100000); // Adjust sleep time as needed
        driver.quit();





    }
}
