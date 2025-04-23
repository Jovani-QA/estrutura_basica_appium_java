package login;


import io.appium.java_client.android.AndroidDriver;
import org.example.DriverManager;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest {

    private AndroidDriver driver;
    private LoginPage loginPage;

    @BeforeAll
    void setUp() throws Exception {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterAll
//    void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

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

