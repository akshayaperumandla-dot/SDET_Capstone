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

public class Screenshot {

    public static String captureScreenshot(String testName) {
        WebDriver driver = DriverSetup.getDriver();
        if (driver == null) {
            System.err.println("Driver is null. Cannot capture screenshot.");
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
            System.out.println("Screenshot captured: " + destFile.getAbsolutePath());
            // Return relative path from reports folder
            return "screenshots/" + fileName;
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
            return null;
        }
    }
}
