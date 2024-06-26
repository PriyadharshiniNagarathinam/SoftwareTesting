package com.skcet.class_exercise;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class demo {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		Actions actions = new Actions(driver);

		driver.get("https://economictimes.indiatimes.com/et-now/results");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//nav[@id='topnav']/div[@data-ga-action='Mutual Funds']/a")).click();
		Thread.sleep(3000);

		WebElement select = driver.findElement(By.id("amcSelection"));
		actions.scrollToElement(select).perform();

		Select selectEle = new Select(select);
		selectEle.selectByVisibleText("Canara Robeco");
		Thread.sleep(3000);

		select = driver.findElement(By.id("schemenm"));

		selectEle = new Select(select);
		selectEle.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");

		driver.findElement(By.xpath("//*[@id='getDetails']")).click();
		Thread.sleep(5000);

		String current_tab = driver.getWindowHandle(); 
		for(String s : driver.getWindowHandles())
		{
			if(!s.equals(current_tab))
			{
				driver.switchTo().window(s);
			}
		}

		driver.findElement(By.xpath("//*[@id='installment_amt']/li/span")).click();
		driver.findElement(By.xpath("//*[@id='installment_amt']/li/ul/li[3]")).click();

		driver.findElement(By.xpath("//*[@id='installment_period']/li/span")).click();
		driver.findElement(By.xpath("//*[@id='installment_period']/li/ul/li[4]/span")).click();

		driver.findElement(By.xpath("//*[@id=\"mfNav\"]/div/ul/li[2]")).click();
		WebElement details = driver.findElement(By.xpath("//*[@id='mfReturns']/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"));

		System.out.println(details.getText());
	}

}
