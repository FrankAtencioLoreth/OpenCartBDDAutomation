package opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Base{

    private final By EMAIL_INPUT = By.name("email");
    private final By PASSWORD_INPUT = By.name("password");
    private final By LOGIN_BUTTON = By.xpath("//input[@type='submit']");
    private final By FORGOTTEN_PASSWORD_LINK = By.linkText("Forgotten Password");
    private final By LOGOUT_LINK = By.linkText("Logout");
    private final By ERROR_MESSAGE = By.xpath("//div[contains(@class,'alert-danger')]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        this.enterEmail(email);
        this.enterPassword(password);
        this.clickLoginButton();
    }

    public void enterEmail(String email) {
        WebElement emailInput = this.driver.findElement(this.EMAIL_INPUT);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = this.driver.findElement(this.PASSWORD_INPUT);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = this.driver.findElement(this.LOGIN_BUTTON);
        loginButton.click();
    }

    public void clickForgottenPasswordLink() {
        WebElement forgottenLink = this.driver.findElement(this.FORGOTTEN_PASSWORD_LINK);
        forgottenLink.click();
    }

    public void clickLogoutLink() {
        WebElement logoutLink = this.driver.findElement(this.LOGOUT_LINK);
        logoutLink.click();
    }

    public boolean checkForgottenLink() {
        return this.driver.findElement(this.FORGOTTEN_PASSWORD_LINK).isDisplayed();
    }

    public boolean checkLogoutLink() {
        return this.driver.findElement(this.LOGOUT_LINK).isDisplayed();
    }

    public boolean checkErrorMessage() {
        return this.driver.findElement(this.ERROR_MESSAGE).isDisplayed();
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

}
