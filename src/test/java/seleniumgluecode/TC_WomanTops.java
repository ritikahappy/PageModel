package seleniumgluecode;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC_WomanTops {

	public static WebDriver driver;

	@When("^User searched for dresses$")
	public void user_searched_for_dresses() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "/java/software/chromedriver3");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("dresses");
		driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).submit();
	}

	@When("^Sort By dropdown box appeared and selected option$")
	public void sort_By_dropdown_box_appeared_and_selected_option() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Select product = new Select(driver.findElement(By.xpath("//*[@id=\"selectProductSort\"]")));
		product.selectByVisibleText("Product Name: A to Z");
	}

	@Then("^items displayed as per choice made$")
	public void items_displayed_as_per_choice_made() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// *[@id="center_column"]/div[1]/div[2]/div[2]/text()
		String str = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]")).getText();
		assertEquals("7 results have been found.", str);
		driver.quit();
	}
}
