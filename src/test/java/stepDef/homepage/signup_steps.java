package stepDef.homepage;

import base.config;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class signup_steps extends config {
    Faker faker = new Faker();


    @And("student enter their first name")
    public void studentEnterTheirFirstName() {
        String randomFirstName = faker.name().firstName();

        driver.findElement(By.name("firstName")).sendKeys(randomFirstName);
    }

    @And("student enter their last name")
    public void studentEnterTheirLastName() {
        String randomLastName = faker.name().lastName();
        driver.findElement(By.name("lastName")).sendKeys(randomLastName);
    }

    @And("student enter their email")
    public void studentEnterTheirEmail() {
        String randomEmail=faker.internet().emailAddress();
        driver.findElement(By.name("email")).sendKeys(randomEmail);
    }

    @And("student enter their password")
    public void studentEnterTheirPassword() {
        driver.findElement(By.name("password")).sendKeys("123456");
    }

    @And("student enter confirm password")
    public void studentEnterConfirmPassword() {
        driver.findElement(By.name("confirmPassword")).sendKeys("123456");
    }

    @And("student enter their dob such as month,date,year")
    public void studentEnterTheirDobSuchAsMonthDateYear() {
        Select m = new Select (driver.findElement(By.name("month")));
        m.selectByVisibleText("Dec");
        Select d = new Select (driver.findElement(By.name("day")));
        d.selectByVisibleText("25");
        Select y = new Select (driver.findElement(By.name("year")));
        y.selectByVisibleText("1990");

    }
    @And("student enter their dob such as month {string} day as {string} and year as {string}")
    public void studentEnterTheirDobSuchAsMonthDayAsAndYearAs(String month, String day, String year) {
        Select m = new Select (driver.findElement(By.name("month")));
        m.selectByVisibleText(month);
        Select d = new Select (driver.findElement(By.name("day")));
        d.selectByVisibleText(day);
        Select y = new Select (driver.findElement(By.name("year")));
        y.selectByVisibleText(year);
    }
    @And("student validate if they can select different months as{string}")
    public void studentValidateIfTheyCanSelectDifferentMonthsAs(String arg0, String arg1) {
        Select m = new Select (driver.findElement(By.name("month")));
        m.selectByVisibleText("month");
    }





    @And("student enter their gender as male")
    public void studentEnterTheirGenderAsMale() {
        driver.findElement(By.xpath("//*[@id='male']")).click();
    }

    @And("student agrees with terms and condition")
    public void studentAgreesWithTermsAndCondition() {
        driver.findElement(By.xpath("//*[@id='defaultCheck1']")).click();
    }

    @When("student click on Create My Account")
    public void studentClickOnCreateMyAccount() {

        driver.findElement(By.xpath("//*[@id='signup-form']/button")).click();
        //Thread.sleep(1500);
    }

    @Then("student should be able to get an student Id")
    public void studentShouldBeAbleToGetAnStudentId() {
        String expected="success";
        String actualvalue=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]")).getText();
        Assert.assertEquals(actualvalue,expected);

        String fullTextofStudentId =driver.findElement(By.xpath("/html/body/div[2]/div/div[3]")).getText();
        System.out.println("student random Id is==="+fullTextofStudentId);
        // your student id is
        STUDENT_RANDOM_ID = fullTextofStudentId.substring(fullTextofStudentId.indexOf(":") + 2);
        System.out.println("ONLY PRINT ==> Student Random Id is ===> " + STUDENT_RANDOM_ID);
        //
       // click on ok  button from the popup
        driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();

    }

    @And("student enter their invalid email")
    public void studentEnterTheirInvalidEmail() {
        driver.findElement(By.name("email")).sendKeys("fakeemail@g");
    }

    @Then("student should be able to get an error message about email is being incorrect")
    public void studentShouldBeAbleToGetAnErrorMessageAboutEmailIsBeingIncorrect() {
        String expected ="please enter a valid email address";
        String actual= driver.findElement(By.xpath("//*[@id='email-error']")).getText();
        Assert.assertEquals(actual,expected);
    }



}
