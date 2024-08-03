package ibm.fst_m1_SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ibm.fst_m1_selenium.FirefoxDriver;
import ibm.fst_m1_selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3 {
	public static void main(String[] args) {
		
		 WebDriverManager.firefoxdriver().setup();
	     WebDriver driver = new FirefoxDriver();
	     
	     driver.get("https://alchemy.hguy.co/lms");
	     WebElement firstInfoBox = driver.findElement(By.tagName("//h3[text()=' Actionable Training ']"));

	     System.out.println("Heading of the page: " + firstInfoBox.getText());
	     
	     if(!firstInfoBox.equals("Actionable Training")) {
	    	 System.out.println("Title is not matched");
	     }
	     driver.close();
		
		}
}

