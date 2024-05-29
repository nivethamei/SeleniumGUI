package campaignmodule;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCampaignWithProduct {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://49.249.28.218:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String parentid = driver.getWindowHandle();
		
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.name("Campaigns")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys("delllaptop");
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Set<String> allwindowids = driver.getWindowHandles();
		for(String e:allwindowids) {
			if(driver.getTitle().contains("Products&action")) {

			driver.switchTo().window(e);
			}
		}
		
		driver.findElement(By.linkText("canabis powder")).click();
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
         driver.findElement(By.linkText("Sign Out")).click();
	}

}
