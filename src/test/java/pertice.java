import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class pertice {
    public static void main(String[] args) {

        // Email address must be unique
        // run in multiple browser like chrome and firefox
        // Test Env such as QA, Stage and Prod

        System.out.println("Hello, World!");

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://qa.taltektc.com/");
        driver.findElement(By.linkText("Create New Account")).click();
        driver.findElement(By.name("firstName")).sendKeys("yasmin");
        driver.findElement(By.name("lastName")).click();
        driver.findElement(By.name("lastName")).sendKeys("farzana");
        driver.findElement(By.name("email")).sendKeys("yasmin12345@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("confirmPassword")).sendKeys("123456");
        new Select(driver.findElement(By.name("month"))).selectByVisibleText("Aug");
        new Select(driver.findElement(By.name("day"))).selectByVisibleText("14");
        new Select(driver.findElement(By.name("year"))).selectByVisibleText("1980");
        driver.findElement(By.id("female")).click();
        driver.findElement(By.id("defaultCheck1")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
