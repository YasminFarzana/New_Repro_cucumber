package stepDef.homepage;

import base.config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class Login_steps extends config {
    @And("student enter their newly created studentId")
    public void studentEnterTheirNewlyCreatedStudentId() {
        //enter student id or email
        driver.findElement(By.xpath("email")).sendKeys(STUDENT_RANDOM_ID);
    }

    @And("student enter their password during login")
    public void studentEnterTheirPasswordDuringLogin() {
      //click on login button


    }

    @When("They click on login button")
    public void theyClickOnLoginButton() {
        //Enter password
    }
}
