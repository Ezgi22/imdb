package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class IMDB_TOP250 {

	
		public static void main(String[] args) {
			 WebDriver driver = new FirefoxDriver();
			 driver.get("http://www.imdb.com/chart/top");
			   SORT_MOVIES_RAKING(driver);
		        driver.close();
			 
		}
public static  void SORT_MOVIES_RAKING(WebDriver driver)

{
	 Select sortby = new Select(driver.findElement(By.name("sort")));
	  sortby.selectByVisibleText("Ranking");
	  
	  List<WebElement> items = driver.findElements(By.className("titleColumn"));

	  System.out.println(items);
	

}

}