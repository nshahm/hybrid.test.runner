package com.hybrid.test.runner.sample;
	/* package com.example.tests; */

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class mysecondtest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://accounts.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  
  @Test
  public void testMy() throws Exception {	
    Navigate("http://gmail.com");
    ConfigureText("vkr.capsin","Email"); 
    ConfigureText("TeamEigqc","Passwd");
    ValidateText("vkr.capsin","Email");
    ValidateText("TeamEigqc","Passwd");
    ButtonClick("signIn");
    
  }
  
  
  private void Navigate(String URL) throws Exception {	
    driver.get(URL);
  }
  
  public void ConfigureText(String Value, String Prop) throws Exception {
	  driver.findElement(By.id(Prop)).clear();
	  driver.findElement(By.id(Prop)).sendKeys(Value);	
	  System.out.println("Input Value is Configured");
  }
  
  public void ValidateText(String Value, String Prop) throws Exception {
	  String tempvariable;
	  
	  tempvariable =  driver.findElement(By.id("Email")).getText();
	  
	  if (tempvariable.equals(Value))
          System.out.println("Expected value '" + Value + "' is match with Actual Value '" + tempvariable + "'.");
	  else
		  System.out.println("Expected value '" + Value + "' does not match with Actual Value '" + tempvariable + "'.");  		  
	  
  }
  public void ButtonClick(String Prop) throws Exception {
	  driver.findElement(By.id(Prop)).click();
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
  */
}
