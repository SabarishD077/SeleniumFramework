package com.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    public static WebDriver driver;
    public static Properties prop;
    public static boolean highlightelement;

    public static ThreadLocal < WebDriver > tldriver = new ThreadLocal < WebDriver > ();

    public static WebDriver launchBrowser() {
        prop = new Properties();
        String path = null;
        String env = null;

        try {
            env = System.getProperty("env");

            if (env.equals("qa2")) {
                path = ".\\src\\main\\java\\com\\hubspot\\config\\QA2config";
            } else if (env.equals("qa3")) {
                path = ".\\src\\main\\java\\com\\hubspot\\config\\QA3config";
            }
        } catch (Exception e) {
            path = ".\\src\\main\\java\\com\\hubspot\\config\\config.properties";
        }

        try {

            FileInputStream ip = new FileInputStream(path);
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        highlightelement = prop.getProperty("highlight").equalsIgnoreCase("yes") ? true : false;
        String browsername = prop.getProperty("browser");
        if (browsername.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\SABARISH\\Downloads\\chromedriver" +
                "\\chromedriver.exe");

            driver = new ChromeDriver();

        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        tldriver.set(driver);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tldriver.get();
    }

    public static void closeBrowser() {
        driver.quit();
    }

}