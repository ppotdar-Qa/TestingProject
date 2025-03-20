
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Login_page {

	WebDriver Driver;

	@BeforeClass()
	public void setup() {

		// Initialize the ChromeDriver
		WebDriverManager.chromedriver().setup();
		Driver = new ChromeDriver();

		// Open the URL
		Driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Maximize the browser window
		Driver.manage().window().maximize();

		// Use modern implicit wait
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test(priority = 1)
	public void Login_test() throws InterruptedException {

		// Locate the Username text box and fill it in
		WebElement username_txt = Driver.findElement(By.xpath("//input[@name='username']"));
		username_txt.sendKeys("Admin");

		Thread.sleep(5000);

		// Locate the Password text box and fill it in
		WebElement password_txt = Driver.findElement(By.xpath("//input[@name='password']"));
		password_txt.sendKeys("admin123");

		// Locate and click the Login button
		WebElement log_btn = Driver.findElement(
				By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
		if (log_btn.isDisplayed()) {
			log_btn.click();
		} else {
			System.out.println("Login button is not present or not working.");
		}

		// Validate successful login by checking the page title
		String Expected_txt = "OrangeHRM";
		String Actual_txt = Driver.getTitle();

		if (Expected_txt.equals(Actual_txt)) {
			System.out.println("User successfully logged in.");
		} else {
			System.out.println("User failed to log in.");
		}
	}

	@AfterClass
	public void teardown() {
		// Close the browser
		Driver.quit();
	}
}