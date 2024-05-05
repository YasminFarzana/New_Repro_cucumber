package stepDef.homepage;

import base.config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook extends config {
    public static String baseURL;
    public static String envType=System.getProperty("env");
    public static String browserType=System.getProperty("browser");
  @Before
    public void beforeEachTest() {
// List of env
// QA env //https://qa.taltektc.com
// stage env //https://stage.taltektc.com
// prod env //https://env.taltektc.com

      switch (envType) {
          case"qa":
              baseURL="https://qa.taltektc.com";
              STUDENT_HARDCODED_EMAIL_ADDRESS="dinanahar123@gmail.com";
              break;
          case"stage":
              baseURL="https://stage.taltektc.com";
              STUDENT_HARDCODED_EMAIL_ADDRESS="stagedina123@gmail.com";
              break;
          case"prod":
              baseURL="https://prod.taltektc.com";
              STUDENT_HARDCODED_EMAIL_ADDRESS="proddina123@gmail.com";
              break;

      }
driver.get(baseURL);
  }
@After
    public void afterEachScenario(Scenario scenario){
    if (scenario.isFailed()) {
        TakesScreenshot ts = (TakesScreenshot) driver;

        byte[] src =ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(src, "image/png", "screenshot");
    }

}

}



