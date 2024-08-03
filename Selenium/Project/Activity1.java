package ibm.fst_m1_SeleniumProject;

import ibm.fst_m1_selenium.FirefoxDriver;
import ibm.fst_m1_selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {
	public static void main(String[] args) {
		
	 WebDriverManager.firefoxdriver().setup();
     WebDriver driver = new FirefoxDriver();
     
     driver.get("https://alchemy.hguy.co/lms");
     String PageTitle = driver.getTitle();
     
     if(!PageTitle.equals("Alchemy LMS – An LMS Application")) {
    	 System.out.println("Title is not matched");
     }
     driver.close();
	
	}
}