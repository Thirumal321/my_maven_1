package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	private WebDriver driver;
	
	@Before
	public void setup() throws InterruptedException {
		driver=new EdgeDriver();
		
	}

	@Given("User is on the login page")
	public void Login_page() throws InterruptedException {
		Thread.sleep(4000);
		driver.get("https://the-internet.herokuapp.com/login");
		
	}
	@When("User enters valid username and password")
	public void valid_credentials() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		Thread.sleep(2000);
	}

	@When("User clicks the login button")
	public void userClicksTheLoginButton() throws InterruptedException {
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(4500);
	}

	@Then("User should see the success message")
	public void userShouldSeeTheSuccessMessage() {
		String actualMessage = driver.findElement(By.id("flash")).getText();
		String expectedMessage="You logged into a secure area!";
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}

	@After("@LoginTest")
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
