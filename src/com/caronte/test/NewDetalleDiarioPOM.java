package com.caronte.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class NewDetalleDiarioPOM {

    private AndroidDriver<WebElement> driver;
    private AndroidElement etDescripcion;
    private AndroidElement etMonto;
    private AndroidElement btnAgregar;
    private AndroidElement lblException;

    private final String ID_ET_DESCRIPCION = "txt_detalle_diario_descripcion";
    private final String ID_ET_MONTO = "txt_detalle_diario_gasto";
    private final String ID_BTN_AGREGAR = "btn_new_detalle_diario";
    private final String ID_LBL_EXCEPTION = "lbl_exception";

    public NewDetalleDiarioPOM(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        waitForElements();
        etDescripcion = (AndroidElement) this.driver.findElementById(ID_ET_DESCRIPCION);
        etMonto = (AndroidElement) this.driver.findElementById(ID_ET_MONTO);
        btnAgregar = (AndroidElement) this.driver.findElementById(ID_BTN_AGREGAR);
        lblException = (AndroidElement) this.driver.findElementById(ID_LBL_EXCEPTION);
    }

    private void waitForElements() {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID_ET_DESCRIPCION)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID_ET_MONTO)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID_BTN_AGREGAR)));
    }

    public boolean hasException() {
        return Utils.populated(lblException.getText());
    }

    public void agregarDetalle(String descripcion, Integer monto) {
        etDescripcion.clear();
        etMonto.clear();
        etDescripcion.sendKeys(descripcion);
        etMonto.sendKeys(monto != null ? monto.toString() : null);
        btnAgregar.click();
    }
}
