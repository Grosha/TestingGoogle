package com.apple.tests;

import com.apple.Locators;
import com.apple.Variable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by groshkka on 3/18/17.
 */
public class BaseTestApple implements Locators, Variable {
    public WebDriver browser;


    @BeforeClass
    public void setUp() throws IOException {
        //File chromeDriver = new File("/Users/groshkka/Downloads/chromedriver");
        //System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
        //open firefox
        browser = new FirefoxDriver();
        //browser = new ChromeDriver();

        //do maximize window browser
        browser.manage().window().maximize();

        //open page on browser
        browser.get(AppleLink);

    }

    //method close browser
    @AfterClass
    public void setDown() {
        browser.close();
        browser.quit();
    }

    //method wait, until items appear
    public void waitElement(By locator) {
        WebDriverWait wait = new WebDriverWait(browser, 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement $(By locator) {
        return browser.findElement(locator);
    }

    public List<WebElement> $s(By locator) {
        return browser.findElements(locator);
    }

    public Set<By> setIgnoredElements(By by, By by1) {
        Set<By> d = new HashSet<By>();
        d.add(by);
        d.add(by1);
        return d;
    }

    public Screenshot createScreen() {
        return new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(browser);
    }

    public Screenshot createScreenIgnoreElement(Set<By> setIgnoredElements) {
        return new AShot()
                .ignoredElements(setIgnoredElements)
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(browser);
    }

    public Screenshot createScreenOneElement(By by) {
        waitElement(by);
        return new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(browser, $(by));
    }

    public void saveNewScreen(String fileName, Screenshot screenshot) throws IOException {
        File actualFile = new File("applescreenshots/new/" + fileName + ".png");
        ImageIO.write(screenshot.getImage(), "png", actualFile);
    }

    public void saveStandardScreen(String fileName, Screenshot screenshot) throws IOException {
        File actualFile = new File("applescreenshots/standard/" + fileName + ".png");
        ImageIO.write(screenshot.getImage(), "png", actualFile);
    }

    public void saveResult(Screenshot screenshot, Screenshot screenshot1, String fileName) throws IOException {
        ImageDiff diff = new ImageDiffer().makeDiff(screenshot, screenshot1);
        File diffFile = new File("applescreenshots/result/" + fileName + ".png");
        ImageIO.write(diff.getMarkedImage(), "png", diffFile);
        assertEquals(diff.getDiffSize(), 0);
    }

    public Screenshot getScreenshot(String screenshotName) throws IOException {
        File file = new File(screenshotsWay + screenshotName);
        BufferedImage image = ImageIO.read(file);
        return new Screenshot(image);
    }
}
