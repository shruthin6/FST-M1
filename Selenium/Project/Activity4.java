package ibm.fst_m1_SeleniumProject;

import org.openqa.selenium.By;
import ibm.fst_m1_selenium.FirefoxDriver;
import ibm.fst_m1_selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4 {
	public static void main(String[] args) {
		
		 WebDriverManager.firefoxdriver().setup();
	     WebDriver driver = new FirefoxDriver();
	     
	     driver.get("https://alchemy.hguy.co/lms");
	 
	     String secondPopularCourceTitle = driver.findElement(By.xpath("//h3[text()='Email Marketing Strategies']")).getText();
	     
	     if(!secondPopularCourceTitle.equals("Email Marketing Strategies"))
	     {
	    	 System.out.println("Title is not matched");
	     }
	     driver.close();
	}
}
