package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_SELECT_BIRTH_DAY = "//div[contains(@class, \"_5k_5\")]" +
            "/span/span/select[1]";
    public static final String XPATH_SELECT_BIRTH_MONTH = "//div[contains(@class, \"_5k_5\")]" +
            "/span/span/select[2]";
    public static final String XPATH_SELECT_BIRTH_YEAR = "//div[contains(@class, \"_5k_5\")]" +
            "/span/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        WebElement selectDay = driver.findElement(By.xpath(XPATH_SELECT_BIRTH_DAY));
        Select selectBirthDay = new Select(selectDay);
        selectBirthDay.selectByIndex(10);

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_SELECT_BIRTH_MONTH));
        Select selectBirthMonth = new Select(selectMonth);
        selectBirthMonth.selectByIndex(7);

        WebElement selectYear = driver.findElement(By.xpath(XPATH_SELECT_BIRTH_YEAR));
        Select selectBirthYear = new Select(selectYear);
        selectBirthYear.selectByValue("1981");
    }
}
