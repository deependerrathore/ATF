/*
 * Copyright (c) 2020. automation testing framework team.
 */

package com.framework.w2a.base;

import com.framework.atf.utils.Profile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    /*
    WebDriver
    Excel
    Mail
    Properties
    ExtentReport
    DB
    Logs
     */

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    @BeforeSuite
    public void setUp() throws IOException {
        if (driver == null){
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
            config.load(fis);

            fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
            OR.load(fis);

        }

        if (config.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver", config.getProperty("driverBinaryPath")+"/chromedriver");
            driver = new ChromeDriver();
        }

        driver.get(config.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
