package stepDef.homepage;

import base.config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Login_steps extends config {
    @And("student enter their newly created studentId")
    public void studentEnterTheirNewlyCreatedStudentId() {
        //enter student id or email
        driver.findElement(By.xpath("email")).sendKeys(STUDENT_RANDOM_ID);
    }

    @And("student enter their password during login")
    public void studentEnterTheirPasswordDuringLogin() {
        driver.findElement(By.xpath("password")).sendKeys("123456");
      //click on login button
    }
    @When("They click on login button")
    public void theyClickOnLoginButton() {
        driver.findElement(By.xpath("//*[@id='login_form']/input")).click();
        //Enter password
    }

    @And("student enter their valid  email address")
    public void studentEnterTheirValidEmailAddress() {
        driver.findElement(By.xpath("email")).sendKeys("STUDENT_HARDCODED_EMAIL_ADDRESS");
    }


    @Then("student should be successfully login")
    public void studentShouldBeSuccessfullyLogin() {
//assertion
        //what developer has been implemented
        String act=driver.findElement(By.xpath("//*[@id='wrap']/div/div/div[1]/h2")).getText();
        //requirements or design or business
        String exp="Student Information";
        Assert.assertEquals(act,exp);

    }

    @And("student enter their invalid  email address")
    public void studentEnterTheirInvalidEmailAddress() {
        driver.findElement(By.xpath("email")).sendKeys("ThisemailNeverExit1@gmail.com");
    }

    @Then("student should be not be able to successfully login")
    public void studentShouldBeNotBeAbleToSuccessfullyLogin() {
        //assertion
        //what developer has been implemented
        String act=driver.findElement(By.xpath("//*[@id='error-msg']")).getText();
        //requirements or design or business
        String exp="Student Information";
        Assert.assertEquals(act,exp);


    }

    @Then("student should be successfully login but failing on purpose")
    public void studentShouldBeSuccessfullyLoginButFailingOnPurpose() {
        String act=driver.findElement(By.xpath("//*[@id='wrap']/div/div/div[1]/h2")).getText();
        //requirements or design or business
        String exp="Student Information - fail";
        Assert.assertEquals(act,exp);
    }
}
