package Academy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	@Test
	public void getData() {
		System.out.println("Hello Guys");
		// Downloads / selects ChromeDriver that matches the installed Chrome (local + CI)
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://olgatraining2026-amecemgrdcgee9ey.canadacentral-01.azurewebsites.net/");
			String text = driver.findElement(By.cssSelector("h1")).getText();
			System.out.println(text);
			Assert.assertTrue(text.equalsIgnoreCase("RahulShettyAcademy.com Learning"));
		} finally {
			driver.quit();
		}
	}
}
