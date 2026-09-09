package com.rrr.utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException {

        ExcelUtility excel = new ExcelUtility();

        return excel.getLoginData();
    }
}