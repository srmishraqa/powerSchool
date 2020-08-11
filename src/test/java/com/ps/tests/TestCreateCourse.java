package com.ps.tests;

import com.ps.base.TestBase;
import com.ps.pages.SchoologyHomePage;
import com.ps.pages.SchoologyLandingPage;
import com.ps.pages.SchoologyLoginPage;
import com.ps.util.TestUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCreateCourse extends TestBase {
    SchoologyLandingPage schoologyLandingPageLandingPage;
    SchoologyLoginPage schoologyLoginPageLoginPage;
    SchoologyHomePage schoologyHomePage;

    public TestCreateCourse() {
        super();
    }

    //This method will perform all pre-requisites activity
    @BeforeMethod
    public void setUp() {
        TestBase.intialization();
        schoologyLandingPageLandingPage = new SchoologyLandingPage();

    }

    // This method will perform all post execution activities
    // It will take screenshot in case there are any failures
    @AfterMethod
    public void tearDown(ITestResult res) throws IOException {
        if (res.getStatus() == ITestResult.FAILURE) {
            TestUtil.takeScreenshotAtEndOfTest();
        }

        driver.quit();
    }

    /**
     * This Method testCreateCourse() will perform all the testing activity to create a course
     * This method will login to the application, click on add new course, fill the details , create course and validate
     * whether successfully created or not
     *
     * @throws InterruptedException
     */
    @Test
    public void testCreateCourse() throws InterruptedException {
        schoologyLoginPageLoginPage = schoologyLandingPageLandingPage.clickOnLoginLink();
        schoologyHomePage = schoologyLoginPageLoginPage.loginToSchoology(prop.getProperty("username"), prop.getProperty("password"));
        schoologyHomePage.addNewCourse();
        schoologyHomePage.fillNewCourseDetails(prop.getProperty("courseName"), prop.getProperty("sectionName"), prop.getProperty("subjectArea"), prop.getProperty("level"), prop.getProperty("range"));
        schoologyHomePage.clickOnCreateNewCourse();
        Assert.assertEquals(schoologyHomePage.getInnerTextOfNewCourse(), prop.getProperty("courseName") + ": " + prop.getProperty("sectionName"));

    }
}
