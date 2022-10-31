package ru.dns.shop.framework.utils;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.dns.shop.framework.managers.DriverManager;

public class MyAllureListener implements TestWatcher {

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] getScreenshot() {
        return ((TakesScreenshot) DriverManager.getINSTANCE().getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        getScreenshot();
        System.out.println();
    }
}
