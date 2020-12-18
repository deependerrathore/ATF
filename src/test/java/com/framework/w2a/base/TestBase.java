/*
 * Copyright (c) 2020. automation testing framework team.
 */

package com.framework.w2a.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
    public static Properties config;
    public static Properties OR;
    public static FileInputStream fis;
    @BeforeSuite
    public void setUp() throws IOException {
        if (driver == null){
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
            config.load(fis);

            fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
            OR.load(fis);

        }
    }

    @AfterSuite
    public void tearDown(){

    }
}
