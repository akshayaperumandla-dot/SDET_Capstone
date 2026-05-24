package Utils;

import Base.DriverSetup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

// Simple utility to capture screenshot on test failure
public class Screenshot {

    public static String captureScreenshot(String testName) {
        WebDriver driver = DriverSetup.getDriver();
        if (driver == null) {
            System.out.println("Driver is null. Cannot capture screenshot.");
            return null;
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timestamp + ".png";

        String targetDir = "reports/screenshots/";
        File directory = new File(targetDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(targetDir + fileName);

        try {
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot taken: " + destFile.getAbsolutePath());
            return "screenshots/" + fileName;
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
            return null;
        }
    }
}
