package automation;

import java.util.List;

//import javax.swing.event.RowSorterEvent.Type;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ImdbTop250 {

	public static void main(String[] args) throws InterruptedException {
		String[] text = {"Popularity","Alphabetical","IMDb Rating"," Number of Votes","US Box Office","Runtime","Year","Release Date"};
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.imdb.com/chart/top");
		sortGenre(driver);
		
		
		for (int i=0; i <= text.length; i++ )
        {
			WebElement sortby = driver.findElement(By.className("sorting"));
			WebElement type = sortby.findElement(By.partialLinkText(text[i]));
			System.out.println(type.getText());
			type.click();
			sortMovies( driver);
			
        }
		driver.close();
	}
	
	public static void sortMovies(WebDriver driver) {
	
		
		List<WebElement> items = driver.findElements(By.className("lister-item-header"));
		System.out.println(items.size());
		Assert.assertTrue(items.size() > 1);
	}
	public static void sortGenre(WebDriver driver)
	
	{
		WebElement genre = driver.findElement(By.linkText("Western"));
		genre.click();		
	}
}