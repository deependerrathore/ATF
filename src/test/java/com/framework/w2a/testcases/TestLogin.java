/*
 * Copyright (c) 2020. automation testing framework team.
 */

package com.framework.w2a.testcases;

import com.framework.w2a.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestLogin extends TestBase {
    @Test
    public void loginAsBankManager(){
        driver.findElement(By.cssSelector(OR.getProperty("btnbml"))).click();
    }
}
