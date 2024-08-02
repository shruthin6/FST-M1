package ibm.fst_m1_selenium;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity19 {

	 public static void main(String[] args) {
	        
	        WebDriverManager.firefoxdriver().setup();
	        WebDriver driver = new FirefoxDriver();
	        
	        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
	        System.out.println("Home page title: " + driver.getTitle());

	        driver.findElement(By.id("confirm")).click();

	        Alert confirmAlert = driver.switchTo().alert();

		        String alertText = confirmAlert.getText();
	        System.out.println("Text in alert: " + alertText);

	        confirmAlert.accept();

	       	        driver.quit();
	    }
}
