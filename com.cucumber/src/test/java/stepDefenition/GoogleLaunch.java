package stepDefenition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLaunch {

	WebDriver driver = null;
	String title;

	@Given("Open chrome browser")
	public void open_chrome_browser() {
		System.out.println("Chrome Browser Opened.");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("The URL is Launched")
	public void the_url_is_launched() {
		System.out.println("URL Launched.");
		driver.get("https://www.google.com");
	}

	@Then("Will get the Page Title")
	public void will_get_the_page_title() {
		System.out.println("Title of the page retrieved.");
		title = driver.getTitle();
		System.out.println("Title of the page is : "+title+".");
	}

	@And("Verify the Title of the page")
	public void verify_the_title_of_the_page() {
		System.out.println("Verified Title");
		if(title.equalsIgnoreCase("gogle"))
		{
			System.out.println("Title Matched");
		}
		else
		{
			System.out.println("Title Not Matched");
		}
	}

	@Then("Enter words in the search option")
	public void enter_words_in_the_search_option() {
		System.out.println("Word Entered");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Velavan");
	}

	@And("Hit the Search button")
	public void hit_the_search_button() {
		System.out.println("Searched");
		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).click();
	}

	@And("Close the Browser")
	public void close_the_browser() {
		System.out.println("Browser Closed");
		driver.close();
	}

}
