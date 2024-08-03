package ibm.fst_m1_SeleniumProject;

import org.openqa.selenium.By;
import ibm.fst_m1_selenium.FirefoxDriver;
import ibm.fst_m1_selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5 {
	public static void main(String[] args) {
		
		 WebDriverManager.firefoxdriver().setup();
	     WebDriver driver = new FirefoxDriver();
	     
	     driver.get("https://alchemy.hguy.co/lms");
	     driver.findElement(By.xpath("//a[text()='My Account']")).click();
	     	     
	     String Title = driver.findElement(By.xpath("//h1[text()='  My Account    ']")).getText();
	     Assert.assertEquals(Title.getText(), "My Account");
	        System.out.println("On Page: " + Title.getText());
	     }
	     
	
}
