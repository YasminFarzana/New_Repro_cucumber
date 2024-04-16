package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class config {
    public static WebDriver driver;
    public static String STUDENT_RANDOM_ID;

    public static WebDriver setupBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Invalid browser Type specified. Defaulting to Chrome.");


        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }
}


//How to do cross-brower testing, run test in chrome,ff ect
//How to do cross env testing such as qa/stage/prod
//If test fail because of the bug or any reason, how capture the log and screenshorts
//and attach the logs/screenshort within the report
//How to generate JVM report
//How to run the test suit in CI/CD (GitHUb and Jenkins)