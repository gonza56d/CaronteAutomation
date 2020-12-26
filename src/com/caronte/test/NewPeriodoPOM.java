package com.caronte.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class NewPeriodoPOM {

    private AndroidDriver<WebElement> driver;
    private AndroidElement etNuevoPeriodo;
    private AndroidElement etPeriodoBalanceInicial;
    private AndroidElement btnNewPeriodo;
    private AndroidElement lblException;

    private final String ID_ET_NUEVO_PERIODO = "@+id/txt_periodo_hasta";
    private final String ID_ET_PERIODO_BALANCE_INICIAL = "@+id/txt_periodo_balance_inicial";
    private final String ID_BTN_NEW_PERIODO = "@+id/btn_new_periodo";
    private final String ID_LBL_EXCEPTION = "@+id/lbl_exception";

    public NewPeriodoPOM(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        waitForElements();
        etNuevoPeriodo = (AndroidElement) this.driver.findElementById(ID_ET_NUEVO_PERIODO);
        etPeriodoBalanceInicial = (AndroidElement) this.driver.findElementById(ID_ET_PERIODO_BALANCE_INICIAL);
        btnNewPeriodo = (AndroidElement) this.driver.findElementById(ID_BTN_NEW_PERIODO);
        lblException = (AndroidElement) this.driver.findElementById(ID_LBL_EXCEPTION);
    }

    private void waitForElements() {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID_ET_NUEVO_PERIODO)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID_ET_PERIODO_BALANCE_INICIAL)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID_BTN_NEW_PERIODO)));
    }

    public boolean hasException() {
        return Utils.populated(lblException.getText());
    }

    public void agregarPeriodo(Date finalizaEl, Integer balanceInicial) {
        etNuevoPeriodo.clear();
        etPeriodoBalanceInicial.clear();
        etNuevoPeriodo.sendKeys(new SimpleDateFormat("dd/MM/yyyy").format(finalizaEl));
        etPeriodoBalanceInicial.sendKeys(balanceInicial != null ? balanceInicial.toString() : null);
        btnNewPeriodo.click();
    }

    public AndroidDriver<WebElement> getDriver() {
        return driver;
    }

    public void setDriver(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    public AndroidElement getEtNuevoPeriodo() {
        return etNuevoPeriodo;
    }

    public void setEtNuevoPeriodo(AndroidElement etNuevoPeriodo) {
        this.etNuevoPeriodo = etNuevoPeriodo;
    }

    public AndroidElement getEtPeriodoBalanceInicial() {
        return etPeriodoBalanceInicial;
    }

    public void setEtPeriodoBalanceInicial(AndroidElement etPeriodoBalanceInicial) {
        this.etPeriodoBalanceInicial = etPeriodoBalanceInicial;
    }

    public AndroidElement getBtnNewPeriodo() {
        return btnNewPeriodo;
    }

    public void setBtnNewPeriodo(AndroidElement btnNewPeriodo) {
        this.btnNewPeriodo = btnNewPeriodo;
    }

    public AndroidElement getLblException() {
        return lblException;
    }

    public void setLblException(AndroidElement lblException) {
        this.lblException = lblException;
    }
}
