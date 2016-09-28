package automation;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class ImdbTop250 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.imdb.com/chart/top");
		Select sortby = new Select(driver.findElement(By.name("sort")));

		for (WebElement type : sortby.getOptions()) {
			sortMovies(driver, type.getText(), sortby);
		}
		
		driver.close();
	}
	
	public static void sortMovies(WebDriver driver, String sort, Select sortby) {
		sortby.selectByVisibleText(sort);
		
		List<WebElement> items = driver.findElements(By.className("titleColumn"));
		Assert.assertTrue(items.size() > 1);
	}

}