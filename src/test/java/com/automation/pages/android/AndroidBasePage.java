package com.automation.pages.android;

import com.automation.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

import static java.time.Duration.*;
import static java.util.Collections.*;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;
import static org.openqa.selenium.support.PageFactory.*;

public class AndroidBasePage {

    AndroidDriver driver;
    WebDriverWait wait;

    public AndroidBasePage() {
        driver = (AndroidDriver) DriverManager.getDriver();
        initElements(driver, this);
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


    public void setImplicitWait(int sec) {
        driver.manage().timeouts().implicitlyWait(ofSeconds(sec));
    }

    public void location(WebElement name, String action) {
        int x = name.getLocation().getX();
        int y = name.getLocation().getY();
        int width = name.getSize().getWidth();
        int height = name.getSize().getHeight();
        if (Objects.equals(action, "scroll")) {
            scroll(x + width / 2, (int) (y + height), x + width / 2, y);
        } else {
            swipe(x + width, y + height / 2, x, y + height / 2);
        }
    }

    public void scroll(int startX, int startY, int endX, int endY) {
        PointerInput finger1 = new PointerInput(TOUCH, "finger1");

        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, viewport(), startX, startY))
                .addAction(finger1.createPointerDown(LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(2), viewport(), endX, endY))
                .addAction(finger1.createPointerUp(LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));

    }

    public void swipe(int startX, int startY, int endX, int endY) {
        PointerInput finger2 = new PointerInput(TOUCH, "finger2");

        Sequence sequence = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(ZERO, viewport(), startX, startY))
                .addAction(finger2.createPointerDown(LEFT.asArg()))
                .addAction(finger2.createPointerMove(ofSeconds(2), viewport(), endX, endY))
                .addAction(finger2.createPointerUp(LEFT.asArg()));

        driver.perform(singletonList(sequence));

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

}


