package com.mypackage;

import com.mypackage.Pages.GooglePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class TestScreenShoot extends GooglePage {
    @Test
    public void screenShotTest() throws IOException, InterruptedException {
        searchDataInGoogle("oo");
        Set<By> setIgnoredElements = setIgnoredElements(By.cssSelector(".sfibbbc"));
        Screenshot screenshot = createScreenIgnoreElement(setIgnoredElements);
        //Screenshot screenshot = createScreen();
        saveScreen("firstScreenShot", screenshot);

        openNewLink();
        Screenshot screenshot1 = createScreenIgnoreElement(setIgnoredElements);
        //Screenshot screenshot1 = createScreen();
        saveScreen("secondScreenShot", screenshot1);

        saveResult(screenshot, screenshot1, "result");
    }

    private Set<By> setIgnoredElements(By by) {
        Set<By> d = new HashSet<By>();
        d.add(by);
        return d;
    }

    private Screenshot createScreen() {
        return new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(browser);
    }

    private Screenshot createScreenIgnoreElement(Set<By> setIgnoredElements) {
        return new AShot()
                .ignoredElements(setIgnoredElements)
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(browser);
    }

    private void saveScreen(String fileName, Screenshot screenshot) throws IOException {
        File actualFile = new File("screenshots/" + fileName + ".png");
        ImageIO.write(screenshot.getImage(), "png", actualFile);
    }

    private void saveResult(Screenshot screenshot, Screenshot screenshot1, String fileName) throws IOException {
        ImageDiff diff = new ImageDiffer().makeDiff(screenshot, screenshot1);
        File diffFile = new File("screenshots/" + fileName + ".png");
        ImageIO.write(diff.getMarkedImage(), "png", diffFile);
        assertEquals(diff.getDiffSize(), 0);
    }


}
