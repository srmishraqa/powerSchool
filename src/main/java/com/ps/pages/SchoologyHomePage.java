package com.ps.pages;

import com.ps.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SchoologyHomePage extends TestBase {

    final String createCoursePopupHeaderXpath = "//div[@class='title' and text()='Create Course']";
    final String newlyCreatedCourseHeaderXpath = "//h2//a[@class='sExtlink-processed']";

    @FindBy(xpath = "//span[text()='Courses']//parent::button")
    WebElement courseButtonOnNavMenu;

    @FindBy(xpath = "//a[text()='My Courses']")
    WebElement myCoursesLink;

    @FindBy(xpath = "//a[text()='Create Course']")
    WebElement createCourseButton;

    @FindBy(xpath = "//input[@id='edit-course-name']")
    WebElement courseNameEditBox;

    @FindBy(xpath = "//input[@id='edit-section-name-1']")
    WebElement sectionNameEditBox;

    @FindBy(xpath = "//select[@id='edit-subject-area']")
    WebElement subjectAreaDropdown;

    @FindBy(xpath = "//select[@id='edit-grade-level-range-start']")
    WebElement levelDropdown;

    @FindBy(xpath = "//span[text()='Add Range']")
    WebElement addRangeLink;

    @FindBy(xpath = "//select[@id='edit-grade-level-range-end']")
    WebElement rangeDropdown;

    @FindBy(xpath = "//input[@value='Create']")
    WebElement createButtonOnCreateCoursePopup;

    @FindBy(xpath = newlyCreatedCourseHeaderXpath)
    WebElement newlyCreatedCourseHeader;

    public SchoologyHomePage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * This method will click on add new course link and waits till the pop-up form appears which user has to fill
     */
    public void addNewCourse() {
        courseButtonOnNavMenu.click();
        myCoursesLink.click();
        createCourseButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(createCoursePopupHeaderXpath)));
    }

    /**
     * This method performs entire form filling part of course creation using following params
     * @param courseName
     * @param sectionName
     * @param subjectArea
     * @param level
     * @param range
     */
    public void fillNewCourseDetails(String courseName, String sectionName, String subjectArea, String level, String range) {
        courseNameEditBox.sendKeys(courseName);
        sectionNameEditBox.clear();
        sectionNameEditBox.sendKeys(sectionName);
        Select select = new Select(subjectAreaDropdown);
        select.selectByVisibleText(subjectArea);
        select = new Select(levelDropdown);
        select.selectByVisibleText(level);
        addRangeLink.click();
        select = new Select(rangeDropdown);
        select.selectByVisibleText(range);
    }

    /**
     * This method performs clicking and creation of course after the form is duly filled
     */
    public void clickOnCreateNewCourse() {
        createButtonOnCreateCoursePopup.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newlyCreatedCourseHeaderXpath)));
    }

    public String getInnerTextOfNewCourse() {
        return newlyCreatedCourseHeader.getText();
    }

}
