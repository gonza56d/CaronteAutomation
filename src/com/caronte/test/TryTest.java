package com.caronte.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import io.appium.java_client.android.AndroidDriver;

public class TryTest extends BaseTest {

    private AndroidDriver<WebElement> driver;
    private final String NEW_DETALE_DIARIO_ACTIVITY = ".NewDetalleDiarioActivity";
    private final String NEW_PERIODO_ACTIVITY = ".NewPeriodoActivity";
    private final String PACKAGE = "com.caronte";

    @BeforeClass
    public void setUp() throws IOException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "../apps");
        File app = new File(appDir.getCanonicalPath(), "ApiDemos-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver<WebElement>(getServiceUrl(), capabilities);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test()
    public void testAddNewPeriodo() throws ParseException {
        //driver.startActivity(new Activity(PACKAGE, NEW_PERIODO_ACTIVITY));
        NewPeriodoPOM newPeriodoPOM = new NewPeriodoPOM(driver);
        //wrong date (before today) and wrong cash (less than 100)
        newPeriodoPOM.agregarPeriodo(Utils.getFecha("15/10/2015"), 5);
        Assert.assertTrue(newPeriodoPOM.hasException());
        //proper data
        newPeriodoPOM.agregarPeriodo(Utils.getFecha("15/10/2021"), 6000000);
        Assert.assertFalse(newPeriodoPOM.hasException());
    }

    /*@Test()
    public void testAddNewDetalleDiario() {
        driver.startActivity(new Activity(PACKAGE, NEW_DETALE_DIARIO_ACTIVITY));
        NewDetalleDiarioPOM newDetalleDiarioPOM = new NewDetalleDiarioPOM(driver);
        //wrong descrption (empty)
        newDetalleDiarioPOM.agregarDetalle("", 3);
        Assert.assertTrue(newDetalleDiarioPOM.hasException());
        //proper data
        newDetalleDiarioPOM.agregarDetalle("Coca cola", 140);
        Assert.assertFalse(newDetalleDiarioPOM.hasException());
    }*/

    public AndroidDriver<WebElement> getDriver() {
        return driver;
    }

    public void setDriver(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }
}
