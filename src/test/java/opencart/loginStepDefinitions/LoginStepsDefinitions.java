package opencart.loginStepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import opencart.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LoginStepsDefinitions {

    private WebDriver driver;

    private LoginPage loginPage;
    private final String URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";

    @Before
    public void setup() {
       WebDriverManager.chromedriver().setup();
       this.driver = new ChromeDriver();
       this.driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if(this.driver!=null) {
            this.driver.quit();
        }
    }

    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() {
        this.loginPage = new LoginPage(this.driver);
        this.driver.get(this.URL);
    }

    @Given("I have entered a valid {string} and {string}")
    public void i_have_entered_a_valid_username_and_password(String email, String password) {
        this.loginPage.enterEmail(email);
        this.loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        this.loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertTrue(this.loginPage.checkLogoutLink());
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String email, String password) {
        this.loginPage.enterEmail(email);
        this.loginPage.enterPassword(password);
    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) {
        Assert.assertTrue(this.loginPage.checkErrorMessage());
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String string) {
        this.loginPage.clickForgottenPasswordLink();
    }

    @Then("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page() {
        Assert.assertTrue(this.loginPage.getCurrentUrl().contains("account/forgotten"));
    }



}
