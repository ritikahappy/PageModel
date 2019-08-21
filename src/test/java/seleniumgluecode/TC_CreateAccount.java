package seleniumgluecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC_CreateAccount {
	public static WebDriver driver;

	@Given("^User is in homepage$")
	public void user_is_in_homepage() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "/java/software/chromedriver3");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");

	}

	@When("^User clicked on signin$")
	public void user_clicked_on_signin() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

	}

	@When("^User enters emailId and clicked on Createaccount button$")
	public void user_enters_emailId_and_clicked_on_Createaccount_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("ritveda@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
	}

	@Then("^Create An Account page is displayed$")
	public void create_An_Account_page_is_displayed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	System.out.println(driver.getCurrentUrl());
	driver.close();

	}

}
