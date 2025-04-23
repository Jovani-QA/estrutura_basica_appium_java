package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("appPackage", "com.sercasting.castingapp");
            capabilities.setCapability("appActivity", "com.sercasting.castingapp.MainActivity");
            capabilities.setCapability("automationName", "UiAutomator2");

            driver = new AndroidDriver(new URL("http://192.168.101.10:4723"), capabilities);

            // Aguarda o app abrir completamente
            try {
                Thread.sleep(5000); // Espera 5 segundos (substituir por espera explícita depois)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("App iniciado com sucesso!");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
