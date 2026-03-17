package Academy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Requires in pom.xml:
 *   io.github.bonigarcia:webdrivermanager (test scope)
 * Without that dependency + this code, CI uses whatever chromedriver is on the agent (often v86) → fails vs Chrome 145.
 */
public class BrowserTest {

	@Disabled("No browser on CI")
	@Test
	public void getData() {
		System.out.println("Hello Guys");

		// Hosted agents often set webdriver.chrome.driver to an old chromedriver — clear so WDM wins
		System.clearProperty("webdriver.chrome.driver");

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920,1080");

		WebDriver driver = new ChromeDriver(options);
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

