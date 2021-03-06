package seleniumgluecode;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class test {
	public static WebDriver driver;

	@Given("^User is on homepage$")
	public void user_is_on_homepage() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "/java/software/chromedriver3");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}

	@When("^user navigates to homepage$")
	public void user_navigates_to_homepage() throws Throwable {
		// Write code here that turns
		driver.findElement(By.linkText("Sign in")).click();

	}

	@When("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("blog.cucumber@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("Cucumber@blog");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
	}

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String str = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
		assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", str);
		driver.quit();
	}
}

