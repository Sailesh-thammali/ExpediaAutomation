package com.automation.pages.web;

import com.automation.utils.DriverManager;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import static java.lang.Thread.sleep;
import static java.time.Duration.ofSeconds;
import static org.apache.commons.io.FileUtils.copyFile;
import static org.openqa.selenium.OutputType.FILE;


public class WebBasePage {

    WebDriver driver;
    WebDriverWait wait;

    public WebBasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, ofSeconds(60));
    }

    public boolean isDisplayed(WebElement element) {
        try {
            setImplicitWait(10);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(60);
        }
    }

    public void waitForElementVisible(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void waitForElementClickable(WebElement ele) {
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public String getFormattedDate(String expectedFormat, String date, String currentDateFormat) {
        try {
            SimpleDateFormat currentFormatter = new SimpleDateFormat(currentDateFormat);
            Date dateObject = currentFormatter.parse(date);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateObject);

            SimpleDateFormat expectedFormatter = new SimpleDateFormat(expectedFormat);
            return expectedFormatter.format(calendar.getTime());
        } catch (Exception e) {
            throw new RuntimeException("Invalid date format " + expectedFormat);
        }
    }

    public void pause(long milliSec) {
        try {
            sleep(milliSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setImplicitWait(int sec) {
        driver.manage().timeouts().implicitlyWait(ofSeconds(sec));
    }

    public void switchToNewWindow() {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        for (String window : allWindow) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }
    }

    public void takeScreenshot(String filename) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(FILE);
        try {
            copyFile(src, new File("src/test/resources/screenshots/" + filename + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
