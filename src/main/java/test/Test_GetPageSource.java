package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.FileUtils;

import java.io.IOException;

public class Test_GetPageSource {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com/");

        Thread.sleep(3000);
        String pageSource = driver.getPageSource();
        FileUtils.writeHTML(pageSource,"baidu.html");
    }
}
