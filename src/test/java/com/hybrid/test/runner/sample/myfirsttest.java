package com.hybrid.test.runner.sample;
/* package com.example.tests; */

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class myfirsttest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  //@Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://accounts.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  //@Test
  public void testMy() throws Exception {	
    driver.get("http://gmail.com");
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("vkr.capsin");
    driver.findElement(By.id("Passwd")).clear();
    driver.findElement(By.id("Passwd")).sendKeys("TeamEigqc");
    driver.findElement(By.id("Email")).getText();
    
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | this.page().findElement("//input[@id='Email']").value  | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | this.page().findElement("//input[@id='Passwd']").value  | ]]
    driver.findElement(By.id("signIn")).click();
    driver.findElement(By.cssSelector("span.gb_V.gbii")).click();
    driver.findElement(By.id("gb_71")).click();
  }

  //@After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
