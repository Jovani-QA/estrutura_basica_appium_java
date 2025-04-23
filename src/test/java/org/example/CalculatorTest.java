package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {
    public static void main(String[] args) throws MalformedURLException {
        // Configurar as capabilities usando DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("appPackage", "com.sercasting.castingapp");
        capabilities.setCapability("appActivity", "com.sercasting.castingapp.MainActivity");

        // Defina automationName explicitamente
        capabilities.setCapability("automationName", "UiAutomator2");

        // Conecta ao Appium
        AndroidDriver driver = new AndroidDriver(new URL("http://192.168.101.10:4723"), capabilities);

        // Espera o app abrir
        System.out.println("App iniciado com sucesso!");
        driver.findElement(By.xpath("//android.widget.ListView/android.view.View[1]/android.view.View/android.widget.EditText"))
                .sendKeys("db118@cstng.com");
        driver.findElement(By.xpath("//android.widget.ListView/android.view.View[2]/android.view.View/android.widget.EditText"))
                .sendKeys("cst0962");
        // Fecha o app
        //driver.quit();
    }
}