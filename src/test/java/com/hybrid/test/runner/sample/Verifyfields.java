package com.hybrid.test.runner.sample;
/* package com.example.tests; */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
import org.openqa.selenium.support.ui.Select;

public class Verifyfields {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.facebook.com/"; 
    /* baseUrl = "file:///C:/Users/Guest1/Desktop/Welcome%20to%20Facebook%20-%20Log%20In,%20Sign%20Up%20or%20Learn%20More.htm"; */
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

//  @Test
  public void testVerifyfields() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("input[type=text][name=firstname]")).clear();
    driver.findElement(By.cssSelector("input[type=text][name=firstname]")).sendKeys("sample first name");
    
    try {

    	if (isElementPresent(By.cssSelector("input[type=text][name=firstname]"))) {

    	} else {

    	}
    			
       assertEquals("sdsdsdsdsds", driver.findElement(By.cssSelector("input[type=text][name=firstname]")).getAttribute("value")); 
      /* assertEquals("sdsdsdsdsds", driver.findElement(By.cssSelector("input[type=text][name=firstname]")).getText()); */
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("input[type=text][name=lastname]")).clear();
    driver.findElement(By.cssSelector("input[type=text][name=lastname]")).sendKeys("sample last name");
    try {
      assertEquals("sample last name", driver.findElement(By.cssSelector("input[type=text][name=lastname]")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("input[type=text][name=reg_email__]")).clear();
    driver.findElement(By.cssSelector("input[type=text][name=reg_email__]")).sendKeys("sample@email.com");
    try {
      assertEquals("sample@email.com", driver.findElement(By.cssSelector("input[type=text][name=reg_email__]")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("input[type=text][name=reg_email_confirmation__]")).clear();
    driver.findElement(By.cssSelector("input[type=text][name=reg_email_confirmation__]")).sendKeys("sample@email.com");
    try {
      assertEquals("sample@email.com", driver.findElement(By.cssSelector("input[type=text][name=reg_email_confirmation__]")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("input[type=password][name=reg_passwd__]")).clear();
    driver.findElement(By.cssSelector("input[type=password][name=reg_passwd__]")).sendKeys("sample");
    try {
      assertEquals("sample", driver.findElement(By.cssSelector("input[type=password][name=reg_passwd__]")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    new Select(driver.findElement(By.name("birthday_month"))).selectByVisibleText("Feb");
    // ERROR: Caught exception [ERROR: Unsupported command [getSelectedLabel | id=month | ]]
    new Select(driver.findElement(By.name("birthday_day"))).selectByVisibleText("1");
    // ERROR: Caught exception [ERROR: Unsupported command [getSelectedLabel | name=birthday_day | ]]
    new Select(driver.findElement(By.name("birthday_year"))).selectByVisibleText("2000");
    // ERROR: Caught exception [ERROR: Unsupported command [getSelectedLabel | name=birthday_year | ]]
    if (!driver.findElement(By.cssSelector("input[id=u_0_e][name=sex]")).isSelected()) {
      driver.findElement(By.cssSelector("input[id=u_0_e][name=sex]")).click(); 
    };
    assertEquals("2", driver.findElement(By.cssSelector("input[id=u_0_e][name=sex]")).getAttribute("value"));
    assertEquals("1", driver.findElement(By.cssSelector("input[id=u_0_d][name=sex]")).getAttribute("value")); 
    try {
      assertEquals("Sign Up", driver.findElement(By.xpath("//div[@id='content']/div/div/div/div/div[2]/h1")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("It���s free and always will be.", driver.findElement(By.xpath("//div[@id='content']/div/div/div/div/div[2]/h2")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Birthday", driver.findElement(By.xpath("//div[@id='u_0_b']/div")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(driver.findElement(By.linkText("Why do I need to provide my birthday?")).getText().matches("^Why do I need to provide my birthday[\\s\\S]$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("Female", driver.findElement(By.xpath("//span[@id='u_0_g']/span[1]/label")).getText());
    assertEquals("Male", driver.findElement(By.xpath("//span[@id='u_0_g']/span[2]/label")).getText());
    try {
      assertEquals("By clicking Sign Up, you agree to our Terms and that you have read our Data Use Policy, including our Cookie Use.", driver.findElement(By.cssSelector("p._58mv")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Sign Up", driver.findElement(By.name("websubmit")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }

  }

  
//  @After
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
