package login;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.example.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest {

    private AndroidDriver driver;
    private LoginPage loginPage;
   private String appPackage = "com.sercasting.castingapp";



    @BeforeAll
    void setUp() throws Exception {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
    }
    @BeforeEach
    void resetApp() {
        driver.terminateApp(appPackage);
        driver.activateApp(appPackage);
        try {
            // Espera 3 segundos para o app inicializar corretamente
            Thread.sleep(5000);

            // Alternativa: espera explícita para algum elemento da página de login ficar visível
//             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfElementLocated(
////                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)")
//            ));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterAll
    void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }

    @Test
    @DisplayName("Login com credenciais válidas")
    void testLoginValido() {
        loginPage.login("db118@cstng.com", "cst0962");
        // aqui você pode validar a tela após login, por exemplo
        // Assertions.assertTrue(loginPage.isLoggedIn());
    }

    @Test
    @DisplayName("Login com senha inválida")
    void testSenhaInvalida() {
        loginPage.login("db118@cstng.com", "senha_errada");
        // Assertions.assertTrue(loginPage.isErroSenha());
    }

    @Test
    @DisplayName("Login com e-mail inválido")
    void testEmailInvalido() {
        loginPage.login("emailerrado@cstng.com", "cst0962");
        // Assertions.assertTrue(loginPage.isErroEmail());
    }

    @Test
    @DisplayName("Login com campos vazios")
    void testCamposVazios() {
        loginPage.login("", "");
        // Assertions.assertTrue(loginPage.isCamposVazios());
    }
}

