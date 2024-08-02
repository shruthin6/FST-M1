package ibm.fst_m1_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	
    WebDriver driver;
    
    @BeforeClass
    public void beforeMethod() {

        WebDriverManager.firefox().setup();
        driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net");
    }
 
    @Test
    public void exampleTestCase() {

        String title = driver.getTitle();

        System.out.println("Page title is: " + title);
            
        Assert.assertEquals("Training Support", title);

        driver.findElement(By.id("about-link")).click();

        System.out.println("New page title is: " + driver.getTitle());
        
        Assert.assertEquals(driver.getTitle(), "About Training Support");
    }
 
    @AfterClass
    public void afterMethod() {
 
    	driver.quit();
    }
 
}
