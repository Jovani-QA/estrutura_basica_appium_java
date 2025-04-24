package login;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage {

    private AndroidDriver driver;

    // Construtor recebe o driver
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Elementos
    private final By emailField =
            By.xpath("//android.widget.ListView/android.view.View[1]/android.view.View/android.widget.EditText");
    private final By passwordField =
            By.xpath("//android.widget.ListView/android.view.View[2]/android.view.View/android.widget.EditText");
    private final By loginButton =
            By.xpath("//android.widget.Button[@text='Login']");


    // Ações


    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}