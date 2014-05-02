package com.hybrid.test.runner.sample;
/* package com.example.tests; */

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegistration {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  //@Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.facebook.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  //@Test
  public void testFacebookRegistration() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("input[name=firstname][type=text]")).clear();
    driver.findElement(By.cssSelector("input[name=firstname][type=text]")).sendKeys("sample first name");
    driver.findElement(By.cssSelector("input[name=lastname][type=text]")).clear();
    driver.findElement(By.cssSelector("input[name=lastname][type=text]")).sendKeys("sample last name");
    driver.findElement(By.cssSelector("input[name=reg_email__][type=text]")).clear();
    driver.findElement(By.cssSelector("input[name=reg_email__][type=text]")).sendKeys("sampleemail@email.com");
    driver.findElement(By.cssSelector("input[name=reg_email_confirmation__][type=text]")).clear();
    driver.findElement(By.cssSelector("input[name=reg_email_confirmation__][type=text]")).sendKeys("sampleemail@email.com");
    driver.findElement(By.cssSelector("input[name=reg_passwd__][type=password]")).clear();
    driver.findElement(By.cssSelector("input[name=reg_passwd__][type=password]")).sendKeys("sample");
    new Select(driver.findElement(By.name("birthday_month"))).selectByVisibleText("Jan");
    new Select(driver.findElement(By.name("birthday_day"))).selectByVisibleText("1");
    new Select(driver.findElement(By.name("birthday_year"))).selectByVisibleText("2000");
    driver.findElement(By.cssSelector("input[name=sex][value=1]")).click();
    driver.findElement(By.name("websubmit")).click();
  }
}

  /*
  @After
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

*/
