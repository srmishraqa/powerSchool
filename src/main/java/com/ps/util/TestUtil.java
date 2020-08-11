package com.ps.util;

import java.io.File;
import java.io.IOException;

import com.ps.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class TestUtil extends TestBase {

    // Constants to use throughout the framework
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICITLY_WAIT = 20;


    /**
     * This Method will take screenshot when any test gets failed
     * @throws IOException
     */
    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "\\Screenshots\\" + System.currentTimeMillis() + ".png"));

    }
}
