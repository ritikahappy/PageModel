package seleniumgluecode;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginNegative {

	public static WebDriver driver;

	@Given("^User is at homepage$")
	public void user_is_at_homepage() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "/java/software/chromedriver3");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}

	@When("^user navigate to homepage$")
	public void user_navigate_to_homepage() throws Throwable {
		// Write code here that turns
		driver.findElement(By.linkText("Sign in")).click();

	}

	@When("^user enter username and password$")
	public void user_enter_username_and_password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("blog.cucumber@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("Cucumber@blo"); // wrong password
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
	}

	@Then("^Failure message is displayed$")

	public void failure_message_is_displayed() throws Throwable {

		String str = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p")).getText();
		assertEquals("There is 1 error", str);
		driver.quit();
	}
}
